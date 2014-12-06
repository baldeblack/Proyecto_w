$( document ).ready(function() {
	init();
});

var map, polygonControl, polygonLayer;
function init(){
    map = new OpenLayers.Map('map' , {projection: new OpenLayers.Projection("EPSG:3857")});  
    
    var wmsLayer = new OpenLayers.Layer.WMS( "OpenLayers WMS", 
        "http://vmap0.tiles.osgeo.org/wms/vmap0?", {layers: 'basic'}); 

    polygonLayer = new OpenLayers.Layer.Vector("Polygon Layer");

    map.addLayer(new OpenLayers.Layer.OSM());
    map.addLayers([wmsLayer, polygonLayer]);
    map.addControl(new OpenLayers.Control.LayerSwitcher());
    map.addControl(new OpenLayers.Control.MousePosition());

    polyOptions = {sides: 4};
    polygonControl = new OpenLayers.Control.DrawFeature(polygonLayer,
                                    OpenLayers.Handler.RegularPolygon,
                                    {handlerOptions: polyOptions});
    
     polygonLayer.events.on({
         featuresadded: onFeaturesAdded
    });
     
    map.addControl(polygonControl);    
    map.setCenter(new OpenLayers.LonLat(-6204506.617537793,-3865213.305498507), 5);
    
    document.getElementById('noneToggle').checked = true;
    document.getElementById('irregularToggle').checked = false;
}
function setOptions(options) {
    polygonControl.handler.setOptions(options);
}
function setSize(fraction) {
    var radius = fraction * map.getExtent().getHeight();
    polygonControl.handler.setOptions({radius: radius,
                                       angle: 0});
}

function onFeaturesAdded(event){

  if(polygonLayer.features.length > 1){
	  polygonLayer.destroyFeatures(polygonLayer.features.shift());
     };   
}


 function SavePoligono() {
	    	var zona = document.getElementById("zonaAfectada");
	    	var zonas = polygonControl.layer;
	    	var jsonResult = new Array();
	    	for ( var i = 0; i < zonas.features.length; i++) {
	    		var zonaArray = zonas.features[i].geometry.getVertices();
	    		var jsonArr = new Array();
	    		for ( var j = 0; j < zonaArray.length; j++) {
	    			jsonArr[j] = zonaArray[j].x + " " + zonaArray[j].y;
	    		}
	    		jsonArr[jsonArr.length] = zonaArray[0].x + " " + zonaArray[0].y;
	    		jsonResult[i] = jsonArr;
	    	}
	    	zona.value = JSON.stringify(jsonResult);
	    }
 
 function addFile() {
	 
	 $('#uploadTable').append(
             '<tr><td><input type="file" name="multiUploadedFileList['+ $('#uploadTable tr').length +']" />'+
             '</td></tr>');
 }
 
 
function addPalabras() {
	 
	 $('#palabrasTable').append(
             '<tr><td><input type="text" name="PalabrasList['+ $('#palabrasTable tr').length +']" ondblclick="deletePalabras(this)"/>'+
             '</td></tr>');
 }

function deletePalabras(inpt){
	 var tr = inpt;
	    while(tr && tr.nodeName != "TR") tr = tr.parentNode;
	    if( !tr) throw new Error("Failed to find the row, was the function called correctly?");
	    tr.parentNode.removeChild(tr); // delete it
}
 
