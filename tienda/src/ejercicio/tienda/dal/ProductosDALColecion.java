package ejercicio.tienda.dal;


import java.util.Map;
import java.util.TreeMap;

import ejercicio.tienda.tipos.Producto;

public class ProductosDALColecion implements ProductosDAL {

	private Map<Integer, Producto> productos = new TreeMap<Integer, Producto>();

	@Override
	public void alta(Producto producto) {
		if (productos.containsKey(producto.getId()))

			throw new IdProductoYaExistenteDALException("Ya existe el producto con esta ID:  " + producto.getId());
			

		productos.put(producto.getId(), producto);

	}

	@Override
	public void modificar(Producto producto) {
		if (!productos.containsKey(producto.getId()))
			throw new DALException("Intento de modificar producto no existente ID: " + producto);

		productos.put(producto.getId(), producto);

	}

	@Override
	public void borrar(Producto producto) {
		productos.remove(producto.getId());

	}

	@Override
	public Producto[] buscarTodosLosProductos() {

		return productos.values().toArray(new Producto[productos.size()]);
	}

	@Override
	public boolean validar(Producto producto) {

		return productos.containsValue(producto);
	}

	@Override
	public Producto buscarPorId(int id) {

		return productos.get(id);
	}

}
