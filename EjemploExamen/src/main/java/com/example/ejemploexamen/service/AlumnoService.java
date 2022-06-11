package com.example.ejemploexamen.service;

import com.example.ejemploexamen.dao.AlumnoDao;
import com.example.ejemploexamen.entity.Alumno;
import com.example.ejemploexamen.repository.AlumnoRepository;
import com.example.ejemploexamen.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase servicio para la entidad Alumno, que contiene las implementaciones de los métodos
 * necesarios para la interacción con la base de datos.
 */
@Service
public class AlumnoService implements AlumnoDao {

    @Autowired
    private AlumnoRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void guardar(Alumno alumno) {
            String contrasenaCodificada = passwordEncoder.encode(alumno.getContrasena());
            alumno.setContrasena(contrasenaCodificada);
            repo.save(alumno);
    }

    @Override
    public void actualizar(Alumno alumno) {
        repo.save(alumno);
    }

    @Override
    public List<Alumno> listar() {
        return repo.findAll();
    }

    @Override
    public Alumno buscar(Long id) {
        return repo.getById(id);
    }

    @Override
    public Optional<Alumno> buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public boolean validacionInscripcion(Authentication usuarioAuth) {
        if (usuarioAuth != null) {
            //Se extrae el usuario
            Usuario usuario = (Usuario) usuarioAuth.getPrincipal();
            if (usuario.getAlumno() == null) {
                return false;
            }
            else {
                Alumno alumno = buscar(usuario.getAlumno().getId());
                return alumno.getCurso() == null;
            }
        }
        else {
            return true;
        }
    }
}
