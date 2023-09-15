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
    public Alumno actualizarAlumno(Alumno alumnoActualizar) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(alumnoActualizar.getId()).orElse(null);
        alumnoEncontrado.setNombres(alumnoActualizar.getNombres());
        alumnoEncontrado.setApellido1(alumnoActualizar.getApellido1());
        alumnoEncontrado.setApellido2(alumnoActualizar.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumnoActualizar.getCursoAsignado());
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
