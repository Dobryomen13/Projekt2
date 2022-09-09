package pl.cyber.trainess.demo.endpoint;

import groovyjarjarantlr4.v4.runtime.misc.IntegerList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainess.demo.dto.IntegerListRequest;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;
import pl.cyber.trainess.demo.service.BasicsService;
import pl.cyber.trainess.demo.service.KalkulatorSrevice;
import pl.cyber.trainess.demo.service.ZnajdzService;

import java.util.List;

@RestController
@RequestMapping("/v1/basics")
@RequiredArgsConstructor
public class BasicsController {
    /*
    Zadanie 1
    Napisać zapytania dla prostego kalkulatora, ktory bedzie obslugiwac 5 operacji
    kazda z nich powinna byc oddzielnym zapytaniem restowym

    Opreacja:
    -dodawanie
    -odejmowanie
    -mnozenie
    -dzielenie
    -obiczenie reszty z dzielenia liczb
    Zwrocenie wyniku naszych operacji.

    Np.
    "/dodawanie/{a}"

    @PathVariable
     */

    private final KalkulatorSrevice kalkulatorSrevice;
    private final BasicsService basicsService;
    private final ZnajdzService znajdzService;

    @GetMapping("/dodawanie/{a}/{b}")
    public Integer getDodawanie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB){
        return kalkulatorSrevice.getDodawanie(liczbaA,liczbaB);

    }
    @GetMapping("/dodawanieParams")
    public Integer getDodawanieParams(@RequestParam("a") final Integer liczbaA, @RequestParam("b") final Integer liczbaB){
        return kalkulatorSrevice.getDodawanie(liczbaA,liczbaB);

    }

    @GetMapping("/odejmowanie/{a}/{b}")
    public Integer getOdejmowanie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB){
        return kalkulatorSrevice.getOdejmowanie(liczbaA,liczbaB);

    }

    @GetMapping("/mnozenie/{a}/{b}")
    public Integer getMnozenie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB){
        return kalkulatorSrevice.getMnozenie(liczbaA,liczbaB);

    }

    @GetMapping("/dzielenie/{a}/{b}")
    public Integer getDzielenie(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB){
        return kalkulatorSrevice.getDzielenie(liczbaA,liczbaB);

    }

    @GetMapping("/reszta/{a}/{b}")
    public Integer getReszta(@PathVariable("a") final Integer liczbaA, @PathVariable("b") final Integer liczbaB){
        return kalkulatorSrevice.getReszta(liczbaA,liczbaB);

    }
    // Zadanie 2
    /*
    Napisz zapytanie restowe, ktorego zadaniem bedzie wykonanie sprawdzenia
    czy przekazana liczba jest liczba pierwsza

     */


 /*   @GetMapping("/czyLiczbaPierwsza/{liczbaA}")
    public String getCzyLiczbaPierwsza(@PathVariable("a") final Integer liczbaA){
        return kalkulatorSrevice.getCzyLiczbaPierwsza(liczbaA);

    }

  */

    //Zadanie 3
    /*
    Napisz zapytanie restowe, ktorego zadaniem bedzie wykonanie sklejenia dwoch
    Stringow (przekazanych jako RequestBody) a nastepnie zwroci wynik.
    POST/PUT
     */

 /*   @PostMapping("/sklejenie-stringow")
    public String getSklejenie(
            @RequestBody final StringRequest request){
        return basicsService.getSklejenie(request);

    }

  */
    //    region Zadanie4
/*Napisz zapytanie restowe, którego zadaniem będzie przyjęcie napisu  jako zdania
(przekazanych jako RequestBody)
 Program powinien policzyć ilość wystąpień poszczególnych liter zdania i zwrócić
 odpowiednio przygotowane dane.
Uwaga należy pominąć litery, których w zdaniu nie ma oraz wszystkie znaki puste.

Przykład.
Ala ma kota

a - 4
k - 1
l - 1
m - 1
o - 1
t - 1
*/

/*
    @PostMapping
    @RequestBody

    List<LiteryDTO> wystapienia
    Set<String>litery
    List<String>wynik

    pętla for przejscie po kazdym znaku w zdania
    if jeżeli znak ze zdania jest litera to nalezy wykonac dodawanie lub aktualizacje naszej listy

    Object String posiada metode matches(//reqexp//) .matches("[a-zA-Z]+")

    Object List posiada metode sort(//Comparator//) wynik.sort(String::compareTo)

 */
    @PostMapping("/zliczanie")
    public List<String> getWystapieniaLiterWZdaniuMap(
            @RequestBody final OneStringRequest request
    ) {
        return basicsService.getWystapieniaLiterWZdaniu(request);
    }

    //Zadanie 5
    /*
    Napisz zapytanie restowe, ktorego zadaniem bedzie przekazanie liczb a i b (calkowite)
    nastepnie wykona sprawdzenie czy liczba a jest dzielnikiem liczby b i zwroci
    inforamcje true or false
     */

    @GetMapping("/czyDzielnik/{a}/{b}")
    public boolean getCzyDzielnik(@PathVariable("a") final Integer a, @PathVariable("b") final Integer b){
        return kalkulatorSrevice.getCzyDzielnik(a,b);
    }



