<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${not empty Losts}">
	<div class="container-fluid desaparecidos">
		<div class="container lista_desaparecidos" id="searchable-container" >
			<div class="row">
				<c:forEach var="lost" items="${Losts}">
				 	<div class="col-xs-6 col-md-3 thumbnail">
				 		<div class="caption">
			            	<h4 class="nm">${lost.nombre} ${lost.apellido}</h4>
			            	<p>Contacto: ${lost.nombreContacto}</p>
			                <p>Telefono: ${lost.telefonoContacto}</p>
			                <p>${lost.ultimoParadero}</p>
					    </div>
					    <img class="img-responsive" src="data:image/jpeg;base64,${lost.foto}" alt="...">
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="slider_desaparecidos">
			<div class="row">
				<div class="col-lg-12">
				<!-- CAROUSEL DESAPARECIDOS -->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						 <!-- Imagenes -->
						  <div class="carousel-inner" role="listbox">
							<c:forEach var="lost" items="${Losts}" varStatus="loop" >
								<c:if test="${loop.index % 4 == 0}">
									<c:if test="${loop.index  != 0}">
										</div>
									</c:if>
									<div class="item" >
								</c:if>
								
										<div class="col-sm-4 col-md-4">
								  		<div class="col-lg-6">
							                <div class="post-img-content">
							                    <img src="data:image/jpeg;base64,${lost.foto}" class="img-responsive" />
							                    <span class="post-title"><b>${lost.nombre} ${lost.apellido}</b><br />
							                        <b>${lost.telefonoContacto}</b></span>
							                </div>
					               	   </div>
					               		<div class="col-lg-6">
						                    <div class="">
						                        reportado por: <b>${lost.nombreContacto}</b> |
						                        <time datetime="${lost.fechaDesaparicion}">${lost.fechaDesaparicion}</time>
						                    </div>
						                    <div>
						                    	<b>Ultimo paradero</b> ${lost.ultimoParadero}
						                    	<br/>
						                    	<b>Edad</b> ${lost.edad} <b>Sexo</b> ${lost.sexo}
						                    </div>
					                	</div>
					  					</div>
					  			<c:if test="${fn:length(Losts) == (loop.index+1)}">
									</div>
								</c:if>
			  				</c:forEach>  
			  			</div>		 
					</div>
				 		<!--Controles -->
					  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>