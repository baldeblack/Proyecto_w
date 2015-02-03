<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ONG</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/planes.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
<style>
		 .container{
		display:table;
		width:90%;
		border-collapse: collapse;
		}
	 .heading{
		 font-weight: bold;
		 display:table-row;
		 background-color:#C91622;
		 text-align: center;
		 line-height: 25px;
		 font-size: 14px;
		 font-family:georgia;
		 color:#fff;
		 
	 }
	 .table-row{  
		 display:table-row;
		 text-align: center;
	 }
	 .col{ 
	 display:table-cell;
	 border: 1px solid #CCC;
	 }
		
	</style>
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
					</ul>
			</div>
        </nav>
        <div id="contenedor_web_contenido">			    

 <p>Crear Plan</p>
		
			<div id="container" class="container">	
				<div class="heading">
				<div class="col">Nombre</div>
				 <div class="col">Descripcion</div>
				<div class="col">Tipo de Plan</div>
				<div class="col">Tipo de Catastrofe</div>
				 </div>	
					
				 <div class="table-row">				
						<div class="col">
						<input type="text" id="pasoNom" value=""/>
				</div>
					<div class="col">
						<textarea id="pasoDesc" rows="3" cols="20">
							
						</textarea>
				</div>
						<div class="col">										
					<select id="selectTipoPl" name="TiposPl">
							<option value="0" selected="selected">Gestion</option>
							<option value="1">Emergencia</option>
					</select>	
					</div>
						<div class="col">	
					<select id="selectTipoCt" name="TiposCT">
							<option value="g" selected="selected">General</option>
							<option value="0">Terremoto</option>
							<option value="1">Huracan</option>
					</select>		
					
					</div>
				</div>
			
			</div>
				
		<div id="pasosContainer">
			<div id="container" class="container">	
				<div class="heading">
				<div class="col">Nombre</div>
				 <div class="col">Descripcion</div>
				
				 </div>	
					
				 <div class="table-row">				
						<div class="col">
						<input type="text" name="pasos[0]" value=""/>
				</div>
					<div class="col">
						<textarea rows="3" cols="20">
							
						</textarea>
				</div>
						<div class="col">				
						<input type="image" src="C:\ic_cancel_24px.svg" type="image" onclick="deletePaso(this)"/>
					</div>
				</div>
			
			</div>	
		</div>
         
        </div>               
      
   </div>  
</body>
</html>
