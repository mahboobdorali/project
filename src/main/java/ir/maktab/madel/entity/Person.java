package ir.maktab.madel.entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String family;
    @Column(nullable = false, unique = true)
    private String emailAddress;
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeOfRegistration;
    @Column(nullable = false)
    private boolean isConfirm;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", dateAndTimeOfRegistration=" + dateAndTimeOfRegistration +
                '}';
    }
}
