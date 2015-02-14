<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Catastrofe</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=drawing"></script>
	<script type="text/javascript" src="<c:url value="/resources/catastrofesZona.js" />">
	
	
		
	</script>
	<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
		
	</script>
	<script type="text/javascript">
		_uacct = "UA-162157-1";
		urchinTracker();
	</script>

	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" />

<style type="text/css">

/*
#panel {
	width: 800px;
	font-family: Arial, sans-serif;
	font-size: 13px;
	float: right;
	margin: 10px;
}*/
/*
#color-palette {
	clear: both;
}
*/
#panel_color {
	display: absolute;
	float:righ;
	top:10px;
	right: 30px;
}
.color-button {
	width: 14px;
	height: 14px;
	font-size: 0;
	margin: 2px;
	float: left;
	cursor: pointer;
}

#delete-button {
	margin-top: 5px;
}

#div1 {
	width: 100px;
	float: left;
}

#div2 {
	margin-left: 120px;
	width: 100px;
}

.delete {
	width: 20px;
	height: 20px;
	margin-left: 125px;
}

.imgShow {
	width: 150px;
	height: 150px;
}

#container {
	width: 100px;
	height: 100px;
	position: relative;
}

.overlay {
	bottom: 30px;
	background: rgb(245, 245, 249);
	width: 150px;
	opacity: 0.8;
	position: relative; //
	display: none;
}

.wrapper {
	max-width: 1200px;
	margin: 0 auto;
}

.inner {
	padding: 20px;
	border: 1px solid #D1D1D1;
	width: 215px;
	background-color: #00F;
	height: 190px;
}

#div1 {
	width: 100px;
	float: left;
}

#div2 {
	margin-left: 120px;
	width: 100px;
}

