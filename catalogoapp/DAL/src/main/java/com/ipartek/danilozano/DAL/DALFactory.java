package com.ipartek.danilozano.DAL;

public class DALFactory {
	public static ProductosDAL getProductosDAL() {

		return new ProductosDALColecion();
	}

	public static UsuariosDAL getUsuariosDAL() {

		return new UsuariosDALColeccion();
	}
}
