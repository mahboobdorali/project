package ir.maktab.madel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class SubmitAnOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeRegistrationOfOffer;
    @ManyToOne
    private Expert expert;
    @OneToOne
    private OrdersCustomer ordersCustomer;
    private double priceOffer;

    private Duration durationOfWork;

    @Temporal(value = TemporalType.TIME)
    private Date TimeProposeToStartWork;
}
