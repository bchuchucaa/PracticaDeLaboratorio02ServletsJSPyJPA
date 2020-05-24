package privada.dao;

import privada.entidad.Usuario;

public interface UsuarioDAO extends GenericDAO< Usuario, String>{
	
	public Usuario logIn(Usuario entity);
	public Usuario buscarPorCorreo(Usuario entity);

}
