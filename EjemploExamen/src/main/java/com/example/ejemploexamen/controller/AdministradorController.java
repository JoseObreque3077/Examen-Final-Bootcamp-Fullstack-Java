package com.example.ejemploexamen.controller;

import com.example.ejemploexamen.dao.AlumnoDao;
import com.example.ejemploexamen.dao.CursoDao;
import com.example.ejemploexamen.entity.Alumno;
import com.example.ejemploexamen.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador que contiene los métodos necesarios para la navegación entre páginas relacionadas con
 * la entidad Administrador y la gestión de cursos por parte de un administrador.
 */
@Controller
public class AdministradorController {
    //INYECCIÓN DE DEPENDENCIAS
    @Autowired
    private CursoDao cursoDao;
    @Autowired
    private AlumnoDao alumnoDao;

    //ABRE
    @GetMapping("/admin/administrar-cursos")
    public String administradorCursos(Model model) {
        model.addAttribute("cursos", cursoDao.listar());
        return "/otros/administrarCursos";
    }

    //FORMULARIO DE REGISTRO DE CURSOS
    @GetMapping("/admin/registro-curso")
    public String registroCursos(Curso curso, Model model) {
        model.addAttribute("curso", curso);
        return "/formularios/registroCursos";
    }

    //RECIBE DATOS DEL FORMULARIO DE REGISTRO DE CURSOS
    //MUESTRA EL FORMULARIO DE ORIGEN EN CASO DE REGISTRO FALLIDO
    //REDIRECCIONA AL PANEL DE ADMINISTRACIÓN DE CURSOS EN CASO DE REGISTRO EXITOSO
    @PostMapping("admin/registro-curso")
    public String envioRegistroCursos(@Valid Curso curso,
                                      BindingResult bindingResult,
                                      Model model) {
        if (bindingResult.hasErrors()) {
            return "/formularios/registroCursos";
        } else {
            if (curso.getFechaInicio().compareTo(curso.getFechaFinal()) >= 0) {
                model.addAttribute("errorFechas", true);
                return "/formularios/registroCursos";
            } else {
                cursoDao.guardar(curso);
                return "redirect:/admin/administrar-cursos";
            }
        }
    }

    //FORMULARIO DE EDICIÓN DE CURSOS
    @GetMapping("/admin/editar-curso/{id}")
    public String editarCurso(@PathVariable Long id, Model model) {
        /*
        - A través de la URL se envía el id del curso a modificar.
        - La anotación @PathVariable permite capturar ese id de la URL.
        - Se envía a través del modelo, el curso en cuestión buscándolo por su id (para
        pre-cargar datos en el formulario de edición).
        - Se abre la vista del formulario de edición de cursos.
         */
        model.addAttribute("curso", cursoDao.buscar(id));
        return "/formularios/edicionCurso";
    }

    @PostMapping("/admin/editar-curso")
    public String envioEdicionCurso(@Valid Curso curso,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("curso", curso);
            return "/formularios/edicionCurso";
        } else {
            Integer nuevosCuposDisp = curso.getCuposIniciales() - curso.getAlumnos().size();
            curso.setCuposDisponibles(nuevosCuposDisp);
            cursoDao.actualizar(curso);
            return "redirect:/admin/administrar-cursos";
        }
    }

    //ELIMINA UN REGISTRO Y REDIRECCIONA AL PANEL DE ADMINISTRACIÓN DE CURSOS
    @GetMapping("/admin/eliminar-curso/{id}")
    public String eliminarCurso(@PathVariable Long id, Model model) {
        //Si el curso tiene alumnos inscritos, se eliminan las FK en la tabla alumno
        Curso curso = cursoDao.buscar(id);
        if (curso.getAlumnos().isEmpty()) {
            //Se elimina el curso usando el ID que viene por la URL
            cursoDao.eliminar(id);
        } else {
            //Para cada alumno inscrito, se coloca la FK en null
            List<Alumno> alumnos = curso.getAlumnos();
            for (Alumno alumno : alumnos) {
                alumno.setCurso(null);
                alumnoDao.actualizar(alumno);
            }
            cursoDao.eliminar(id);
        }
        //Se redirecciona hacia la URL que abre la ventana de administración de cursos
        return "redirect:/admin/administrar-cursos";
    }

}
