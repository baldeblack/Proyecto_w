<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>

<!-- Modal Ayuda-->
<div class="modal fade" id="modalAyuda" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="closeModal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Solicitar Ayuda</h4>
        <h3 id="responseHelp"></h3>
      </div>
      
     <!-- <form id="helpForm">--> 	        
		<div class="modal-body">
			<form data-toggle="validator"> 
			<div class="form-group">
				<label class="control-label">Tipo de ayuda</label>
				<select  id="typeRequest" class="form-control" tabindex="1" required>
				<c:if test="${empty sessionScope.active_user}">
					<option value="1" selected="selected">Anonimo</option>
				</c:if> 	
				<c:if test="${not empty sessionScope.active_user}">
				  <option value="2" selected="selected">Para Mi</option>
				  <option value="3">Para Otro</option>
				</c:if>
				</select>
			</div>
			<div class="form-group">
				<label class="control-label">Mensaje</label>
				<textarea id="message" class="form-control" placeholder="Mensaje.." rows="3" tabindex="2" required></textarea><br>
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                <!-- <div class="help-block with-errors"></div> -->
			</div>
			<div class="form-group">
				<label class="control-label">Telefono</label>
				<input type="text" name="tel_ayuda" id="tel_ayuda" class="form-control" placeholder="" tabindex="3" required/>
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                <!-- <div class="help-block with-errors"></div> -->
			</div>
			<div class="form-group">	
				<label class="control-label">Ubicacion</label>
				<input type="text" name="ubicacion_ayuda" id="ubicacion_ayuda" class="form-control" placeholder="" tabindex="4" required/>
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                <!-- <div class="help-block with-errors"></div> -->	
			</div>
			</form>
		</div>
		<div class="modal-footer">
		     <button type="button" class="btn btn-default" data-dismiss="modal" tabindex="5">Cerrar</button>
		     <button id="btnSend"  class="btn btn-warning" onclick="SendHelp()" tabindex="6">Solicitar</button>
		</div>
		<!--</form>-->
     
      
    </div>
  </div>
</div>