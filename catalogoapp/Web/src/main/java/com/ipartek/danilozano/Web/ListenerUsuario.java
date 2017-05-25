package com.ipartek.danilozano.Web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerUsuario implements ServletContextListener, HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// crear un objeto de la dal para guardar el nombre
		// ServletContext application = getServletContext();
		// DAL dal = (DAL) application.getAttribute("dal");
		//
		// dal = DALFactory.getProductosDAL();
		// dal = DALFactory.getUsuariosDAL();
		// dal.alta(new Producto(1, "sandia", "descripcion1", 1));
		// dal.alta(new Producto(2, "manzana", "descripcion2", 2));
		// dal.alta(new Usuario("admin", "pass"));
		// dal.alta(new Usuario("usuario1", "pass1"));
		//
		// application.setAttribute("dal", dal);

	}

	private ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

}