package ir.maktab.madel.entity;

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

public class Expert extends Person implements Serializable {
    private double averageScore;//نباید از کاربر بگیرم و خودم باید متد بنویسم تا میانگین امتیازاتش رو حساب کنه و ذخیره کنه
    @Lob
    @Column(nullable = false, name = "PERSONAL_PICTURE")
    private byte[] image;
    @Column(unique = true, nullable = false)
    private int code;//رندوم هندلش کنم
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<زیرخدمت> list = new ArrayList<>();
    //private double amount;//کاربر خودش نباید وارد کنه و هرچی از حساب مشتریش کم شد باید به حساب این واریز بشه
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    private List<SubmitAnOffer> submitAnOfferList = new ArrayList<>();






       /* System.out.print("your personalCode is : ");
    int min = 1000;
    int max = 9999;
        expert.setCvv2((int) (Math.random() * (max - min + 1) + min));
        System.out.println(expert.getCode);*/

}
