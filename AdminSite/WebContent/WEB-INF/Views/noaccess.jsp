<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NO ACCESS</title>

<style type="text/css">

.icono_error{
	font-size: 250px;
	color: #B00004;
	/*text-shadow: 2px 0 0 #fff, -2px 0 0 #fff, 0 2px 0 #fff, 0 -2px 0 #fff, 1px 1px #fff, -1px -1px 0 #fff, 1px -1px 0 #fff, -1px 1px 0 #fff;*/
}

.icono_error2{
	font-size: 70px;
	color: #B00004;
	
}

</style>

</head>
<body>
	<!-- <div id="lgnerror" class="alert alert-danger" role="alert">"No tiene acceso."</div>-->
	
	<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<i class="fa fa-times-circle-o icono_error"></i>
					<h1 class="text-center icono_error2">NO ACCESS!!</h1>
					<h2 class="color1" style="color:white;">SIN ACCESO!!</h2>
					
					<p class="text-center" style="color:white;">El usuario no tiene acceso a la pagina ingresada, disculpe las molestias!.</p>	

					<i class="fa fa-hand-o-left icono_error2"></i>

				</div>
			</div>
		</div>
</body>
</html>