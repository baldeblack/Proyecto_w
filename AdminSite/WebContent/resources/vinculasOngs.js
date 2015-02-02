function initialize() {

	var dataFrom = $('#jsonTable').val().toString().replace(/'/g, "\"");
	var datap = JSON.parse(dataFrom);
	loadOngs(datap);
	var nombre;

	$('#deleteBtn').click(
			function() {
				var idc = $('#idCt').val();
				$('#table input').each(
						function() {
							if ($(this).is(":checked")) {
								var ido = $(this).closest('td').next().next()
										.html();
								nombre = ido;
								getOngsBefore(idc, ido, function(data) {
									loadOngs(data)
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

	$('#add').click(function() {
		if ($('#select option').length != 0) {
			var ido = $('#select option:selected').val();
			var idc = $('#idCt').val();

			$('#table').empty();

			getOngs(idc, ido, function(data) {
				loadOngs(data)
			});

			$('#select option').each(function() {
				if ($(this).val() == ido) {
					$(this).remove();
				}
			});
		}
	});
}

function loadOngs(dataFrom) {
	var data = new google.visualization.DataTable();
	data.addColumn('string', '');
	data.addColumn('number', 'idONGs');
	data.addColumn('string', 'Nombre');
	data.addColumn('string', 'Direccion');
	data.addColumn('number', 'Telefono');
	data.addColumn('string', 'Email');
	data.addColumn('string', 'Web');
	data.addColumn('string', 'Origen');
	data.addColumn('string', 'DatosPayPal');

	var datap = dataFrom;
	data.addRows(datap.length);

	for (i = 0; i < datap.length; i++) {
		if (datap[i].borrar == 0) {
			data.setCell(i, 0, '<input type="checkbox">');
		} else {
			data.setCell(i, 0, '<input type="checkbox" disabled>');
		}

		data.setCell(i, 1, datap[i].idONGs);
		data.setCell(i, 2, datap[i].nombre);
		data.setCell(i, 3, datap[i].direccion);
		data.setCell(i, 4, datap[i].telefono);
		data.setCell(i, 5, datap[i].email);
		data.setCell(i, 6, datap[i].web);
		data.setCell(i, 7, datap[i].origen);
		data.setCell(i, 8, datap[i].datosPayPal);
	}
	var options = {};
	options['showRowNumber'] = false;
	options['page'] = 'enable';
	options['allowHtml'] = true;
	options['pageSize'] = 18;
	options['pagingButtonsConfiguration'] = 'auto';

	var visualization = new google.visualization.Table(document
			.getElementById('table'));
	visualization.draw(data, options);
}

function getAborrar() {
	$('#table input').each(function() {
		var nextTD = $(this).closest('td').next().next().html();
		alert(nextTD);
	});
}

function getOngs(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/ongs/addOng',
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
			alert("error Lost: " + data + " status: " + status + " er:" + er);
		}
	});
}

function getOngsBefore(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/ongs/delOng',
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
			alert("error Lost: " + data + " status: " + status + " er:" + er);
		}
	});
}

function getOngsid(nombre, callback) {
	return $.ajax({
		url : '/BackOffice/ongs/getongid',
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
			alert("error Lost: " + data + " status: " + status + " er:" + er);
		}
	});
}

google.setOnLoadCallback(initialize);
// google.setOnLoadCallback(drawVisualization);
google.load('visualization', '1', {
	packages : [ 'table' ]
});