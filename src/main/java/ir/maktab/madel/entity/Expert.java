package ir.maktab.madel.entity;

import ir.maktab.madel.enumurated.ApprovalStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SuperBuilder
@NamedQueries(
        @NamedQuery(name = "getAllExpert", query = "FROM Expert"))
public class Expert extends Person implements Serializable {
    private double averageScore;//نباید از کاربر بگیرم و خودم باید متد بنویسم تا میانگین امتیازاتش رو حساب کنه و ذخیره کنه
  //  @Lob
   /* @Column(nullable = false, name = "PERSONAL_PICTURE")
    private byte[] image;
*/
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<UnderService> underServiceList = new ArrayList<>();
    @OneToMany( fetch = FetchType.LAZY)
    private List<Comments> commentsList = new ArrayList<>();
    @OneToMany
    private List<OrdersCustomer> ordersCustomer = new ArrayList<>();
}
