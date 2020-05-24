package privada.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.TldCache;
import org.eclipse.persistence.config.TargetDatabase;

import privada.dao.DAOFactory;
import privada.dao.TelefonoDAO;
import privada.entidad.Telefono;
import privada.entidad.Usuario;

/**
 * Servlet implementation class EliminarTelefono
 */
@WebServlet("/EliminarTelefono")
public class EliminarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setContrasena(request.getParameter("contrasena"));
		telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		telefono.setNumero(request.getParameter("numero"));
		usuario.setCedula(request.getParameter("cedula"));
		telefono.setUsuario(usuario);
		//telefono.toString();
		TelefonoDAO t= DAOFactory.getFactory().getTelefonoDAO();
		telefono= t.read(Integer.valueOf(request.getParameter("codigo")));
		t.eliminarTelefono(telefono);
		System.out.println(telefono.toString());
		System.out.println("se elimino el numero");
		response.sendRedirect("/JPADAOProyecto1/SesionController?correo="+usuario.getCorreo()+"&contrasena="+usuario.getContrasena());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
