package com.example.ejemploexamen.service;

import com.example.ejemploexamen.dao.CursoDao;
import com.example.ejemploexamen.entity.Curso;
import com.example.ejemploexamen.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase servicio para la entidad Curso, que contiene las implementaciones de los métodos
 * necesarios para la interacción con la base de datos.
 */
@Service
public class CursoService implements CursoDao {

    @Autowired
    private CursoRepository repo;

    @Override
    public void guardar(Curso curso) {
        Integer cuposIniciales = curso.getCuposIniciales();
        curso.setCuposDisponibles(cuposIniciales);
        repo.save(curso);
    }

    @Override
    public void actualizar(Curso curso) {
        repo.save(curso);
    }

    @Override
    public List<Curso> listar() {
        return repo.findAll();
    }

    @Override
    public Curso buscar(Long id) {
        return repo.getById(id);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
