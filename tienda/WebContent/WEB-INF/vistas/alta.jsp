<%@ include file="includes/cabecera.jsp" %>

	<h2>Alta de Productos</h2>
	
	<jsp:useBean id="producto" scope="request"
		class="ejercicio.tienda.tipos.Producto" />

	<form action="alta" method="post">
		<fieldset>
			<label for="id">ID</label> <input id="id" name="id"
			  required="required" minlength="4" value="${producto.id}" />
		</fieldset>
		<fieldset>
			<label for="nombre">Nombre</label> <input id="nombre" name="nombre"
			   minlength="4" value="${usuario.nombre}" />
		</fieldset>
		<fieldset>
			<label for="descripcion">Descripcion</label> <input type="descripcion" id="descripcion"
				name="pass" />
		</fieldset>
		<fieldset>
			<label for="precio">Precio</label> <input type="precio" id="precio"
				name="precio" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Alta" />
			<%//<p class="errores">${producto.errores}</p> %>
		</fieldset>
	</form>
	
<%@ include file="includes/pie.jsp" %>>