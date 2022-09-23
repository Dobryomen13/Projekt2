package pl.cyber.trainess.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
@Getter
public class PersonDTO {  private final String imie;
    private final String nazwisko;

    private LocalDate dataUrodzenia;
    private final String miasto;
    private final String plec;

    @Builder
    @ConstructorProperties({"imie", "nazwisko", "dataUrodzenia", "miasto", "plec"})
    public PersonDTO(final String imie, final String nazwisko,
                     final LocalDate dataUrodzenia, final String miasto,
                     final String plec) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.miasto = miasto;
        this.plec = plec;
    }
}