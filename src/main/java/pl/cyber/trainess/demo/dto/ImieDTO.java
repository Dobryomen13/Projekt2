package pl.cyber.trainess.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter //adnotacja, ktorej zadaniem jest dodanie do klasy metod Getter dla jej parametrow
public class ImieDTO {
    private final String imie;


@Builder //adnotacja pomaga utworzyc obiekt bez wypelniania konstruktora
@ConstructorProperties({"imie"}) //pomaga w budowaniu pliku wynikowego JSON
    public ImieDTO(final String imie) {
        this.imie = imie;
    }
}
