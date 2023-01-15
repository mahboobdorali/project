package ir.maktab.madel.entity;

import ir.maktab.madel.enumurated.ApprovalStatus;
import lombok.*;

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
@Builder
@NamedQueries(
        @NamedQuery(name = "getAllExpert",query = "FROM Expert"))
public class Expert extends Person implements Serializable {
    private double averageScore;//نباید از کاربر بگیرم و خودم باید متد بنویسم تا میانگین امتیازاتش رو حساب کنه و ذخیره کنه
    @Lob
    @Column(nullable = false, name = "PERSONAL_PICTURE")
    private byte[] image;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<UnderService> list = new ArrayList<>();

    //private double amount;//کاربر خودش نباید وارد کنه و هرچی از حساب مشتریش کم شد باید به حساب این واریز بشه
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<SubmitAnOffer> submitAnOfferList = new ArrayList<>();






       /* System.out.print("your personalCode is : ");
    int min = 1000;
    int max = 9999;
        expert.setCvv2((int) (Math.random() * (max - min + 1) + min));
        System.out.println(expert.getCode);*/

}
