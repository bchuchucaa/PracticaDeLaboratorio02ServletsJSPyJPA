package privada.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import privada.dao.DAOFactory;
import privada.dao.TelefonoDAO;
import privada.dao.UsuarioDAO;
import privada.entidad.Telefono;
import privada.entidad.Usuario;



/**
 * Servlet implementation class SesionController
 */
@WebServlet("/SesionController")
public class SesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioDAO usuarioDAO;
	TelefonoDAO telefonoDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SesionController() {
   	 	usuarioDAO= DAOFactory.getFactory().getUsuarioDAO();
   	 	telefonoDAO= DAOFactory.getFactory().getTelefonoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		Telefono telefon = new Telefono();
		String url = null;
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setContrasena(request.getParameter("contrasena"));
		request.setAttribute("Usuario", usuario);
		usuario= usuarioDAO.logIn(usuario);
		HttpSession session = request.getSession();
		List<Telefono> telefonos = new ArrayList<Telefono>();
		List<Telefono> telfs = new ArrayList<Telefono>();
		if (usuario != null) {
			session = request.getSession(true);
			session.setAttribute("sesion", "logueado");
			request.setAttribute("usuario", usuario);
			try {
				//telefon.setUsuario(usuario.getCedula());
				telefon.setUsuario(usuario);
				telefonos=telefonoDAO.recuperarTelefonos(telefon);
				for(Telefono telefono : telefonos) {
					telfs.add(telefono);
					//System.out.println(telefono.toString());
				}
				usuario.setTelefonos(telfs);
				request.setAttribute("telefono", telfs);
				url = "/JSPs/usuario.jsp";
			} catch (Exception e) {
				System.out.println("ingreso aqui 11111");
				url = "/JSPs/usuario.jsp";
			}
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {
			session.setAttribute("sesion", "invalido");
			
			response.sendRedirect("/JPADAOProyecto1/JSPs/logIn.jsp");
		
	
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
