package pl.cyber.trainess.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Getter
public class PersonRequest {

    @ConstructorProperties({"imie","nazwisko","dataUrodzenia", "miasto","plec"})
    public PersonRequest(final String imie, final String nazwisko, final LocalDate dataUrodzenia, final String miasto, final String plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.miasto = miasto;
        this.plec = plec;
    }

    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    private final String miasto;
    private final String plec;
}
