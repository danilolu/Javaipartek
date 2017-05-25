package com.ipartek.danilozano.Web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroUsuarios implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// System.out.println(nombre);
		// if (nombre == "admin") {
		//
		// request.getRequestDispatcher("/WEB-INF/vistas/admin/productocrud.jsp").forward(request,
		// response);
		// System.out.println("soy admin");
		// chain.doFilter(request, response);
		// } else {
		// System.out.println("no soy admin");
		// request.getRequestDispatcher("/WEB-INF/vistas/admin/productocrud.jsp").forward(request,
		// response);
		// }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
