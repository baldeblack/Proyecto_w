//var id = 0;
$(document).ready(function() {
	
	
	if ($('#idPlan').val() != "") {
		var dataFromPlan = $('#jsondata').val().toString()
				.replace(/'/g, "\"");
		var dataplan = JSON.parse(dataFromPlan);		

		$('#descripcion').val(dataplan.descripcion);
		$('#selt').val(dataplan.idTipoCatastrofe);
		$('#selp').val(dataplan.idTipoPlan);
		$('#nombre').val(dataplan.nombre);
		$('#createP').val('Modificar');
		$('#createP').html('');
		$('#createP').html('Modificar');
		$('#colPasoInical').remove();
    	addPasoIncial();
    	
    	var pasojson = dataplan['pasos'];
    	for (i = 0; i < pasojson.length; i++) { 
    		$('#nombre_paso').val(pasojson[i].nombre_paso);
    		$('#desc_paso').val(pasojson[i].descripcion_paso);
    		addPaso(pasojson[i].idPaso);
    		$('#nombre_paso').val("");
			$('#desc_paso').val("");
			if(pasojson[i].nombre_paso == 1){
				$("#ph_" + pasojson[i].idPaso + " a").remove();
			}
    	}
		
	}
	
	
	
	
$('#altaPlanForm').validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
    // handle the invalid form...
  } else {
  e.preventDefault();
 	  
		if ($('#idPlan').val() == "") {
		    $('#idPlan').val('0');
		}
		$
		    .ajax({
		        url: '/BackOffice/planes/update',
		        type: 'POST',
		        data: JSON
		            .stringify({
		                "idPlan": parseInt($(
		                        '#idPlan')
		                    .val()),
		                "idTipoPlan": $(
		                        '#selp')
		                    .val(),
		                "idTipoCatastrofe": $(
		                        '#selt')
		                    .val(),
		                "nombre": $(
		                        '#nombre')
		                    .val(),
		                "nombre": $(
		                        '#nombre')
		                    .val(),
		                "descripcion": $(
		                        '#descripcion')
		                    .val(),
		                "cantidadPasos": 1,
		                "nombre_paso": $(
		                        '#nombre_paso')
		                    .val(),
		                    "descripcion_paso": $(
	                        '#desc_paso')
	                    .val(),   
	                    "estado": 0,
		                "accion": $(
		                        '#createP')
		                    .val()
		            }),
		        beforeSend: function(
		            xhr) {
		            xhr
		                .setRequestHeader(
		                    "Accept",
		                    "application/json");
		            xhr
		                .setRequestHeader(
		                    "Content-Type",
		                    "application/json");
		        },
		        success: function(data) {
		        	 if($('#createP').val() != "Modificar"){
		        		 $("#idPlan").val(
		 		                data.idc);
		 		            addPaso(data.ido);
		 		        	$('#createP').html("");
		 		        	$('#createP').html("Modificar");
		 		        	$('#createP').val("Modificar");
		 		        	$('#pHeading').html("");
		 		        	$('#pHeading').html("Paso");
		 		        	$('#colPasoInical').remove();
		 		        	$('#selt').attr('disabled', 'disabled');
		 		        	addPasoIncial();
		        	 }
		            
		            message(
		                "La operacion se realizo con exito.",
		                "success")
		        },
		        error: function(data,
		            status, er) {
		            message(
		                "No se pudo realizar la operacion.",
		                "error");
		        }
		    });	  
	
  }
})




$(function () {
    $('[data-toggle="tooltip"]').tooltip();
})
});

