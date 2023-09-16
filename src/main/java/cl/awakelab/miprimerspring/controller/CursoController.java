package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    ICursoService objCursoService;

    @GetMapping("/listar")
    public String listarCursos(Model model){
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("atributoListaCursos", listaCursos);
        return "templateListarCursos";
    }

    @GetMapping("/crear")
    public String formCrearCurso(Model model){
        return "templateCrearCurso";
    }

    @PostMapping("/crear")
    public String crearCurso(@ModelAttribute Curso curso){
        objCursoService.crearCurso(curso);
        return "redirect:/curso/listar";
    }

    @GetMapping("/editar/{id}")
    public String formEditarCurso(Model model, @PathVariable int id){
        Curso curso = objCursoService.devolverCursoId(id);
        model.addAttribute("curso",curso);
        return "templateEditarCurso";
    }

    @PostMapping("/editar")
    public String editarCurso(@ModelAttribute Curso curso){
        objCursoService.actualizarCurso(curso);
        return "redirect:/curso/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){

        objCursoService.eliminarCurso(id);
        return "redirect:/curso/listar";
    }

}
