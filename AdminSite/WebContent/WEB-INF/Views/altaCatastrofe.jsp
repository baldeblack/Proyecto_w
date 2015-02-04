<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catastrofe</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false&libraries=drawing"></script>
<script type="text/javascript"
	src="<c:url value="/resources/catastrofesZona.js" />">
	
</script>
<script src="http://www.google-analytics.com/urchin.js"
	type="text/javascript">
	
</script>
<script type="text/javascript">
	_uacct = "UA-162157-1";
	urchinTracker();
</script>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>"
	rel="stylesheet" type="text/css" />
<style type="text/css">
#map {
	width: 600px;
	height: 600px;
}

#panel {
	width: 800px;
	font-family: Arial, sans-serif;
	font-size: 13px;
	float: right;
	margin: 10px;
}

#color-palette {
	clear: both;
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
	border: 1px solid #D1D1D1;
	background-color: #00F;
}
</style>
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
								class="fa fa-fw fa-power-off"></i> Cerrar Sesion</a></li>
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
					<li><a href="/BackOffice/planes/create"><i class="fa fa-fw fa-file"></i>Alta
							Plan</a></li>
				</ul>
			</div>
		</nav>
		<div id="contenedor_web_contenido">
			<div class="container-fluid">
				<h1>Alta Catastrofe</h1>

				<form:form method="POST" action="/BackOffice/catastrofes/save"
					commandName="CatastrofeModel" enctype="multipart/form-data">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<div>
						<div>
							<div>Nombre :</div>
							<div>
								<form:input path="nombre" required="true" />
							</div>
							<div>
								<form:errors path="nombre" cssClass="error" />
							</div>
						</div>
						<div>
							<div>Dominio :</div>
							<div>
								<form:input path="dominio" required="true" />
							</div>
							<div>
								<form:errors path="dominio" cssClass="error" />
							</div>
						</div>
						<div>
							<div>Informacion :</div>
							<div>
								<form:textarea path="informacion" required="true" />
							</div>
							<div>
								<form:errors path="informacion" cssClass="error" />
							</div>
						</div>
							<div>
							<div>Key Facebook :</div>
							<div>
								<form:input path="apiFb" required="true" />
							</div>
							<div>
								<form:errors path="apiFb" cssClass="error" />
							</div>
						</div>
							<div>
							<div>Key Twitter :</div>
							<div>
								<form:input path="apiTw" required="true" />
							</div>
							<div>
								<form:errors path="apiTw" cssClass="error" />
							</div>
						</div>
						<div>
							<div>Activa :</div>
							<div>
								<select name="activa">
									<option selected="selected" value="1">SI</option>
									<option value="0">NO</option>
								</select>
							</div>
						</div>
						<div>
							<div>
								<div class="innerTwo">
									<p>Palabras Claves :</p>

									<div>
										<input id="PalabrasInput" type="image"
											src="http://localhost/img/ic_add_box_24px.svg" />
									</div>
									<br /> <br />
									<div id="PalabrasDiv">
										<c:if test="${not empty CatastrofeModel.palabrasList}">

											<c:forEach var="palabras"
												items="${CatastrofeModel.palabrasList}" varStatus="i">
												<div class="palabraContainer">
													<input type="text" name="palabrasList[${i.index}]"
														value="${palabras}"
														ondblclick="javascript:return deletePalabras(this)" />
												</div>
											</c:forEach>

										</c:if>


									</div>
								</div>
							</div>
						</div>
						<div>
							<div>Logo :</div>
							<div>
								<form:input type="file" path="logo" />
							</div>
							<div>
								<form:errors path="logo" cssClass="error" />
							</div>
							<div>
								<img class="imgShow" alt="" title=""
									src="data:image/jpeg;base64,${CatastrofeModel.logoString}">
							</div>
						</div>
						<div>
							<div>Temas :</div>
							<div>
								<select name="css">
									<option selected="selected" value="Style1.css">TEMA 1</option>
									<option value="Style2.css">TEMA 2</option>
									<option value="Style2.css">TEMA 3</option>
									<option value="Style1.css">TEMA 4</option>
									<option value="Style1.css">TEMA 5</option>
									<option value="Style1.css">TEMA 6</option>
								</select>
							</div>
						</div>
						</div>
						<div>
						<div>Tipo :</div>
						<div><form:select path="tipo" multiple="false" size="1">
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
							</form:select></div>
						</div>
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
						<div id="panel">
							<div id="color-palette"></div>
							<div>
								<button id="delete-button" onclick="return false;">Limpiar
									Mapa</button>
							</div>
						</div>
						<div id="map"></div>
						<div>
							<div>
								<div>
									<form:hidden id="zonaAfectada" path="zonaAfectada"
										required="true" />
									</td>
									<div>
										<form:errors path="zonaAfectada" cssClass="error" />
									</div>
								</div>
							</div>

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
							<div>
								<div>
									<div colspan="2" align="center">
										<input type="submit" name="action"
											value="${CatastrofeModel.action}" />
									</div>
								</div>
							</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
