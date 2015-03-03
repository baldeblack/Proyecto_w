<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row contenedor_index_pasos">
	<div class="row form-group">
	<input type="hidden" id="idplan" value="${plan.idPlan}"></input>
        <div class="col-xs-12">
            <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                <c:if test="${not empty plan.pasos}">                      
                       	<c:forEach var="p" varStatus="j" items="${plan.pasos}">						
						<li id="${p.idpasos}" class="disabled pasos_resc"><a href="#step-${p.idpasos}" onclick="nav(this,event)">
		                   <h4 class="list-group-item-heading">${p.nombre}</h4>
		                   <!-- <p class="list-group-item-text">${p.descripcion}</p>-->
		                   <input type="hidden" id="hidden-${p.idpasos}" value="${p.estado}"></input>
               		    </a></li>
               		    </c:forEach>
               		
				</c:if>		
            </ul>
        </div>
	</div>
     <c:if test="${not empty  plan.pasos}">
                       <c:forEach var="p" varStatus="i" items="${plan.pasos}">
							<div class="row setup-content" id="step-${p.idpasos}">
								<div class="col-xs-12">
								   <div class="col-md-12 well contenido_pasos_res">
										<h1 class="text-center">${p.nombre}</h1>
										<p>${p.descripcion}</p>
										<br> 										
										<button id="btn-${p.idpasos}" onclick="updatestep(this , ${p.idpasos})" class="btn btn-primary btn-lg">Completado</button>										 
									</div>
								</div>
							</div>
					</c:forEach>
				</c:if>		
</div>
