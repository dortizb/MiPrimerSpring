package cl.awakelab.miprimerspring.service;


import cl.awakelab.miprimerspring.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario crearUsuario(Usuario usuarioACrear);
    public Usuario actualizarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario devolverUsuarioId(int id);
    public void eliminarUsuario(int id);
    public void eliminarUsuario2(Usuario usuario);
}
