package com.example.ejemploexamen.service;

import com.example.ejemploexamen.dao.AdministradorDao;
import com.example.ejemploexamen.entity.Administrador;
import com.example.ejemploexamen.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase servicio para la entidad Administrador, que contiene las implementaciones de los métodos
 * necesarios para la interacción con la base de datos.
 */
@Service
public class AdministradorService implements AdministradorDao {

    //Inyección de dependencias: AdministradorRepository
    @Autowired
    private AdministradorRepository repo;

    @Override
    public void guardar(Administrador administrador) {
        repo.save(administrador);
    }

    @Override
    public List<Administrador> listar() {
        return repo.findAll();
    }

    @Override
    public Administrador buscar(Integer id) {
        return repo.getById(id);
    }

    @Override
    public Optional<Administrador> buscarPorNombreUsuario(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
