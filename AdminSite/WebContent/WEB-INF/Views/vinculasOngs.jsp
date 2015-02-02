<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="https://www.google.com/jsapi" ></script>
<script type="text/javascript"
	src="<c:url value="/resources/vinculasOngs.js" />"> </script>
	
	
<h1>${ongCatastofeModel.ctNombre} ONGs</h1>
<input type="hidden" id="idCt" name="idCt" value="${ongCatastofeModel.idCt}"/>
		<select id="select" name="ongSistemaLst">
		<c:if test="${not empty ongCatastofeModel.ongSistemaLst}">
					
								<c:forEach var="o" items="${ongCatastofeModel.ongSistemaLst}"
									varStatus="i">
									<option value="${o.idONGs}">${o.nombre}</option>							
								</c:forEach>
						
						</c:if>
		</select>
	
		<input id="add" type="button" name="add" value="Agregar"/>
		
<div id="tableContainer" style="width:500px, height:500px">
<div id="table"></div>
</div>

<input type="hidden" id="jsonTable" value="${ongCatastofeModel.jsonData}"/>
<input type="button" id="deleteBtn" value="Borrar" />