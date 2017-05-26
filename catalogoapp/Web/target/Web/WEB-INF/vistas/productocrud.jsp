<%@ include file="includes/cabecera.jsp"%>

<table border="1" style="margin: 0 auto;">
	<thead>
		<tr>
			<th>Operaciones</th>
			<th>ID</th>
			<th>Nombre</th>
			<th>Imagen</th>
			<th>Descripcion</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.productos}" var="producto">
			<tr>
				<td>
					<a href="?op=modificar&id=${producto.id}">Modificar</a></br></br>
					
					<a href="?op=borrar&id=${producto.id}">Borrar</a>
				</td>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td><IMG SRC="${producto.nombre}.jpg" width="100" height="100px" /></td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>