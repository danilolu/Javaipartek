package com.ipartek.ejemplos.danilozano.dal;

import com.ipartek.ejemplos.danilozano.tipos.Usuario;

public interface UsuariosDAL {
	public void alta(Usuario usuario);

	public boolean validar(Usuario usuario);
}
