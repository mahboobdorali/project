package ir.maktab.madel.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@NamedQueries(
        @NamedQuery(name = "getAllCustomer",query = "FROM Customer"))
public class Customer extends Person implements Serializable {

}
