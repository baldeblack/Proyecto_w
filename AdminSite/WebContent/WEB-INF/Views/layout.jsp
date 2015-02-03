<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<script type="text/javascript" src="<c:url value="/resources/OpenLayers/OpenLayers.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.tableTools.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>
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
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        
                    </ul>
                </li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Nick Usuario <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Configuración</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesion</a>
                        </li>
                    </ul>
                </li>
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
        </nav>
        <div id="contenedor_web_contenido">
            <div class="container-fluid">
                <tiles:insertAttribute name="body" />
            </div>               
        </div>  
   </div>  

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>
</html>
