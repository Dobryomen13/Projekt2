package pl.cyber.trainess.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
/*
new LiteryDTO("a",1);

LiteryDTO.builder()
.litera("a")
.ilosc(1)
.build()

litera ->, jej ilosc -> 1
___________________________

new LiteryDTO("a",null);

LiteryDTO.builder()
.litera("a")
.build()

litera -> a, jej ilosc -> null

 */
@AllArgsConstructor
public class LiteryDTO {
    private String litera;
    private Integer ilosc;
}
