package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Override
    public Alumno crearAlumno(Alumno alumnoACrear) {
        return objAlumnoRepo.save(alumnoACrear);
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumno.getNombres());
        alumnoEncontrado.setApellido1(alumno.getApellido1());
        alumnoEncontrado.setApellido2(alumno.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumno.getCursoAsignado());
        return objAlumnoRepo.save(alumnoEncontrado);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return objAlumnoRepo.findAll();
    }

    @Override
    public Alumno devolverAlumno(int id) {
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
    }

    @Override
    public void eliminarAlumno2(Alumno alumno) {
        objAlumnoRepo.delete(alumno);
    }
}
