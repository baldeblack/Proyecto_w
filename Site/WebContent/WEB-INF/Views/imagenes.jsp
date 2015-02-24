<!-- IMGENES -->
<!-- === SLide 3 - Portfolio -->
<%@page import="com.entities.Catastrofe"%>
<%@page import="java.util.List"%>

<div class="slide story" id="slide-3" data-slide="3">
	<div class="row">
	<%  Catastrofe cat = (Catastrofe)request.getSession(true).getAttribute("Catastrofe"); 
		for(int a=0; a<cat.getlistOfImages().size(); a++){
		%>
			<div class="col-12 col-sm-6 col-lg-2"><a data-fancybox-group="portfolio" class="fancybox" href="data:image/jpeg;base64,<%=cat.getlistOfImages().get(a)%>"><img class="thumb" src="data:image/jpeg;base64,<%=cat.getlistOfImages().get(a)%>" alt=""></a></div>
			
	<%	}%>
	</div><!-- /row -->
</div><!-- /slide3 -->
