package ejercicio.tienda.dal;

public class DALFactory {
	public static ProductosDAL getProductosDAL() {
		
		return new ProductosDALColecion();
	}
}
