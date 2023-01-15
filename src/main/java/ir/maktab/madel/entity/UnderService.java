package ir.maktab.madel.entity;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnderService extends Service implements Serializable {
    private double basePrice;
    private String briefExplanation;

}
