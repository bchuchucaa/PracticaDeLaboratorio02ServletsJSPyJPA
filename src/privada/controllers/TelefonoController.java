package privada.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import privada.dao.DAOFactory;
import privada.dao.TelefonoDAO;
import privada.entidad.Telefono;
import privada.entidad.Usuario;

/**
 * Servlet implementation class TelefonoController
 */
@WebServlet("/TelefonoController")
public class TelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelefonoController() {
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TelefonoDAO telefonoDAO= DAOFactory.getFactory().getTelefonoDAO();
		List<Telefono> telefonos = new ArrayList<Telefono>();
		System.out.println("------------");
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		usuario.setCorreo(request.getParameter("usu_correo"));
		usuario.setContrasena(request.getParameter("usu_contrasena"));
		usuario.setCedula(request.getParameter("usu_usuario"));
		telefono.setNumero(request.getParameter("tel_numero"));
		telefono.setTipo(request.getParameter("tel_tipo"));
		telefono.setOperadora(request.getParameter("tel_operadora"));
		telefono.setUsuario(usuario);
		telefonoDAO.create(telefono);
		telefonos=telefonoDAO.recuperarTelefonos(telefono);
		usuario.setTelefonos(telefonos);
		System.out.println("------------");
		response.sendRedirect("/JPADAOProyecto1/SesionController?correo=" + usuario.getCorreo() + "&contrasena=" + usuario.getContrasena());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
