package ir.maktab.madel.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany( fetch = FetchType.LAZY)
    private List<OrdersCustomer> ordersCustomerList = new ArrayList<>();

}
