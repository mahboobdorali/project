package ir.maktab.madel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    private Date dateAndTimeOfOffer;

    private double priceOffer;

    @Temporal(value = TemporalType.TIME)
    private Date durationOfWork;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date TimeProposeToDoWork;

//برای متخصص
}
