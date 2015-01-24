<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Spring 3.0 MVC Series: Hello World - ViralPatel.net</title>
<script type="text/javascript">
		$(document).ready(function() {			 
    var table = $('#lstTable').DataTable( {
        "language": 
        {
        	"sProcessing":     "Procesando...",
        	"sLengthMenu":     "Mostrar _MENU_ registros",
        	"sZeroRecords":    "No se encontraron resultados",
        	"sEmptyTable":     "Ningun dato disponible en esta tabla",
        	"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
        	"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
        	"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
        	"sInfoPostFix":    "",
        	"sSearch":         "Buscar:",
        	"sUrl":            "",
        	"sInfoThousands":  ",",
        	"sLoadingRecords": "Cargando...",
        	"oPaginate": {
        		"sFirst":    "Primero",
        		"sLast":     "Ultimo",
        		"sNext":     "Siguiente",
        		"sPrevious": "Anterior"
        	},
        	"oAria": {
        		"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
        		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
        	}
        }
    });
    
    var tt = new $.fn.dataTable.TableTools( table );
 
    $( tt.fnContainer() ).insertBefore('div.dataTables_wrapper');
} );
	</script>
</head>
<body>
<%
    String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
%>

	<c:if test="${not empty OngsListModel.lstOngs}">
    <table id="lstTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
     <thead>
            <tr>
                <th>Name</th>               
                  <th>Link</th>          
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                 <th>Name</th>              
                  <th>Link</th>              
            </tr>
        </tfoot>
    <tbody>
        <c:forEach var="o" items="${OngsListModel.lstOngs}">
            <tr>
                <th>${o.nombre}</th>
                <th><a href="/BackOffice/ongs/edit/${o.idONGs}">Editar</a></th>                 
            </tr>
        </c:forEach>
      </tbody>
    </table>
</c:if>
</body>
</html>