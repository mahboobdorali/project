package ir.maktab.madel.entity;

import ir.maktab.madel.enumurated.CurrentSituation;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<UnderService> underService=new ArrayList<>();
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
