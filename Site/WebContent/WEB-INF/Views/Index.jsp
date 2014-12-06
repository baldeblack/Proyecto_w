<!-- CONTENIDO PRINCIPAL -->
		<div id="contenido-principal">
		  <div class="container">
			<div class="row">
			  <div class="col-md-7">
				<h1>${sessionScope.Catastrofe.nombre}
				  <p class="lead"></p>
				</h1>
			  </div>		  
			  <div class="col-md-5"><br><br>
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
		
		<div id="secDesaparecidos"></div>
		
		<div id="secOngs"></div>