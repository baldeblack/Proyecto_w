<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<script type="text/javascript"
	src="<c:url value="/resources/ongscatastrofe.js" />"> </script>
<style>
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
			
			.innerTwo {
               padding: 20px;
	       border: 1px solid #D1D1D1;
               background-color: #00F;            
            }
</style>

<h1>${ongCatastofeModel.ctNombre} ONGs</h1>
<form:form method="POST" action="/BackOffice/ongs/ongct"
	commandName="ongCatastofeModel">
		<div class="wrapper">
		<input type="hidden" name="idCt" value="${ongCatastofeModel.idCt}"/>
			<div class="inner">
				<div id="div1">
					<div id="ongs" class="ongs">
						<c:if test="${not empty ongCatastofeModel.ongSistemaLst}">
					
						<c:forEach var="sis" items="${ongCatastofeModel.ongSistemaLst}"
							varStatus="i">
							<div class="ongContainer">
						      <input style="width: 70px;" type="text" name="ongSistemaLst[${i.index}].nombre" value="${sis.nombre}" readonly ondblclick="Traspass(this, $(this).closest('.ongs').attr('id'))" onclick="fover(this)" onmouseout="fout(this)"/>
						   	  <input type="hidden"  class="hd" name="ongSistemaLst[${i.index}].idONGs" value="${sis.idONGs}"/>
						   	</div>	
						</c:forEach>
					
				</c:if>
											
					</div>
				</div>
				<div id="div2">
					<div id="ongsMod" class="ongs">
						 		<c:if test="${not empty ongCatastofeModel.ongTenantLst}">
					
						<c:forEach var="tnt" items="${ongCatastofeModel.ongTenantLst}"
							varStatus="i">
							<div class="ongContainer">
						      <input style="width: 70px;" type="text" name="ongTenantLst[${i.index}].nombre" value="${tnt.nombre}" readonly ondblclick="Traspass(this, $(this).closest('.ongs').attr('id'))" onclick="fover(this)" onmouseout="fout(this)"/>
							  <input type="hidden"  class="hd" name="ongTenantLst[${i.index}].idONGs" value="${tnt.idONGs}"/>
							</div>	
						</c:forEach>
					
				</c:if>
					</div>
				</div>
			</div>
			
			<div class="inner" id="divInfo" style="display: none">
				<div id="divMail"></div>
				<div id="divWeb"></div>
				<div id="divDir"></div>
				<div id="divTel"></div>
			</div>
</div>
	
			<div><input type="submit"
				 name="action" value="Guardar" /></div>
	
</form:form>
