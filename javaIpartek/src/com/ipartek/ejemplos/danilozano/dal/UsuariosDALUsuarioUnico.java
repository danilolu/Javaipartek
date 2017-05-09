package com.ipartek.ejemplos.danilozano.dal;

import com.ipartek.ejemplos.danilozano.tipos.Usuario;

public class UsuariosDALUsuarioUnico implements UsuariosDAL {

	private Usuario usuario;

	@Override
	public void alta(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean validar(Usuario usuario) {
		return this.usuario != null && this.usuario.equals(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Usuario usuario) {
		if (this.usuario.equals(usuario))
			this.usuario = usuario;

	}

	@Override
	public Usuario buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
