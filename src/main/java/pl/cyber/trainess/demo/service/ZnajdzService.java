package pl.cyber.trainess.demo.service;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
@Slf4j
public class ZnajdzService {
    private Integer losowaLiczba = 0;

    public ZnajdzService() {
        Random r = new Random();
        this.losowaLiczba = r.nextInt(10,1000);

        log.info("Wylosowana liczba to: " + this.losowaLiczba.toString());
    }

    public String getLosowaLiczba(final Integer a) {
        if (a<losowaLiczba) {
            return "Wygenerowana liczba jest większa";
        } else if (a>losowaLiczba){
            return "Wygenerowana liczba jest mniejsza";
        }
        return "Udało się!!";
}

    public String ZnajdzLiczbe(final Integer liczba){
        if(Objects.equals(liczba,losowaLiczba)){
            return "Udało się!!";
        } else if (liczba<losowaLiczba){
            return "Wygenerowana liczba jest większa";
        } else return "Wygenerowana liczba jest mniejsza";
    }
}
