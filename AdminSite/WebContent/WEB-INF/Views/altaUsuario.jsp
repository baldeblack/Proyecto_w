<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<c:url value="/resources/altausuario.js" />"> </script>
        <h1>Alta Usuarios</h1>

 <form:form method="POST" action="/BackOffice/usuarios/save" commandName="UsuariosModel"> 
        <form:errors path="*" cssClass="errorblock" element="div"/> 
        <table>
			<tr>		
				<td>Nombre :</td>
				<td><form:input path="nombre" required="true" /></td>
			</tr>					
			<tr>
				<td>Apellido :</td>
				<td><form:input path="apellido" required="true" /></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td><form:input type="email" path="email" required="true" /></td>
			</tr>	
			<tr>
				<td>Nick :</td>
				<td><form:input path="nick" required="true"/></td>
			</tr>
			<tr>
				<td>Contraseņa :</td>
				<td><form:input type="password" path="password" required="true"/></td>
			</tr>
			<tr>
				<td>Celular :</td>
					<td><form:input path="celular" type="tel" required="true" /></td>
			</tr>	
			<tr>
				<td>Direccion :</td>
					<td><form:input path="direccion" required="true"/></td>
			</tr>	
				<tr>
				<td>Sexo :</td>
				<td>	
				<select name=sexo>
						  <option selected="selected" value="M">Masculino</option>				
						  <option value="F">Femenino</option>						  			
				</select>
				</td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento :</td>
				<td><form:input type="date" path="nacimiento" required="true"/></td>	
			</tr>
			<tr>
				<td>Tipo Usuario :</td>
				<td>	<select name="tipoUsuario" onchange="rescatistaDiv(this)">
						  <option selected="selected" value="0">ADMINISTRADOR</option>
						  <option value="1">RESCATISTA</option>
						</select>
				</td>				
			</tr>			
	</table>	
	
	 
               		<div id="rescatistaDiv" style="display:none;">		
               			<table>	
             <tr>
				<td>Tipo Rescatista :</td>
				<td>	
				<form:select path="tiporescatisa" id="tiposrescatistas" multiple="false" size="1">
				<form:options items="${UsuariosModel.tiposrescatistas}" itemValue="idTipoRescatista" itemLabel="Nombre"/>
				</form:select>							
				</td>
			</tr>
			<tr>
			<td>
				<div id="map_container" style="width: 500px; height: 500px;"></div>
				</td>
				</tr>
			<tr>
        	<td><input type="hidden" name="lat" id="lat"></td>			
			<td><input type="hidden" name="long" id="long"></td>
			<td><form:hidden id="latLongRecidencia"  path="latLongRecidencia" /></td>
			<td><form:errors path="latLongRecidencia" cssClass="error" /></td>
			</tr>
            </table>
            </div>		 

		
		<table>
                <tr>
                <td colspan="2" align="center"><input type="submit" value="Guardar"/></td>
                </tr>
            </table>

		
		</form:form>

