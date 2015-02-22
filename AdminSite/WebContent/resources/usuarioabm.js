$( document ).ready(function() {
	
	$('#usuABMForm').validator().on('submit', function (e) {

		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  e.preventDefault();
			  if($('#idUsu').val() == ""){
				  $('#idUsu').val('0');
			  }
		    	 $.ajax({
		    			url : '/BackOffice/usuarios/update',
		    			type : 'POST',
		    			data : JSON.stringify({
		    					"idC": 0,
		    					"idUsu": parseInt($('#idUsu').val()),
		    					"apellido":$('#apellido').val(),
		    					 "borrado":0,
		    					 "celular":parseInt($('#celular').val()),
		    					"creacion":$('#').val(),
		    					 "direccion":$('#direccion').val(),
		    					 "email":$('#email').val(),
		    					"nacimiento":$('#nacimiento').val(),
		    					"nick":$('#nick').val(),
		    					"nombre":$('#nombre').val(),
		    					"password":$('#password').val(),
		    					"sexo":$('#sexo').val(),
		    					"tipoUsuario": parseInt($('#tipoUsuario').val()),
		    					"tiporescatisa":parseInt($('#tiposrescatistas').val()),
		    					"residencia":$('#direccion').val(),
		    					"accion":$('#actionbtn').val()
		    			}),
		    			beforeSend : function(xhr) {
		    				xhr.setRequestHeader("Accept", "application/json");
		    				xhr.setRequestHeader("Content-Type", "application/json");
		    			},
		    			success : function(data) {
		    				$("#idUsu").val(data.id);
		    				$('#actionbtn').val('Modificar');
		    				$('#actionbtn').html("");
		    				$('#actionbtn').html("Modificar");
		    				$('#passdiv').remove();		    	
		    				$('#tipoUsuario').attr('disabled', 'disabled');
		    				message("La operacion se realizo con exito.", "success")	    				
		    			},
		    			error : function(data, status, er) {
		    				message("No se pudo realizar la operacion.", "error");
		    			}
		    		});;
		  }
		})
	
	
	
	var dataFromRes = $('#jsondata').val().toString().replace(/'/g, "\"");
		var datares = JSON.parse(dataFromRes);	

		for (i = 0; i < datares.length; i++) {
				$('#tiposrescatistas').append('<option value="'+datares[i].value+'">'+datares[i].nombre+'</option>');			
		}
	
	if($('#idUsu').val() != ""){
		var flag = false;
		var dataFromUsu = $('#jsonusu').val().toString().replace(/'/g, "\"");
		var datarusu = JSON.parse(dataFromUsu);	
		
		if(typeof datarusu.idRescatista != 'undefined'){
			$('#tiposrescatistas option[value="'+datarusu.idTipoRescatista+'"]').attr("selected", "selected");
			flag = true;
		}
		
		
		if(flag){
		for (key in datarusu) {
		        if (key == 'usuario') {
		        	var usujson = datarusu[key];
		        	for (key in usujson){	        
		        		load(key, usujson);
		        	}
		     }
		}
		}else{
				for (key in datarusu){	        
		        		load(key, datarusu);
		        	}				
		}
		
	}
	
	if($('#actionbtn').val() == "Modificar"){
		$('#passdiv').remove();
		$('#tipoUsuario').attr('disabled', 'disabled');
	}
	
	if($('#tipoUsuario').val() == 1){
		$('#rescatistaDiv').show();
	
	}
});


function rescatistaDiv(select){
var value = select.value
	 if(value === "1"){
	 	$('#rescatistaDiv').fadeIn("400");
	 }else{
	 	$('#rescatistaDiv').fadeOut("400");
	 }

}

function load(keyn, usujson){
switch (keyn) {
case "apellido":
	$('#apellido').val(usujson[keyn]);
    break;
case "celular":
	$('#celular').val(usujson[keyn]);
    break;	  
case "direccion":
	$('#direccion').val(usujson[keyn]);	    			      
    break;
case "email":
	$('#email').val(usujson[keyn]);	    			      
    break;
case "nombre":
	$('#nombre').val(usujson[keyn]);	    			      
    break;
case "nick":
	$('#nick').val(usujson[keyn]);	    			      
    break;
case "sexo":
	$('#sexo option[value="'+usujson[keyn]+'"]').attr("selected", "selected");  			      
    break;
case "tipoUsuario":
	$('#tipoUsuario option[value="'+usujson[keyn]+'"]').attr("selected", "selected");  			      
    break;
case "nacimiento":
	 	var d = new Date(usujson[keyn]);
        var m = d.getMonth() + 1;
        var day = d.getDate();
        var y = d.getFullYear();
        
        var mstr = m.toString();
        if(mstr.length == 1){
        	mstr = "0" + mstr
        }
        
        var daystr = day.toString();
        if(daystr.length == 1){
        	daystr = "0" + daystr
        }
        
        $('#nacimiento').val(y+'-'+mstr+'-'+daystr);  			      
    break;
}
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