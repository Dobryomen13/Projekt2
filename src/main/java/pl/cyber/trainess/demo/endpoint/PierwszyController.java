package pl.cyber.trainess.demo.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainess.demo.dto.ImieDTO;
import pl.cyber.trainess.demo.dto.Person;
import pl.cyber.trainess.demo.dto.PersonRequest;
import pl.cyber.trainess.demo.service.PersonService;


@Slf4j //odpowiada za logi w ramach serwera
@RestController // adnotacja mowi dla serwera Springa, ze w tym miejscu beda funkcjonalnosci REST API
@RequiredArgsConstructor
@RequestMapping("/v1/first")
public class PierwszyController {

    private final PersonService service;


    //HTTP metoda GET - metoda sluzy do pobierania informacji z serwera oraz

    @GetMapping("/{imie}")
    public ImieDTO getImie(@PathVariable final String imie){
        return ImieDTO.builder()
                .imie(imie)
                .build();
    }

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPerson(@RequestBody final PersonRequest request){
        log.info("Dokonuje utworzenia Osoby");
        service.createPerson(request);
    }


    /*
    User PersonDTO      <-> Server Person <-> DB PersonEntity
         PersonRequest
     */

    // Zadanie: Utworzyc 2 obiekty
    // 1.PersonDTO, ktory bedzie przekazywany dla uzytkownika
    // 2.Person jako obiekt wewnetrzny aplikacji
    // GET @GetMapping, PUT @PutMapping, POST @PostMapping
    // PersonRequest
    // Utworzyc  metody REST do tworzenia uzytkownika, zmiany jego danych oraz jego pobierania

    // Imie, nazwisko, date ur, miasto zamieszkania, plec
}
