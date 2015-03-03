<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row contenedor_index_desap">
	<div class="row">
         <div class="col-sm-12 buscador">
             <div class="input-group">
               <input type="text" class="form-control buscar-desp" id="buscador" placeholder="Buscar desaparecido...">
               <span class="input-group-btn">
                 <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
               </span>
             </div><!-- /input-group -->
         </div>
     </div>
     <div class="row" id="contenedor-busqueda"><br>  
  
 			 <c:if test="${not empty desaparecidos}">                      
                       	<c:forEach var="d" varStatus="j" items="${desaparecidos}">						
						 <div id="div-${d.idDesaparecidos}"class="col-sm-3 opcion animated bounceInUp">
				             <div class="hero-widget well well-sm">
				                 <p class="fecha_des">${d.fechaDesaparicion}</p>
				                 <img src="data:image/jpeg;base64,${fotos[j.index]}" alt="">				
				                 <div class="text">
				                     <label class="text-muted">${d.nombre}</label>
				                     <p class="lugar_des">${d.ultimoParadero}</p>
				                 </div>
				                 <div class="options">
				                     <a href="#" id="${d.idDesaparecidos}" onclick="reportar(${d.idDesaparecidos})" class="btn btn-primary btn-lg"><i class="fa fa-check"></i>ENCONTRADO</a>
				                 </div>
				             </div>
				         </div>
               		    </c:forEach>               		
				</c:if>	  

     </div>
</div>