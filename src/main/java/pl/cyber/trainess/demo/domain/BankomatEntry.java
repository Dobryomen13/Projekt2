package pl.cyber.trainess.demo.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.cyber.trainess.demo.dto.BankomatDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BANKOMAT")
public class BankomatEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID",updatable = false, nullable = false)
    private String id;

    @Setter
    @Column(name = "NAME")
    private String name;

    @Setter
    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "MIASTO")
    private String miasto;

    @Column(name = "ULICA")
    private String ulica;

    @Setter
    @Column(name = "CZY_AKTYWNY")
    private Boolean czyAktywny;

    public BankomatDTO convertToDTO() {
        return BankomatDTO.builder()
                .id(this.id)
                .name(this.name)
                .saldo(this.saldo)
                .ulica(this.ulica)
                .miasto(this.miasto)
                .czyAktywny(this.czyAktywny)
                .build();
    }

}
