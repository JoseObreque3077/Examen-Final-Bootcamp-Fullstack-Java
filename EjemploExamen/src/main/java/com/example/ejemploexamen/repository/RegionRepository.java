package com.example.ejemploexamen.repository;

import com.example.ejemploexamen.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositorio que incluye todos los métodos CRUD, de paginación y ordenamiento desde JPA Repository, para
 * su uso en la tabla "region" de la base de datos.
 */
public interface RegionRepository extends JpaRepository<Region, Integer> {
}