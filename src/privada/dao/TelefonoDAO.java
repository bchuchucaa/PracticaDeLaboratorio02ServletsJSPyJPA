package privada.dao;

import java.util.List;

import privada.entidad.Telefono;
import privada.entidad.Usuario;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>  {
	
	public List<Telefono> recuperarTelefonos(Telefono entity);
	public void eliminarTelefono(Telefono entity);
	public void actualizarTelefono(Telefono entity);

}
