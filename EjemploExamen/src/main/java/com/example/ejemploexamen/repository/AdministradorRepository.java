package com.example.ejemploexamen.repository;

import com.example.ejemploexamen.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio que incluye todos los métodos CRUD, de paginación y ordenamiento desde JPA Repository, para
 * su uso en la tabla "administrador" de la base de datos.
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    /**
     * Busca un registro de la tabla "administrador" usando un nombre de usuario.
     * @param nombreUsuario Nombre de usuario del administrador.
     * @return Instancia de la clase Administrador (opcional).
     */
    Optional<Administrador> findByNombreUsuario(String nombreUsuario);
}