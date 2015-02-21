<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ong's Catastrofe</title>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/validacion.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/vincular.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/dynatable.js" />"></script>
	
<link href="<c:url value="/resources/reportes/required/jquery.dynatable.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/animate.css"/>"
	rel="stylesheet" type="text/css" />

</head>
<body>
<jsp:include page="ongModal.jsp" />
<jsp:include page="usuarioModal.jsp" />
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
				<!-- <h2 class="navbar-text">Lista ONGs</h2>-->
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
						<div class="panel-heading">${VincularModel.ctNombre}</div>
						<div class="panel-body">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<div id="radios">
											<input type="radio" name="donRbt" value="don"
												checked="checked">ONG's<br> <input type="radio"
												name="rescRbt" value="resc">Rescatistas<br>
										</div>
									</div>
										<div class="col-md-4">
									<div class="btn-group" role="group" aria-label="...">
										<button id="addbtn" class="btn btn-default" type="button">AGREGAR</button>
										<button id="delbtn" class="btn btn-default" type="button">REMOVER</button>
									</div>
									</div>
									<div class="col-md-4">
										<input type="hidden" id="idCt" name="idCt"
											value="${VincularModel.idCt}">
											<div class="col-lg-4">
											<div class="btn-group btn-group-justified" role="group" aria-label="...">  
												<a id="createO" class="btn btn-warning bton-reportar" data-toggle="modal" data-target="#modalOng">ONG</a>
												<a class="btn btn-warning bton-reportar" data-toggle="modal" data-target="#modalUsuario">USUARIO</a>	
											</div>
											</div>							
									</div>
									<div class="col-md-12">
										<div id="selectO" class="form-group">
										<select id="select" name="ongSistemaLst"  class="form-control">
											<c:if test="${not empty VincularModel.ongSistemaLst}">

												<c:forEach var="o" items="${VincularModel.ongSistemaLst}"
													varStatus="i">
													<option value="${o.idONGs}">${o.nombre}</option>
												</c:forEach>

											</c:if>
										</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">

									<div class="box">

										<div class="box-body table-responsive" id='ptable'>
											<div id="tableContainer" class="container-fluid">
												<table id="tableList" class="table table-bordered">
													<thead>
														<tr></tr>
													</thead>
													<tbody>

													</tbody>
												</table>
											</div>
											<input type="hidden" id="jsonTable"
												value="${VincularModel.jsonData}" />
											<input type="hidden" id="jsonTipo"
												value="${VincularModel.jsonDataResc}" />
										</div>
										<!-- /.box-body -->

									</div>
									<!-- /.box -->


								</div>
								<!-- /.col -->

							</div>
						</div>

					</div>

				</div>
			</div>
		</div>

	</div>

	</div>
</body>
</html>
