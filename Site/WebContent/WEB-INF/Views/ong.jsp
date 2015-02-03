<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty Ongs}">
<!-- ONG´s -->
<div  class="ong_titulo">
	<div id="ong"></div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-lg-12 columna-desp">
				<h1>ONG'S</h1>
			</div>
		</div>
	</div>			
</div>

<div class="ongs">
	<div class="container ongs">
		<div class="row">
			<div class="table-responsive">
				<table class="table">
					 <thead>
	                    <tr class="filters">
	                        <th>Nombre</th>
	                        <th>Direccion</th>
	                        <th>Telefono</th>
	                        <th>E-mail</th>
	                        <th>Web</th>
	                        <th>Origen</th>
	                        <th>Donacion</th>
	                    </tr>
	                </thead>
	                <tbody>
	                <c:forEach var="o" items="${Ongs}">
	                	<tr>
	                        <td>${o.nombre}</td>
	                        <td>${o.direccion}</td>
	                        <td>${o.telefono}</td>
	                        <td>${o.email}</td>
	                        <td>${o.web}</td>
	                        <td>${o.origen}</td>
	                        <c:if test="${empty sessionScope.active_user}">
	                        	<td><a href="" class="btn btn-warning" onclick="javascript:alert('Debe iniciar sesi&oacute;n para realizar una daonai&oacute;n.')">Donar</a></td>
	                        </c:if>
							<c:if test="${not empty sessionScope.active_user}">
	                        	<td><a href="" class="btn btn-warning" data-toggle="modal" data-target="#modalDonar" onclick="javascript:$('#idong').val('${o.idONGs}');">Donar</a></td>
	                     	</c:if>
	                    </tr>
	                </c:forEach>
	                </tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</c:if>