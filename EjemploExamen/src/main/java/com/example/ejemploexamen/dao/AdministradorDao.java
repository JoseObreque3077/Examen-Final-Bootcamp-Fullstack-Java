package com.example.ejemploexamen.dao;

import com.example.ejemploexamen.entity.Administrador;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos necesarios para interactuar con la tabla "administrador" de la base de datos
 */
public interface AdministradorDao {
    /**
     * Método que permite guardar o actualizar un registro de la tabla "administrador" en la base de datos.
     * @param administrador Instancia de la clase Administrador
     */
    void guardar(Administrador administrador);

    /**
     * Método que permite obtener todos los registros de la tabla "administrador" en la base de datos.
     * @return Lista de objetos de la clase Administrador.
     */
    List<Administrador> listar();

    /**
     * Método que permite buscar un registro de la tabla "administrador" en la base de datos, según un
     * identificador único.
     * @param id Identificador único del registro a buscar.
     * @return Objeto de la clase Administrador.
     */
    Administrador buscar(Integer id);

    /**
     * Método que permite buscar un registro de la tabla "administrador" en la base de datos, según un
     email (único).
     * @param nombreUsuario Nombre de usuario del administrador.
     * @return Instancia de la clase Administrador.
     */
    Optional<Administrador> buscarPorNombreUsuario(String nombreUsuario);

    /**
     * Método que permite eliminar un registro de la tabla "administrador" en la base de datos, según un
     * identificador único.
     * @param id Identificador único del registro a eliminar.
     */
    void eliminar(Integer id);


}
