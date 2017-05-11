package com.ipartek.ejercicio.danilozano.tienda.dal;

import com.ipartek.ejercicio.danilozano.tienda.tipos.Producto;

public interface ProductosDAL {
	public void alta(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(int id);

	public Producto[] buscarTodosLosProductos();

}
