package com.example.ejemploexamen.security;

import com.example.ejemploexamen.dao.AdministradorDao;
import com.example.ejemploexamen.dao.AlumnoDao;
import com.example.ejemploexamen.entity.Administrador;
import com.example.ejemploexamen.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private AdministradorDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca un alumno (opcional) en la BD según un email ingresado en el login
        Optional<Alumno> alumnoOptional = alumnoDao.buscarPorEmail(username);
        /*
        - Si el usuario efectivamente es un alumno, se retorna una instancia de la clase Usuario
        con el atributo admin en null.
         */
        if (alumnoOptional.isPresent()) {
            return new Usuario(alumnoOptional.get(), null);
        }
        else {
            //Se busca un administrador (opcional) en la BD según un email ingresado en el login
            Optional<Administrador> adminOptional = adminDao.buscarPorNombreUsuario(username);
            /*
            - Si el usuario efectivamente es un admin, se retorna una instancia de la clase Usuario
            con el atributo alumno en null.
             */
            if (adminOptional.isPresent()) {
                return new Usuario(null, adminOptional.get());
            }
        }
        /*
        - Si las credenciales ingresadas en el login no pertenecen ni a un alumno ni a un admin
        entonces se lanza una excepción.
         */
        throw new UsernameNotFoundException("Usuario no encontrado.");
    }
}
