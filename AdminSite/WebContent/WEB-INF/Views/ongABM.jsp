<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ONG</title>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/validacion.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/ongabm.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
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
				<!-- <h2 class="navbar-text">Alta ONGs</h2>-->
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
					<li class="active"><a href="/BackOffice/ongs/create"><i
							class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i
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
						<div class="panel-heading">Alta ONGs</div>
						<div class="panel-body">
						<input type="hidden" id="idOng" name="idOng" value="${idOng}">
							<input type="hidden" id="jsondata" name="jsondata"
								value="${jsondata}"> 
							<form id="ongForm" method="post" data-toggle="validator"
								role="form">
								<div class="col-md-6">
									<div class="form-group">
										<label for="nombre" class="control-label">Nombre</label> <input
											id="nombre" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="email" class="control-label">Mail</label> <input
											id="email" type="text" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="web" class="control-label">Web</label> <input
											id="web" type="text" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<label for="tel" class="control-label">Telefono</label> <input
											id="telefono" type="text" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="direccion" class="control-label">Direccion</label>
										<input id="direccion" type="text" class="form-control"
											required /> <span class="glyphicon form-control-feedback"
											aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>

									<div class="form-group">
										<label for="pay" class="control-label">Datos PayPal</label> <input
											id="datosPayPal" type="text" class="form-control" required />
										<span class="glyphicon form-control-feedback"
											aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label for="origen" class="control-label">Origen</label> <input
											id="origen" type="text" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<div class="col-xs-5 col-xs-offset-3">
											<button type="submit"  class="btn btn-success btn-lg"
												id="actionbtn" name="action" value="${action}">${action}</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
</body>
</html>
