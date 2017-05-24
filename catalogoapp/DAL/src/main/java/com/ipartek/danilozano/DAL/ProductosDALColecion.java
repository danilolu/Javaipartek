package com.ipartek.danilozano.DAL;

import java.util.Map;
import java.util.TreeMap;

import com.ipartek.danilozano.Tipos.Producto;

public class ProductosDALColecion implements ProductosDAL {

	private Map<Integer, Producto> productos = new TreeMap<Integer, Producto>();

	public void alta(Producto producto) {
		if (productos.containsKey(producto.getId()))

			throw new IdProductoYaExistenteDALException("Ya existe el producto con esta ID:  " + producto.getId());

		productos.put(producto.getId(), producto);

	}

	public void modificar(Producto producto) {
		if (!productos.containsKey(producto.getId()))
			throw new DALException("Intento de modificar producto no existente ID: " + producto);

		productos.put(producto.getId(), producto);

	}

	public void borrar(Producto producto) {
		productos.remove(producto.getId());

	}

	public Producto[] buscarTodosLosProductos() {

		return productos.values().toArray(new Producto[productos.size()]);
	}

	public Producto buscarPorId(int id) {

		return productos.get(id);
	}

}
