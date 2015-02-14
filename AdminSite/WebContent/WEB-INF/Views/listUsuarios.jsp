<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Usuarios</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
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
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="contenedor-header">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Menu</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex2-collapse">
                    <span>User</span> 
                </button>
				<a class="navbar-brand" href="">Backend</a>
			</div>
			
			<div class="collapse navbar-collapse navbar-ex2-collapse">
				<!-- <h2 class="navbar-text">Lista Usuarios</h2>-->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-user"></i>
							${sessionScope.user.nick} <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="divider"></li>
							<li><a href="/BackOffice/dologout"><i
									class="fa fa-power-off"></i> Cerrar Sesion</a></li>
						</ul></li>
				</ul>
			</div>
			
			<!-- MENU VERTICAL -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/BackOffice/catastrofes"><i class="fa fa-list"></i> Lista Catastrofe</a></li>
					<li><a href="/BackOffice/usuarios"><i class="fa fa-list"></i> Lista Usuarios</a></li>
					<li><a href="/BackOffice/ongs"><i class="fa fa-list"></i> Lista ONGs</a></li>
					<li><a href="/BackOffice/ongs/create"><i class="fa fa-plus-square"></i> Alta Ong's</a></li>
					<li><a href="/BackOffice/usuarios/create"><i class="fa fa-plus-square"></i> Alta Usuarios</a></li>
					<li><a href="/BackOffice/catastrofes/create"><i class="fa fa-plus-square"></i> Alta Catastrofe</a></li>	
					<li><a href="/BackOffice/planes/create"><i class="fa fa-plus-square"></i> Alta Plan</a></li>
					<li><a href="/BackOffice/rpt"><i class="fa fa-file"></i> Reportes</a></li>
				</ul>
			</div>
		</nav>
        <div class="row">
			<div class="contenido"><br>
        		<div class="col-md-12"><br>
		            <div class="panel panel-primary">
		                <div class="panel-heading">Lista Usuarios</div>
		                <div class="panel-body">
							<%
							    String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
							%>

							<c:if test="${not empty UsuariosListModel.lstUsuarios}">
						    <table id="lstTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
						     <thead>
						            <tr>
						                <th>Nombre</th>               
						                  <th>Link</th>          
						            </tr>
						        </thead>
						 
						        <tfoot>
						            <tr>
						                 <th>Nombre</th>              
						                  <th>Link</th>              
						            </tr>
						        </tfoot>
						    <tbody>
						        <c:forEach var="o" items="${UsuariosListModel.lstUsuarios}">
						            <tr>
						                <th>${o.nombre}</th>
						                <th><a href="/BackOffice/usuarios/edit/${o.idUsuarios}">Editar</a></th>                 
						            </tr>
						        </c:forEach>
						      </tbody>
						    </table>
						</c:if> 
					</div> 
   				</div>
   			</div>
   		</div>               
      </div>
   </div>  
</body>
</html>
