<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Spring 3.0 MVC Series: Hello World - ViralPatel.net</title>
</head>
<body>
<%
    String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
%>

	<c:if test="${not empty CatastrofeListModel.ctList}">
    <table>
        <c:forEach var="o" items="${CatastrofeListModel.ctList}">
            <tr>
                <td>${o.nombre}</td>      
                <td>${o.dominio}</td>    
                <td><a href="/BackOffice/catastrofes/edit/${o.idCatastrofe}">Editar</a></td>               
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>