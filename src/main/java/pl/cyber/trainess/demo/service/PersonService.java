package pl.cyber.trainess.demo.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cyber.trainess.demo.dto.KluczSortowaniaEnum;
import pl.cyber.trainess.demo.dto.Person;
import pl.cyber.trainess.demo.dto.PersonDTO;
import pl.cyber.trainess.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private List<Person> personList = new ArrayList<>();

    public void createPerson(final PersonRequest request) {
        walidujOsobe(request);
        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }

    private void walidujOsobe(final PersonRequest request) {
        boolean czyIstnieje = false;
        for (Person element : personList) {
            if (element.getImie().equals(request.getImie()) &&
                    element.getNazwisko().equals(request.getNazwisko()) &&
                    element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                czyIstnieje = true;
            }
        }
        if (czyIstnieje) {
            throw new RuntimeException("Taka osoba juz istnieje");
        }

    }

    public PersonDTO getPerson(final PersonRequest request) {
        for (Person element : personList) {
            if (element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                return PersonDTO.builder()
                        .imie(element.getImie())
                        .nazwisko(element.getNazwisko())
                        .miasto(element.getMiasto())
                        .dataUrodzenia(element.getDataUrodzenia())
                        .plec(element.getPlec())
                        .build();
            }
        }
        return PersonDTO.builder().build();
    }

    public PersonDTO getPersonParms(final String imie, final String nazwisko) {
        for (Person element : personList) {
            if (element.getImie().equals(imie) && element.getNazwisko().equals(nazwisko)) {
                return PersonDTO.builder()
                        .imie(element.getImie())
                        .nazwisko(element.getNazwisko())
                        .miasto(element.getMiasto())
                        .dataUrodzenia(element.getDataUrodzenia())
                        .plec(element.getPlec())
                        .build();
            }
        }
        return PersonDTO.builder().build();
    }

    public void updatePerson(final PersonRequest request) {
        for (Person element : personList) {
            if (element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())) {
                element.setMiasto(request.getMiasto());
            }
        }
    }
    //zadanie 12

    /*
      Wykonaj createPerson z PersonController aby utworzyć 6 różnych osób (przy użyciu Postman), następnie
      napisz program, który z kolekcji typu List posiadającej  6 różnych osób(w oparciu o poprzednie zadanie)
      posortuje ich względem wskazanego klucza (np. miasta, datyUrodzenia, nazwiska lub imienia).
      Po czym zostanie zwrócona posortowana lista do użytkownika.
    */


    @GetMapping("/zadanie12")
    public List<PersonDTO> zadanie12(@RequestParam("klucz") final KluczSortowaniaEnum klucz) {

        List<PersonDTO> resultPersonList = new ArrayList<>();
        for (Person ele : personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());

            if (klucz.equals(KluczSortowaniaEnum.DATA)) {
                resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
            } else if (klucz.equals(KluczSortowaniaEnum.IMIE)) {
                resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
            } else if (klucz.equals(KluczSortowaniaEnum.NAZWISKO)) {
                resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
            } else if (klucz.equals(KluczSortowaniaEnum.MIASTO)) {
                resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
            }
        }
        return resultPersonList;
    }

    @GetMapping("/zadanie12b")
    public List<PersonDTO> zadanie12b(final KluczSortowaniaEnum klucz) {

        List<PersonDTO> resultPersonList = new ArrayList<>();
        for (Person ele : personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());
        }

        switch (klucz){
            case DATA: resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
            break;
            case IMIE: resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
            break;
            case MIASTO: resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
            break;
            case NAZWISKO: resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
            break;

        }
        return resultPersonList;
    }

    @GetMapping("/zadanie12c")
    public List<PersonDTO> zadanie12c(final KluczSortowaniaEnum klucz) {

        List<PersonDTO> resultPersonList = new ArrayList<>();
        for (Person ele : personList) {
            resultPersonList.add(PersonDTO.builder()
                    .imie(ele.getImie())
                    .dataUrodzenia(ele.getDataUrodzenia())
                    .miasto(ele.getMiasto())
                    .plec(ele.getPlec())
                    .nazwisko(ele.getNazwisko())
                    .build());
        }

        switch (klucz) {
            case DATA -> resultPersonList.sort(Comparator.comparing(PersonDTO::getDataUrodzenia));
            case IMIE -> resultPersonList.sort(Comparator.comparing(PersonDTO::getImie));
            case MIASTO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getMiasto));
            case NAZWISKO -> resultPersonList.sort(Comparator.comparing(PersonDTO::getNazwisko));
        }
        return resultPersonList;
    }
}
