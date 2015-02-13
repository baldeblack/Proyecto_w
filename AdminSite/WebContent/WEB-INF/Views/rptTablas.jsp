<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" async=""
	src="http://www.google-analytics.com/ga.js"></script>
<script id="twitter-wjs" src="http://platform.twitter.com/widgets.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
<script type="text/javascript" src="resources/reportes/report.js"></script>
<!--link rel="stylesheet" media="all" href="https://s3.amazonaws.com/dynatable-docs-assets/css/bootstrap-2.3.2.min.css" /-->

<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />


<link rel="stylesheet" media="all"
	href="https://s3.amazonaws.com/dynatable-docs-assets/css/jquery.dynatable.css" />

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
					data-toggle="dropdown"><i class="fa fa-user"></i>
						${sessionScope.user.nick} <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a href="/BackOffice/dologout"><i
								class="fa fa-power-off"></i> Cerrar Sesion</a></li>
					</ul></li>
			</ul>

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
							Reportes en el tiempo</a></li>
				</ul>
			</div>
		</nav>

		<div id="contenedor_web_contenido">
			<div id="radios">
				<input type="radio" id="usoRbt" name="usoRbt" value="fle"
					checked="checked">Uso sitio<br> <input type="radio"
					id="donRbt" name="donRbt" value="m">Donaciones en el
				tiempo.<br> <input type="radio" id="pedRbt" name="pedRbt"
					value="fe">Pedido de ayuda en el tiempo<br>
			</div>
			<div id="selectDiv" class="form-group">
				<select id="select" name="Catastrofes">
					<c:if test="${not empty ReporteModel.lstCT}">
						<option value="g" selected="selected">General</option>
						<c:forEach var="sis" items="${ReporteModel.lstCT}" varStatus="i">
							<option value="${sis.idCatastrofe}">${sis.nombre}</option>

						</c:forEach>

					</c:if>

				</select>
			</div>
			<div id="dateDiv" class="form-group">
				<input id="start" type="date" name="start" class="form-control"
					required> <input id="end" type="date" name="end"
					class="form-control" required>
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
</body>

</html>