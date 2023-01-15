package ir.maktab.madel.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double proposedPrice;

    private String jobDescription;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeOfWork;
    @Column(nullable = false)
    private String customerAddress;

    @Enumerated(EnumType.STRING)
    private CurrentSituation currentSituation;
//این قسمت برای مشتریه
}
