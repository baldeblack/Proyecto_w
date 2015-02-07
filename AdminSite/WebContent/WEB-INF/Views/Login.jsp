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
<link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-6 col-md-offset-3  div_login">
				<h1 class=".hidden-xs .hidden-sm text-center">BACKEND</h1><br>
				<fieldset>
					<legend class="text-center">Iniciar Sesion</legend>
						<div  class="form-horizontal" >
							<div class="control-group">
								<label class="control-label">Correo</label>
								<div class="controls">
									<input class="form-control" type="text" name="mail" id="mail" title="mail" required>
								</div>
							</div><br>
							<div class="control-group">
								<label class="control-label">Contraseña</label>
								<div class="controls">
									<input type="password" class="form-control" name="password" id="password"
										title="password" required>
								</div>
							</div>
							<br>
							<div style="display:none" id="lgnerror" class="alert alert-danger" role="alert">"Error Usuario y/o contraseña no coinciden."</div>
									
							<div class="control-group form-actions text-center">
								<button type="button" id="loginbtn" value="Login" class="btn btn-lg btn-success ">Entrar</button>
							</div><br>
					</div>
				</fieldset>
			</div>
		</div>

   </div>  

</body>
</html>
