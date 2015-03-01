<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script
	src="resources/reportes/required/jquery.min.js"></script>
<script type="text/javascript" async=""
	src="resources/reportes/required/ga.js"></script>
<script id="twitter-wjs" src="resources/reportes/required/widgets.js"></script>
<script
	src="resources/reportes/required/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/reportes/tableExport.js"></script>
<script type="text/javascript" src="resources/reportes/jquery.base64.js"></script>
<script type="text/javascript" src="resources/reportes/html2canvas.js"></script>
<script type="text/javascript" src="resources/reportes/sprintf.js"></script>
<script type="text/javascript" src="resources/reportes/base64.js"></script>
<script type="text/javascript"
	src="resources/reportes/jquery.dynatable.js"></script>
<script type="text/javascript" src="resources/reportes/jsapi.js"></script>
<script type="text/javascript" src="resources/reportes/jspdf.js"></script>
<script type="text/javascript"
	src="resources/reportes/jspdf.plugin.addhtml.js"></script>
<script type="text/javascript" src="resources/reportes/png.js"></script>
<script type="text/javascript" src="resources/reportes/zlib.js"></script>
<script type="text/javascript"
	src="resources/reportes/jspdf.plugin.addimage.js"></script>
<script type="text/javascript"
	src="resources/reportes/jspdf.plugin.from_html.js"></script>
<script type="text/javascript"
	src="resources/reportes/jspdf.plugin.png_support.js"></script>
<script type="text/javascript"
	src="resources/reportes/jspdf.plugin.standard_fonts_metrics.js"></script>
<script type="text/javascript" src="resources/reportes/FileSaver.js"></script>
<script type="text/javascript" src="resources/js/validacion.js"></script>
<script type="text/javascript" src="resources/reportes/report.js"></script>


<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="resources/reportes/required/jquery.dynatable.css"/>" rel="stylesheet" type="text/css" />
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
			
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/BackOffice/catastrofes"><i class="fa fa-list"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i class="fa fa-list"></i> Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-list"></i> Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i class="fa fa-plus-square"></i> Alta Catastrofe</a></li>	
					<li><a href="/BackOffice/planes/create"><i class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/planes"><i class="fa fa-plus-square"></i> Planes</a></li>
					<li class="active"><a href="/BackOffice/rpt"><i class="fa fa-file"></i> Reportes</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="notification ">
	          
	        </div>
			<div class="contenido"><br>
        		<div class="col-md-12"><br>
        		<div class="panel panel-primary ani_panel animated bounceInUp">
						<div class="panel-heading">Reportes</div>
						<div class="panel-body">
					<div class="col-md-3">
					<div class="form-group">
					<div id="radios">					
						<input type="radio" id="usoRbt" name="usoRbt" value="fle" checked="checked">Uso sitio<br>
						<input type="radio" id="donRbt" name="donRbt" value="m">Donaciones en el tiempo<br> 
						<input type="radio" id="pedRbt" name="pedRbt" value="fe">Pedido de ayuda en el tiempo<br>			
					</div>
					</div>
					</div>
					<div class="col-md-9">
						<div class="col-md-6">
							<div class="form-group">
								<div id="selectDiv">
									<select id="select"  class="form-control" name="Catastrofes">
										<c:if test="${not empty ReporteModel.lstCT}">
											<option value="g" selected="selected">General</option>
											<c:forEach var="sis" items="${ReporteModel.lstCT}" varStatus="i">
												<option value="${sis.idCatastrofe}">${sis.nombre}</option>
					
											</c:forEach>
					
										</c:if>
					
									</select>
								</div>
							</div>
						</div>
					
					
					<div class="col-md-12">
						<div class="form-group">
						<form id="rptform" class="form-inline" method="post" data-toggle="validator" role="form">
							<div id="dateDiv">
									<div class="form-group">
									  	<label for="start" class="control-label">Fecha de Inicio</label>
										<input id="start" type="date" name="start" class="form-control" required> 				 
								        
							        </div>	
									<div class="form-group">		           
							          	<label for="end" class="control-label">Fecha de Fin</label>
										<input id="end" type="date" name="end" class="form-control" required>
							           	
							        </div>
								
									<button id="generar" class="btn btn-default" type="submit">GENERAR</button>						
								
							</div>
						</form>
						</div>
					</div>
					</div>
					<div class="row">
						<div class="col-md-12">
		
							<div class="box">
		
								<div class="box-body table-responsive" id='ptable'>
									<div id="exportdp" class="btn-group">
										<button class="btn btn-warning btn-sm dropdown-toggle"
											data-toggle="dropdown">
											<i class="fa fa-bars"></i>Exportar
										</button>
										<ul class="dropdown-menu " role="menu">
		
											<li class="tableMenu"><a id="ecsv" href="#"
												onClick="exportT(this)"> <img
													src='resources/images/csv.png' width='24px'> CSV
											</a></li>
											<li class="divider"></li>
		
											<li class="tableMenu"><a id="exls" href="#"
												onClick="exportT(this)"> <img
													src='resources/images/xls.png' width='24px'> XLS
											</a></li>
											<li class="divider"></li>
		
											<li class="tableMenu"><a id="epng" href="#"
												onClick="exportT(this)"> <img
													src='resources/images/png.png' width='24px'> PNG
											</a></li>
											<li class="divider"></li>
		
											<li class="tableMenu"><a id="epdf" href="#"
												onClick="exportT(this)"> <img
													src='resources/images/pdf.png' width='24px'> PDF
											</a></li>
		
											<li class="chartMenu"><a id="eChartpng" href="#"
												onClick="exportChart(this)"> <img
													src='resources/images/png.png' width='24px'> PNG
											</a></li>
											<li class="divider chart"></li>
											<li class="chartMenu"><a id="eChartpdf" href="#"
												onClick="exportChart(this)"> <img
													src='resources/images/pdf.png' width='24px'> PDF
											</a></li>
										</ul>
		
									</div>
		
									<div id="rptContainer"></div>
		
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
</body>

</html>