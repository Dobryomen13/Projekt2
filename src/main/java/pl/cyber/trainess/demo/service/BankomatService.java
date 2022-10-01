package pl.cyber.trainess.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.cyber.trainess.demo.domain.BankomatEntry;
import pl.cyber.trainess.demo.dto.BankomatDTO;
import pl.cyber.trainess.demo.repository.BankomatRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankomatService {

    private final BankomatRepository bankomatRepository;
    public List<BankomatDTO> getAllAtms(){
        /*
        1.Polaczenie do bazy danych oraz pobranie odpowiednich info
        2.przygotowanie listy wynikowej
        3.petla konwertujaca Obiekt DB na Obiekt dla uzytkownika
         */

       log.info("Wyszukanie wszystkich bankomatow");
       log.warn("Coś poszlo nie tak!");
       log.error("Rest communication failed!");

       var allAtms = bankomatRepository.findAll();
       List<BankomatDTO> result = new ArrayList<>();

        for (BankomatEntry entry: allAtms) {
            result.add(entry.convertToDTO());
        }
        return result;
    }

    public void create(final BankomatDTO bankomatDTO) {
        bankomatRepository.save(BankomatEntry.builder()
                .miasto(bankomatDTO.getMiasto())
                .name(bankomatDTO.getName())
                .saldo(bankomatDTO.getSaldo())
                .ulica(bankomatDTO.getUlica())
                .czyAktywny(bankomatDTO.getCzyAktywny())
                .build());
    }
@Transactional
    public void updateName(final String id, final String name) {
       /* OPCJA 1
       var allAtms  = bankomatRepository.findAll();
        for (BankomatEntry entry:allAtms) {
            if (entry.getId().equals(id)){
                entry.setName(name);
                bankomatRepository.save(entry);
            }
        }

        */

    // OPCJA2
        // var atm = bankomatRepository.findById(id).orElseThrow(()->new RuntimeException("brak rekordu!"));

        /* OPCJA 3
        bankomatRepository.findById(id).ifPresent(entry -> {
            entry.setName(name);
            bankomatRepository.save(entry);
        });

         */
        /* OPCJA 4
        */
        bankomatRepository.findById(id).ifPresentOrElse(entry -> {
            entry.setName(name);
            bankomatRepository.save(entry);
        }, ()-> {throw new RuntimeException("Brak rekordu");
        });


        /* OPCJA 5
        var atm = bankomatRepository.findById(id).orElse(null);
        if(Objects.nonNull(atm)){
            atm.setName(name);
            bankomatRepository.save(atm);
        }

         */

    //    bankomatRepository.update(id,name);

    }

    private final FileReaderService fileReaderService;

    public void create(final MultipartFile file) {
        List<BankomatDTO> bankomatDTOs = fileReaderService.readATMFile(file);

        for (BankomatDTO element:bankomatDTOs) {
            bankomatRepository.save(BankomatEntry.builder()
                            .name(element.getName())
                            .saldo(element.getSaldo())
                            .miasto(element.getMiasto())
                            .ulica(element.getUlica())
                            .czyAktywny(element.getCzyAktywny())
                    .build());

        }



    }


    public void wplata( final String id, final Integer cash){
        if(cash<=0){
            throw new RuntimeException("Niedozwolona kwota wpłaty");
        }


        var atm = bankomatRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nie odnaleziono bankomatu"));
        atm.setSaldo(BigDecimal.valueOf(cash));
        if(atm.getSaldo().compareTo(BigDecimal.ZERO)>0){
            atm.setCzyAktywny(true);
        }
        bankomatRepository.save(atm);
    }

    public void wyplata(final String id, final Integer cash) {

        if(cash<=0){
            throw new RuntimeException("Prosze o podanie kwoty wiekszej od 0");
        }

        var atm = bankomatRepository.findById(id).orElseThrow(()->new RuntimeException("Nie odnaleziono bankomatu"));

        if(atm.getSaldo().subtract(BigDecimal.valueOf(cash)).compareTo(BigDecimal.ZERO)<0) {
            throw new RuntimeException("Kwota wyplaty jest wieksza niz gotowka w bankomacie");
        }

        atm.setSaldo(atm.getSaldo().subtract(BigDecimal.valueOf(cash)));
        if(atm.getSaldo().compareTo(BigDecimal.ZERO)<0){
            atm.setCzyAktywny(false);
        }

        bankomatRepository.save(atm);
    }
}
