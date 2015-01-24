var map;
var markers = [];

function initialize() {

	  var mapOptions = {
			    zoom: 4,
			    center: new google.maps.LatLng(-25.363882,131.044922)
			  };
	  
  
	  map = new google.maps.Map(document.getElementById('map_container'), mapOptions);
  
  
  
  var ResMod = document.getElementById("latLongRecidencia").value 
  if(ResMod != ""){
  	var pointsArr = ResMod.split(",");
  	
  	var lat = pointsArr[0];
  	var long = pointsArr[1];
  	var myLatlng = new google.maps.LatLng(long,lat);
  	 var marker = new google.maps.Marker({
  	      position: myLatlng,
  	      map: map,
  	  });
    markers.push(marker);
  	map.setCenter(myLatlng);
  	map.setZoom(4);
  }else{
	  	
		function placeMarker(location) {
		    var marker = new google.maps.Marker({
		        position: location, 
		        map: map
		    });
		    markers.push(marker);
		    
		    var lat = document.getElementById("lat");
		    lat.value = location.D;
		    var long = document.getElementById("long");
		    long.value = location.k;

		    document.getElementById("latLongRecidencia").value = location.D + "," + location.k;
		}
  }
  
  google.maps.event.addListener(map, 'click', function(event) {	
	   DeleteMarkers();
	   placeMarker(event.latLng);
	});

  function DeleteMarkers() {
      //Loop through all the markers and remove
      for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(null);
      }
      markers = [];
  };
}


google.maps.event.addDomListener(window, 'load', initialize);

$( document ).ready(function() {
	
	if($('#actionbtn').val() == "Modificar"){
		$('#password').hide();
		$("#password").removeAttr("required");
	}
	
	if($('#tipoU').val() == 1){
		$('#rescatistaDiv').show();
		
	}
});


function rescatistaDiv(select){
var value = select.value
	 if(value === "1"){
	 	$('#rescatistaDiv').show();
	 	 google.maps.event.trigger(map, "resize");
	 }else{
	 	$('#rescatistaDiv').hide();
	 }

}