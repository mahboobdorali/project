package ir.maktab.madel.entity;

import ir.maktab.madel.enumurated.CurrentSituation;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@NamedQueries(
        @NamedQuery(name = "getAllOrder", query = "FROM OrdersCustomer "))
public class OrdersCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double proposedPrice;
    private String jobDescription;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeOfWork;
    @Embedded
    @AttributeOverrides(value ={
            @AttributeOverride(name="city",column = @Column(nullable = false)),
            @AttributeOverride(name="plaque",column = @Column(nullable = false))
    })
    private CustomerAddress customerAddress;

    @Enumerated(EnumType.STRING)
    private CurrentSituation currentSituation;
}
