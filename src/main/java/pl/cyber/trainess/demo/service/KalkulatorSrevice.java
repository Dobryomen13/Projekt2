package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.IntegerRequest;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
            if (a % b == 0) {
                return true;
            } else return false;
        } else throw new RuntimeException("Nie dziel przez 0!");
    }


    public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        if (a == 0) {
            return "To nie jest rownanie kwadratowe";
        }

        delta = Double.valueOf(b * b - 4 * a * c);

        if (delta < 0) {
            return "Brak pierwiastkow";
        } else {
            if (delta == 0) {
                x1 = Double.valueOf(-b / (2 * a));
                return "Jeden pierwiastek. Wynik: " + x1;
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
            }
        }
    }

    public String rownanieKwadratowe(final RownanieKwRequest request) {
        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;

        if (delta == 0) {
            x1 = -b / (2 * a * b);
            return "Jeden pierwiastek. Wynik: " + x1;
        } else if (delta < 0) {
            return "Brak pierwiastkow";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
        }
    }

    public String rownanieKwadratowe2miejsca(final RownanieKwRequest request) {

        Locale englishLocale = Locale.ENGLISH;
        Locale polishLocale = Locale.forLanguageTag("pl-PL");

        Locale.setDefault(polishLocale);

        DecimalFormat df = new DecimalFormat("#,##0.00");

        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        Double a = request.getA();
        Double b = request.getB();
        Double c = request.getC();

        delta = b * b - 4 * a * c;

        if (delta == 0) {
            x1 = -b / (2 * a * b);
            return "Jeden pierwiastek. Wynik: " + df.format(x1);
        } else if (delta < 0) {
            return "Brak pierwiastkow";
        } else {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            return "Dwa pierwiastki. Wynik x1: " + df.format(x1) + " x2: " + df.format(x2);
        }
    }

    public String zadanie10a() {
//        Integer y=0;
//        String result = "program oblicza wartosc funkcji y=3x, dla x zmieniajacego sie od 0 do 10\n";
//
//        for (int x=0; x<=10; x++){
//            y=3*x;
//            result +="x = " + x +"\t" + "y = " + y + "\n";
//        }
//        return result;

        Integer y = 0;
        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y=3x, dla x zmieniajacego sie od 0 do 10\n");

        for (int x = 0; x <= 10; x++) {
            y = 3 * x;
            result.append("x = ").append(x).append("\t").append("y = ").append(y).append("\n");
        }
        return result.toString();
    }

    public String zadanie10b() {

        Integer y = 0;
        Integer x = 0;
        String result = "Program oblicza wartosc funkcji y=3x, dla x zmieniajacego sie od 0 do 10 " +
                "Za pomoca petli do-while \n";
        do {
            y = 3 * x;
            result += "x = " + x + "\t" + "y = " + y + "\n";
            x++;
        } while (x <= 10);
        return result;
    }

    public String zadanie10c() {
        Integer y = 0;
        Integer x = 0;

        String result = "Program oblicza wartosc funkcji y=3x, dla x zmieniajacego sie od 0 do 10 " +
                "Za pomoca petli while \n";
        while (x <= 10) {
            y = 3 * x;
            result += "x = " + x + "\t" + "y = " + y + "\n";
            x++;
        }
        return result;
    }

    public String zadanie11a() {
//       Integer n = 10;
//       String result = "Tabliczka mnozenia 10x10\n\n";
//       for (int wiersz =1; wiersz<=n; wiersz++){
//           for (int kolumna =1; kolumna<=n; kolumna++){
//               result += wiersz*kolumna;
//               result += "\t";
//           }
//           result +="\n";

//       } return result;

       String result = "Tabliczka mnozenia 10x10\n";


       for (int i = 1; i <= 10; i++) {

           for (int j = 1; j <= 10; j++) {
               int a = i * j;
               result += a + "\t";
               a++;
           }
            result += "\n";

       }
       return result;
    }

    public String zadanie11aa() {
       Integer n = 100;
       Integer m = 10;
       String result = "Tabliczka mnozenia " + n + "x" + m +
               "\n\n";
       for (int wiersz =1; wiersz<=n; wiersz++){
           for (int kolumna =1; kolumna<=m; kolumna++){
               result += wiersz*kolumna;
               result += "\t";
           }
           result +="\n";

       } return result;

    }

    public String zadanie11b() {
        String result = "Tabliczka mnozenia 10x10\n";
        int j=1;
        do {
            int i=1;
            do {
                int a = i * j;
                result += a + "\t";
                i++;
            } while (i<=10);
            j++;
            result +="\n";
        } while (j<=10);
        return result;
    }

    public String zadanie11brozw() {
        Integer k = 10;
        Integer w = 20;
        Integer wiersz = 1;
        Integer kolumna = 1;

        String result = "Tabliczka mnozenia " + k + "x" + w + " przy uzyciu petli do-while" +"\n\n" ;
        do {
            kolumna =1;
            do {
                result +=wiersz*kolumna + "\t";
                kolumna++;
            } while (kolumna<=k);
            result +="\n";
            wiersz++;
        } while (wiersz<=w);
        return result;
    }

    public String zadanie11c() {
        String result = "Tabliczka mnozenia przy uzyciu petli while 10x10" +"\n\n" ;
        int i =1;
        while (i<=10){
            int j =1;
            while (j<=10){
                int a = i * j;
                result += a + "\t";
                j++;
            }
            result +="\n";
            i++;
        }
        return result;
    }

    public String zadanie11cRozw() {
        Integer k = 10;
        Integer w = 20;
        Integer wiersz = 1;
        Integer kolumna = 1;

        String result = "Tabliczka mnozenia " + k + "x" + w + " przy uzyciu petli while" +"\n\n" ;

        while (kolumna<=k){
                wiersz=1;
            while (wiersz<=w){
                result +=wiersz*kolumna + "\t";
                wiersz++;
            }
            result +="\n";
            kolumna++;
        }
        return result;
    }

    public String zadanie10d(final IntegerRequest request) {

        Integer y=0;
        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y=3x"
        + "dla x zmieniajacego sie od 0 do wartosci podanej przez uzytkownika");

        for (int x=0; x<= request.getParametrA(); x++){
            y=3*x;

            result.append("x= ").append(x).append("\t").append("y= ").append(y).append("\n");

        }

        return result.toString();
    }

    public String zadanie10e(final IntegerRequest request) {

        Integer y=0;
        Integer x=0;

        StringBuilder result = new StringBuilder("Program oblicza wartość funkcji y=3x");
        do {
            y=3*x;
            result.append("x= ").append(x).append("\t").append("y= ").append(y).append("\n");

            x++;

        } while (x<=request.getParametrA());

        return result.toString();
    }

    public String zadanie10f(final IntegerRequest request) {

        Integer x=0;
        StringBuilder result = new StringBuilder("Program oblicza wartosc funkcji y=3x");

        while (x<=request.getParametrA()){
            result.append("x= ").append(x).append("\t").append("y= ").append(3*x).append("\n");
        }

        return result.toString();
    }

    public String zadanie12for(final IntegerRequest request){
        Random random = new Random();
        Integer iloscLosowan = request.getParametrA();
        List<Integer> listaLiczb = new ArrayList<>();

        Integer min = 100;
        Integer max = 0;
        Integer suma = 0;
        Double srednia = 0.00;

        for (int i=0; i<iloscLosowan; i++){
            listaLiczb.add(random.nextInt(100));
        }

    /*    for(int i =0; i<listaLiczb.size(); i++){
            Integer element = listaLiczb.get(i);

            suma += element; //alternatywa -> suma = suma+element

            if(element<min){
                min = element;
            }

            if (element>max){
                max = element;
            }
        }
     */ //petla for

        for (Integer element:listaLiczb) {
            suma+=element;

            if (element<min){
                min=element;
            }
            if (element>max){
                max=element;
            }
        }
        srednia = (double) suma/listaLiczb.size();
        //alternatywa
      //  srednia = Double.valueOf(suma/listaLiczb.size());

        return "Dla listy: "+ listaLiczb + " Min: " + min +
                " Max: " + max +
                " , natomiast srednia liczny: " + srednia;
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



