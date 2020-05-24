package privada.jpa;

import javax.persistence.Query;

import privada.dao.UsuarioDAO;
import privada.entidad.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	public JPAUsuarioDAO(){
		
		super(Usuario.class);
	}

	@Override
	public Usuario logIn(Usuario user) {
		String correo= user.getCorreo();
		//String contrasena= user.getContrasena();
		Query query = em.createNamedQuery("logIn");
		query.setParameter("correo",correo);
		//query.setParameter("contrasena", contrasena);
		@SuppressWarnings("unchecked")
		Usuario res= (Usuario) query.getSingleResult();
		return res;
	}

	@Override
	public Usuario buscarPorCorreo(Usuario entity) {
		String correo= entity.getCorreo();
		Query query = em.createNamedQuery("buscarPorCorreo");
		query.setParameter("correo",correo);
		@SuppressWarnings("unchecked")
		Usuario res= (Usuario) query.getSingleResult();
		return res;
	}


}
