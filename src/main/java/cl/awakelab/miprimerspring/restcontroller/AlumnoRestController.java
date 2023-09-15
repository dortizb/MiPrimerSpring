package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        return objAlumnoService.crearAlumno(alumno);
    }
    @GetMapping
    public List<Alumno> listarAlumno() { return objAlumnoService.listarAlumnos();}

    @PutMapping ("/{id}")
    public Alumno actualizarAlumno(@RequestBody Alumno alumno){
        return objAlumnoService.actualizarAlumno(alumno);
    }
    @GetMapping("/{id}")
    public Alumno devolverAlumnoId(@PathVariable int id) {return objAlumnoService.devolverAlumno(id);}

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id) {objAlumnoService.eliminarAlumno(id);}

    @DeleteMapping
    public void eliminarAlumno2(@RequestBody Alumno alumno) {objAlumnoService.eliminarAlumno2(alumno);}


}
