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
import ejercicio.tienda.dal.IdProductoYaExistenteDALException;
import ejercicio.tienda.controladores.ProductoCRUDServlet;
import ejercicio.tienda.dal.ProductosDAL;
import ejercicio.tienda.tipos.Producto;

@WebServlet("/productoform")
public class ProductoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("opform");

		int id;
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio;

		if (request.getParameter("id") == null
				|| request.getParameter("id") == "") {
			id = 0;
		} else {
			id = Integer.parseInt(request.getParameter("id"));
		}
		if (request.getParameter("precio") == null
				|| request.getParameter("precio") == "") {
			precio = 0;
		} else {
			precio = Double.parseDouble(request.getParameter("precio"));
		}
		RequestDispatcher rutaListado = request
				.getRequestDispatcher(ProductoCRUDServlet.RUTA_SERVLET_LISTADO);
		RequestDispatcher rutaFormulario = request
				.getRequestDispatcher(ProductoCRUDServlet.RUTA_FORMULARIO);

		if (op == null) {
			rutaListado.forward(request, response);
			return;
		}

		Producto producto = new Producto(id, nombre, descripcion, precio);

		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");

		switch (op) {
		case "alta":

			// String esnumero = Double.toString(precio);

			// for(int i=0;i<esnumero.length();i++)
			if (id == 0 || nombre == null || descripcion == null || precio == 0) {
				producto.setErrores("- Los campos deben estar rellenados \n - ID y precio deben ser numericos y no tener valor 0");

				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);

			} // else if(Character.isDigit(esnumero.charAt(i))==false){
				// producto.setErrores("el precio debe de ser rellenado con numeros");
				// request.setAttribute("producto", producto);
				// rutaFormulario.forward(request, response);
				// }
				// else if (equals(request.getParameter("id")) == true) {
			//
			// producto.setErrores("ID ya existente");
			// request.setAttribute("producto", producto);
			// rutaFormulario.forward(request, response);
			//
			// }
			else {
				try {
					dal.alta(producto);
					rutaListado.forward(request, response);
				} catch (IdProductoYaExistenteDALException a) {
					producto.setErrores("ID ya existente");
					request.setAttribute("producto", producto);
					rutaFormulario.forward(request, response);

				}

			}

			break;
		case "modificar":
			if (id == 0 || nombre == null || descripcion == null || precio == 0) {
				producto.setErrores("Los campos deben estar rellenados y no deben tener valor 0");
				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);

			} else
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
