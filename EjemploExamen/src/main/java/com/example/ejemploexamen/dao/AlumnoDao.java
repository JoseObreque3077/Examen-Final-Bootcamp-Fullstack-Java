package com.example.ejemploexamen.dao;

import com.example.ejemploexamen.entity.Alumno;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos necesarios para interactuar con la tabla "alumno" de la base de datos
 */
public interface AlumnoDao {
    /**
     * Método que permite guardar o actualizar un registro de la tabla "alumno" en la base de datos.
     * @param alumno Instancia de la clase Alumno.
     */
    void guardar(Alumno alumno);

    /**
     * Método que permite actualizar la información de un Alumno en la base de datos.
     * @param alumno Instancia de la clase Alumno con la información a actualizar
     */
    void actualizar(Alumno alumno);

    /**
     * Método que permite obtener todos los registros de la tabla "alumno" en la base de datos.
     * @return Lista de objetos de la clase Alumno.
     */
    List<Alumno> listar();

    /**
     * Método que permite buscar un registro de la tabla "alumno" en la base de datos, según un
     * identificador único.
     * @param id Identificador único del registro a buscar.
     * @return Instancia de la clase Alumno.
     */
    Alumno buscar(Long id);

    /**
     * Método que permite buscar un registro de la tabla "alumno" en la base de datos, según un
     email (único).
     * @param email Correo electrónico del alumno.
     * @return Instancia de la clase Alumno.
     */
    Optional<Alumno> buscarPorEmail(String email);

    /**
     * Método que permite eliminar un registro de la tabla "alumno" en la base de datos, según un
     * identificador único.
     * @param id Identificador único del registro a eliminar.
     */
    void eliminar(Long id);

    /**
     * Método que permite identificar si un Alumno puede inscribir un curso en base a si tiene inscrito
     * un curso o no.
     * @param usuarioAuth Usuario autentificado
     * @return verdadero si no tiene cursos inscritos, falso en caso contrario
     */
    boolean validacionInscripcion(Authentication usuarioAuth);
}
