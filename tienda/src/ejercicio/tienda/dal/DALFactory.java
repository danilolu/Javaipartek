package ejercicio.tienda.dal;

public class DALFactory {
	public static ProductosDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new ProductosDALColecion();
	}
}
