<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Spring 3.0 MVC Series: Hello World - ViralPatel.net</title>
<script type="text/javascript">
		$(document).ready(function() {			 
    var table = $('#lstTable').DataTable();
    var tt = new $.fn.dataTable.TableTools( table );
 
    $( tt.fnContainer() ).insertBefore('div.dataTables_wrapper');
} );
	</script>
</head>
<body>
<%
    String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
%>

	<c:if test="${not empty CatastrofeListModel.ctList}">
    <table id="lstTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
     <thead>
            <tr>
                <th>Name</th> 
                 <th>Dom</th> 
                  <th>Link</th>          
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                 <th>Name</th> 
                 <th>Dom</th> 
                  <th>Link</th>              
            </tr>
        </tfoot>
    <tbody>
        <c:forEach var="o" items="${CatastrofeListModel.ctList}">
            <tr>
                <th>${o.nombre}</th>      
                <th>${o.dominio}</th>   
                <th><a href="/BackOffice/catastrofes/edit/${o.idCatastrofe}">Editar</a></th>                 
            </tr>
        </c:forEach>
      </tbody>
    </table>
</c:if>
</body>
</html>