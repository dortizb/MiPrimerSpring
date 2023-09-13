package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario usuarioACrear) {
        Usuario usuario = new Usuario();
        usuario = objUsuarioRepo.save(usuarioACrear);
        return usuario;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar) {
        Usuario usuarioEncontrado = objUsuarioRepo.findById(usuarioActualizar.getId()).orElse(null);
        usuarioEncontrado.setNombre(usuarioActualizar.getNombre());
        usuarioEncontrado.setRol(usuarioActualizar.getRol());
        usuarioEncontrado.setPassword(usuarioActualizar.getPassword());
        return objUsuarioRepo.save(usuarioEncontrado);
    }

    @Override
    public List<Usuario> listarUsuarios() { return objUsuarioRepo.findAll(); }

    @Override
    public Usuario devolverUsuarioId(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }

    @Override
    public void eliminarUsuario2(Usuario usuario) { objUsuarioRepo.delete(usuario); }
}
