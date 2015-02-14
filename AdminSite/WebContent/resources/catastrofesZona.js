
var palabrasCont = 0;
var FilCont = 0;
var map;

var drawingManager;
      var selectedShape;
      var colors = ['#1E90FF', '#FF1493', '#32CD32', '#FF8C00', '#4B0082'];
      var selectedColor;
      var drawedShape;
      var colorButtons = {};  	 
      var zonaPolygon;
    	  
 
    function clearSelection() {
        if (selectedShape) {
          selectedShape.setEditable(false);
          selectedShape = null;
        }
      }

      function setSelection(shape) {
        clearSelection();
        selectedShape = shape;
        shape.setEditable(true);
        selectColor(shape.get('fillColor') || shape.get('strokeColor'));
      }

  function deletedrawedShape() {
        if (drawedShape) {
          drawedShape.setMap(null);
          document.getElementById("zonaAfectada").value = "";	
        }
        // To show:
         drawingManager.setOptions({
           drawingControl: true
         });
      }
  
  function deleteModShape() {
      if (zonaPolygon) {
    	  zonaPolygon.setMap(null);
        document.getElementById("zonaAfectada").value = "";	
      }
      // To show:
       drawingManager.setOptions({
         drawingControl: true
       });
    }

      function selectColor(color) {
        selectedColor = color;
        for (var i = 0; i < colors.length; ++i) {
          var currColor = colors[i];
          colorButtons[currColor].style.border = currColor == color ? '2px solid #789' : '2px solid #fff';
        }

        // Retrieves the current options from the drawing manager and replaces the
        // stroke or fill color as appropriate.
        var polylineOptions = drawingManager.get('polylineOptions');
        polylineOptions.strokeColor = color;
        drawingManager.set('polylineOptions', polylineOptions);

        var rectangleOptions = drawingManager.get('rectangleOptions');
        rectangleOptions.fillColor = color;
        drawingManager.set('rectangleOptions', rectangleOptions);

        var circleOptions = drawingManager.get('circleOptions');
        circleOptions.fillColor = color;
        drawingManager.set('circleOptions', circleOptions);

        var polygonOptions = drawingManager.get('polygonOptions');
        polygonOptions.fillColor = color;
        drawingManager.set('polygonOptions', polygonOptions);
      }

      function setSelectedShapeColor(color) {
        if (selectedShape) {
          if (selectedShape.type == google.maps.drawing.OverlayType.POLYLINE) {
            selectedShape.set('strokeColor', color);
          } else {
            selectedShape.set('fillColor', color);
          }
        }
      }

      function makeColorButton(color) {
        var button = document.createElement('span');
        button.className = 'color-button';
        button.style.backgroundColor = color;
        google.maps.event.addDomListener(button, 'click', function() {
          selectColor(color);
          setSelectedShapeColor(color);
        });

        return button;
      }

       function buildColorPalette() {
         var colorPalette = document.getElementById('color-palette');
         for (var i = 0; i < colors.length; ++i) {
           var currColor = colors[i];
           var colorButton = makeColorButton(currColor);
           colorPalette.appendChild(colorButton);
           colorButtons[currColor] = colorButton;
         }
         selectColor(colors[0]);
       }

      function initialize() {
    	  
    		$('#PalabrasInput').click(function(){
    			if(palabrasCont < 5){
    		          	 $('#PalabrasDiv').append(
    		      	             '<div class="palabraContainer"><input class="form-control" type="text" name="palabrasList[0]" ondblclick="deletePalabras(this)"/>'+
    		      	             '</div>');
    						var ind = 0;
    						$('#PalabrasDiv input').each(function(){    		  
    							$(this).attr('name', "palabrasList[" + ind + "]");    	
    							ind = ind + 1;     		    	
    						});
    						
    						palabrasCont = palabrasCont + 1
    		              }
    			else{
    				alert('El numero de palabras claves no puede ser mayor a 5.');
    			} 
    			 return false;
    			})
    			    	  
         map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: new google.maps.LatLng(-34.7506398050501, -56.1785888671875),
          mapTypeId: google.maps.MapTypeId.ROADMAP,
          disableDefaultUI: true,
          zoomControl: true
        });

        var polyOptions = {
          strokeWeight: 0,
          fillOpacity: 0.45,
          editable: true
        };
        // Creates a drawing manager attached to the map that allows the user to draw
        // markers, lines, and shapes.
        drawingManager = new google.maps.drawing.DrawingManager({
          drawingMode: google.maps.drawing.OverlayType.POLYGON,
          drawingControlOptions: {
            drawingModes: [
              google.maps.drawing.OverlayType.POLYGON
            ]
          },
          markerOptions: {
            draggable: true
          },
          polylineOptions: {
            editable: true
          },
          rectangleOptions: polyOptions,
          circleOptions: polyOptions,
          polygonOptions: polyOptions,
          map: map
        });

        var zonaMod = document.getElementById("zonaAfectada").value 
        if(zonaMod != ""){
        	zonaMod = zonaMod.replace('[', '');
        	zonaMod  = zonaMod.replace(']', '');
        	zonaMod = zonaMod.replace(/"/g, '');
						
						var pointsArr = zonaMod.split(",");
						var arr = new Array();
						
					   for (var i = 0; i < pointsArr.length; i++) {
						var puta = pointsArr[i].split(" ");
			            arr.push( new google.maps.LatLng(
			                    parseFloat(puta[0]),
			                    parseFloat(puta[1])
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
		      map.setZoom(1);
		      
			  drawingManager.setDrawingMode(null);
	            // To hide:
	            drawingManager.setOptions({
	              drawingControl: false
	            });
	            google.maps.event.addListener(zonaPolygon, 'click', function() {
	                setSelection(zonaPolygon);
	              });	            
	   			 
        }
        google.maps.event.addListener(drawingManager, 'overlaycomplete', function(event) {
          if (event.type == google.maps.drawing.OverlayType.CIRCLE) {
            var radius = event.overlay.getRadius();
          }
        });
        google.maps.event.addListener(drawingManager, 'overlaycomplete', function(e) {
            if (e.type != google.maps.drawing.OverlayType.MARKER) {
            // Switch back to non-drawing mode after drawing a shape.
            drawingManager.setDrawingMode(null);
            // To hide:
            drawingManager.setOptions({
              drawingControl: false
            });

            // Add an event listener that selects the newly-drawn shape when the user
            // mouses down on it.
            var newShape = e.overlay;
            newShape.type = e.type;
	    drawedShape = newShape;
            google.maps.event.addListener(newShape, 'click', function() {
              setSelection(newShape);
            });
            setSelection(newShape);
          }
        });

	    google.maps.event.addListener(drawingManager, 'polygoncomplete', function (polygon) {
		var coordinates = (polygon.getPath().getArray());
	

		var jsonResult = new Array();	 
	    		var jsonArr = new Array();
	    		for ( var j = 0; j < coordinates.length; j++) {
	    			jsonArr[j] = coordinates[j].k + " " + coordinates[j].D;
	    		}
	    		
	    	
	    		 document.getElementById("zonaAfectada").value = JSON.stringify(jsonArr);	    		
		
	      });

        // Clear the current selection when the drawing mode is changed, or when the
        // map is clicked.	
        google.maps.event.addListener(drawingManager, 'drawingmode_changed', clearSelection);
        google.maps.event.addListener(map, 'click', clearSelection);
        google.maps.event.addDomListener(document.getElementById('delete-button'), 'click', deleteModShape);
        google.maps.event.addDomListener(document.getElementById('delete-button'), 'click', deletedrawedShape);
   
        
      }
      
      
      
      google.maps.event.addDomListener(window, 'load', initialize);
      
       
      function deletePalabras(elem){
    		$(elem).closest('.palabraContainer').remove();
    		var ind = 0;
    		$('#PalabrasDiv input').each(function(){    		  
    			    $(this).attr('name', "palabrasList[" + ind + "]");    	
    			    ind = ind + 1;     		    	
    			 });
    			 
    		palabrasCont = palabrasCont - 1
    	}
      
      function deleteFile(elem){
    	  $(elem).closest('.fileContainer').remove();
    	  var ind = 0;
    	  	$('#uploadTable input').each(function(){    
    	  			if($(this).attr('type') != "image"){	
    	  				$(this).attr('name', "multiUploadedFileList[" + ind + "]");    	
    	  		    ind = ind + 1;     		 
    	  			}			
    	  		 });
    	  		 
    	  	FilCont = FilCont - 1
    	  	return false;
    	  }
      
      function Traspass(elem, idT){

    		if(idT == "fuenteDedatos"){
    			$(elem).closest('.fuenteDedatosContainer').remove().clone().appendTo('#fuenteDedatosMod');
    		}else if(idT == "fuenteDedatosMod"){
    			$(elem).closest('.fuenteDedatosContainer').remove().clone().appendTo('#fuenteDedatos');
    		}
    		updateName("fuenteDedatos");
    		updateName("fuenteDedatosMod");
    	}

    	function updateName(id){
    		var ind = 0;
    		if(id == "fuenteDedatos"){	 
    			$('#fuenteDedatos input').each(function(){    		  
    			    $(this).attr('name', "fuenteDedatos[" + ind + "]");    	
    			    ind = ind + 1;     		    	
    			 });
    		}else if(id == "fuenteDedatosMod"){
    			ind = 0;	
    			$('#fuenteDedatosMod input').each(function(){    		  
    			    $(this).attr('name', "fuenteDedatosMod[" + ind + "]");    	
    			    ind = ind + 1;     		    	
    			});
    		}	 
    	}

    	function borrar(img){
    		 var div = $(img).parent().closest('div');
    		 $(div).parent().closest('div').remove();
    		 var ind = 0;
    		  $('#fd input').each(function(){    		  
    		  	$(this).attr('name', "imagenesNuevas[" + ind + "]");    	
    		  	ind = ind + 1;     		    	
    		  });
    	}
     
		function addFilClick(){
			if(FilCont < 8){
		          	 $('#uploadTable').append(
		      	             '<div class="fileContainer" style="border: 1px solid black;"><input name="multiUploadedFileList[0]" type="file" style="margin-bottom: 16px;"/>'+
		      	             '<input type="image" src="http://localhost/img/ic_cancel_24px.svg" "name="image" style="margin-left: 30px; width:30px; height:30px" onclick="javascript:return deleteFile(this)" /></div>');
						var ind = 0;
						$('#uploadTable input').each(function(){    
							if($(this).attr('type') != "image"){
							$(this).attr('name', "multiUploadedFileList[" + ind + "]");    	
							ind = ind + 1;     	
							}					
						});
						
						FilCont = FilCont + 1
		              }
			else{
				alert('El numero de palabras claves no puede ser mayor a 9.');
			} 
			 return false;
			}
		
		function rezice(){
			google.maps.event.trigger(map, "resize");
		}
		
		function message(msj, tipo){

		    //Setemos la notificacion

		    //Removemos clases
		    $('.notification').removeClass('notification-error');
		    $('.notification').removeClass('notification-succes');
		    //Limpiados el msj
		    $('.notification').empty();
		    

		    //Ingresamos msj
		    $('.notification').append( msj );

		     // Notification
		    $('.notification').removeClass('bounceOutRight notification-show animated bounceInRight');
		        
		    // show notification
		    $('.notification').addClass('notification-show notification-'+tipo+' animated bounceInRight');


		    $('.notification').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
		        setTimeout(function(){
		            $('.notification').addClass('animated bounceOutRight');           
		        }, 800);

		    });
		    
		}
		
