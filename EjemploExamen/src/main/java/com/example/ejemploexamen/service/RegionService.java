package com.example.ejemploexamen.service;

import com.example.ejemploexamen.dao.RegionDao;
import com.example.ejemploexamen.entity.Region;
import com.example.ejemploexamen.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase servicio para la entidad Región, que contiene las implementaciones de los métodos
 * necesarios para la interacción con la base de datos.
 */
@Service
public class RegionService implements RegionDao {

    @Autowired
    private RegionRepository repo;


    @Override
    public void crear(Region region) {
        repo.save(region);
    }

    @Override
    public List<Region> listar() {
        return repo.findAll();
    }

    @Override
    public Region buscar(Integer id) {
        return repo.getById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
