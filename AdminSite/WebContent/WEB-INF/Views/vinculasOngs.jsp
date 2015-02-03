<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ong's Catastrofe</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="<c:url value="/resources/vinculasOngs.js" />"> </script>

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
				</ul>
			</div>
		</nav>
		<div id="contenedor_web_contenido">
			<h1>${ongCatastofeModel.ctNombre}ONGs</h1>
			<input type="hidden" id="idCt" name="idCt"
				value="${ongCatastofeModel.idCt}" /> <select id="select"
				name="ongSistemaLst">
				<c:if test="${not empty ongCatastofeModel.ongSistemaLst}">

					<c:forEach var="o" items="${ongCatastofeModel.ongSistemaLst}"
						varStatus="i">
						<option value="${o.idONGs}">${o.nombre}</option>
					</c:forEach>

				</c:if>
			</select> <input id="add" type="button" name="add" value="Agregar" />

			<div id="tableContainer" style="width: 500px, height:500px">
				<div id="table"></div>
			</div>

			<input type="hidden" id="jsonTable"
				value="${ongCatastofeModel.jsonData}" /> <input type="button"
				id="deleteBtn" value="Borrar" />
		</div>

	</div>
</body>
</html>
