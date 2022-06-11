package com.example.ejemploexamen.security;

import com.example.ejemploexamen.entity.Administrador;
import com.example.ejemploexamen.entity.Alumno;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {
    //Un usuario autentificado puede ser un Alumno o un Administrador.
    private Alumno alumno;
    private Administrador admin;

    //Constructor de la clase
    public Usuario(Alumno alumno, Administrador admin) {
        this.alumno = alumno;
        this.admin = admin;
    }

    //Getters
    public Alumno getAlumno() {
        return alumno;
    }

    public Administrador getAdmin() {
        return admin;
    }

    //Métodos de la interfaz UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        - A los alumnos autentificados, se les otorga un permiso de ALUMNO
        - A los administradores autentificados, se les otorga un permiso de ADMIN
         */
        if (alumno != null) {
            return List.of(new SimpleGrantedAuthority("ALUMNO"));
        }
        if (admin != null) {
            return List.of(new SimpleGrantedAuthority("ADMIN"));
        }
        return null;
    }

    @Override
    public String getPassword() {
        // Se extrae la contraseña del alumno o el admin autentificado
        if (alumno != null) {
            return alumno.getContrasena();
        }
        if (admin != null) {
            return admin.getContrasena();
        }
        return null;
    }

    @Override
    public String getUsername() {
        // Se extrae el nombre de usuario del alumno o el admin autentificado
        if (alumno != null) {
            return alumno.getNombre1() + ' ' + alumno.getApellido1();
        }
        if (admin != null) {
            return admin.getNombreUsuario();
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        //Por defecto las cuentas no se encuentran expiradas
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //Por defecto las cuentas no se encuentran bloqueadas
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //Por defecto, las credenciales no se encuentran expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {
        //Por defecto, las cuentas se encuentran habilitadas/activadas
        return true;
    }

}
