package com.example.ejemploexamen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entidad que representa a un administrador de la plataforma de cursos online.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Administrador {
    /*
    - ID: identificador único auto-generado
    - nombreUsuario: username del administrador
    - contrasena: password del administrador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String nombreUsuario;
    @Column(nullable = false, length = 60)
    private String contrasena;
}
