package com.ipartek.danilozano.DAL;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.danilozano.Tipos.Usuario;

public class UsuariosDALColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public void alta(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre()))
			throw new UsuarioYaExistenteDALException("Ya existe el usuario " + usuario.getNombre());

		usuarios.put(usuario.getNombre(), usuario);
	}

	public boolean validar(Usuario usuario) {
		return usuarios.containsValue(usuario);
	}

	public void modificar(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre()))
			throw new DALException("Intento de modificar usuario no existente " + usuario);

		usuarios.put(usuario.getNombre(), usuario);
	}

	public void borrar(Usuario usuario) {
		usuarios.remove(usuario.getNombre());
	}

	public Usuario buscarPorId(String id) {
		return usuarios.get(id);
	}

	public Usuario[] buscarTodosLosUsuarios() {

		return usuarios.values().toArray(new Usuario[usuarios.size()]);
	}

}
