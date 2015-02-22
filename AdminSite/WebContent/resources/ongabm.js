$(document)
		.ready(
				function() {

					$('#ongForm')
							.validator()
							.on(
									'submit',
									function(e) {

										if (e.isDefaultPrevented()) {
											// handle the invalid form...
										} else {
											e.preventDefault();
											if ($('#idONGs').val() == "") {
												$('#idONGs').val('0');
											}
											$
													.ajax({
														url : '/BackOffice/ongs/update',
														type : 'POST',
														data : JSON
																.stringify({
																	"idC" : 0,
																	"idONGs" : parseInt($(
																			'#idOng')
																			.val()),
																	"datosPayPal" : $(
																			'#datosPayPal')
																			.val(),
																	"direccion" : $(
																			'#direccion')
																			.val(),
																	"email" : $(
																			'#email')
																			.val(),
																	"nombre" : $(
																			'#nombre')
																			.val(),
																	"origen" : $(
																			'#origen')
																			.val(),
																	"telefono" : parseInt($(
																			'#telefono')
																			.val()),
																	"web" : $(
																			'#web')
																			.val(),
																	"accion" : $(
																			'#actionbtn')
																			.val()
																}),
														beforeSend : function(
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
														success : function(data) {
															$("#idOng").val(
																	data.id);
															$('#actionbtn')
																	.val(
																			'Modificar');
															$('#actionbtn')
																	.html("");
															$('#actionbtn')
																	.html(
																			"Modificar");
															message(
																	"La operacion se realizo con exito.",
																	"success")
														},
														error : function(data,
																status, er) {
															message(
																	"No se pudo realizar la operacion.",
																	"error");
														}
													});
											;
										}
									})

					if ($('#idOng').val() != "") {
						var dataFromOng = $('#jsondata').val().toString()
								.replace(/'/g, "\"");
						var dataong = JSON.parse(dataFromOng);
						for (key in dataong) {
							load(key, dataong);
						}

						if ($('#actionbtn').val() == "Modificar") {
							$('#nombre').attr('readonly', true);
						}
					}
				});

function load(keyn, usujson) {
	switch (keyn) {
	case "datosPayPal":
		$('#datosPayPal').val(usujson[keyn]);
		break;
	case "direccion":
		$('#direccion').val(usujson[keyn]);
		break;
	case "email":
		$('#email').val(usujson[keyn]);
		break;
	case "email":
		$('#email').val(usujson[keyn]);
		break;
	case "nombre":
		$('#nombre').val(usujson[keyn]);
		break;
	case "origen":
		$('#origen').val(usujson[keyn]);
		break;
	case "telefono":
		$('#telefono').val(usujson[keyn]);
		break;
	case "web":
		$('#web').val(usujson[keyn]);
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