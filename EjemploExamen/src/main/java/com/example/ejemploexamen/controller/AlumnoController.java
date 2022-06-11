package com.example.ejemploexamen.controller;

import com.example.ejemploexamen.dao.AlumnoDao;
import com.example.ejemploexamen.dao.CursoDao;
import com.example.ejemploexamen.dao.RegionDao;
import com.example.ejemploexamen.entity.Alumno;
import com.example.ejemploexamen.entity.Curso;
import com.example.ejemploexamen.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Controlador que contiene los métodos necesarios para la navegación entre páginas relacionadas con
 * la entidad Alumno.
 */
@Controller
public class AlumnoController {
    //INYECCIÓN DE DEPENDENCIAS
    @Autowired
    private RegionDao regionDao;
    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private CursoDao cursoDao;

    //FORMULARIO DE REGISTRO DE ALUMNOS
    @GetMapping("/alumno/registro")
    public String registroAlumnos(Alumno alumno, Model model) {
        model.addAttribute("alumno", alumno);
        model.addAttribute("regiones", regionDao.listar());
        return "/formularios/registroAlumno";
    }

    /*
    - RECIBE DATOS DESDE FORMULARIO DE REGISTRO DE ALUMNOS
    - MUESTRA EL MISMO FORMULARIO DE ORIGEN EN CASO DE ERROR DE VALIDACIONES
    - REDIRECCIONA AL INICIO EN CASO DE REGISTRO EXITOSO
     */
    @PostMapping("/alumno/registro")
    public String envioRegistroAlumnos(@Valid Alumno alumno, BindingResult bindingResult, Model model) {
        boolean emailEnUso = alumnoDao.buscarPorEmail(alumno.getEmail()).isPresent();
        if (bindingResult.hasErrors() || emailEnUso) {
            model.addAttribute("regiones", regionDao.listar());
            model.addAttribute("emailEnUso", emailEnUso);
            return "/formularios/registroAlumno";
        }
        else {
            alumnoDao.guardar(alumno);
            return "redirect:/";
        }
    }

    //PANEL DE UN ALUMNO YA AUTENTIFICADO
    @GetMapping("/alumno/mi-panel")
    public String panel(Authentication usuarioAuth, Model model) {
        Usuario usuario = (Usuario) usuarioAuth.getPrincipal();
        Alumno alumno = alumnoDao.buscar(usuario.getAlumno().getId());
        model.addAttribute("curso", alumno.getCurso());
        return "/otros/panel";
    }

    //INSCRIPCIÓN EN CURSO
    @GetMapping("alumno/inscripcion-curso/{id}")
    public String inscribirAlumnoEnCurso(@PathVariable Long id,
                                         Authentication usuarioAuth) {
        if (usuarioAuth!=null) {
            //Se obtiene el usuario autentificado
            Usuario usuario = (Usuario) usuarioAuth.getPrincipal();
            //Se obtiene el alumno autentificado a partir del objeto usuario
            Alumno alumno = alumnoDao.buscar(usuario.getAlumno().getId());
            //Se busca el curso al cual se desea inscribir usando el ID de la URL
            Curso curso = cursoDao.buscar(id);
            //Se le asigna el curso al alumno
            alumno.setCurso(curso);
            //Se actualiza el alumno en la base de datos con la info de curso inscrito asignada
            alumnoDao.actualizar(alumno);
            //Se le descuenta 1 cupo al total de cupos disponibles del curso
            curso.setCuposDisponibles(curso.getCuposDisponibles()-1);
            //Se actualiza la información del curso en la base de datos
            cursoDao.actualizar(curso);
        }
        return "redirect:/cursos/listado";
    }
}
