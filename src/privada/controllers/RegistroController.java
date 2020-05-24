package privada.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import privada.dao.DAOFactory;
import privada.dao.UsuarioDAO;
import privada.entidad.Usuario;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 	UsuarioDAO usuarioDAO;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RegistroController() {

	    	usuarioDAO= DAOFactory.getFactory().getUsuarioDAO();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Servlet para registrar");
			Usuario usuario= new Usuario();
			PrintWriter out= response.getWriter();
			String url= null;
				usuario.setCedula(request.getParameter("cedula"));
				usuario.setNombre(request.getParameter("nombre"));
				usuario.setApellido(request.getParameter("apellido"));
				usuario.setCorreo(request.getParameter("correo"));
				usuario.setContrasena(request.getParameter("contrasena"));
				usuario.setTelefonos(null);
				usuarioDAO.create(usuario);
				request.setAttribute("Usuario", usuario);
				System.out.println("Se registro correctamente");
				response.sendRedirect("SesionController?correo="+ usuario.getCorreo()+"&contrasena="+usuario.getContrasena());
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
