package pl.cyber.trainess.demo.dto;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

public class PersonDTO {

@ConstructorProperties({"imie","nazwisko","dataUrodzenia", "miasto","plec"})
    public PersonDTO(final String imie, final String nazwisko, final LocalDate dataUrodzenia, final String miasto, final String plec) {
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
