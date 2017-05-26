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

public class FiltroUsuarios implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FILTER");
		// //Cargamos la sesion
		// HttpServletRequest httpRequest = (HttpServletRequest)request;
		// HttpSession session= httpRequest.getSession();
		// Object usuario = null;
		// //Preguntamos por un objeto en la sesion
		// if(session!=null)usuario=session.getAttribute("nombre");
		// if(session==null ||
		// usuario==null)System.out.println("Session Invalid");
		// else System.out.println("Session valid");
		// if (session==null || usuario==null) {//si no hay sesion
		// try {
		// httpRequest.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request,
		// response);
		// return;
		// }
		// catch (ServletException e) { }
		// catch (IOException e) {}
		// }
		// try {
		// chain.doFilter(request, response);
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (ServletException e) {
		// e.printStackTrace();
		// }
		// }

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();

		

		String nombresesion = (String) session.getAttribute("nombre");
		System.out.println(nombresesion + " hola justo antes de comparar");
		String admin = "admin"; 
		System.out.println("compara "+nombresesion+ " con "+ admin);
		
		if (nombresesion == admin) {
			System.out.println("soy admin");
			request.getRequestDispatcher("/WEB-INF/vistas/admin/productocrud.jsp").forward(request,
					response);

			chain.doFilter(request, response);
		} else {
			System.out.println("no soy admin");
			request.getRequestDispatcher("/WEB-INF/vistas/productocrud.jsp").forward(request,
					response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
