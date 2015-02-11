<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript">
	    $(function () {
	  	  $('[data-toggle="tooltip"]').tooltip()
	  	})
	</script>
	
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/rescatista.css"/>" rel="stylesheet" type="text/css" />

	<title>Rescatista Home</title>
	
</head>
<body>
 <!-- <div id="contenedor_web">-->
<!-- 	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->

<!-- 			<div class="navbar-header"> -->
<!-- 				<button type="button" class="navbar-toggle" data-toggle="collapse" -->
<!-- 					data-target=".navbar-ex1-collapse"> -->
<!-- 					<span class="sr-only">Menu</span> <span class="icon-bar"></span> <span -->
<!-- 						class="icon-bar"></span> <span class="icon-bar"></span> -->
<!-- 				</button> -->
<!-- 				<a class="navbar-brand" href="">Rescatista Backend</a> -->
<!-- 			</div> -->

<!-- 			<ul class="nav navbar-right top-nav"> -->
<!-- 				<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<!-- 					data-toggle="dropdown"><i class="fa fa-user"></i> -->
<%-- 						${sessionScope.user.nick} <b class="caret"></b></a> --%>
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li class="divider"></li> -->
<!-- 						<li><a href="/BackOffice/dologout"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li> -->
<!-- 					</ul></li> -->
<!-- 			</ul> -->

<!-- 			<!-- MENU VERTICAL --> -->
<!-- 			<div class="collapse navbar-collapse navbar-ex1-collapse"> -->
<!-- 				<ul class="nav navbar-nav side-nav"> -->
<!-- 					<li><a href="" ><i -->
<!-- 							class="fa fa-file"></i> Lista Catastrofe</a></li> -->
					
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</nav> -->
<!-- 	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->

<!--             <div class="navbar-header"> -->
<!--                 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> -->
<!--                     <span class="sr-only">Menu</span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                 </button> -->
<%--                 <a class="navbar-brand" href=""> ${sessionScope.user.nombre}</a> --%>
<!--             </div> -->

<!--        	<ul class="nav navbar-right top-nav"> -->
<!-- 				<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<%-- 					data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.user.nick} --%>
<!-- 						<b class="caret"></b></a> -->
<!-- 					<ul class="dropdown-menu">					 -->
<!-- 						<li class="divider"></li> -->
<!-- 							<li><a href="/BackOffice/dologout"><i class="fa fa-fw fa-power-off"></i> -->
<!-- 								Cerrar Sesion</a></li> -->
<!-- 					</ul></li> -->
<!-- 			</ul> -->
           
<!--         </nav> -->
<!--         <div id="contenedor_web_contenido"> -->
			    
<!-- 			<div>VOS SOS RESCATISTA</div> -->

<!--         </div>                -->

<!--    </div>   -->
        <div class="contenedor-header">
        
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="btn-menu">Menu</span>
                </button>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex2-collapse">
                    <span class="btn-menu">User</span>
                
                </button>
                <a class="navbar-brand text-center" href="index.html"><i class="fa fa-life-ring fa-spin"></i> Rescatista</a>
            </div>
           
            <div class="collapse navbar-collapse navbar-ex2-collapse">
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle item_menu2" data-toggle="dropdown"><i class="fa fa-user"></i><span class="hidden-xs"> ${sessionScope.user.nick} </span><b class="caret"></b></a>
                    <ul class="dropdown-menu">
<!--                         <li > -->
<!--                             <a href="#"><i class="fa fa-fw fa-user"></i></a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                             <a href="#"><i class="fa fa-fw fa-gear"></i> Configuración</a> -->
<!--                         </li> -->
                        <li class="divider"></li>
                        <li>
                            <a href="/BackOffice/dologout"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesion</a>
                        </li>
                    </ul>
                </li>
            </ul>
            </div>

        
        <!-- MENU VERTICAL -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">

                    <li class="item_menu">
                        <a href="#" data-toggle="tooltip" data-placement="right" title="Lista catastrofes"><i class="fa fa-fw fa-bar-chart-o"></i><span class="hidden-sm hidden-md hidden-lg"> Lista catastrofes</span></a>
                    </li>
                    <li class="item_menu active">
                        <a href="#"  data-toggle="tooltip" data-placement="right" title="Lista usuarios"><i class="fa fa-fw fa-user"></i><span class="hidden-sm hidden-md hidden-lg"> Lista usuarios</span></a>
                    </li >

                    <li class="item_menu">
                        <a href="#"  data-toggle="tooltip" data-placement="right" title="Alta catastrofe"><i class="fa fa-fw fa-plus"></i><span class="hidden-sm hidden-md hidden-lg"> Alta catastrofe</span></a>
                    </li>
                    <li class="item_menu">
                        <a href="#"  data-toggle="tooltip" data-placement="right" title="Alta usuario"><i class="fa fa-fw fa-search-plus"></i><span class="hidden-sm hidden-md hidden-lg"> Alta usuario</span></a>
                    </li>
                    <li class="item_menu">
                        <a href="#"  data-toggle="tooltip" data-placement="right" title="Reportes"><i class="fa fa-fw fa-pie-chart"></i><span class="hidden-sm hidden-md hidden-lg"> Reportes</span></a>
                    </li>
                    <li class="item_menu">
                        <a href="#"  data-toggle="tooltip" data-placement="right" title="Creditos"><i class="fa fa-fw fa-thumbs-up"></i><span class="hidden-sm hidden-md hidden-lg"> Creditos</span></a>
                    </li>

                </ul>

            </div> 
            <!-- /.navbar-collapse -->
        </nav>
            
            <div class="row ">
                <i><h1> Titulo<small> /create</small></h1></i>
                <div class="panel panel-danger fondo_alt2">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">Panel content</div>
                </div>

            </div>
             
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </div>

</body>
</html>