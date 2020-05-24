package privada.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ActTelefono
 */
@WebServlet("/ActTelefono")
public class ActTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		usuario.setCorreo(request.getParameter("usu_correo"));
		usuario.setContrasena(request.getParameter("usu_contrasena"));
		telefono.setCodigo(Integer.valueOf(request.getParameter("tel_codigo")));
		telefono.setNumero(request.getParameter("tel_numero"));
		telefono.setTipo(request.getParameter("tel_tipo"));
		telefono.setOperadora(request.getParameter("tel_operadora"));
		TelefonoDAO t= DAOFactory.getFactory().getTelefonoDAO();
		t.actualizarTelefono(telefono);
		System.out.println("**********************");
		System.out.println(t.find());
		System.out.println("**********************");
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
