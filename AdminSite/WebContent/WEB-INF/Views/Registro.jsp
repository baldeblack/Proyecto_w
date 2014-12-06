<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Proyecto</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" /> 
</head>
<body>

	<h3>Bienvenido</h3>

	<table>
		<tr>
			<td>Usuario :</td>
			<td>${admin.mail}</td>
		</tr>

	</table>

	<form action="/BackOffice/Exito.html" method="post">
		<table>
			<tr>
				<td>Mail :</td>
				<td><input type="text" name="mail" /></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="text" name="password" /></td>
			</tr>

		</table>
		<table>
			<tr>
				<td><input type="submit" value="Registro" /></td>
			</tr>
		</table>

	</form>
</body>
</html>