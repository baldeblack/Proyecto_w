<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false&libraries=drawing"></script>
<script type="text/javascript"
	src="<c:url value="/resources/catastrofesZona.js" />"> </script>
<script src="http://www.google-analytics.com/urchin.js"
	type="text/javascript"> 
</script>
<script type="text/javascript"> 
_uacct = "UA-162157-1";
urchinTracker();
</script>
<script type="text/javascript" >
function borrar(img){
	 var div = $(img).parent().closest('div');
	 $(div).parent().closest('div').remove();
	 var ind = 0;
	  $('#fd input').each(function(){    		  
	  	$(this).attr('name', "imagenesNuevas[" + ind + "]");    	
	  	ind = ind + 1;     		    	
	  });
}
</script>
<style type="text/css">
#map {
	width: 600px;
	height: 600px;
}

#panel {
	width: 800px;
	font-family: Arial, sans-serif;
	font-size: 13px;
	float: right;
	margin: 10px;
}

#color-palette {
	clear: both;
}

.color-button {
	width: 14px;
	height: 14px;
	font-size: 0;
	margin: 2px;
	float: left;
	cursor: pointer;
}

#delete-button {
	margin-top: 5px;
}

.wrapper {
	max-width: 1200px;
	margin: 0 auto;
}

.inner {
	padding: 20px;
	border: 1px solid #D1D1D1;
	width: 215px;
	background-color: #00F;
	height: 190px;
}

#div1 {
	width: 100px;
	float: left;
}

#div2 {
	margin-left: 120px;
	width: 100px;
}

.delete{
width: 20px;
height: 20px;
margin-left: 125px;
}

.imgShow{
width:150px;
height:150px;
}

#container {
    width: 100px;
    height: 100px;
    position: relative;
}

.overlay {
	bottom: 30px;
	background: rgb(245, 245, 249);
	width: 150px;
	opacity: 0.8;
	position: relative;	
	//display:none;
}

</style>
<h1>Alta Catastrofe</h1>

<form:form method="POST" action="/BackOffice/catastrofes/save"
	commandName="CatastrofeModel" enctype="multipart/form-data">
	<form:errors path="*" cssClass="errorblock" element="div" />
	<table>
		<tr>
			<td>Nombre :</td>
			<td><form:input path="nombre" /></td>
			<td><form:errors path="nombre" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Dominio :</td>
			<td><form:input path="dominio" /></td>
			<td><form:errors path="dominio" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Informacion :</td>
			<td><form:textarea path="informacion" /></td>
			<td><form:errors path="informacion" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Activa :</td>
			<td><select name="activa">
					<option selected="selected" value="1">SI</option>
					<option value="0">NO</option>
			</select></td>
		</tr>
		<tr>
			<td>Palabras Claves :</td>

			<td><input id="PalabrasInput" type="button" value="Add Plabras" /><br />
				<br />
				<div id="PalabrasDiv">
		<table id="palabrasT">
					<c:if test="${not empty CatastrofeModel.palabrasList}">
				
							<c:forEach var="palabras" items="${CatastrofeModel.palabrasList}"
								varStatus="i">
								<tr>
									<td><input type="text" name="palabrasList[${i.index}]"
										value="${palabras}" ondblclick="deletePalabras(this)" /></td>
								</tr>
							</c:forEach>
					
					</c:if>
	</table>
				</div></td>
		</tr>
		<tr>
			<td>Logo :</td>
			<td><form:input type="file" path="logo" /></td>
			<td><form:errors path="logo" cssClass="error" /></td>
			<td><img class="imgShow" alt="" title="" src="data:image/jpeg;base64,${CatastrofeModel.logoString}"></td>
		</tr>
		<tr>
			<td>Temas :</td>
			<td><select name="css">
					<option selected="selected" value="TEMA 1">TEMA 1</option>
					<option value="TEMA 2">TEMA 2</option>
					<option value="TEMA 3">TEMA 3</option>
					<option value="TEMA 4">TEMA 4</option>
					<option value="TEMA 5">TEMA 5</option>
					<option value="TEMA 6">TEMA 6</option>
			</select></td>
		</tr>
		<tr>
	</table>
	<div class="wrapper">
		<div class="inner">
			<div id="div1">
<table id="palabrasTable">
				<c:if test="${not empty CatastrofeModel.fuenteDedatos}">
					
						<c:forEach var="fuentes" items="${CatastrofeModel.fuenteDedatos}"
							varStatus="i">
							<tr>
								<td><input style="width: 70px;" type="text"
									name="fuenteDedatos[${i.index}]" value="${fuentes}" readonly
									ondblclick="pp(this)" /></td>
							</tr>
						</c:forEach>
					
				</c:if>
</table>
			</div>
			<div id="div2">
				<table id="palabrasTableR">
				<c:if test="${not empty CatastrofeModel.fuenteDedatosMod}">
				
						<c:forEach var="fuentesmod"
							items="${CatastrofeModel.fuenteDedatosMod}" varStatus="i">
							<tr>
								<td><input style="width: 70px;" type="text"
									name="fuenteDedatosMod[${i.index}]" value="${fuentesmod}"
									readonly ondblclick="pp2(this)" /></td>
							</tr>
						</c:forEach>
			
				</c:if>
		</table>
			</div>
		</div>
	</div>
	<div id="panel">
		<div id="color-palette"></div>
		<div>
			<button id="delete-button" onclick="return false;">Limpiar
				Mapa</button>
		</div>
	</div>
	<div id="map"></div>
	<table>
		<tr>
			<td><form:hidden id="zonaAfectada" path="zonaAfectada" /></td>
			<td><form:errors path="zonaAfectada" cssClass="error" /></td>
		</tr>
	</table>
	<h3>Click Add More Files button to add files la puta madre</h3>
	<input id="addMoreFile" type="button" value="Add More Files" />
	<br />
	<br />
	<div id="fileDiv">
		<table id="uploadTable">
			<tr>
				<td><input name="multiUploadedFileList[0]" type="file" /></td>
			</tr>
		</table>
	</div>
	<div id="fd" style="width:600px; height:300px; height:300px; overflow-x: hidden; overflow-y: scroll">
	<c:if test="${not empty CatastrofeModel.imagenes}">				
						<c:forEach var="img"
							items="${CatastrofeModel.imagenes}" varStatus="i">	
	 <div style="display:inline-block">
      <img class="imgShow" alt="" title="" src="data:image/jpeg;base64,${img.byteValue}">
	  	  <div class="overlay">
		<img class="delete" alt="" title="" src="https://cdn3.iconfinder.com/data/icons/edition/100/trashcan-128.png" onclick="borrar(this)">
	  </div>
	  	<input type="hidden" name="imagenesNuevas[${i.index}]" value="${img.pathValue}"/>
    </div>
    	</c:forEach>
	</c:if>
	</div>
	<table>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				 name="action" value="${CatastrofeModel.action}" /></td>
		</tr>
	</table>
</form:form>