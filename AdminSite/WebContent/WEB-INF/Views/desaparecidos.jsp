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
  
         <div class="col-sm-3 opcion animated bounceInUp">
             <div class="hero-widget well well-sm">
                 <p class="fecha_des">12/02/15</p>
                 <img src="resources/images/des1.jpg" alt="">
   
                 <div class="text">
                     <label class="text-muted">Nombre</label>
                     <p class="lugar_des">Canelones</p>
                 </div>
                 <div class="options">
                     <a href="#" class="btn btn-primary btn-lg"><i class="glyphicon glyphicon-plus"></i> Encontrado</a>
                 </div>
             </div>
         </div>

     </div>
</div>