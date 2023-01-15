package ir.maktab.madel.entity;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends Person implements Serializable {
//اینجا میخوام رابطه بزنم با order
}
