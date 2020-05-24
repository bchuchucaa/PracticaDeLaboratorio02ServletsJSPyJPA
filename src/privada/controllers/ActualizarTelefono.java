package privada.controllers;

import java.io.IOException;
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
 * Servlet implementation class ActualizarTelefono
 */
@WebServlet("/ActualizarTelefono")
public class ActualizarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       TelefonoDAO telefonoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTelefono() {
        super();
        telefonoDAO= DAOFactory.getFactory().getTelefonoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		Telefono telefono= new Telefono();
		Usuario usuario = new Usuario();
		telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		telefono.setNumero(request.getParameter("numero"));
		telefono.setTipo(request.getParameter("tipo"));
		telefono.setOperadora(request.getParameter("operadora"));
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setContrasena(request.getParameter("contrasena"));
		try {
			request.setAttribute("usuario", usuario);
			request.setAttribute("telefono", telefono);
			url="/JSPs/ActualizarTelefono.jsp";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al redirigir");
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
