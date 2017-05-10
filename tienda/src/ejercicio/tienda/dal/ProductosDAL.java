package ejercicio.tienda.dal;

import ejercicio.tienda.tipos.Producto;

public interface ProductosDAL {
	public void alta(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(int id);

	public Producto[] buscarTodosLosProductos();

	public boolean validar(Producto producto);
}
