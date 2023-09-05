package cl.awakelab.miprimerspring.service;

import cl.awakelab.miprimerspring.entity.Curso;
import java.util.List;

public interface ICursoService {
    public Curso crearCurso(Curso cursoACrear);
    public Curso actualizarCurso(int id, Curso curso);
    public List<Curso> listarCursos();
    public Curso devolverCursoId(int id);
    public void eliminarCurso(int id);
    public void elminarCurso2(Curso curso);
}
