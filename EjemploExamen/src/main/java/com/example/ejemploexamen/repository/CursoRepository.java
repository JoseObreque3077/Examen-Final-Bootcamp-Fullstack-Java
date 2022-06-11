package com.example.ejemploexamen.repository;

import com.example.ejemploexamen.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositorio que incluye todos los métodos CRUD, de paginación y ordenamiento desde JPA Repository, para
 * su uso en la tabla "curso" de la base de datos.
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {
}