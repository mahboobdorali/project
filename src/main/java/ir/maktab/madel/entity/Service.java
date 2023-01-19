package ir.maktab.madel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
/*
@NamedQueries(
        @NamedQuery(name = "getAllService",query = "FROM Service"))
*/

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
