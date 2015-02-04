<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuario</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/dataTables.tableTools.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false&libraries=drawing"></script>
<script type="text/javascript"
	src="<c:url value="/resources/altausuario.js" />"> </script>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="contenedor_web">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Menu</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">Backend</a>
			</div>

			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.user.nick}
						<b class="caret"></b></a>
					<ul class="dropdown-menu">					
						<li class="divider"></li>
						<li><a href="/BackOffice/dologout"><i class="fa fa-fw fa-power-off"></i>
								Cerrar Sesion</a></li>
					</ul></li>
			</ul>

			<!-- MENU VERTICAL -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/BackOffice/catastrofes"><i
							class="fa fa-fw fa-file"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i
							class="fa fa-fw fa-file"></i> Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-fw fa-file"></i>
							Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i
							class="fa fa-fw fa-file"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i
							class="fa fa-fw fa-file"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i
							class="fa fa-fw fa-file"></i> Alta Catastrofe</a></li>
					<li><a href="/BackOffice/rpt"><i class="fa fa-fw fa-file"></i>Reportes
							en el tiempo</a></li>
					<li><a href="/BackOffice/planes/create"><i class="fa fa-fw fa-file"></i>Alta
							Plan</a></li>
				</ul>
			</div>
		</nav>
		<div id="contenedor_web_contenido">
			<h1>Alta Usuarios</h1>

			<form:form method="POST" action="/BackOffice/usuarios/save"
				commandName="UsuariosModel">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td>Nombre :</td>
						<td><form:input path="nombre" required="true" /></td>
					</tr>
					<tr>
						<td>Apellido :</td>
						<td><form:input path="apellido" required="true" /></td>
					</tr>
					<tr>
						<td>Mail :</td>
						<td><form:input type="email" path="email" required="true" /></td>
					</tr>
					<tr>
						<td>Nick :</td>
						<td><form:input path="nick" required="true" /></td>
					</tr>
					<tr id="password">
						<td>Contraseña :</td>
						<td><form:input type="password" path="password"
								required="true" /></td>
					</tr>
					<tr>
						<td>Celular :</td>
						<td><form:input path="celular" type="tel" required="true" /></td>
					</tr>
					<tr>
						<td>Direccion :</td>
						<td><form:input path="direccion" required="true" /></td>
					</tr>
					<tr>
						<td>Sexo :</td>
						<td><form:select path="sexo" multiple="false" size="1">
								<c:forEach var="s" varStatus="i"
									items="${UsuariosModel.generos}">
									<c:choose>
										<c:when test="${s.valor eq UsuariosModel.sexo}">
											<option value="${s.valor}" selected="true">${s.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${s.valor}">${s.nombre}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td>Fecha de Nacimiento :</td>
						<td><form:input type="date" path="nacimiento" required="true" /></td>
					</tr>
					<tr>
						<td>Tipo Usuario :</td>
						<td><form:select path="tipoUsuario"
								onchange="rescatistaDiv(this)" multiple="false" size="1">
								<c:forEach var="tu" varStatus="i" items="${UsuariosModel.tipos}">
									<c:choose>
										<c:when test="${tu.value eq UsuariosModel.tipoUsuario}">
											<option value="${tu.value}" selected="true">${tu.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${tu.value}">${tu.nombre}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select></td>
					</tr>
				</table>
				<div id="rescatistaDiv" style="display: none;">
					<table>
						<tr>
							<td>Tipo Rescatista :</td>
							<td><form:select path="tiporescatisa" id="tiposrescatistas"
									multiple="false" size="1">
									<c:forEach var="rt" varStatus="i"
										items="${UsuariosModel.tiposrescatistas}">
										<c:choose>
											<c:when
												test="${rt.nombre eq UsuariosModel.tiporescatisa.nombre}">
												<option value="${rt.idTipoRescatista}" selected="true">${rt.nombre}</option>
											</c:when>
											<c:otherwise>
												<option value="${rt.idTipoRescatista}">${rt.nombre}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td>
								<div id="map_container" style="width: 500px; height: 500px;"></div>
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="lat" id="lat"></td>
							<td><input type="hidden" name="long" id="long"></td>
							<td><input type="hidden" name="tipoU" id="tipoU"
								value="${UsuariosModel.tipoUsuario}"></td>
							<td><form:hidden id="latLongRecidencia"
									path="latLongRecidencia" /></td>
							<td><form:errors path="latLongRecidencia" cssClass="error" /></td>
						</tr>
					</table>
				</div>


				<table>
					<tr>
						<td colspan="2" align="center"><input id="actionbtn"
							type="submit" name="action" value="${UsuariosModel.action}" /></td>
					</tr>
				</table>

			</form:form>

		</div>

	</div>
</body>
</html>



