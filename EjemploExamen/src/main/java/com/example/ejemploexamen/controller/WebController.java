package com.example.ejemploexamen.controller;

import com.example.ejemploexamen.security.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que contiene los métodos necesarios para la navegación entre
 * páginas (navegación general).
 */
@Controller
public class WebController {

    //Carga el login personalizado
    @GetMapping("/login")
    public String login() {
        return "seguridad/login";
    }

    //Muestra la pantalla de inicio en la URL vacía
    @GetMapping("/")
    public String inicio() {
        return "/otros/inicio";
    }

}
