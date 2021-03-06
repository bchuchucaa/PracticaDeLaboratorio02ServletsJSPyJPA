package privada.dao;

import privada.jpa.JPADAOFactory;

public abstract class DAOFactory {

	protected static DAOFactory factory= new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		
		return factory;
	}
	
	
	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract TelefonoDAO getTelefonoDAO();
	
	
}