function pasoSubmit(id) {
  $('#pasoform_' + id).validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
    // handle the invalid form...
  } else {
  e.preventDefault();
  $.ajax({
		url : '/BackOffice/planes/editpaso',
		type : 'POST',
		data : JSON.stringify({
			"idPlan" : $('#idPlan').val(),
			"idPaso" : id,
			"estado" : 0,
			"nombre_paso" : $('#nombre_' + id).val(),
			"descripcion_paso" : $('#desc_' + id).val(),
			"accion" : "accion",
		}),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {		
			$('#fgnom_' + data.ido).fadeOut('400');
			$('#fgbtn_' + data.ido).fadeOut('400');
			$('#desc_' + data.ido).attr('readonly',true);	    
		    $('#lbl_' + data.ido).html("");  
			$('#lbl_' + data.ido).html($('#nombre_' + data.ido).val());
			 message(
		                "La operacion se realizo con exito.",
		                "success")
		},
		error : function(data, status, er) {
			   message(
		                "No se pudo realizar la operacion.",
		                "error");
		}
	});
	  
  }
})
}

function pasoInitSubmit() {
           $('#pasoforminit').validator().on('submit', function (e) {
  if (e.isDefaultPrevented()) {
    // handle the invalid form...
  } else {
  e.preventDefault();
  $.ajax({
		url : '/BackOffice/planes/addpaso',
		type : 'POST',
		data : JSON.stringify({
			"idPlan" : $('#idPlan').val(),
			"idPaso" : 0,
			"estado" : 0,
			"nombre_paso" : $('#nombre_paso').val(),
			"descripcion_paso" : $('#desc_paso').val(),
			"accion" : "accion",
		}),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			addPaso(data.ido);
			$('#fgnom_' + data.ido).fadeOut('400');
			$('#fgbtn_' + data.ido).fadeOut('400');
			$('#desc_' + data.ido).attr('readonly',true);	    
		    $('#lbl_' + data.ido).html("");  
			$('#lbl_' + data.ido).html($('#nombre_' + data.ido).val());
			 message(
		                "La operacion se realizo con exito.",
		                "success")
		},
		error : function(data, status, er) {
			   message(
		                "No se pudo realizar la operacion.",
		                "error");
		}
	});
  }
})
}


function pasoEdit(id){
	$('#fgnom_' + id).fadeIn('400');
	$('#fgbtn_' + id).fadeIn('400');
	$('#desc_' + id).attr('readonly',false);
}

function pasoRemove(id){
	$('#primary_' + id).remove();
}
		
function addPaso(id){
var nombre = $('#nombre_paso').val();
var desc =  $('#desc_paso').val();
	$('#pasosContainer').append('<div class="col-md-6"><div id="primary_' + id +'" class="panel panel-primary">' +                  
            '<div id="ph_' + id +'" class="panel-heading"> <p id="lbl_'+ id +'">'+nombre+'</p> <a id="ar_' + id +'" class="close" style=" margin-top: -27px; "aria-label="Close" href="#" onClick="pasoRemove('+id+')"><i class="glyphicon glyphicon-remove"></i></a><a id="ae_' + id +'" class="close" style="margin-right: 30px; margin-top: -27px;" aria-label="Close" onClick="pasoEdit('+id+')" href="#"><i class="glyphicon glyphicon-pencil"></i></a></div>' +
                '<div class="panel-body">' +
				 '<form id="pasoform_' + id +'" data-toggle="validator_' + id +'" role="form" >' +                     
                    '<div id="fgnom_'+ id +'" class="form-group" style="display:none">' +
                        '<label class="control-label" for="nombre_'+id+'">Nombre</label>' +
						'<input type="text" id="nombre_'+id+'" class="form-control" value="'+nombre+'" required>' +						
						           '<div class="help-block with-errors"></div>' +
					'</div>' +
					'<div class="form-group">' +
						'<label class="control-label" for="id="desc_'+id+'">Descripcion</label>' +
                        '<input id="desc_'+id+'" type="text" readonly class="form-control" value="'+desc+'" required>' +						
						           '<div class="help-block with-errors"></div>' +						
                    '</div>' + 
					'<div id="fgbtn_'+ id +'" class="form-group"  style="display:none">' +
						'<button id="sbtn_'+ id +'" type="submit" class="btn btn-default" onClick="pasoSubmit('+id+')" value="Editar">Editar</button>' +	
					 '</div>' + 
					'</form>' + 
					 '</div>' +  
					 '</div>' +   
                '</div>' +
         '</div></div>');		
		// id = id + 1
}

