package privada.jpa;

import privada.dao.DAOFactory;
import privada.dao.TelefonoDAO;
import privada.dao.UsuarioDAO;

public class JPADAOFactory  extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JPATelefonoDAO();
	}
	

}
