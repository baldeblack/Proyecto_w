var activeStep = "";
var stepNumber = 0;
var map;
$(document).ready(function() {
	
	$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})	
		
	//	var navListItems = $('ul.setup-panel li a'),
		//allWells = $('.setup-content');

		//allWells.hide();

	$('ul.setup-panel li a').click(function(e)
		{
		e.preventDefault();
		var $target = $($(this).attr('href')),
		    $item = $(this).closest('li');

		if (!$item.hasClass('disabled')) {
		    navListItems.closest('li').removeClass('active');
		    $item.addClass('active');
		    allWells.hide();
		    $target.show();
		}
		});
	var ct = $('ul#dataMenu li:first').attr('id');
	getCatastrofe(ct);


});


	
	function mostrar(elem, id){	
	  	    if(elem.name == "plan"){
	  	 	 $.ajax({
	    			url : '/BackOffice/rescatista/planes',
	    			type : 'POST',
	    			data : JSON.stringify({"id" : id}),
	    			beforeSend : function(xhr) {
	    				xhr.setRequestHeader("Accept", "application/json");
	    				xhr.setRequestHeader("Content-Type", "application/json");
	    			},
	    			success : function(data) {
	    				$('#mainContent').html("");
	    				$('#mainContent').html(data);
	    				 stepsWizard();
	    			},
	    			error : function(data, status, er) {
	    				message("No se pudo realizar la operacion.","error");
	    			}
	    		});


		  	    } else if(elem.name == 'catastrofe'){
		  	    	getCatastrofe(25);
 
	  	}else if(elem.name == 'desaparecidos'){
		 	 $.ajax({
	    			url : '/BackOffice/rescatista/desaparecidos',
	    			type : 'POST',
	    			data : JSON.stringify({"id" : id}),
	    			beforeSend : function(xhr) {
	    				xhr.setRequestHeader("Accept", "application/json");
	    				xhr.setRequestHeader("Content-Type", "application/json");
	    			},
	    			success : function(data) {
	    				$('#mainContent').html("");
	    				$('#mainContent').html(data);
	    				 stepsWizard();
	    			},
	    			error : function(data, status, er) {
	    				message("No se pudo realizar la operacion.","error");
	    			}
	    		});
	  	}
  }

function getCatastrofe(id){
	 $.ajax({
			url : '/BackOffice/rescatista/ctinfo',
			type : 'POST',
			data : JSON.stringify({"id" : id}),
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				$('#mainContent').html("");
				$('#mainContent').html(data);  
				showMap();
			},
			error : function(data, status, er) {
				message("No se pudo realizar la operacion.","error");
			}
		});
}

function stepsWizard(){

	allWells = $('.setup-content');

	allWells.hide();

	  $("ul.setup-panel li").each(function(n) {
		  id = $(this).attr('id');
		  estado = $('#' + id + " input").val();
		  
		  if(estado == 1){			 
			  index = $(this).index() + 1;		
			  inpt = $('ul.setup-panel li:eq('+index+') input').val();
			  if(inpt == 0){
				activeStep =  $('ul.setup-panel li:eq('+index+')').attr('id');	
				$('ul.setup-panel li:eq('+index+')').removeClass('disabled');
				$('ul.setup-panel li:eq('+index+')').addClass('active');
				$('#step-' +activeStep).show();
			  }
	        }
		
		  })
		  
	if(activeStep != ""){	  
   $("ul.setup-panel li").each(function(n) {
		  id = $(this).attr('id');	
		  if(id < activeStep){
			  index = $(this).index();			 
			  $('ul.setup-panel li:eq('+index+')').removeClass('disabled');
			  $('#btn-' + id).remove();
	        }
		
		  })
	}else
	{	
		activeStep = $('ul.setup-panel li:eq(0)').attr('id');
	$('ul.setup-panel li:eq(0)').removeClass('disabled');
	$('ul.setup-panel li:eq(0)').addClass('active');
	$('#step-' +activeStep).show();
	}

	  activeStep = "";
	  
	  var lastid = $("ul.setup-panel li:last-child").attr('id');
	  $('#btn-'+lastid).html("");
	  $('#btn-'+lastid).html("Finalizar Plan");
}


function nav(elem, event){
	event.preventDefault();        
       var target = $(elem).closest('li');
       allWells = $('.setup-content');

       if (!$(target).hasClass('disabled')) {
    	   
    	   $("ul.setup-panel li").each(function(n) {
    		   if ($(this).hasClass('active')) {
    			   $(this).removeClass('active');
    		   }
    	   })
    	   
    	   $(target).addClass('active');
    	  // $(target).removeClass('active');
           allWells.hide();
           id = $(target).attr('id');
           $('#step-' + id).show();       
       }

}

function updatestep(elem , idp){	
	var str = elem.id.split("-");
	var steptoupdate = str[1];
	
	var idplan = $('#idplan').val();
	
	 $.ajax({
			url : '/BackOffice/rescatista/updatepaso',
			type : 'POST',
			data : JSON.stringify({"idplan" : idplan, "idpaso":steptoupdate}),
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				 $('#'+ steptoupdate).removeClass('active');
				$('#hidden-'+steptoupdate).val('1');
				elem.remove();
				stepsWizard();
				message("La operacion se realizo con exito.","success")
			},
			error : function(data, status, er) {
				message("No se pudo realizar la operacion.","error");
			}
		});

}


function showMap(){   
	
    var mapOptions = {
    	    zoom: 5,
    	    center: new google.maps.LatLng(24.886436490787712, -70.2685546875),
    	    mapTypeId: google.maps.MapTypeId.ROADMAP
    	  };
    
    map = new google.maps.Map(document.getElementById('map-canvas'),
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
	      map.setZoom(3);
	      
	      if (navigator.geolocation) {
	    	  navigator.geolocation.getCurrentPosition(success);
	    	} else {
	    	  error('Geo Location is not supported');
	    	}
	  }
}

function success(position) {
	  var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
	  	
	  var marker = new google.maps.Marker({
	      position: coords,
	      map: map,
	      title:"Usted esta aqui!"
	  });
}

	
function message(msj, tipo) {

	//Setemos la notificacion

	//Removemos clases
	$('.notification').removeClass('notification-error');
	$('.notification').removeClass('notification-succes');
	//Limpiados el msj
	$('.notification').empty();

	//Ingresamos msj
	$('.notification').append(msj);

	// Notification
	$('.notification').removeClass(
			'bounceOutRight notification-show animated bounceInRight');

	// show notification
	$('.notification').addClass(
			'notification-show notification-' + tipo
					+ ' animated bounceInRight');

	$('.notification')
			.one(
					'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
					function() {
						setTimeout(function() {
							$('.notification').addClass(
									'animated bounceOutRight');
						}, 800);

					});

}