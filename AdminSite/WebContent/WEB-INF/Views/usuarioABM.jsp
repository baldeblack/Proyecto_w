<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuario</title>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/validacion.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/usuarioabm.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/animate.css"/>"
	rel="stylesheet" type="text/css" />

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
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex2-collapse">
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
					<li><a href="/BackOffice/catastrofes"><i
							class="fa fa-list"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i class="fa fa-list"></i>
							Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-list"></i>
							Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i
							class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li class="active"><a href="/BackOffice/usuarios/create"><i
							class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i
							class="fa fa-plus-square"></i> Alta Catastrofe</a></li>
					<li><a href="/BackOffice/planes/create"><i
							class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/rpt"><i class="fa fa-file"></i>
							Reportes</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="notification "></div>
			<div class="contenido">
				<br>
				<div class="col-md-12">
					<br>
					<div class="panel panel-primary ani_panel animated bounceInUp">
						<div id="responseUsu" class="panel-heading">Alta Usuario</div>
						<div class="panel-body">
							<input type="hidden" id="idUsu" name="idUsu" value="${idUsu}">
							<input type="hidden" id="jsondata" name="jsondata"
								value="${jsondata}"> <input type="hidden" id="jsonusu"
								name="jsondata" value="${jsonusu}">
							<form id="usuABMForm" method="post" data-toggle="validator"
								role="form">
								<div class="col-md-6">
									<div class="form-group">
										<label for="nombre" class="control-label">Nombre</label> <input
											class="form-control" id="nombre" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="apellido" class="control-label">Apellido</label> <input
											class="form-control" id="apellido" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
						
									<div class="form-group">
										<label for="nick" class="control-label">Nick</label> <input
											id="nick" type="text" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="email" class="control-label">Mail</label> <input
											type="email" class="form-control" id="email" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								
									<div id="passdiv" class="form-group">
										<label for="password" class="control-label">Contraseña</label>
										<input type="password" class="form-control" id="password"
											required /> <span class="glyphicon form-control-feedback"
											aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								
									<div class="form-group">
										<label for="celular" class="control-label">Celular</label> <input
											id="celular" class="form-control" type="tel" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="direccion" class="control-label">Direccion</label>
										<input id="direccion" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="sexo" class="control-label">Sexo</label> <label
											for="sexo" class="control-label">Sexo</label> <select
											id="sexo" class="form-control">
											<option value="M">MASCULINO</option>
											<option value="F">FEMENINOD</option>
										</select>
									</div>

									<div class="form-group">
										<label for="nacimiento" class="control-label">Fecha de
											Nacimiento</label> <input type="date" id="nacimiento"
											class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="tipoUsuario" class="control-label">Tipo de
											Usuario</label> <select id="tipoUsuario" class="form-control"
											onchange="rescatistaDiv(this)">
											<option value="0">ADMINISTRADOR</option>
											<option value="1">RESCATISTA</option>
										</select>
									</div>
								
								
									<div id="rescatistaDiv" class="form-group"
										style="display: none">
										<label for="tiposrescatistas" class="control-label">Tipo
											Rescatista</label> <select id="tiposrescatistas" class="form-control">

										</select>

									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-success btn-lg"
										id="actionbtn" name="action" value="${action}">${action}</button>
								</div>
							</form>
						</div>
					</div>
				</div>


			</div>
		</div>

	</div>
</body>
</html>



