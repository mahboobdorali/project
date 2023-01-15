package ir.maktab.madel.entity;

import lombok.*;

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
@Builder
@NamedQueries(
        @NamedQuery(name = "getAllCustomer",query = "FROM Customer"))
public class Customer extends Person implements Serializable {
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order>orderList=new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comments> commentsList=new ArrayList<>();
}
