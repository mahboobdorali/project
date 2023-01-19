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
        @NamedQuery(name = "getAllUnderService",query = "FROM UnderService "))

public class UnderService  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSubService;
    private double basePrice;
    private String briefExplanation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Service Service;
}
