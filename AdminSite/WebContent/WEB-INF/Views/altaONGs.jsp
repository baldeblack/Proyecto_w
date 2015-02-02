<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" >
 	jQuery(document).ready(function($) {	
		
		if($('#actionbtn').val() == "Modificar"){
			$('#nombre').attr('readonly', true);
		}
			});
</script>
        <h1>Alta ONGs</h1>

 <form:form method="POST" action="/BackOffice/ongs/save" commandName="OngModel"> 
        <form:errors path="*" cssClass="errorblock" element="div"/> 
        <table>
			<tr>		
				<td>Nombre :</td>
				<td><form:input id="nombre" path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>					
			<tr>
				<td>Mail :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Web :</td>
				<td><form:input path="web" /></td>
				<td><form:errors path="web" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Telefono :</td>
					<td><form:input path="telefono" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>	
			<tr>
				<td>Direccion :</td>
					<td><form:input path="direccion" /></td>
				<td><form:errors path="direccion" cssClass="error" /></td>		
			<tr>
				<td>Datos PayṔal :</td>
					<td><form:input path="datosPayPal" /></td>
				<td><form:errors path="datosPayPal" cssClass="error" /></td>			
				<tr>
				<td>Origen :</td>
					<td><form:input path="origen" /></td>
				<td><form:errors path="origen" cssClass="error" /></td>				    
			
	</table>				              
		
		<table>
                <tr>
                <td colspan="2" align="center"><input id="actionbtn"
				type="submit" name="action" value="${OngModel.action}" /></td>
                </tr>
            </table>

		
		</form:form>


