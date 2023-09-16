package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;

    @GetMapping("/listar")
    public String listarProfesor(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesores();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }

    @GetMapping("/crear")
    public String formCrearProfesor(Model model){
        return "templateCrearProfesor";
    }

    @PostMapping("/crear")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor/listar";
    }

    @GetMapping("/editar/{id}")
    public String formEditarUsuario(Model model, @PathVariable int id){
        Profesor profesor = objProfesorService.devolverProfesorId(id);
        model.addAttribute("profesor",profesor);
        return "templateEditarProfesor";
    }

    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute Profesor profesor){
        objProfesorService.actualizarProfesor(profesor);
        return "redirect:/profesor/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){

        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor/listar";
    }
}
