package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;

import java.text.DecimalFormat;
import java.util.Locale;

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


    public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        if(a==0){
            return "To nie jest rownanie kwadratowe";
        }

        delta = Double.valueOf(b*b-4*a*c);

        if(delta<0){
            return "Brak pierwiastkow";
        } else {
            if (delta==0){
                x1= Double.valueOf(-b/(2*a));
                return "Jeden pierwiastek. Wynik: " +x1;
            } else {
                x1 = (-b-Math.sqrt(delta))/(2*a);
                x2 = (-b+Math.sqrt(delta))/(2*a);
                return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
            }
        }
    }

    public String rownanieKwadratowe(final RownanieKwRequest request) {
        Double delta=0.0;
        Double x1=0.0;
        Double x2=0.0;

        Double a=request.getA();
        Double b=request.getB();
        Double c=request.getC();

        delta = b*b-4*a*c;

        if (delta==0){
            x1=-b/(2*a*b);
           return "Jeden pierwiastek. Wynik: " + x1;
        } else if (delta<0) {
            return "Brak pierwiastkow";
        } else {
            x1 = (-b-Math.sqrt(delta))/(2*a);
            x2 = (-b+Math.sqrt(delta))/(2*a);
            return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
        }
    }

    public String rownanieKwadratowe2miejsca(final RownanieKwRequest request) {

        Locale englishLocale = Locale.ENGLISH;
        Locale polishLocale = Locale.forLanguageTag("pl-PL");

        Locale.setDefault(polishLocale);

        DecimalFormat df = new DecimalFormat("#,##0.00");

        Double delta=0.0;
        Double x1=0.0;
        Double x2=0.0;

        Double a=request.getA();
        Double b=request.getB();
        Double c=request.getC();

        delta = b*b-4*a*c;

        if (delta==0){
            x1=-b/(2*a*b);
            return "Jeden pierwiastek. Wynik: " + df.format(x1);
        } else if (delta<0) {
            return "Brak pierwiastkow";
        } else {
            x1 = (-b-Math.sqrt(delta))/(2*a);
            x2 = (-b+Math.sqrt(delta))/(2*a);
            return "Dwa pierwiastki. Wynik x1: " + df.format(x1) + " x2: " + df.format(x2);
        }
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



