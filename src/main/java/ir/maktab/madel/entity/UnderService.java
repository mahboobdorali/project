package ir.maktab.madel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries(
        @NamedQuery(name = "getAllUnderService",query = "FROM UnderService "))

public class UnderService extends Service implements Serializable {
    private double basePrice;
    private String briefExplanation;

}
