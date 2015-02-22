jQuery(document).ready(function($) {

	var dataFrom = $('#jsonTable').val().toString().replace(/'/g, "\"");
	var datap = JSON.parse(dataFrom);
	
	load("donRbt", datap);
	
	$('#modalUsuario').on('shown.bs.modal', function() {
		var dataFromRes = $('#jsonTipo').val().toString().replace(/'/g, "\"");
		var datares = JSON.parse(dataFromRes);	

		for (i = 0; i < datares.length; i++) {
				$('#tiposrescatistas').append('<option value="'+datares[i].value+'">'+datares[i].nombre+'</option>');			
		}
		
	})

	$('#modalOng').on('hidden.bs.modal', function () {

		
		$('#loginForm input').each(function() {
		
			   var $group = $(this).closest('.form-group')
			    var $block = $group.find('.help-block.with-errors')
			    var $feedback = $group.find('.form-control-feedback')

			    $block.html($block.data('bs.validator.originalContent'))
			    $group.removeClass('has-error')
			    $group.removeClass('has-success')
			    $feedback.removeClass('glyphicon-remove')
			    $feedback.removeClass('glyphicon-ok')
			     $(this).val("");
			
		});
	})
		
		$('#modalUsuario').on('hidden.bs.modal', function () {

			
			$('#usuarioForm input').each(function() {
			
				   var $group = $(this).closest('.form-group')
				    var $block = $group.find('.help-block.with-errors')
				    var $feedback = $group.find('.form-control-feedback')

				    $block.html($block.data('bs.validator.originalContent'))
				    $group.removeClass('has-error')
				    $group.removeClass('has-success')
				    $feedback.removeClass('glyphicon-remove')
				    $feedback.removeClass('glyphicon-ok')
				     $(this).val("");
				
			});
		})
	
	$('#loginForm').validator().on('submit', function (e) {

		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  e.preventDefault();
		    	 $.ajax({
		    			url : '/BackOffice/vincular/createong',
		    			type : 'POST',
		    			data : JSON.stringify({
		    					"idC": $('#idCt').val(),
		    					"idONGs": null,
		    					"datosPayPal": $('#datosPayPal').val(),
		    					"direccion": $('#direccion').val(),
		    					"email": $('#email').val(),
		    					"nombre": $('#nombre').val(),
		    					"origen": $('#origen').val(),
		    					"telefono": $('#telefono').val(),
		    					"web": $('#web').val(),
		    			}),
		    			beforeSend : function(xhr) {
		    				xhr.setRequestHeader("Accept", "application/json");
		    				xhr.setRequestHeader("Content-Type", "application/json");
		    			},
		    			success : function(data) {
		    				$("#responseOng").html("La se dio de alta la ong " + data.nombre + " .");
		    				load("donRbt", data);    		
		    			},
		    			error : function(data, status, er) {
		    				$("#responseOng").html("No se pudo realizar la operacion");
		    			}
		    		});;
		  }
		})
	
	$('#usuarioForm').validator().on('submit', function (e) {

		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  e.preventDefault();
		    	 $.ajax({
		    			url : '/BackOffice/vincular/createresc',
		    			type : 'POST',
		    			data : JSON.stringify({
		    					"idC": $('#idCt').val(),
		    					"idUsu": 0,
		    					"apellido":$('#apellidou').val(),
		    					 "borrado":0,
		    					 "celular":$('#celular').val(),
		    					"creacion":$('#').val(),
		    					 "direccion":$('#direccionu').val(),
		    					 "email":$('#emailu').val(),
		    					"nacimiento":$('#nacimiento').val(),
		    					"nick":$('#nick').val(),
		    					"nombre":$('#nombreu').val(),
		    					"password":$('#pass').val(),
		    					"sexo":$('#sexo').val(),
		    					"tipoUsuario": 1,
		    					"tiporescatisa":$('#tiposrescatistas').val(),
		    					"residencia":$('#direccionu').val()
		    			}),
		    			beforeSend : function(xhr) {
		    				xhr.setRequestHeader("Accept", "application/json");
		    				xhr.setRequestHeader("Content-Type", "application/json");
		    			},
		    			success : function(data) {
		    				$("#responseUsu").html("La se dio de alta el usuario " + data.nombre + " .");
		    				load("rescRbt", data);    		
		    			},
		    			error : function(data, status, er) {
		    				$("#responseUsu").html("No se pudo realizar la operacion");
		    			}
		    		});;
		  }
		})
	$("#addbtn").click(function() {
		
		var idc = $('#idCt').val();
		var rowCount = $('#tableList tbody tr').length;
		if(rowCount != 0){
		$('#radios input').each(function() {
			if($(this).is(':checked')){
				if($(this).attr('name') == "donRbt"){
					if ($('#select option').length != 0) {
						var ido = $('#select option:selected').val();
			
						getOngs(idc, ido, function(data) {
							load("donRbt", data);
						});

						$('#select option').each(function() {
							if ($(this).val() == ido) {
								$(this).remove();
							}
						});
					}
				}else{
	
					var arrido = [];
					
					$('#tableList input').each(function() {
						if($(this).is(':checked')){
						var ido = $(this).attr('name');
						arrido.push(ido);	
						}
					});
			
					
					for (i = 0; i < arrido.length; i++) {
						
						updateres(idc,arrido[i], function(data) {
							load("rescRbt", data);	
							message("se dio de alta", "success")
						});
					}
						
					
					
				}
			}
		});
	} else {
		var ido = $('#select option:selected').val();
		getOngs(idc, ido, function(data) {
			load("donRbt", data);
		});
		
		$('#select option').each(function() {
			if ($(this).val() == ido) {
				$(this).remove();
			}
		});
	}
	});
			
	$("#delbtn").click(function() {
		
		var idc = $('#idCt').val();
		
						$('#tableList input').each(
								function() {
									if ($(this).is(":checked")) {
										var ido = $(this).attr('name');
										nombre = ido;
										getOngsBefore(idc, ido, function(data) {
											load("donRbt", data);
										});

										var idData;
										getOngsid(nombre, function(data) {
											idData = data;
											$('#select').append(
													"<option value='" + idData.idc
															+ "'>" + idData.ido
															+ "</option>");
										});

									}

								});
		
	});
	
	
	

	$("input:radio").click(function() {
		var current = $(this).attr('name');
		$('#radios input').each(function() {
			if ($(this).attr('name') != current) {
				$(this).attr('checked', false);
			}
		});
		
		var idc = $('#idCt').val();
		
		if (current == 'donRbt') {
			getOngs(idc,"", function(data) {			
				load(current, data);
			});
			
			$('#selectO').fadeIn("400");
			$('#createO').fadeIn("400");
			$('#delbtn').fadeIn("400");
			
			
		} else {
			
			updateres(idc,"", function(data) {			
				load(current, data);
			});			

			$('#selectO').fadeOut("400");
			$('#createO').fadeOut("400");
			$('#delbtn').fadeOut("400");
		}

	});

});

