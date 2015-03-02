
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- STILOS -->

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link title="${sessionScope.Catastrofe.css}" href="<c:url value="/resources/css/${sessionScope.Catastrofe.css}"/>" rel="stylesheet"  type="text/css" >

<!-- JAVASCRIPTS -->

<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/mapa.js" />"></script>

<link rel="stylesheet" href="<c:url value="/resources/fancybox/jquery.fancybox-v=2.1.5.css"/>" type="text/css" media="screen">
<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/sweet-alert.css"/>">
<link rel="prefetch" href="<c:url value="/resources/images/zoom.png"/>">
<script src="<c:url value="/resources/js/fb.js" />"></script>

<!-- <link title="${sessionScope.Catastrofe.css}" href="<c:url value="/resources/css/${sessionScope.Catastrofe.css}"/>" rel="stylesheet"  type="text/css" >-->

<style>
	#map-canvas 
	{
   	   width: 850px;
       height: 350px;
       margin: 0px;
       padding: 0px;
	}
</style>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link title="${sessionScope.Catastrofe.css}" href="<c:url value="/resources/css/${sessionScope.Catastrofe.css}"/>" rel="stylesheet"  type="text/css" >

<title>${sessionScope.Catastrofe.nombre}</title>
<!--  <title><tiles:insertAttribute name="title" ignore="true" /></title>-->


</head>
<body data-spy="scroll" data-target=".navbar-proyecto">

<input type="hidden" value="${empty sessionScope.active_user}" id="isLoged"/>
<input type="hidden" value="${sessionScope.Catastrofe.apiFb}" id="fbKey"/>
<input type="hidden" id="palabrasClaves" value="${sessionScope.Catastrofe.palabrasClaves}"/>
<input type="hidden" id="fuentesDatos" value="${sessionScope.Catastrofe.fuentesDatos}"/>

<jsp:include page="header.jsp" />
<jsp:include page="registro.jsp" />
<jsp:include page="formDesaparecidos.jsp" />
<jsp:include page="donar.jsp" />
<jsp:include page="ayuda.jsp" />
<jsp:include page="modalnews.jsp" />
<jsp:include page="Index.jsp" />

<footer>
	<div id="cont"></div>
	<div class="container">
			
	</div>
</footer>
<!-- SCRIPTS -->
		<script type="text/javascript" src="http://www.google.com/jsapi?key=AIzaSyC5GEN5EEuqS2xs80glOzyiW9ZyvIrDUCk"></script>

		<script src="<c:url value="/resources/js/html5shiv.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-migrate.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.easing.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/fancybox/jquery.fancybox.pack-v=2.1.5.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/noticias.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/custom.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/site.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.searchable.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/validacion.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.easy-ticker.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/sweet-alert.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/alert.js" />"></script>
		
		
		<!-- fancybox init -->
		<script>
		$(document).ready(function(e) {	
			
			$(".fancybox").fancybox({
				padding: 10,
				helpers: {
					overlay: {
						locked: false
					}
				}
			});
		
		});
		</script>
</body>
</html>