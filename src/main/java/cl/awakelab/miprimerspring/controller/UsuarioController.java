package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listarUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("atributoListarUsuarios", listarUsuarios);
        return "templateListarUsuarios";
    }
}
