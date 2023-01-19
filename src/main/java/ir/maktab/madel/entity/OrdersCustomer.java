package ir.maktab.madel.entity;

import ir.maktab.madel.enumurated.CurrentSituation;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
        @NamedQuery(name = "getAllOrder",query = "FROM OrdersCustomer "))
public class OrdersCustomer {//سفارش
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double proposedPrice;
    private String jobDescription;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeOfWork;
    @Column(nullable = false)
    private String customerAddress;

    @Enumerated(EnumType.STRING)
    private CurrentSituation currentSituation;
//این قسمت برای مشتریه
}
