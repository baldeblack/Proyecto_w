<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="<c:url value="/resources/rptTables.js" />"> </script>

<div id="radios">
		<input type="radio" name="donRbt" value="m" checked="checked">Donaciones en el tiempo.<br>
		<input type="radio" name="pedRbt" value="fe">Pedido de ayuda en el tiempo<br>
		<input type="radio" name="usoRbt" value="fle">Uso sitio<br>
	</div>
		<div id="selectDiv">
		  <select id="select" name="Catastrofes">
						<c:if test="${not empty ReporteModel.lstCT}">
					    <option value="g" selected="selected">General</option>
						<c:forEach var="sis" items="${ReporteModel.lstCT}"
							varStatus="i">
						 <option value="${sis.idCatastrofe}">${sis.nombre}</option>					   
					
						</c:forEach>
					
				</c:if>
											
				       </select>
		</div>
		<div id="dateDiv">
			<input id="start" type="date" name="start" required >
			<input id="end" type="date" name="end" required >
		</div>
		<input id="clickinpt" type="submit" value="Generar"/>
    <div id="divTable" style="width: 900px; height: 500px;">

	</div>
  