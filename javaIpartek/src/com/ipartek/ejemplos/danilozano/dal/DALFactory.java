package com.ipartek.ejemplos.danilozano.dal;

public class DALFactory {
	public static UsuariosDAL getUsuariosDAL() {
		return new UsuariosDalColeccion();
	}
}
