// This example creates a simple polygon representing the Bermuda Triangle.
$(document).ready(function() {
    
	var a = '${sessionScope.Catastrofe.zonaAfectada}';
    var mapOptions = {
    	    zoom: 5,
    	    center: new google.maps.LatLng(24.886436490787712, -70.2685546875),
    	    mapTypeId: google.maps.MapTypeId.TERRAIN
    	  };
    
    var map = new google.maps.Map(document.getElementById('map-canvas'),
    	      mapOptions);
    
    var zonaMod =$("#zonaAfectada").val(); 
    
	  if(zonaMod != ""){
	  	zonaMod = zonaMod.replace('[', '');
	  	zonaMod  = zonaMod.replace(']', '');
	  	zonaMod = zonaMod.replace(/'/g, '');
	  	
	  	var pointsArr = zonaMod.split(",");
	  	var arr = new Array();
	  	
	  	 for (var i = 0; i < pointsArr.length; i++) {
	  		var points = pointsArr[i].split(" ");
	  		           arr.push( new google.maps.LatLng(
	  		                   parseFloat(points[0]),
	  		                   parseFloat(points[1])
	  		           ));
	  		}
	  	 
	  	 // Construct the polygon.
	     zonaPolygon = new google.maps.Polygon({
	     paths: arr,
	     strokeColor: '#FF1493',
	     strokeOpacity: 0.8,
	     strokeWeight: 2,
	     fillColor: '#FF1493',
	     fillOpacity: 0.35
	     
	   });
	     
	      zonaPolygon.setMap(map);	   
	   	  var bounds = new google.maps.LatLngBounds();
	      var i;
	      
	      for (i = 0; i < arr.length; i++) {
	          bounds.extend(arr[i]);
	      }
	      
	      map.fitBounds(bounds);
	      map.setZoom(5);
	  }
 });