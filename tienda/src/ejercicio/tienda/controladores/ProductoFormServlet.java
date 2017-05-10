package ejercicio.tienda.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejercicio.tienda.dal.DALException;

import ejercicio.tienda.controladores.ProductoCRUDServlet;
import ejercicio.tienda.dal.ProductosDAL;
import ejercicio.tienda.tipos.Producto;





@WebServlet("/productoform")
public class ProductoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("opform");

		String id =request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");

		RequestDispatcher rutaListado = request.getRequestDispatcher(ProductoCRUDServlet.RUTA_SERVLET_LISTADO);
		RequestDispatcher rutaFormulario = request.getRequestDispatcher(ProductoCRUDServlet.RUTA_FORMULARIO);

		if (op == null) {
			rutaListado.forward(request, response);
			return;
		}

		Producto producto = new Producto(id, nombre, descripcion, precio);

		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");

		switch (op) {
		case "alta":
			if (id != null || nombre != null || descripcion != null || precio != null) {
				dal.alta(producto);
				rutaListado.forward(request, response);
			} else {
				producto.setErrores("Los campos deben estar rellenados");
				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);
			}

			break;
		case "modificar":
			
			try {
				dal.modificar(producto);
			} catch (DALException de) {
				producto.setErrores(de.getMessage());
				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);
				return;
			}
			rutaListado.forward(request, response);
			

			break;
		case "borrar":
			dal.borrar(producto);
			rutaListado.forward(request, response);

			break;
		}
	}

}