package pl.cyber.trainess.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.Person;
import pl.cyber.trainess.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private List<Person> personList = new ArrayList<>();

    public void createPerson(final PersonRequest request){
        walidujOsobe(request);
        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }

    private void walidujOsobe (final PersonRequest request){
        boolean czyIstnieje = false;
        for (Person element: personList){
            if(element.getImie().equals(request.getImie()) &&
                    element.getNazwisko().equals(request.getNazwisko()) &&
                    element.getDataUrodzenia().equals(request.getDataUrodzenia()))
            {
                czyIstnieje = true;
            }
        } if (czyIstnieje){
            throw new RuntimeException("Taka osoba juz istnieje");
        }

    }

}
