package com.example.ejemploexamen.controller;

import com.example.ejemploexamen.dao.AlumnoDao;
import com.example.ejemploexamen.dao.CursoDao;
import com.example.ejemploexamen.entity.Alumno;
import com.example.ejemploexamen.entity.Curso;
import com.example.ejemploexamen.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * Controlador que contiene los métodos necesarios para la navegación entre páginas relacionadas con
 * la entidad Curso (sin relación con la entidad Administrador).
 */
@Controller
public class CursoController {
    //INYECCIÓN DE DEPENDENCIAS
    @Autowired
    private CursoDao cursoDao;
    @Autowired
    private AlumnoDao alumnoDao;

    //LISTADO DE CURSOS DISPONIBLES (EN TARJETAS)
    @GetMapping("/cursos/listado")
    public String cursosDisponibles(Model model, Authentication usuarioAuth) {
        boolean usuarioHab = alumnoDao.validacionInscripcion(usuarioAuth);
        model.addAttribute("usuarioHab", usuarioHab);
        model.addAttribute("cursos", cursoDao.listar());
        return "/otros/cursosDisp";
    }

    //FICHA DE CURSO
    @GetMapping("cursos/ficha/{id}")
    public String fichaCurso(Model model, @PathVariable Long id, Authentication usuarioAuth) {
        boolean usuarioHab = alumnoDao.validacionInscripcion(usuarioAuth);
        model.addAttribute("usuarioHab", usuarioHab);
        //Se busca el curso usando el ID que viene por URL
        model.addAttribute("curso", cursoDao.buscar(id));
        return "/otros/fichaCursos";
    }

}
