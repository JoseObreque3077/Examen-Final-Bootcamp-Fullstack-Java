package com.example.ejemploexamen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entidad que representa a una región del país.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "region")
    private List<Alumno> alumnos;

}
