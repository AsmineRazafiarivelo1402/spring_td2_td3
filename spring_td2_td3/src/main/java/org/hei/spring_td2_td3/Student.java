package org.hei.spring_td2_td3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String reference;
    private String firstName;
    private String lastName;
    private int age;

}

