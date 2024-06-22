package com.devsu.financial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Persona {

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private boolean estado;

}
