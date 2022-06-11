package com.example.ejemploexamen.dao;

import com.example.ejemploexamen.entity.Curso;

import java.util.List;

/**
 * Interfaz que define los métodos necesarios para interactuar con la tabla "curso" de la base de datos.
 */
public interface CursoDao {

    /**
     * Método que permite guardar un registro en la tabla "curso" de la base de datos.
     * @param curso Instancia de la clase Curso a guardar.
     */
    void guardar(Curso curso);

    /**
     * Método que permite actualizar un registro en la tabla "curso" en la base de datos.
     * @param curso Instancia de la clase Curso a actualizar.
     */
    void actualizar(Curso curso);

    /**
     * Método que permite obtener una lista con todos los registros de la tabla "curso" de la base de datos.
     * @return Lista con instancias de la clase Curso.
     */
    List<Curso> listar();

    /**
     * Método que permite buscar un registro de la tabla "curso" en la base de datos.
     * @param id Identificador único del registro a buscar.
     * @return Instancia de la clase Curso.
     */
    Curso buscar(Long id);

    /**
     * Método que permite eliminar un registro de la tabla "curso" de la base de datos.
     * @param id Identificador único del registro a eliminar.
     */
    void eliminar(Long id);

}
