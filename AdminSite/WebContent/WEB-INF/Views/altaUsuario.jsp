<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Usuario</title>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/dataTables.tableTools.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=drawing"></script>
	<script type="text/javascript" src="<c:url value="/resources/altausuario.js" />"> </script>
	
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="contenedor-header">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Menu</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex2-collapse">
                    <span>User</span> 
                </button>
				<a class="navbar-brand" href="">Backend</a>
			</div>
			
			<div class="collapse navbar-collapse navbar-ex2-collapse">
				<!-- <h2 class="navbar-text">Alta Usuarios</h2>-->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-user"></i>
							${sessionScope.user.nick} <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="divider"></li>
							<li><a href="/BackOffice/dologout"><i
									class="fa fa-power-off"></i> Cerrar Sesion</a></li>
						</ul></li>
				</ul>
			</div>
			
			<!-- MENU VERTICAL -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/BackOffice/catastrofes"><i class="fa fa-list"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i class="fa fa-list"></i> Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-list"></i> Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i class="fa fa-plus-square"></i> Alta Catastrofe</a></li>	
					<li><a href="/BackOffice/planes/create"><i class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/rpt"><i class="fa fa-file"></i> Reportes</a></li>
				</ul>
			</div>
		</nav>
        <div class="row">
			<div class="contenido"><br>
			<!--<form:form method="POST" action="/BackOffice/usuarios/save"
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

			</form:form>-->
			
				<div class="col-md-12"><br>
		            <div class="panel panel-primary">
		                <div class="panel-heading">Alta Usuario</div>
		                <div class="panel-body">
		                    <form:form method="POST" action="/BackOffice/usuarios/save" commandName="UsuariosModel">
							  <form:errors path="*" cssClass="errorblock" element="div" />
							  <div class="col-md-6">
			                      <div class="form-group">
			                        <label for="nombre">Nombre</label>
			                        <form:input class="form-control" path="nombre" required="true" />
			                        
			                      </div>
			                      <div class="form-group">
			                        <label for="apellido">Apellido</label>
			                        <form:input class="form-control" path="apellido" required="true" />
	
			                      </div>
			                  </div>
			                  <div class="col-md-6">
			                      <div class="form-group">
			                        <label for="email">Mail</label>
			                        <form:input type="email" class="form-control" path="email" required="true" />
			                        
			                      </div>
			                      <div class="form-group">
			                        <label for="pass">Contraseña</label>
			                        <form:input type="password" class="form-control" path="password" required="true" />
	
			                      </div>
			                  </div>
			                  <div class="col-md-6">
			                      <div class="form-group">
			                        <label for="cel">Celular</label>
			                        <form:input path="celular" class="form-control" type="tel" required="true" />
			                       
			                      </div>
			                      <div class="form-group">
			                        <label for="direccion">Direccion</label>
			                        <form:input path="direccion"  class="form-control" required="true" />
	
			                      </div>
			                        <div class="form-group">
			                         <label for="">Sexo</label>
			                         <form:select path="sexo" multiple="false" size="1" class="form-control">
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
									</form:select>
			                      </div>
			                  </div>
			                  <div class="col-md-6">
			                      <div class="form-group">
			                        <label for="nacimiento">Fecha de Nacimiento</label>
			                        <form:input type="date" path="nacimiento" class="form-control" required="true" />
	
			                      </div>
			                      <div class="form-group">
			                         <label for="">Tipo de Usuario</label>
			                         <form:select path="tipoUsuario"
										onchange="rescatistaDiv(this)" multiple="false" size="1" class="form-control">
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
									</form:select>
			                      </div>
			                  </div>
			                  <div class="col-md-6">
				                  	<div class="form-group">
				                  		<label for="tiposrescatistas">Tipo Rescatista</label>
				                        <form:select path="tiporescatisa" id="tiposrescatistas" multiple="false" size="1" class="form-control">
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
										</form:select>
		
				                      	
				                    </div>
		                  
			                      <div id="map_container" style="width: 500px; height: 500px;"></div>
			                      <input type="hidden" name="lat" id="lat">
			                      <input type="hidden" name="long" id="long">
			                      <input type="hidden" name="tipoU" id="tipoU"
									value="${UsuariosModel.tipoUsuario}">
								  <form:hidden id="latLongRecidencia"
										path="latLongRecidencia" />
								  <form:errors path="latLongRecidencia" cssClass="bg-danger" />
							  </div>
							  <div class="form-group">
		                      	<button type="submit" class="btn btn-success btn-lg" id="actionbtn" name="action" value="${UsuariosModel.action}">Crear</button>
		                      </div>
		                    </form:form>
		                </div>
		            </div>
		        </div>
			
			
			</div>
		</div>

	</div>
</body>
</html>



