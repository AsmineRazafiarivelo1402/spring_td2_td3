package org.hei.spring_td2_td3.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;

}

