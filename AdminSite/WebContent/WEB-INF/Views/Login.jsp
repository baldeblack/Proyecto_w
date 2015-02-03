<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/login.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
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
	 	</nav>
        <div id="contenedor_web_contenido">
            <div class="container-fluid">
                				<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<legend>Iniciar Sesion</legend>
				<div  class="form-horizontal" >
						<div class="control-group">
							<label class="control-label">Mail usuario</label>
							<div class="controls">
								<input type="text" name="mail" id="mail" title="mail" required>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Contraseña</label>
							<div class="controls">
								<input type="password" name="password" id="password"
									title="password" required>
							</div>
						</div>
						
						<div style="display:none" id="lgnerror" class="alert alert-danger" role="alert">"Error Usuario y/o contraseña no coinciden."</div>
						
						<div class="form-actions">
							<button type="button" id="loginbtn" value="Login" class="btn btn-success">Entrar</button>
						</div>
			</div>
				</fieldset>
			</div>
		</div>
	</div>
            </div>               
        </div>  
   </div>  
</body>
</html>
