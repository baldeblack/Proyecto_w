<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Catastrofes</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/dataTables.tableTools.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />">
	</script>
	<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/listcatastrofes.js" />"></script>
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" />

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
				<!-- <h2 class="navbar-text">Lista Catastrofes</h2>-->
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
					<li class="active"><a href="/BackOffice/catastrofes"><i class="fa fa-list"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i class="fa fa-list"></i> Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-list"></i> Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i class="fa fa-plus-square"></i> Alta Catastrofe</a></li>	
					<li><a href="/BackOffice/planes/create"><i class="fa fa-plus-square"></i> Alta Plan</a></li>
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
		                <div class="panel-heading">Lista Catastrofes</div>
		                <div class="panel-body">
						<%
			    		String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
						%>
			
				<c:if test="${not empty CatastrofeListModel.ctList}">
							<table id="lstTable" class="table table-striped table-bordered"
								cellspacing="0" width="70%">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Dominio</th>
										<th>Estado</th>
										<th>Fecha de Creacion</th>
										<th></th>
										<th></th>										
									</tr>
								</thead>
			
								<tfoot>
									<tr>
										<th>Nombre</th>
										<th>Dominio</th>
										<th>Estado</th>		
										<th>Fecha de Creacion</th>							
										<th></th>
										<th></th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="o" items="${CatastrofeListModel.ctList}">
										<tr>
											<td>${o.nombre}</td>
											<td>${o.dominio}</td>
											<c:choose>
											<c:when test="${o.activa == 0}">
											<td><a href="#" onclick="deactive(this,${o.idCatastrofe}, event)">Inactiva</a></td>
											</c:when>
											<c:otherwise>
											<td><a href="#" onclick="deactive(this,${o.idCatastrofe}, event)">Activa</a></td>
											</c:otherwise>
											</c:choose>
											<td>${o.fechaCreacion}</td>
											<td><a href="/BackOffice/catastrofes/edit/${o.idCatastrofe}" data-toggle="tooltip" data-placement="top" title="Editar"><i class="fa fa-pencil"></i></a></td> 
											<td><a href="/BackOffice/vincular/init/${o.idCatastrofe}" data-toggle="tooltip" data-placement="top" title="Vincular"><i class="fa fa-external-link"></i></a></td>							
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
