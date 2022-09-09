package pl.cyber.trainess.demo.service;

import groovyjarjarantlr4.v4.runtime.misc.IntegerList;
import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.IntegerListRequest;
import pl.cyber.trainess.demo.dto.LiteryDTO;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.StringRequest;

import java.sql.Array;
import java.util.*;

@Service
public class BasicsService {

    private static String SPACJA = " ";

    public String getSklejenie(final StringRequest request) {
    //    return request.getStringPierwszy()+request.getStringDrugi();

        // Alternatywa przy uzyciu zewnetrznej biblioteki

        var string = new StringBuilder();
        return string.append(request.getStringPierwszy())
                .append(SPACJA)
                .append(request.getStringDrugi())
                .toString();
    }

    public List<String> getWystapieniaLiterWZdaniu(final OneStringRequest request) {

        List<LiteryDTO> wystapienia = new ArrayList<>();
        Set<String> litery =new HashSet<>();
        List<String > wynik = new ArrayList<>();

        String zdanie = request.getValue();

        for(int i=0; i < zdanie.length(); i++){
            String litera = String.valueOf(zdanie.charAt(i));

            if(litera.matches("[a-zA-Z]+")) {
                if(wystapienia.size()==0){
                    litery.add(litera.toLowerCase());
                    wystapienia.add((LiteryDTO.builder().litera(litera.toLowerCase()).ilosc(1).build()));
                } else {
                    if(litery.contains(litera.toLowerCase())){
                        for (LiteryDTO element :
                             wystapienia) {
                            if(element.getLitera().equals(litera.toLowerCase())){
                                element.setIlosc(element.getIlosc()+1);
                            }
                        }
                    } else {
                        litery.add(litera.toLowerCase());
                        wystapienia.add(LiteryDTO.builder().litera(litera.toLowerCase()).ilosc(1).build());
                    }
                }
            }
        }
        for (LiteryDTO element: wystapienia) {
            wynik.add(element.getLitera()+" - " + element.getIlosc());
        }
        wynik.sort(String::compareTo);

        return wynik;
    }

    // Zadanie w oparciu o kolekcje Map

    public List<String>getWystapieniaLiterWZdaniuMap(final OneStringRequest request){
        Map<String, Integer> wystapienia = new HashMap<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue().toLowerCase();

        for(int i =0; i< zdanie.length(); i++){
            String litera = String.valueOf(zdanie.charAt(i));

            if(litera.matches("[a-zA-Z]+")){
                if(wystapienia.containsKey(litera)){
                    wystapienia.put(litera,wystapienia.get(litera)+1);
                } else {
                    wystapienia.put(litera, 1);
                }
            }
        }
        for (String element: wystapienia.keySet()){
            wynik.add(element+" - " + wystapienia.get(element));
        }
        return wynik;
    }

    public String sumaLiczbPomiedzy(final Integer a, final Integer b) {
        Integer wynik =0;

        if (a > b) {
            throw new RuntimeException("Wartosc parametru 'a' powinna byc mniejsza od wartosci 'b' ");
        }

        for(int i = a; i<=b; i++){
            wynik += i;

        }
        return "Wynik dodawania liczb pomiedzy a: " + a + " oraz b: " + b +" to: " + wynik;
    }

    public String zadanie8(final IntegerListRequest request) {

        List<Integer> listaUjemnych = new ArrayList<>();
        Integer sumaDodatnich = 0;

        for (Integer element:
                request.getIntList()) {
            if (element< 0) {
                listaUjemnych.add(element);
            } else {
                sumaDodatnich += element;
            }

        }

        return listaUjemnych + " oraz suma liczb dodatnich wynosi" + sumaDodatnich;
    }
}
