package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id,@RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(id, usuario);
    }

    @GetMapping("/{id}")
    public Usuario devolverUsuarioId(@PathVariable int id){
        return objUsuarioService.devolverUsuarioId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        objUsuarioService.eliminarUsuario(id);
    }
    @DeleteMapping
    public void eliminarUsuario2(@RequestBody Usuario usuario) {objUsuarioService.eliminarUsuario2(usuario);}

}

