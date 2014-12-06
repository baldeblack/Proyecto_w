<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Proyecto</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" /> 
</head>
<body>
	<h3>Exito vos si que andas usuario dado de alta ${admin.mail}</h3>

	<form:errors path="admin.*" /> 
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>Bootstrap Form With Spring Mvc Example</legend>
				
				</fieldset>
			</div>
		</div>
	</div>		
</body>
</html>

