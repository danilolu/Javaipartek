package ejercicio.tienda.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejercicio.tienda.tipos.Producto;

@WebServlet("/altaproducto")
public class AltaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/vistas/alta.jsp").forward(request, response);

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int precio = Integer.parseInt(request.getParameter("id"));

		Producto producto = new Producto(id, nombre, descripcion, precio);

		boolean hayDatos = id != null && nombre != null && descripcion != null && precio != 0;
		// Inicio sin datos: mostrar formulario
		// valor idproducto unico
		// Datos correctos: guardar
		if (hayDatos) {
			if (!hayDatos) {
				producto.setErrores("Todos los campos son requeridos ");
				request.setAttribute("usuario", usuario);
			}
		}

	}

}