package privada.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import privada.dao.TelefonoDAO;
import privada.entidad.Telefono;
import privada.entidad.Usuario;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{

	
	public JPATelefonoDAO() {
		super(Telefono.class);
	}

	@Override
	public List<Telefono> recuperarTelefonos(Telefono telefono) {
		Usuario usuario=telefono.getUsuario();
		System.out.println("este es el usario a buscar "+usuario.toString());
		Query query = em.createNamedQuery("recuperarTelefonos");
		query.setParameter("cedula",usuario);
		@SuppressWarnings("unchecked")
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos=query.getResultList();
		return telefonos;
	}

	@Override
	public void eliminarTelefono(Telefono entity) {
		int codigo= entity.getCodigo();
		System.out.println("codigo telefono a eliminar "+ codigo);
		em.getTransaction().begin();
		Query query= em.createNamedQuery("eliminarTelefono");
		query.setParameter("codigo", codigo).executeUpdate();
		em.getTransaction().commit();
		
	}

	@Override
	public void actualizarTelefono(Telefono entity) {
		int codigo=entity.getCodigo();
		Telefono telefono = new Telefono();
		telefono=this.read(codigo);
		System.out.println(telefono.getNumero());
		telefono.setNumero(entity.getNumero());
		telefono.setOperadora(entity.getOperadora());
		telefono.setTipo(entity.getTipo());
		System.out.println("telefono despues"+ telefono.toString());
		System.out.println("---------------------------------");
		em.getTransaction().begin();
		try {
		    em.merge(telefono);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		
	}
}
