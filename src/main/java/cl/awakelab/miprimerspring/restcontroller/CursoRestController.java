package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso){
        return objCursoService.crearCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id,@RequestBody Curso curso){
        return objCursoService.actualizarCurso(id, curso);
    }
    @GetMapping
    public List<Curso> listarCursos() {return objCursoService.listarCursos();}

    @GetMapping("/{id}")
    public Curso devolverCursoId(@PathVariable int id){return objCursoService.devolverCursoId(id);}

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id){objCursoService.eliminarCurso(id);}

    @DeleteMapping
    public void eliminarCurso2(@RequestBody Curso curso){objCursoService.elminarCurso2(curso);}
}
