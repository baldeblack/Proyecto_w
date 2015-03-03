$(document).ready(function() {			 
	    var table = $('#lstTable').DataTable( {
	        "language": 
	        {
	        	"sProcessing":     "Procesando...",
	        	"sLengthMenu":     "Mostrar _MENU_ registros",
	        	"sZeroRecords":    "No se encontraron resultados",
	        	"sEmptyTable":     "Ningun dato disponible en esta tabla",
	        	"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        	"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        	"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        	"sInfoPostFix":    "",
	        	"sSearch":         "Buscar:",
	        	"sUrl":            "",
	        	"sInfoThousands":  ",",
	        	"sLoadingRecords": "Cargando...",
	        	"oPaginate": {
	        		"sFirst":    "Primero",
	        		"sLast":     "Ultimo",
	        		"sNext":     "Siguiente",
	        		"sPrevious": "Anterior"
	        	},
	        	"oAria": {
	        		"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	        		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        	}
	        }
	    });
	    
	    var tt = new $.fn.dataTable.TableTools( table );
	 
	    $( tt.fnContainer() ).insertBefore('div.dataTables_wrapper');
	} );

  function deactive(elem, id, event){
	  event.preventDefault();	  
	  $.ajax({
			url : '/BackOffice/catastrofes/deactivate',
			type : 'POST',
			data : JSON.stringify({
					"idc": id,
					"estado":$(elem).html()
			}),
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {			
				$(elem).html("");
				$(elem).html(data.estado);				
				 message(
			                "La operacion se realizo con exito.",
			                "success")
			},
			error : function(data, status, er) {
				   message(
			                "No se pudo realizar la operacion.",
			                "error");
			}
		});;
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