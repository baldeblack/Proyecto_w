<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- CONTENIDO PRINCIPAL -->
		<div id="contenido-principal" class="header alt vert">
		  <div class="container">
			<div class="row">
			  <div class="col-md-7 titulo_principal"">
				<h1>${sessionScope.Catastrofe.nombre}
				  <p class="lead"></p>
				</h1>
			  </div>		  
			  <div class="col-md-5 boton_solayu"><br><br>
				<a href="#" class="btn btn-danger bton-sos" data-toggle="modal" data-target="#modalAyuda" data-placement="bottom" title="Solicitar Ayuda"><i class="glyphicon glyphicon-warning-sign"></i></a>
			  </div>
			</div> 
		  </div>
		  <div id="loc"></div>	  
		</div>
		
		<!-- DESCRIPCION-->
		<div class="container-fluid informacion">
		
			<!-- Heading Row -->
	        <div class="row">
	            <div class="col-md-8">
 						<div id="map-canvas"></div>
 						<input type="hidden" id="zonaAfectada" value="${sessionScope.Catastrofe.zonaAfectada}"/>
	            </div>
	            <!-- /.col-md-8 -->
	            <div class="col-md-4">
	                <h1>Descripci&oacute;n</h1>
	                <p>${sessionScope.Catastrofe.informacion}</p>
	            </div>
	            <!-- /.col-md-4 -->
	        </div>
	        <!-- /.row -->
	       
		</div>
		
		<jsp:include page="imagenes.jsp" />
		
	<!-- DESAPARECIDOS -->
	<div  class="desaparecidos_titulo">
		<div id="desp"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-6 col-lg-6 columna-desp">
					<h1>Desaparecidos</h1>
				</div>
				<div class="col-lg-6 search">
					<div class="input-group c-search">
	                      <input type="search" class="form-control" id="container-search">
	                      <span class="input-group-btn">
	                          <button class="btn btn-warning" type="buttom" ><span class="glyphicon glyphicon-search text-muted"></span></button>
	                      </span>
	                  	</div>
	                  </div>
				<div class="col-xs-12 col-md-4 col-lg-2 pull-right botones-desaparecidos">
					<a href="#" class="btn btn-warning bton-vermas">Ver mas</a>
						<c:if test="${empty sessionScope.active_user}">
							<a class="btn btn-warning bton-reportar" onclick="javascript:alert('Para reportar un desaparecido, debe iniciar sesi&oacute;n.')">Reportar</a>
						</c:if>
						<c:if test="${not empty sessionScope.active_user}">
							<a class="btn btn-warning bton-reportar" data-toggle="modal" data-target="#modalDesp">Reportar</a>
						</c:if>
				</div>
				<a href="#" class="btn btn-lg bton-cerrarvermas pull-right"><i class="glyphicon glyphicon-remove"></i></a>
			</div>
		</div>			
	</div>
	
	<div id="secDesaparecidos"></div>
		
	<div id="secOngs"></div>
		
	<jsp:include page="noticias.jsp" />