<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ong's Catastrofe</title>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="<c:url value="/resources/vinculasOngs.js" />"> </script>

<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
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
        	<div class="col-md-12"><br>
        		<div class="panel panel-primary">
		              <div class="panel-heading">${ongCatastofeModel.ctNombre}ONGs</div>
		                <div class="panel-body">

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
		   </div>
		</div>
			
		</div>

	</div>
</body>
</html>
