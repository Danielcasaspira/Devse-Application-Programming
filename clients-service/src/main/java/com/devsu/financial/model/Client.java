package com.devsu.financial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Client")
public class Client extends Person implements Serializable {

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean status;

}
