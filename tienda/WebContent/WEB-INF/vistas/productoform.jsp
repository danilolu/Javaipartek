<%@ include file="includes/cabecera.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<h2>Formulario de Productos</h2>
	
	<jsp:useBean id="producto" scope="request"
		class="ejercicio.tienda.tipos.Producto" />

	<form action="productoform" method="post">
		<fieldset>
			<label for="id">ID</label> <input id="id" name="id"
			  required="required"  value="${producto.id}"<c:if test="${param.op == 'modificar' or param.op == 'borrar'}">
			  	readonly="readonly"
			  </c:if>   
			   />
		</fieldset>
		<fieldset>
			<label for="nombre">Nombre</label> <input id="nombre" name="nombre"
			   value="${usuario.nombre}" />
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
				<input type="submit" value="${fn:toUpperCase(param.op)}" />
			<p class="errores">${usuario.errores}</p>
			
			<input type="hidden" name="opform" value="${param.op}" />
		</fieldset>
	</form>
	
	<c:if test="${param.op == 'borrar'}">
		<script>
			document.forms[0].onsubmit = confirmarBorrado;
		</script>
	</c:if>
	
<%@ include file="includes/pie.jsp" %>>