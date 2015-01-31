<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="<c:url value="/resources/reportes.js" />"> </script>


  <input id="clickinpt" type="button" name="load" value="Load"/>
    
   					   <select id="select" name="Catastrofes">
						<c:if test="${not empty ReporteModel.lstCT}">
					    <option value="g" selected="selected">General</option>
						<c:forEach var="sis" items="${ReporteModel.lstCT}"
							varStatus="i">
						 <option value="${sis.idCatastrofe}">${sis.nombre}</option>					   
					
						</c:forEach>
					
				</c:if>
											
				       </select>
   
   			<div>
	 			<div>Fecha Inicio :</div>
				<div><input type="date" id="start" name="start"/></div>
				
				<div>Fecha Fin :</div>
				<div><input type="date" id="end" name="end"/></div>
				
				<input id="export" type="button" name="export" value="Exportar"/>
			</div>
   
    <div id="chart_lines" style="width: 900px; height: 500px;"></div>
	<div id='png' style="width: 100px; height: 100px;"></div>