<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ONG's</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.tableTools.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>
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
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
  <div id="contenedor_web">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Menu</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">Backend</a>
            </div>

   			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.user.nick}
						<b class="caret"></b></a>
					<ul class="dropdown-menu">					
						<li class="divider"></li>
						<li><a href="/BackOffice/dologout"><i class="fa fa-fw fa-power-off"></i>
								Cerrar Sesion</a></li>
					</ul></li>
			</ul>
               
            <!-- MENU VERTICAL -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
					<li>
                        <a href="/BackOffice/catastrofes"><i class="fa fa-fw fa-file"></i> Lista Catastrofe</a>
                    </li>
                    <li>
                        <a href="/BackOffice/usuarios"><i class="fa fa-fw fa-file"></i> Lista Usuarios</a>
                    </li>
                     <li>
                        <a href="/BackOffice/ongs"><i class="fa fa-fw fa-file"></i> Lista ONGs</a>
                    </li>                    
					<li>
						<a  href="/BackOffice/ongs/create"><i class="fa fa-fw fa-file"></i> Alta Ong's</a>
					</li> 
					<li>
						<a  href="/BackOffice/usuarios/create"><i class="fa fa-fw fa-file"></i> Alta Usuarios</a>
					</li>  
					<li>
						<a href="/BackOffice/catastrofes/create"><i class="fa fa-fw fa-file"></i> Alta Catastrofe</a>
					</li> 
                    <li>
						<a href="/BackOffice/rpt"><i class="fa fa-fw fa-file"></i>Reportes en el tiempo</a>
					</li> 
					<li><a href="/BackOffice/planes/create"><i class="fa fa-fw fa-file"></i>Alta
							Plan</a></li>
					</ul>
			</div>
        </nav>
        <div id="contenedor_web_contenido">
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
        </div>               
      
   </div>  
</body>
</html>
