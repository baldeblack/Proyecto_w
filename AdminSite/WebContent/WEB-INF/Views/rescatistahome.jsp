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
	<script type="text/javascript" src="<c:url value="/resources/planesresc.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/message.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.searchable.js" />"></script>
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/rescatista.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" />

	<title>Rescatista Home</title>
	
</head>
<body>
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
   				<c:if test="${not empty model.ct}">
                    <li class="item_menu active">
                        <a href="#" name="catastrofe" onclick="mostrar(this,${model.ct.idCatastrofe})" data-toggle="tooltip" data-placement="right" title="${model.ct.nombre}"><i class="fa fa-fw fa-bar-chart-o"></i><span class="hidden-sm hidden-md hidden-lg">${model.ct.nombre}</span></a>
                    </li>
                </c:if>
                    
                    <c:if test="${not empty model.lstPlanes}">
                    <c:forEach var="s" varStatus="i" items="${model.lstPlanes}">
																				
										 <li class="item_menu">
                        <a href="#"  name="plan" onclick="mostrar(this,${s.idPlan})" data-toggle="tooltip" data-placement="right" title="${s.nombre}"><i class="fa fa-fw fa-user"></i><span class="hidden-sm hidden-md hidden-lg">${s.nombre}</span></a>
                    </li >
												
											</c:forEach>
					</c:if>					
                     <c:if test="${not empty model.lstdesaparecidos}">
                    <li class="item_menu">
                        <a href="#" name="desaparecidos" onclick="mostrar(this, ${model.ct.idCatastrofe})" data-toggle="tooltip" data-placement="right" title="Desaparecidos"><i class="fa fa-fw fa-plus"></i><span class="hidden-sm hidden-md hidden-lg">Desaparecidos</span></a>
                    </li>                    
					</c:if>	
                </ul>

            </div> 
            <!-- /.navbar-collapse -->
        </nav>
            <div class="notification ">
	          
	        </div>
            <div class="row " id="mainContent"><br>
              
            </div>
             
            <br><br><br><br><br><br><br><br><br><br><br><br>
        </div>


</body>
</html>