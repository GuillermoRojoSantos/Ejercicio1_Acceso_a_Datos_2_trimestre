package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Alumno {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;

    public String nombre;

    public String telefono;

    public String email;

    public Double nDI;

    public Double nAD;
}
