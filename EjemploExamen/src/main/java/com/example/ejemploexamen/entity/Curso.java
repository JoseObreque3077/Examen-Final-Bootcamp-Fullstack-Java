package com.example.ejemploexamen.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * Entidad que representa a un curso disponible en la plataforma de cursos online.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Curso {
    /*
    - Id: Identificador único auto-incremental
    - nombre: Nombre del curso
    - descripcion: Descripción general del curso
    - contenidos: Contenidos del curso
    - fechaInicio: fecha de inicio del curso
    - fechaFinal: fecha de término del curso
    - cuposIniciales: cupos iniciales del curso (no se modifican)
    - cuposDisponibles: cupos disponibles del curso
    - imagen: URL de una imagen referencial para el curso
    - alumnos: Lista de Alumnos inscritos en este curso (relación 1:N)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo admite hasta 75 caracteres", max = 75)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 75)
    private String nombre;

    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo admite hasta 255 caracteres", max = 500)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 500)
    private String descripcion;

    @NotBlank(message = "Este campo es obligatorio")
    @Length(message = "Este campo admite hasta 255 caracteres", max = 500)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false, length = 500)
    private String contenidos;

    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinal;

    @Positive(message = "Este campo no admite números negativos")
    @Min(message = "Este campo debe ser mayor que cero", value = 1)
    @NotNull(message = "Este campo es obligatorio")
    @Column(nullable = false)
    private Integer cuposIniciales;

    @Column(nullable = false)
    private Integer cuposDisponibles;

    @Column(nullable = false)
    private String imagen; //URL DE IMAGEN

    @OneToMany(mappedBy = "curso")
    private List<Alumno> alumnos;

}