//region Zadanie6
/*
Napisz program, który wygeneruje liczbę Random z przedziału od 10 - 1000.
Naszym zadaniem będzie odnalezienie wygenerowanej liczby.
W tym celu należy utworzyć zapytanie restowe, które będzie przyjmowało liczbę
i porównywało ją z wygenerowaną przez system.
Jeśli wprowadzona liczba będzie tą wygenerowaną zostanie zwrócony napis "Udało się!!"
Jeśli wprowadzona liczba będzie mniejsza od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest większa"
Jeśli wprowadzona liczba będzie większa od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest mniejsza"

Uwaga aby generowana liczba powinna być parametrem klasy aby przy każdym zapytaniu
restowym nie doszło do jej modyfikacji.
*/

    @GetMapping("/czyWylosowana/{a}")
    public String getCzyWylosowana(@PathVariable("a") final Integer a){
        return znajdzService.getLosowaLiczba(a);

    }
    @GetMapping("/znajdz/{a}")
    public String znjadzLiczbe(@PathVariable("a") final Integer liczba){
        return znajdzService.ZnajdzLiczbe(liczba);

    }

    //region Zadanie7
  /*
  Napisz program, w którym zostaną przekazane liczby a i b (całkowite) następnie
  zostaną zsumowane wszystkie liczby pomiędzy od a do b
  (jako przedział zamknięty dwustronnie).
  Przykład podajemy: 1 do 10 czego wynikiem będzie 55
  */
    //GET PathVariable lub RequestParam w zaleznosci jak pasuje
    //besicsService

    //endregion

    //region Zadanie8
  /*Napisz program, w krótym przekażemy listę elementów liczb całkowitych program
  powinien zwrócić listę elementów z wartościami ujemnymi oraz sumę liczb,
  które są dodatnie.
  Np. [1, 2, 3, 4, 5, -3, -2, -1]
  wynik:
  [-3, -2, -1] oraz suma liczb dodatnich wynosi: 15
  */

    //POST RequestBody
    //IntegerListReques >>> List<Integer> (utworzyc klase DTO)
    // {
    // "lista": [1, 2, 3, 4, 5, 6, 7, 8]
    // }

    /*
    if do sprawdzenia czy liczba z listy jest ujemna czy dodatnia
     */

    // besicsService
    //endregion

    //region zadanie9
    /*
    Napisz zapytanie restowe, którego zadaniem będzie obliczał pierwiastek
    równania kwadratowego ax2 + bx + c = 0.
    (Do wykorzystania instrukcja if). Pamiętać należy że zmienne a, b i c to
    liczby rzeczywiste.
    Zadanie powinno zwrócić Napis:
    a) To nie jest równanie kwadratowe
    b) Brak pierwiastków
    c) Jeden pierwiastek. Wynik: xxxx
    d) Dwa pierwiastki. Wynik -> x1: xxxx, x2: xxxx


    delta = b*b-4*a*c;
    jeżeli delta == 0
    x1 = -b/(2*a);

    jeśli delta > 0
    x1 = (-b-Math.sqrt(delta))/(2*a);
    x2 = (-b-Math.sqrt(delta))/(2*a); cos tu mam zle
     */

    // GET PathVariable, nie uzywac na liczbach zmiennoprzecinkowych
    // GET RequestParam,
    // POST, BodyRequest
    //KalkulatorService
    //endregion

    //zadanie 7
    @GetMapping("/suma-liczb")
    public String sumaLiczbPomiedzy(
            @RequestParam("a") final Integer a,
            @RequestParam("b") final Integer b
    ) {
        return basicsService.sumaLiczbPomiedzy(a,b);
    }

    //zadanie 8

    @PostMapping("/liczby")
    public String zadanie8(
            @RequestBody final IntegerListRequest request
            ) {
        return basicsService.zadanie8(request);
    }

    @GetMapping("/rownanieKwadratowe/{a}/{b}/{c}")
    public String rownanieKwadratowe(
            @PathVariable("a") final Integer a,
            @PathVariable("b") final Integer b,
            @PathVariable("c") final Integer c
    ) {
        return kalkulatorSrevice.rownanieKwadratowe(a,b,c);
    }

    @PostMapping("/rownanieKwadratowe-b")
    public String rownanieKwadratowe(
            @RequestBody final RownanieKwRequest request
    ) {
        return kalkulatorSrevice.rownanieKwadratowe(request);
    }

    @PostMapping("/rownanieKwadratowe-b-2miejsca")
    public String rownanieKwadratowe2miejsca(
            @RequestBody final RownanieKwRequest request
    ) {
        return kalkulatorSrevice.rownanieKwadratowe2miejsca(request);
    }

}
