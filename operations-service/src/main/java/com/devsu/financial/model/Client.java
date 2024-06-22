package com.devsu.financial.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Client")
public class Client extends Person {

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean status;

}