function load(name, jsonRst) {
	
	$('#tableList thead tr').empty();
	$('#tableList tbody').empty();
	
if(jsonRst.length != 0){	
	var result = jsonRst[0];
	
	if (name == 'donRbt') {		

		for (key in result) {

			if (key != "borrar") {
				if (key == "idONGs") {
					inHead("");
				} else {
					inHead(key);
				}
			}

		}

		for (i = 0; i < jsonRst.length; i++) {
			inBodyOng(jsonRst[i]);
		}
	} else {

		for (key in result) {

			if (key == "idUsuarios") {
				inHead("");
			} else {
				inHead(key);
			}
		}

		for (i = 0; i < jsonRst.length; i++) {
			inBodyResc(jsonRst[i]);
		}

	}

	$('#tableList').dynatable();
} else {
	inBodyNoData();
}
}

function updateres(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/vincular/updateres',
		type : 'POST',
		data : JSON.stringify({
			"idc" : idc,
			"ido" : ido
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

function getOngs(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/vincular/addOng',
		type : 'POST',
		data : JSON.stringify({
			"idc" : idc,
			"ido" : ido
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

function getOngsBefore(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/vincular/delOng',
		type : 'POST',
		data : JSON.stringify({
			"idc" : idc,
			"ido" : ido
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

function getOngsid(nombre, callback) {
	return $.ajax({
		url : '/BackOffice/vincular/getongid',
		type : 'POST',
		data : JSON.stringify({
			"nombre" : nombre
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

function inHead(key) {

	$('#tableList thead tr').append('<th>' + key + '</th>');
}

function inBodyOng(key) {
	if (key.borrar == 0) {
		$('#tableList tbody').append(
				'<tr><td><input type="checkbox" name="' + key.nombre
						+ '"></td><td>' + key.datosPayPal + '</td><td>'
						+ key.direccion + '</td><td>' + key.nombre
						+ '</td><td>' + key.origen + '</td><td>' + key.telefono
						+ '</td><td>' + key.web + '</td><td>' + key.email
						+ '</td></tr>');
	} else {
		$('#tableList tbody').append(
				'<tr><td><input type="checkbox" disabled name="' + key.nombre
						+ '"></td><td>' + key.datosPayPal + '</td><td>'
						+ key.direccion + '</td><td>' + key.nombre
						+ '</td><td>' + key.origen + '</td><td>' + key.telefono
						+ '</td><td>' + key.web + '</td><td>' + key.email
						+ '</td></tr>');
	}
}

function inBodyResc(key) {
	$('#tableList tbody').append(
			'<tr><td><input type="checkbox" name="' + key.idUsuarios
					+ '"></td><td>' + key.nombre + '</td><td>' + key.apellido
					+ '</td><td>' + key.email + '</td><td>' + key.celular
					+ '</td><td>' + key.tipoRescatista + '</td></tr>');
}


function inBodyNoData() {
	$('#tableList tbody').append(
			'<tr><td> NO HAY DATOS </td></tr>');
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
