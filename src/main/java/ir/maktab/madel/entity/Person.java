package ir.maktab.madel.entity;
import ir.maktab.madel.enumurated.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
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
    @Column(unique = true, nullable = false,length=8)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateAndTimeOfRegistration;
    private double amount;//کاربر خودش نباید وارد کنه و هرچی از حساب مشتریش کم شد باید به حساب این واریز بشه

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", dateAndTimeOfRegistration=" + dateAndTimeOfRegistration +
                ", amount=" + amount +
                '}';
    }
}
