<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<script>
function Traspass(elem, idT){

	if(idT == "ongs"){
		$(elem).closest('.ongContainer').remove().clone().appendTo('#ongsMod');
	}else if(idT == "ongsMod"){
		$(elem).closest('.ongContainer').remove().clone().appendTo('#ongs');
	}
	updateName("ongs");
	updateName("ongsMod");
}

function updateName(id){
	var ind = 0;
	if(id == "ongs"){	 
		$('#ongs input').each(function(){    		  
		    $(this).attr('name', "ongSistemaLst[" + ind + "]");    	
		    ind = ind + 1;     		    	
		 });
	}else if(id == "ongsMod"){
		ind = 0;	
		$('#ongsMod input').each(function(){    		  
		    $(this).attr('name', "ongTenantLst[" + ind + "]");    	
		    ind = ind + 1;     		    	
		});
	}	 
}

</script>
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
						      <input style="width: 70px;" type="text" name="ongSistemaLst[${i.index}]" value="${sis.nombre}" readonly ondblclick="Traspass(this, $(this).closest('.ongs').attr('id'))"/>
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
						      <input style="width: 70px;" type="text" name="ongTenantLst[${i.index}]" value="${tnt.nombre}" readonly ondblclick="Traspass(this, $(this).closest('.ongs').attr('id'))"/>
							</div>	
						</c:forEach>
					
				</c:if>
					</div>
				</div>
			</div>
</div>
	
			<div><input type="submit"
				 name="action" value="Guardar" /></div>
	
</form:form>
