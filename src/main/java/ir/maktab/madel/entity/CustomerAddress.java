package ir.maktab.madel.entity;

import lombok.*;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class CustomerAddress {
private String street;
private String city;
private String plaque;
}
