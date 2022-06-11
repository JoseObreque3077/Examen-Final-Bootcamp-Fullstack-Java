package com.example.ejemploexamen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * Entidad que representa a un alumno inscrito en la plataforma de cursos online.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    /*
    - ID: identificador único auto-incremental
    - nombre1: primer nombre del alumno
    - nombre2: segundo nombre del alumno
    - apellido1: primer apellido del alumno
    - apellido2: segundo apellido del alumno
    - direccion: dirección calle-comuna del alumno
    - telefono: número de teléfono del alumno (+569XXXXXXXX)
    - email: correo electrónico del alumno (nombre de usuario)
    - contrasena: contraseña del alumno
    - edad: edad del alumno (solo pueden registrarse mayores de edad)
    - region: región en la que vive el alumno (relación N:1)
    - curso: curso inscrito por el alumno (relación N:1) y es opcional (no obligatorio)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(message = "Este campo solo acepta letras", regexp = "^[a-zA-Z\u00F1\u00E1\u00C1\u00E9\u00C9\u00ED\u00CD\u00F3\u00D3\u00FA\u00DA]+$")
    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta entre 3 y 25 caracteres", min = 3,  max = 25)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 25)
    private String nombre1;

    @Pattern(message = "Este campo solo acepta letras", regexp = "^[a-zA-Z\u00F1\u00E1\u00C1\u00E9\u00C9\u00ED\u00CD\u00F3\u00D3\u00FA\u00DA]+$")
    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta entre 3 y 25 caracteres", min = 3,  max = 25)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 25)
    private String nombre2;

    @Pattern(message = "Este campo solo acepta letras", regexp = "^[a-zA-Z\u00F1\u00E1\u00C1\u00E9\u00C9\u00ED\u00CD\u00F3\u00D3\u00FA\u00DA]+$")
    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta entre 3 y 30 caracteres", min = 3,  max = 30)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 30)
    private String apellido1;

    @Pattern(message = "Este campo solo acepta letras", regexp = "^[a-zA-Z\u00F1\u00E1\u00C1\u00E9\u00C9\u00ED\u00CD\u00F3\u00D3\u00FA\u00DA]+$")
    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta entre 3 y 30 caracteres", min = 3,  max = 30)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 30)
    private String apellido2;

    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta hasta 150 caracteres", min = 3,  max = 150)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 150)
    private String direccion;

    @NotNull(message = "Este campo es obligatorio")
    @Pattern(message = "Formato de teléfono no válido", regexp = "^(\\+569\\d{8})$")
    @Column(nullable = false, length = 12)
    private String telefono;

    @Pattern(message = "Formato de email inválido", regexp = "^([\\w.]+@[a-z]+.[a-z]{2,3})$")
    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo acepta hasta 50 caracteres", max = 50)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Length(message = "Este campo acepta entre 10 y 25 caracteres", min = 10, max = 60)
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 60)
    private String contrasena;


    @Max(message = "La edad máxima permitida es 99 años", value = 99)
    @Min(message = "Debes ser mayor de edad", value = 18)
    @Positive(message = "Solo se admiten valores positivos")
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false)
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region", nullable = false) //Esta relación está marcada como obligatoria
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso")
    private Curso curso;

}
