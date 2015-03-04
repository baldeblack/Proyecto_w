<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Planes</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/planes.js" />"></script>
	
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" />

<style>
.container {
	display: table;
	width: 90%;
	border-collapse: collapse;
}

.heading {
	font-weight: bold;
	display: table-row;
	background-color: #C91622;
	text-align: center;
	line-height: 25px;
	font-size: 14px;
	font-family: georgia;
	color: #fff;
}

.table-row {
	display: table-row;
	text-align: center;
}

.col {
	display: table-cell;
	border: 1px solid #CCC;
}
</style>
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
				<!-- <h2 class="navbar-text">Crear Plan</h2>-->
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
					<li class="active"><a href="/BackOffice/planes/create"><i class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/planes"><i class="fa fa-plus-square"></i> Planes</a></li>
					<li><a href="/BackOffice/rpt"><i class="fa fa-file"></i> Reportes</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="notification ">
	          
	        </div>
			<div class="contenido"><br>
        		<div class="col-md-12"><br>
		            <div class="panel panel-primary ani_panel animated bounceInUp">
		                <div class="panel-heading">Crear Plan</div>
		                <div class="panel-body">

							 <form:form method="POST" action="/BackOffice/planes/save" commandName="PlanModel"> 
							        <form:errors path="*" cssClass="errorblock" element="div"/> 
										<div id="containerAlta" class="container">
											<div class="heading">
												<div class="col">Nombre</div>
												<div class="col">Descripcion</div>
												<div class="col">Tipo de Plan</div>
												<div class="col">Tipo de Catastrofe</div>
											</div>
							
											<div class="table-row">
												<div class="col">
													<form:input path="nombre" type="text" id="nombre" />
												</div>
												<div class="col">
													<form:textarea path="desc" id="desc" rows="3" cols="20" />
												</div>
												<div class="col">
													<select id="selectTipoPl" name="TiposPl">
														<option value="0" selected="selected">Gestion</option>
														<option value="1">Emergencia</option>
													</select>
												</div>
												<div class="col">
													<select id="selectTipoCt" name="TiposCT">
							
														<c:if test="${not empty PlanModel.tiposct}">
															<c:forEach var="s" varStatus="i" items="${PlanModel.tiposct}">
																<c:choose>
																	<c:when
																		test="${s.idtipocatastrofe eq PlanModel.idTipoCatastrofe}">
																		<option value="${s.idtipocatastrofe}" selected="true">${s.nombre}</option>
																	</c:when>
																	<c:otherwise>
																		<option value="${s.idtipocatastrofe}">${s.nombre}</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
							
							
														</c:if>
							
													</select>
							
												</div>
													<div class="col">
														<div><input id="addPaos"  type="image" src="http://localhost/img/ic_add_box_24px.svg" type="image" onclick="javascript:return addPaso()"/></div>
													</div>
											</div>
							
										</div>
							
										<div id="pasosContainer">
											<div id="container" class="container">
												<div class="heading">
													<div class="col">Nombre</div>
													<div class="col">Descripcion</div>
							
												</div>
							
												<div class="table-row">
													<div class="col">
														<input type="text" name="pasos[0].nombre" value="" />
													</div>
													<div class="col">
															<textarea name="pasos[0].descripcion" id="desc" rows="3" cols="20" ></textarea>
													</div>
													<div class="col">
														<input type="image" src="http://localhost/img/ic_cancel_24px.svg" type="image"
															onclick="javascript:return deletePaso(this)" />
													</div>
												</div>
							
											</div>
										</div>
										<div colspan="2" align="center">
																	<input type="submit" name="action"
																		value="${PlanModel.action}" />
																</div>
								</form:form>
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
		<br>
		<br>
		<br>
		<br>
	</div>
</body>
</html>
