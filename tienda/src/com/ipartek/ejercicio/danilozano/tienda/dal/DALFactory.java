package com.ipartek.ejercicio.danilozano.tienda.dal;

public class DALFactory {
	public static ProductosDAL getProductosDAL() {
		
		return new ProductosDALColecion();
	}
}
