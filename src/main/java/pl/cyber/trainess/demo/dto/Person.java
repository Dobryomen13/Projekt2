package pl.cyber.trainess.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor //mówi aplikacji aby utworzyła konstruktor ze wszystkich parametrów dostępnych z objektu
public class Person {
    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    @Setter
    private String miasto;
    private final String plec;
}
