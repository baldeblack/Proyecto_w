<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ONG</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" >
	 	jQuery(document).ready(function($) {	
			
			if($('#actionbtn').val() == "Modificar"){
				$('#nombre').attr('readonly', true);
			}
				});
	</script>

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
				<!-- <h2 class="navbar-text">Alta ONGs</h2>-->
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
        	<div class="contenido">
				<br>
 <!--<form:form method="POST" action="/BackOffice/ongs/save" commandName="OngModel"> 
        <form:errors path="*" cssClass="errorblock" element="div"/> 
        <table>
			<tr>		
				<td>Nombre :</td>
				<td><form:input id="nombre" path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error" /></td>
			</tr>					
			<tr>
				<td>Mail :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Web :</td>
				<td><form:input path="web" /></td>
				<td><form:errors path="web" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Telefono :</td>
					<td><form:input path="telefono" /></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>	
			<tr>
				<td>Direccion :</td>
					<td><form:input path="direccion" /></td>
				<td><form:errors path="direccion" cssClass="error" /></td>		
			<tr>
				<td>Datos PayṔal :</td>
					<td><form:input path="datosPayPal" /></td>
				<td><form:errors path="datosPayPal" cssClass="error" /></td>			
				<tr>
				<td>Origen :</td>
					<td><form:input path="origen" /></td>
				<td><form:errors path="origen" cssClass="error" /></td>				    
			
		</table>				              
		
			<table>
                <tr>
                <td colspan="2" align="center"><input id="actionbtn"
				type="submit" name="action" value="${OngModel.action}" /></td>
                </tr>
            </table>

		
		</form:form>-->
         
         
         		<div class="col-md-12"><br>
		            <div class="panel panel-primary">
		                <div class="panel-heading">Alta ONGs</div>
		                <div class="panel-body">
		                	<form:form method="POST" action="/BackOffice/ongs/save" commandName="OngModel">
		                	<div class="col-md-6">
		                      <div class="form-group">
		                        <label for="nombre">Nombre</label>
		                        <form:input id="nombre" class="form-control" path="nombre" />
								<form:errors class="bg-danger" path="nombre" cssClass="bg-danger text-danger" />
		                      </div>
		                      <div class="form-group">
		                        <label for="email">Mail</label>
		                        <form:input class="form-control" path="email"/>
		                        <form:errors class="bg-danger" path="email" cssClass="bg-danger text-danger" />
		                      </div>
		                    </div>
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="web">Web</label>
		                        <form:input class="form-control" path="web" />
		                        <form:errors class="bg-danger" path="web" cssClass="bg-danger text-danger" />
		                      </div>
		                      <div class="form-group">
		                        <label for="tel">Telefono</label>
		                        <form:input class="form-control" path="telefono" />
		                        <form:errors class="bg-danger" path="telefono" cssClass="bg-danger text-danger" />
		                      </div>
		                    </div>
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="direccion">Direccion</label>
		                        <form:input class="form-control" path="direccion" />
		                        <form:errors class="bg-danger" path="direccion" cssClass="bg-danger text-danger" />
		                      </div>
		                    </div>
		                    
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="pay">Datos PayPal</label>
		                        <form:input class="form-control" path="datosPayPal" />
		                        <form:errors class="bg-danger" path="datosPayPal" cssClass="bg-danger text-danger" />
		                      </div>
		                    </div>
		                    
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="origen">Origen</label>
		                        <form:input class="form-control" path="origen" />
		                        <form:errors class="text-danger" path="origen" cssClass="bg-danger text-danger" />
		                      </div>
		                    </div>
		                    <div class="col-md-12">
		                      <button type="submit" class="btn btn-lg btn-success" id="actionbtn" name="action" value="${OngModel.action}">Crear</button>
		                    </div>
		                    </form:form>
		                </div>
		            </div>
		        </div>
         
         
         	</div>
        </div>               
      <br><br><br><br><br><br><br>
   </div>  
</body>
</html>
