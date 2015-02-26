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
			var texto = notirss[j].link;
			if(texto.search('youtube')>0){
				var link=notirss[j].link;
				var link_c = link.replace("watch?v=", "embed/");
				var titulo='<li class="media"><a class="pull-left">'+'<iframe width="100" height="100" class="embed-responsive-item" src="'+link_c+'" allowfullscreen></iframe></a>'
		
			}
			else{
				var img='/Site/resources/images/rss2.png';
				var titulo='<li class="media"><a class="pull-left img-rss">'+'<img class="media-object" src="'+img+'" alt="Expandable Input" /></a>'
			}	

			rssoutput+= titulo+'<div class="media-body"><a class="media-heading" href="'+notirss[j].link+'">'+notirss[j].title+'</a><p>'+notirss[j].contentSnippet+'</p></div></li>'
				
		}
		$(".media-list").append(rssoutput);
    }
}

function LoadIframe(title, link){
	$("#myModalLabelNews").html(title);
	link = link.replace("watch?v=", "embed/");
	$("#newsFrame").attr("src", link);
	document.getElementById('newsFrame').contentWindow.location.reload();
}

	