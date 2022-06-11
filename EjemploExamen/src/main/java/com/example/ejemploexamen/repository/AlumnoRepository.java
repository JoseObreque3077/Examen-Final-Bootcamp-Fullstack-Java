package com.example.ejemploexamen.repository;

import com.example.ejemploexamen.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio que incluye todos los métodos CRUD, de paginación y ordenamiento desde JPA Repository, para
 * su uso en la tabla "alumno" de la base de datos.
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    /**
     * Busca un registro de la tabla "alumno" en la base de datos, según un email.
     * @param email Email del administrador.
     * @return Instancia de la clase Alumno (opcional).
     */
    Optional<Alumno> findByEmail(String email);
}