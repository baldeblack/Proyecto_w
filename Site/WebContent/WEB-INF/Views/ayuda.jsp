<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>
<script type="text/javascript">

$(document).ready(function() {
	$('#btnSend').click(function() {
		debugger;
		var typeRequest = $('#typeRequest').val();
	    var messaje = $('#message').val();
	    var location = $('#ubicacion_ayuda').val();
	    var json = '{ "typeRequest" : '+typeRequest+', "message" : '+message+', "location": '+location+'}';
	    
	    $.ajax({
	        url : '/Site/help/ask',
	        type: 'POST',
	        data: JSON.stringify(json),
	        cache : false,
	        processData: false,
	        async: false,
	        beforeSend: function(xhr) {
	          xhr.setRequestHeader("Accept", "application/json");
	          xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success : function(response) {
	        	callback(funtion());
	        	 if(response==="success"){ 
		            	$("#responseHelp").html("Se ah enviado su solicitud de ayuda aguarde a ser contactado.");
		            	$('#typeRequest').val(1);
		            	$('#message').val("");
		            	$('#ubicacion_ayuda').val("");
		            	$("#closeModal").click();
		            }
		            else {
		            	$("#responseHelp").html("Hubo un error al procesar su solicitud por fabor vuelva a intentarlo o comuniquece al: 112233");
		            }
	        },
	        error:function(response,status,er) { 
	        	alert("error: "+response+" status: "+status+" er:"+er);
	        }
	    });
	});
});
</script>
<!-- Modal Ayuda-->
<div class="modal fade" id="modalAyuda" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" id="closeModal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Solicitar Ayuda</h4>
        <h3 id="responseHelp"></h3>
      </div>
      
     <form id="helpForm" role="form"> 		        
		<div class="modal-body">
			<div class="form-group">
				<select  id="typeRequest" class="form-control input-lg" tabindex="6">
				  <option value="1">Anonimo</option>
				  <option value="2">Para Mi</option>
				  <option value="3">Para Otro</option>
				</select>
			</div>
			<textarea id="message" class="form-control" placeholder="Mensaje.." rows="3"></textarea><br>
			<div class="form-group">
				<input type="text" name="ubicacion_ayuda" id="ubicacion_ayuda" class="form-control input-lg" placeholder="Ubicacion" tabindex="6"/>
			</div>
		</div>
		<div class="modal-footer">
		     <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		     <input id="btnSend" type="button" class="btn btn-warning" value="Solicitar"/>
		</div>
		</form>
     
      
    </div>
  </div>
</div>