$( document ).ready(function() {
	init();
});

function init(){
var map = new OpenLayers.Map("map_container");

var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS", 
        "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'}); 

  
	map.addLayers(wmsLayer);
    map.addLayer(new OpenLayers.Layer.OSM());
  
    map.addControl(new OpenLayers.Control.LayerSwitcher());
    map.addControl(new OpenLayers.Control.MousePosition());
    

var markers = new OpenLayers.Layer.Markers( "Markers" );
map.addLayer(markers);
map.addControl(new OpenLayers.Control.LayerSwitcher());
//map.zoomToMaxExtent();

map.setCenter(new OpenLayers.LonLat(-6204506.617537793,-3865213.305498507), 5);

map.events.register("click", map, queryDatabase);

markers.clearMarkers();

var lat = document.getElementById("lat").value;
var long = document.getElementById("long").value;

var size = new OpenLayers.Size(21,25);
var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
var icon = new OpenLayers.Icon('resources/marker.png', size, offset);
markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(long, lat),icon));
//markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(-56.229473170625, -34.818454350979),icon.clone()));

function queryDatabase(e) {

// Read the map coordinates from the click event
var lonlat = map.getLonLatFromViewPortPx(e.xy);

var lat = document.getElementById("lat");
lat.value = lonlat.lat;
var long = document.getElementById("long");
long.value = lonlat.lon;

markers.clearMarkers();

var size = new OpenLayers.Size(21,25);
var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
var icon = new OpenLayers.Icon('resources/marker.png', size, offset);
document.getElementById("latLongRecidencia").value = lonlat.lon + "," + lonlat.lat;
markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(lonlat.lon,lonlat.lat),icon));}
}

function rescatistaDiv(select){
	var value = select.value
		 if(value === "1"){
		 	$('#rescatistaDiv').show();
		 }else{
		 	$('#rescatistaDiv').hide();
		 }
	
}