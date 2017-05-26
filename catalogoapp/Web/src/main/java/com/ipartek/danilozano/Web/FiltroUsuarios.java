package com.ipartek.danilozano.Web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.danilozano.Tipos.Usuario;

public class FiltroUsuarios implements Filter {
	private static Logger log = Logger.getLogger(LoginServlet.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FILTER");

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
		String URL = httpReq.getPathInfo();
		Usuario usuariosesion = (Usuario) session.getAttribute("usuario");
		String nombresesion = usuariosesion.getNombre();

		System.out.println(nombresesion + " hola justo antes de comparar");
		String admin = "admin";
		log.info(URL);

		switch (URL) {
		case "LoginServlet":

		case "ProduCRUDServlet":
			if (!admin.equals(nombresesion)) {

				request.getRequestDispatcher("/WEB-INF/vistas/noadmin/productocrud.jsp").forward(request, response);
			}
		case "ProductoFormServlet":
			if (!admin.equals(nombresesion)) {

				request.getRequestDispatcher("/WEB-INF/vistas/noadmin/productocrud.jsp").forward(request, response);
			}
			break;
		default:

		}

		// Usuario usuariosesion = (Usuario) session.getAttribute("usuario");
		// if (usuariosesion == null) {
		// System.out.println("usuario es null");
		// request.getRequestDispatcher("/login").forward(request, response);
		// return;
		// }
		//
		// String nombresesion = usuariosesion.getNombre();
		//
		// System.out.println(nombresesion + " hola justo antes de comparar");
		// String admin = "admin";
		//
		// System.out.println("compara " + nombresesion + " con " + admin);
		//
		// if (admin.equals(nombresesion)) {
		// System.out.println("soy admin");
		// request.getRequestDispatcher("/productocrud").forward(request,
		// response);
		//
		// } else {
		// System.out.println("no soy admin");
		// request.getRequestDispatcher("/WEB-INF/vistas/noadmin/productocrud.jsp").forward(request,
		// response);
		//
		// }
	}

	// String opcion = request.getParameter("opcion");
	// String logout = "logout";
	// if (logout.equals(opcion)) {
	// request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request,
	// response);
	// } else {
	//
	// }

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
