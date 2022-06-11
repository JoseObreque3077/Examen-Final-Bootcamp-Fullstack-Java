package com.example.ejemploexamen.dao;

import com.example.ejemploexamen.entity.Region;

import java.util.List;
/**
 * Interfaz que define los métodos necesarios para interactuar con la tabla "region" de la base de datos.
 */
public interface RegionDao {
    /**
     * Método que permite guardar un registro en la tabla "región" de la base de datos.
     * @param region Instancia de la clase Region a guardar.
     */
    void crear(Region region);

    /**
     * Método que permite obtener una lista con todos los registros de la tabla "región" de la base de datos.
     * @return Lista con instancias de la clase Region.
     */
    List<Region> listar();

    /**
     * Método que permite buscar un registro de la tabla "region" en la base de datos.
     * @param id Identificador único del registro a buscar.
     * @return Instancia de la clase región.
     */
    Region buscar(Integer id);

    /**
     * Método que permite eliminar un registro de la tabla "region" de la base de datos.
     * @param id Identificador único del registro a eliminar.
     */
    void eliminar(Integer id);
}
