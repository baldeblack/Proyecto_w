google.load("feeds", "1");

function LoadNews(){
	var palabrasClaves = $("#palabrasClaves").val();
	var fuentesDatos = $("#fuentesDatos").val();
	
	if(fuentesDatos != null){
		if(palabrasClaves !=  null)
			palabrasClaves = palabrasClaves.replace(/;/g, " ");
		
		var dirsweb = fuentesDatos.split(";")
		
		$.each(dirsweb, function(index, value ) {
			  var defaultQuery = value + ' '  + palabrasClaves;
			  
			  google.setOnLoadCallback(function() {
				  findFeeds(defaultQuery);  
			  });
		});
	}
}

function findFeeds(query) {
	
    google.feeds.findFeeds(query, feedSearchDone);
    function feedSearchDone(result) {
		var notirss = result.entries;
		var rssoutput="";
		for (var j=0; j < 4; j++){
			 var fun = 'LoadIframe("'+notirss[j].title+'", "'+ notirss[j].link+'");';
				rssoutput+="<tr>"+
					"<td>" + notirss[j].title+"</td>"+
					"<td>" +
						"<a href='' class='btn btn-warning' data-toggle='modal' data-target='#modalNews' onclick='javasript:"+fun+"'>Ir!</a>"+
					"</td>" +
				"</tr>"
						
		}
		$("#noticias").append(rssoutput);
    }
}

function LoadIframe(title, link){
	$("#myModalLabelNews").html(title);
	link = link.replace("watch?v=", "embed/");
	$("#newsFrame").attr("src", link);
	document.getElementById('newsFrame').contentWindow.location.reload();
}

	