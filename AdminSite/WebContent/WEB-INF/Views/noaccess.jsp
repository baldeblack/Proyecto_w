<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<!-- <link href="<c:url value="/resources/css/proyecto.css"/>" rel="stylesheet" type="text/css" />-->
<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NO ACCESS</title>

<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300|Oswald:300,400:latin,latin-ext);

body{

    font-family: 'Source Sans Pro', sans-serif;
    font-weight: 300;
    font-size: 18px;
    
	background:
	linear-gradient(27deg, #151515 5px, transparent 5px) 0 5px,
	linear-gradient(207deg, #151515 5px, transparent 5px) 10px 0px,
	linear-gradient(27deg, #222 5px, transparent 5px) 0px 10px,
	linear-gradient(207deg, #222 5px, transparent 5px) 10px 5px,
	linear-gradient(90deg, #1b1b1b 10px, transparent 10px),
	linear-gradient(#1d1d1d 25%, #1a1a1a 25%, #1a1a1a 50%, transparent 50%, transparent 75%, #242424 75%, #242424);
	background-color: #131313;
	background-size: 20px 20px;
}

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