.innerTwo {
	padding: 20px;
	/*border: 1px solid #D1D1D1;
	background-color: #00F;*/
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
				<!--  <h2 class="navbar-text">Alta Catastrofe</h2>-->
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
			<div class="notification ">
	          
	        </div>
			
			<div class="contenido">
                <br>
				<!-- <h1>Alta Catastrofe</h1>-->
				<!-- <a href="#" class="btn btn-danger btn-lg " onclick='message("Error - Error 303 :(","error");'> Error </a>-->
				<form:form method="POST" action="/BackOffice/catastrofes/save"
					commandName="CatastrofeModel" enctype="multipart/form-data">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<div class="panel with-nav-tabs panel-primary ani_panel animated bounceInUp">
                	  <div class="panel-heading">
                	 
						<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
					        <li class="active"><a href="#general" data-toggle="tab">General</a></li>
					        <li><a href="#ubicacion"  data-toggle="tab">Ubicacion</a></li>
					        <li><a href="#imagenes" data-toggle="tab">Imagenes</a></li>
					        <li><a href="#conf" data-toggle="tab">Configuracion</a></li>
				
					    </ul>
					  </div>
					
					  <div class="panel-body ">				 
					    <div id="my-tab-content" class="tab-content">
					        <div class="tab-pane active" id="general">
				      		 	<div class="col-md-6">
				      				<div class="form-group">
										<label>Nombre :</label>
										
										<div>
											<form:input class="form-control" path="nombre" required="true" />
										</div>
										<div>
											<form:errors path="nombre" cssClass="error" />
										</div>
									</div>
									<div class="form-group">
										<label>Dominio :</label>
										<div>
											<form:input class="form-control" path="dominio" required="true" />
										</div>
										<div>
											<form:errors path="dominio" cssClass="error" />
										</div>
									</div>
									<div class="form-group">
										<label>Informacion :</label>
										<div>
											<form:textarea class="form-control" path="informacion" required="true" />
										</div>
										<div>
											<form:errors path="informacion" cssClass="error" />
										</div>
									</div>
									<div class="form-group">
										<label>Key Facebook :</label>
										<div>
											<form:input class="form-control" path="apiFb" required="true" />
										</div>
										<div>
											<form:errors path="apiFb" cssClass="error" />
										</div>
									</div>
				      			</div>
					      		<div class="col-md-6">
					      			<div class="form-group">
										<label>Key Twitter :</label>
										<div>
											<form:input class="form-control" path="apiTw" required="true" />
										</div>
										<div>
											<form:errors path="apiTw" cssClass="error" />
										</div>
									</div>
					      			<div class="form-group">
										<label>Activa :</label>
										<div>
											<select class="form-control" name="activa">
												<option selected="selected" value="1">SI</option>
												<option value="0">NO</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label>Temas :</label>
										<div>
											<select class="form-control" name="css">
												<option selected="selected" value="Style1.css">TEMA 1</option>
												<option value="Style2.css">TEMA 2</option>
												
											</select>
										</div>
									</div>
			      		 			<div class="form-group">
										<label>Tipo :</label>
										<div><form:select class="form-control" path="tipo" multiple="false" size="1">
											<c:forEach var="s" varStatus="i"
												items="${CatastrofeModel.tipos}">
												<c:choose>
													<c:when test="${s.idtipocatastrofe eq CatastrofeModel.tipo}">
														<option value="${s.idtipocatastrofe}" selected="true">${s.nombre}</option>
													</c:when>
													<c:otherwise>
														<option value="${s.idtipocatastrofe}">${s.nombre}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</form:select>
										</div>
									</div>
    		
			      		 		</div>
					        </div>
					        <div class="tab-pane" id="ubicacion">
					            <div id="panel_color">
									<div id="color-palette"></div>
									<div>
										<button id="delete-button" class="btn btn-default" onclick="return false;">Limpiar
											Mapa</button>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div id="map"></div>
					            </div>
								<div>
									<div>
										<form:hidden id="zonaAfectada" path="zonaAfectada"
											required="true" />
										
										<div>
											<form:errors path="zonaAfectada" cssClass="error" />
										</div>
									</div>
								</div>							    
									            
					        </div>
					        <div class="tab-pane" id="imagenes">
					            <div class="col-md-6">
							      	<div class="form-group">
								       	<div class="innerTwo">
											<div>
												<div style="display: table-cell;">
													<div style="height: 30px">Subir nueva imagen:</div>
												</div>
												<div style="display: table-cell;">
													<input id="addMoreFile" type="image"
														src="http://localhost/img/ic_add_box_24px.svg" type="image"
														style="width: 30px; height: 30px"
														onclick="javascript:return addFilClick()" />
												</div>
											</div>
											<br /> <br />
											<div id="fileDiv">
												<div id="uploadTable"
													style="border: 1px solid black; display: table-cell;">
													<div class="fileContainer" style="border: 1px solid black;">
														<input name="multiUploadedFileList[0]" type="file"
															style="margin-bottom: 16px;" /> <input type="image"
															src="http://localhost/img/ic_cancel_24px.svg" name="image"
															style="margin-left: 26px; width: 30px; height: 30px"
															onclick="javascript:return deleteFile(this)" />
													</div>
												</div>
											</div>
										</div>
										<div id="fd"
											style="height: 300px; height: 300px; overflow-x: hidden; overflow-y: auto">
											<c:if test="${not empty CatastrofeModel.imagenes}">
												<c:forEach var="img" items="${CatastrofeModel.imagenes}"
													varStatus="i">
													<div style="display: inline-block">
														<img class="imgShow" alt="" title=""
															src="data:image/jpeg;base64,${img.byteValue}">
														<div class="overlay">
															<img class="delete" alt="" title=""
																src="https://cdn3.iconfinder.com/data/icons/edition/100/trashcan-128.png"
																onclick="borrar(this)">
														</div>
														<input type="hidden" name="imagenesNuevas[${i.index}]"
															value="${img.pathValue}" />
													</div>
												</c:forEach>
											</c:if>
										</div>
						      		</div>
								</div>  
						      	<div class="col-md-6">
							      	<div class="form-group">
										<label>Logo :</label>
										<div>
											<form:input class="form-control" type="file" path="logo" />
										</div>
										<div>
											<form:errors path="logo" cssClass="error" />
										</div>
										<div>
											<img class="imgShow" alt="" title=""
												src="data:image/jpeg;base64,${CatastrofeModel.logoString}">
										</div>
									</div>
								</div>  
						   	</div>
							<div class="tab-pane" id="conf">
								<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<div class="innerTwo">
											<div class="form-inline">
												Palabras Claves:  <input id="PalabrasInput" type="image"
													src="http://localhost/img/ic_add_box_24px.svg" />
											</div>

											<div id="PalabrasDiv" class="row">
												<c:if test="${not empty CatastrofeModel.palabrasList}">
		
													<c:forEach var="palabras"
														items="${CatastrofeModel.palabrasList}" varStatus="i">
														<div class="col-lg-12 palabraContainer">
															<input class="form-control" type="text" name="palabrasList[${i.index}]"
																value="${palabras}"
																ondblclick="javascript:return deletePalabras(this)" />
														</div>
													</c:forEach>
		
												</c:if>
		
		
											</div>
										</div>
									    
									</div>
								</div>
								<div class="col-md-6">
									<div class="wrapper">
										<div class="inner">
											<div id="div1">
												<div id="fuenteDedatos" class="fuenteDedatos">
													<c:if test="${not empty CatastrofeModel.fuenteDedatos}">
			
														<c:forEach var="fuentes"
															items="${CatastrofeModel.fuenteDedatos}" varStatus="i">
															<div class="fuenteDedatosContainer">
																<input style="width: 70px;" type="text"
																	name="fuenteDedatos[${i.index}]" value="${fuentes}"
																	readonly
																	ondblclick="Traspass(this, $(this).closest('.fuenteDedatos').attr('id'))" />
															</div>
														</c:forEach>
			
													</c:if>
			
												</div>
											</div>
											<div id="div2">
												<div id="fuenteDedatosMod" class="fuenteDedatos">
													<c:if test="${not empty CatastrofeModel.fuenteDedatosMod}">
			
														<c:forEach var="fuentesmod"
															items="${CatastrofeModel.fuenteDedatosMod}" varStatus="i">
															<div class="fuenteDedatosContainer">
																<input style="width: 70px;" type="text"
																	name="fuenteDedatosMod[${i.index}]" value="${fuentesmod}"
																	readonly
																	ondblclick="Traspass(this, $(this).closest('.fuenteDedatos').attr('id'))" />
															</div>
														</c:forEach>
			
													</c:if>
												</div>
											</div>
			
			
										</div>
									</div>
								</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<input type="submit" class="btn btn-lg btn-success" name="action"
											value="${CatastrofeModel.action}" />
									</div>
																	
								</div>		
							</div>
					    </div>
					  </div>
					</div>
				</form:form>
			
			</div>
		</div>
		<br><br><br><br>
	</div>
	
	<script>
	 	$('#tabs').tab();

		$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
			initialize();       
		});

		buildColorPalette();
	</script>
</body>
</html>
