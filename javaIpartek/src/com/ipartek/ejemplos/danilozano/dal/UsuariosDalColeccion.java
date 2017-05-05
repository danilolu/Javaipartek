package com.ipartek.ejemplos.danilozano.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.ejemplos.danilozano.tipos.Usuario;

public class UsuariosDalColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	@Override
	public void alta(Usuario usuario) {
		usuarios.put(usuario.getNombre(), usuario);

	}

	@Override
	public boolean validar(Usuario usuario) {
		return usuarios.containsValue(usuario);

	}

}
