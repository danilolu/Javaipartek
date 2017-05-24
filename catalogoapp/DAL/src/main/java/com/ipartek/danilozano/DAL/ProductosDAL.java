package com.ipartek.danilozano.DAL;

import com.ipartek.danilozano.Tipos.Producto;

public interface ProductosDAL {
	public void alta(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(int id);

	public Producto[] buscarTodosLosProductos();

}