function add_Paso(){
	var nombre = $('#nombre_paso').val();
	var desc =  $('#desc_paso').val();
		$('#pasosContainer').append('<div id="primary_" class="panel panel-primary">' +                  
	            '<div id="ph_" class="panel-heading"> <p id="lbl_">'+nombre+'</p> <a id="ar_" class="close" style=" margin-top: -27px; "aria-label="Close" href="#" onClick="pasoRemove(this)"><i class="glyphicon glyphicon-remove"></i></a><a id="ae_" class="close" style="margin-right: 30px; margin-top: -27px;" aria-label="Close" onClick="pasoEdit(this)" href="#"><i class="glyphicon glyphicon-pencil"></i></a></div>' +
	                '<div class="panel-body">' +
					 '<form id="pasoform_" data-toggle="validator_" role="form" >' +                     
	                    '<div id="fgnom_" class="form-group" style="display:none">' +
	                        '<label class="control-label" for="nombre_">Nombre</label>' +
							'<input type="text" id="nombre_" class="form-control" value="'+nombre+'" required>' +						
							           '<div class="help-block with-errors"></div>' +
						'</div>' +
						'<div class="form-group">' +
							'<label class="control-label" for="id="desc_">Descripcion</label>' +
	                        '<input id="desc_" type="text" readonly class="form-control" value="'+desc+'" required>' +						
							           '<div class="help-block with-errors"></div>' +						
	                    '</div>' + 
						'<div id="fgbtn_" class="form-group"  style="display:none">' +
							'<button id="sbtn_" type="submit" class="btn btn-default" onClick="pasoSubmit(this)" value="Editar">Editar</button>' +	
						 '</div>' + 
						'</form>' + 
						 '</div>' +  
						 '</div>' +   
	                '</div>' +
	         '</div>');		
			// id = id + 1
	}

function addPasoIncial(){
	 $('#pasoIncialRow').append('<div class="panel panel-primary">' +                
                        '<div id="pHeading" class="panel-heading">Nuevo Paso</div>' +
                            '<div class="panel-body">' +
							 '<form id="pasoforminit" data-toggle="validatorinit" role="form" >' +    
                              '<div class="form-group">' +
                                '<label class="sr-only" for="nombre_paso">Nombre</label>' +
                                '<input type="text" class="form-control" id="nombre_paso" placeholder="Nombre paso" required>' +
								'<div class="help-block with-errors"></div>' +
                              '</div>' +
                              '<div class="form-group">' +
                                '<label class="sr-only" for="desc_paso">Descripcion</label>' +
                                '<textarea name="desc0" id="desc_paso" placeholder="Descripcion ..." class="form-control" required></textarea>' +
								'<div class="help-block with-errors"></div>' +
                              '</div>' +							
							  '<div class="form-group">' +
								'<button id="sbtninit" type="submit" class="btn btn-default" onClick="pasoInitSubmit()" value="Agergar">Agergar</button>' +	
							 '</div>' + 
							   '</form>' +
                            '</div>' +
                       '</div>');

}

function pasoupdate(idPaso, callback) {
	if (idPaso == "") {
		idPaso = "0";
	}
	return $.ajax({
		url : '/BackOffice/planes/updatepaso',
		type : 'POST',
		data : JSON.stringify({
			"idPlan" : $('#idPlan').val(),
			"idPaso" : idPaso,
			"estado" : nombre,
			"nombre_paso" : nombre,
			"descripcion_paso" : nombre,
			"accion" : "accion",
		}),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			callback(data);
		},
		error : function(data, status, er) {
			$('#tableList tbody').append('<tr><td>HUBO UN ERROR!</td></tr>');
		}
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


