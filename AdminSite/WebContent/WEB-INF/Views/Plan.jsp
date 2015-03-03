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
	src="<c:url value="/resources/plan.js" />"></script>
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
					<li><a href="/BackOffice/ongs/create"><i
							class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i
							class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i
							class="fa fa-plus-square"></i> Alta Catastrofe</a></li>
					<li class="active"><a href="/BackOffice/planes/create"><i
							class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/planes"><i class="fa fa-plus-square"></i> Planes</a></li>
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
					<!-- <div class="panel panel-primary ani_panel animated bounceInUp">
						<div class="panel-heading">Planes</div>
						<div class="panel-body">-->
						<input type="hidden" id="idPlan" name="idPlan" value="${idPlan}">
							<input type="hidden" id="jsondata" name="jsondata"
								value="${jsondata}"> 
								
								 <div class="row">
							        <div class="col-md-4">
							            <div class="panel panel-primary ani_panel animated bounceInUp">
							                <div class="panel-heading">Alta Plan <a data-toggle="collapse" data-target="#altaP" href="#altaP"><i class="glyphicon glyphicon-chevron-up"></i></a>
											</div>
							                <div id="altaP" class="panel-body panel-collapse collapse in">
							                    <form id="altaPlanForm" data-toggle="validator" role="form" >
							                      <div class="form-group">
							                        <label for="nombre">Nombre</label>
							                        <input type="text" class="form-control" id="nombre" placeholder="" required>						
													<div class="help-block with-errors"></div>
							                      </div>
							                      <div class="form-group">
							                        <label for="descripcion">Descripcion</label>
							                        <textarea id="descripcion" name="desc0" placeholder="Description" class="form-control" required></textarea>
													<div class="help-block with-errors"></div>
							                      </div>
							                      <div class="form-group">
							                        <label for="selp">Tipo de Plan</label>
							                        <select id="selp" name="selp" class="form-control">
							        			        <option value="0">Gestion</option>
												        <option value="1">Emergencia</option>    				       
												    </select>
							                      </div>
							                      <div class="form-group">
							                        <label for="selt">Tipo de Catastrofe</label>
							                        <select id="selt" name="selt" class="form-control">
							    				      			<c:if test="${not empty tiposCatastrofe}">
																						<c:forEach var="s" varStatus="i" items="${tiposCatastrofe}">																
																									<option value="${s.idtipocatastrofe}">${s.nombre}</option>																	
																						</c:forEach>
														
														
																					</c:if>
												    </select>
							                      </div>     
											
							            	  <div id="colPasoInical" class="col-md-12">
												<div class="panel panel-primary">                  
							                        <div id="pHeading" class="panel-heading">Paso Inicial</div>
							                            <div class="panel-body">
							                              <div class="form-group">
							                                <label class="sr-only" for="nombre_paso">Nombre</label>
							                                <input type="text" class="form-control" id="nombre_paso" placeholder="Nombre paso" required>
															<div class="help-block with-errors"></div>
							                              </div>
							                              <div class="form-group">
							                                <label class="sr-only" for="desc_paso">Descripcion</label>
							                                <textarea name="desc0" id="desc_paso" placeholder="Descripcion ..." class="form-control" required></textarea>
															<div class="help-block with-errors"></div>
							                              </div>
							                            </div>
							                       </div>
							                    </div>	<div class="form-group">				  
							                      <button id="createP" type="submit" class="btn btn-default" value="Crear">Crear</button>
												  </div>
							                    </form>
							                </div>
							            </div>
							            <div id="pasoIncialRow">
										
										</div>
							        </div>	
							       
									 <div id="pasosContainer" class="col-md-8">
									
									 </div>
									</div>
									
								
				
						<!--  </div>-->
					<!-- </div>-->
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
