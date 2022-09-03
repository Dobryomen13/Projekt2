package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;

@Service
public class KalkulatorSrevice {

    public Integer getDodawanie(final Integer a, final Integer b) {
        return a + b;
    }

    public Integer getOdejmowanie(final Integer a, final Integer b) {
        return a - b;
    }

    public Integer getMnozenie(final Integer a, final Integer b) {
        return a * b;
    }

    public Integer getDzielenie(final Integer a, final Integer b) {
        if (b != 0) {
            return a / b;
        } else throw new RuntimeException("Nie dziel przez 0!");
    }


    public Integer getReszta(final Integer a, final Integer b) {
        if (b != 0) {
            return a % b;
        } else throw new RuntimeException("Nie dziel przez 0!");
    }

    public boolean getCzyDzielnik(final Integer a, final Integer b) {
        if (b != 0) {
            if(a % b == 0){
                return true;
            } else return false;
        } else throw new RuntimeException("Nie dziel przez 0!");
    }






    }

 /*   public String CzyLiczbaPierwsza(Integer a) {

        a = 121;

        if (a < 2) {
            return "ta liczba nie jest pierwsza";
        }
            for (int i = 2; i < a / 2; i++) {
                if (a % i == 0) {
                    return "To nie jest liczba pierwsza";
                }
            }
            return "to jest liczba pierwsza";
        }

  */



