package com.ipartek.ejemplos.danilozano.dal;

import com.ipartek.ejemplos.danilozano.tipos.Usuario;

//CRUD Create Retrieve Update Delete los usuarios
public interface UsuariosDAL {
	public void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String id);

	public Usuario[] buscarTodosLosUsuarios();

	public boolean validar(Usuario usuario);
}
