<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h1>Alta Plan</h1>
        
<script type="text/javascript" >

$( document ).ready(function() {

$('#pasosInput').click(function(){
	 $('#pasosTable').append(
			 '<tr><td><input class="inptNombre" type="text" name="pasos['+ $('#pasosTable tr').length +'].nombre" value="${paso.nombre}" ondblclick="deletePaso(this)" /></td><td><input class="inptDes" type="text" name="pasos['+ $('#pasosTable tr').length +'].descripcion" value="${paso.descripcion}" ondblclick="deletePaso(this)" /></td><td><select id="titleInput" name="pasos['+ $('#pasosTable tr').length +'].tipoRescatista"> <option value=""></option><c:forEach items="${PlanModel.tiposrescatistas}" var="tipo"><option value="${tipo.idTipoRescatista}" >${tipo.nombre}</option></c:forEach></select></td></tr>');
	 
	  var ind = 0;
	    $('.inptNombre').each(function(){
	    	//if statement here 
	        // use $(this) to reference the current div in the loop
	        //you can try something like...

	    	$(this).attr('name', "pasos[" + ind + "].nombre");    	
	    	ind = ind + 1;     		    	

	     });
	    
	    ind = 0;		    
	    $('.inptDes').each(function(){
	    	//if statement here 
	        // use $(this) to reference the current div in the loop
	        //you can try something like...

	    	$(this).attr('name', "pasos[" + ind + "].descripcion");    	
	    	ind = ind + 1;     		    	

	     });
	    
})       
                              
});



function deletePaso(inpt){
		 var tr = inpt;
		    while(tr && tr.nodeName != "TR") tr = tr.parentNode;
		    if( !tr) throw new Error("Failed to find the row, was the function called correctly?");
		    tr.parentNode.removeChild(tr); // delete it
		    
		    var ind = 0;
		    $('.inptNombre').each(function(){
		    	//if statement here 
		        // use $(this) to reference the current div in the loop
		        //you can try something like...

		    	$(this).attr('name', "pasos[" + ind + "].nombre");    	
		    	ind = ind + 1;     		    	

		     });
		    
		    ind = 0;		    
		    $('.inptDes').each(function(){
		    	//if statement here 
		        // use $(this) to reference the current div in the loop
		        //you can try something like...

		    	$(this).attr('name', "pasos[" + ind + "].descripcion");    	
		    	ind = ind + 1;     		    	

		     });
		    
	
  	}
</script>

 <form:form method="POST" action="/BackOffice/plan/save" commandName="PlanModel"> 
        <form:errors path="*" cssClass="errorblock" element="div"/> 
        <table>
			<tr>		
				<td>Nombre :</td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>					
			<tr>
				<td>Descripcion :</td>
				<td><form:textarea path="descripcion" /></td>
				<td><form:errors path="descripcion" cssClass="error" /></td>
			</tr>	
			<tr>
			<td>Pasos :</td>

			<td><input id="pasosInput" type="button" value="Paso Nuevo" /><br />
				<br />
				<div id="pasosDiv">
		<table id="pasosTable">
					<c:if test="${not empty PlanModel.pasos}">
				
							<c:forEach var="paso" items="${PlanModel.pasos}"
								varStatus="i">
								<tr>								
									<td><input class="inptNombre" type="text" name="pasos[${i.index}].nombre"
										value="${paso.nombre}" ondblclick="deletePaso(this)" /></td>
									<td><input class="inptDes" type="text" name="pasos[${i.index}].descripcion"
										value="${paso.descripcion}" ondblclick="deletePaso(this)" /></td>
										
									<td>	<select id="titleInput" name="pasos[${i.index}].tipoRescatista">
										    <option value=""></option>
										    <c:forEach items="${PlanModel.tiposrescatistas}" var="tipo">
										    									     
										            <option value="${tipo.idTipoRescatista}" >${tipo.nombre}</option>
										       
										    </c:forEach>
										</select>	
										</td>	
<%-- 										<td><form:select path="pasos[${i.index}].tipoRescatista" id="tiposrescatistas" multiple="false" size="1"> --%>
<%-- 											<form:options items="${PlanModel.tiposrescatistas}" itemValue="idTipoRescatista" itemLabel="Nombre"/> --%>
<%-- 											</form:select>	 --%>
<!-- 										</td>						 -->
								</tr>
							</c:forEach>
					
					</c:if>
	</table>
				</div></td>
		</tr>
		</table>				              
		
		<table>
                <tr>
                <td colspan="2" align="center"><input type="submit" value="Guardar"/></td>
                </tr>
            </table>

		
		</form:form>

