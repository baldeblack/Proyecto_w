<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="row contenedor_index">
		<div class="col-sm-6">   
            <div class="paneles well well-sm">
                <h2>Catastrofe</h2>
                <div class="row">
                    <div class="col-sm-5">
                     <img src="data:image/jpeg;base64,${logo}" alt="">
                    </div>
                   <div class="col-sm-7">
                        <div class="text">
                            <p>${catastrofe.nombre}</p>
                            <p>${catastrofe.dominio}</p>
                            <p>${tipoc}</p>
                            <p>${catastrofe.informacion}</p>
                        </div>
                   </div>
                </div>
               
            </div>
        </div>

        <div class="col-sm-6">
            
            <div class="paneles well well-sm">
                <h2>Rescatista</h2>
                <div class="row">
                    <div class="col-sm-5">
                     <img src="resources/images/usuario.gif" alt="">
                    </div>
                   <div class="col-sm-7">
                        <div class="text">
                            <p>${rescatista.usuario.nombre}</p>
                            <p>${tipor}</p>
                            <p>${rescatista.usuario.email}</p>
                        </div>
                   </div>
                </div>
               
            </div>
        </div>
        <div class="col-sm-12">
            <div class="mapa well well-sm">
                <h2>Localización</h2>
                <div id="map-canvas" style="width: 100%; height: 380px;"></div>
               <input type="hidden" id="zonaAfectada" value="${catastrofe.zonaAfectada}"/>
            </div>
        </div>
        
</div>