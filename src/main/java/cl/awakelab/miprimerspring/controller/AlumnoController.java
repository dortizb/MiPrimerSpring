package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;

    @GetMapping("/listar")
    public String listarAlumnos(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumnos();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }

    @GetMapping("/crear")
    public String formCrearAlumno(Model model){
        List<Curso> cursoList = objCursoService.listarCursos();
        model.addAttribute("atributoListaCurso", cursoList);
        return "templateCrearAlumno";
    }

    @PostMapping("/crear")
    public String crearAlumno(@ModelAttribute Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id){

        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno/listar";
    }
}
