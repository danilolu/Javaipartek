package com.ipartek.danilozano.Web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.danilozano.DAL.DAL;
import com.ipartek.danilozano.Tipos.Producto;

@WebServlet("/productocrud")
public class ProductoCRUDServlet extends HttpServlet {
	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/productoform.jsp";
	static final String RUTA_LISTADO = "/WEB-INF/vistas/productocrud.jsp";
	static final String RUTA_SERVLET_LISTADO = "/productocrud";

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
		
		ServletContext application = getServletContext();
		DAL dal = (DAL) application.getAttribute("dal");

//		if (dal == null) {
//			dal = DALFactory.getProductosDAL();
//
//			dal.alta(new Producto(1, "sandia", "descripcion1", 1));
//			dal.alta(new Producto(2, "manzana", "descripcion2", 2));
//
//			application.setAttribute("dal", dal);
//		}

		String op = request.getParameter("op");

		if (op == null) {

			Producto[] productos = dal.buscarTodosLosProductos();

			request.setAttribute("productos", productos);

			request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
		} else {
			int id;
			if (request.getParameter("id") == null || request.getParameter("id") == "") {
				id = 0;
			} else {
				id = Integer.parseInt(request.getParameter("id"));
			}
			Producto producto;

			switch (op) {
			case "modificar":
			case "borrar":
				producto = dal.buscarPorId(id);
				request.setAttribute("producto", producto);
			case "alta":

				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
			}
		}
	}

}
