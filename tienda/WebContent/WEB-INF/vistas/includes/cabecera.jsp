<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Ejemplo MVC</title>
<link rel="stylesheet" href="css/estilos.css" />
<script src="js/funciones.js"></script>
</head>
<body>
	<header>
		<h1>TIENDA</h1>
		<p>Ejercicio de tienda</p>
	</header>
	<nav>
		<ul>
			<li><a href="login">Login</a></li>
			<li><a href="usuarioform?op=alta">Alta</a></li>
			<li><a href="login?opcion=logout">Salir</a></li>
			<li><a href="usuariocrud">Mantenimiento usuarios</a></li>
		</ul>
	</nav>