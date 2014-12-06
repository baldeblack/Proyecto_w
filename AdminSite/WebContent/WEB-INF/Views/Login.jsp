<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Proyecto</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" /> 
</head>
<body>
	<h1>${headerMessage}</h1>

	<form:errors path="admin.*" />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<legend>Bootstrap Form With Spring Mvc Example</legend>
					<form class="form-horizontal" action="/BackOffice/Registro.html"
						method="post">
						<div class="control-group">
							<label class="control-label">First Name</label>
							<div class="controls">
								<input type="text" name="mail" id="mail" title="mail">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Last Name</label>
							<div class="controls">
								<input type="text" name="password" id="password"
									title="password">
							</div>
						</div>
						<div class="form-actions">
							<button type="submit" value="Login" class="btn btn-success">Submit</button>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>
