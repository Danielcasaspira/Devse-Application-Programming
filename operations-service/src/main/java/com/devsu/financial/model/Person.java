package com.devsu.financial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private String gender;

    private int age;

    private String identification;

    private String address;

    private String phone;

}
