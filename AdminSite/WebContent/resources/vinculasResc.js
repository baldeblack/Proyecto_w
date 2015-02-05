function initialize() {

	var dataFrom = $('#jsonTable').val().toString().replace(/'/g, "\"");
	var datap = JSON.parse(dataFrom);
	loadResc(datap);
	var nombre;


	$('#add').click(function() {
		var idc = $('#idCt').val();
		var arrido = [];
		
		$('#table input').each(function() {
			if($(this).is(':checked')){
			var ido = $(this).attr('name');
			arrido.push(ido);	
			}
		});
		$('#table').empty();
		
		for (i = 0; i < arrido.length; i++) {
			
			updateres(idc,arrido[i], function(data) {
				loadResc(data)
			});
		}
			
		

	});
}

function loadResc(dataFrom) {
	var data = new google.visualization.DataTable();
	data.addColumn('string', '');
	data.addColumn('string', 'Nombre');
	data.addColumn('string', 'Apellido');
	data.addColumn('string', 'Email');
	data.addColumn('string', 'Celular');
	data.addColumn('string', 'Tipo');

//	'idUsuarios':1,'nombre':'nacho','apellido':'castro','email':'castro@gmail.com','celular':'098999000','tipoRescatista':'bombero'
	
	
	var datap = dataFrom;
	data.addRows(datap.length);

	for (i = 0; i < datap.length; i++) {
		data.setCell(i, 0, '<input type="checkbox" name="'+ datap[i].idUsuarios +'">');
		

		data.setCell(i, 1, datap[i].nombre);
		data.setCell(i, 2, datap[i].apellido);
		data.setCell(i, 3, datap[i].email);
		data.setCell(i, 4, datap[i].celular);
		data.setCell(i, 5, datap[i].tipoRescatista);
		
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

//function getAborrar() {
//	$('#table input').each(function() {
//		var nextTD = $(this).closest('td').next().next().html();
//		alert(nextTD);
//	});
//}
//
function updateres(idc, ido, callback) {
	return $.ajax({
		url : '/BackOffice/usuarios/updateres',
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
//
//function getOngsBefore(idc, ido, callback) {
//	return $.ajax({
//		url : '/BackOffice/ongs/delOng',
//		type : 'POST',
//		data : JSON.stringify({
//			"idc" : idc,
//			"ido" : ido
//		}),
//		beforeSend : function(xhr) {
//			xhr.setRequestHeader("Accept", "application/json");
//			xhr.setRequestHeader("Content-Type", "application/json");
//		},
//		success : function(data) {
//			callback(data);
//		},
//		error : function(data, status, er) {
//			alert("error Lost: " + data + " status: " + status + " er:" + er);
//		}
//	});
//}

//function getOngsid(nombre, callback) {
//	return $.ajax({
//		url : '/BackOffice/ongs/getongid',
//		type : 'POST',
//		data : JSON.stringify({
//			"nombre" : nombre
//		}),
//		beforeSend : function(xhr) {
//			xhr.setRequestHeader("Accept", "application/json");
//			xhr.setRequestHeader("Content-Type", "application/json");
//		},
//		success : function(data) {
//			callback(data);
//		},
//		error : function(data, status, er) {
//			alert("error Lost: " + data + " status: " + status + " er:" + er);
//		}
//	});
//}

google.setOnLoadCallback(initialize);
// google.setOnLoadCallback(drawVisualization);
google.load('visualization', '1', {
	packages : [ 'table' ]
});