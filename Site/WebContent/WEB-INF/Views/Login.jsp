<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>

	<form:errors path="admin.*" />

	<form action="/AdminSite/Registro.html" method="post">
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
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>

	</form>

</body>
</html>
