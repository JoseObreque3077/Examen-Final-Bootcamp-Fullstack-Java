package com.example.ejemploexamen.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Encriptador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Configuración de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        /*
                        - Carpetas estáticas no requieren permisos
                        - Las URL de páginas asociadas a cursos pueden ser accedidas por cualquiera
                        - Las URL de registro de alumnos puede ser accedida por cualquiera
                        - Las URL de páginas asociadas a los alumnos, requieren autorización de ALUMNO
                        - Las URL de páginas asociadas a los administradores, requieren autorización de ADMIN
                        - Toda otra request requiere autentificación
                         */
                        .antMatchers("/css/**", "/js/**").permitAll()
                        .antMatchers("/", "/cursos/**").permitAll()
                        .antMatchers("/alumno/registro").anonymous()
                        .antMatchers("/alumno/mi-panel", "/alumno/inscripcion-curso/**").hasAuthority("ALUMNO")
                        .antMatchers("/admin/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        /*
                        - La URL del login (manejada por WebController) es "/login"
                        - La URL de login exitoso es "/"
                        - El formulario de login puede ser accedido por cualquiera
                         */
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        /*
                        - La URL para cerrar sesión es "/salir"
                        - La URL a la cual se redirecciona luego de un cierre de sesión exitoso es "/"
                         */
                        .logoutRequestMatcher(new AntPathRequestMatcher("/salir", "GET"))
                        .logoutSuccessUrl("/"));
        return http.build();
    }
}
