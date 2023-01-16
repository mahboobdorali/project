package ir.maktab.madel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries(
        @NamedQuery(name = "getAllService",query = "FROM Service"))

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
