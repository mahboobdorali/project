package ir.maktab.madel.entity;

import lombok.*;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CustomerAddress {
private String street;
private String City;
private String plaque;
}
