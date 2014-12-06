var urlHolder = new Object();
function loadTable() {
	$.get(urlHolder.records, function(response) {	
		$('#tableCatastrofes').find('tbody').remove();
		for (var i = 0; i < response.length; i++) {
			var row = '<tr>';
			row += '<td><input type="radio" name="index" id="index" value="'
					+ i + '"></td>';
			row += '<td>' + response[i].dominio + '</td>';
			row += '</tr>';
			$('#tableCatastrofes').append(row);
		}
		$('#tableCatastrofes').data('model', response);
		toggleForms('hide');
		;
	});
}
function submitNewRecord() {
	$.post(urlHolder.add, { 
		dominio : $('#newDominio').val(),
	}, function(response) {
		if (response != null) {
			loadTable();
			toggleForms('hide');
			;
			toggleCrudButtons('show');
			alert('Success! Record has been added.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}
function submitDeleteRecord() {
	var selected = $('input:radio[name=index]:checked').val();
	$.post(urlHolder.del, {
		dominio : $('#tableCatastrofes').data('model')[selected].dominio
	}, function(response) {
		if (response == true) {
			loadTable(urlHolder.records);
			alert('Success! Record has been deleted.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}
function submitUpdateRecord() {
	$.post(urlHolder.edit, {
		dominio : $('#editDominio').val(),		
	}, function(response) {
		if (response != null) {
			loadTable();
			toggleForms('hide');
			;
			toggleCrudButtons('show');
			alert('Success! Record has been edited.');
		} else {
			alert('Failure! An error has occurred!');
		}
	});
}
function getRole(role) {
	if (role == 1) {
		return 'Admin';
	} else if (role == 2) {
		return 'Regular';
	} else {
		return 'Unknown';
	}
}
function hasSelected() {
	var selected = $('input:radio[name=index]:checked').val();
	if (selected == undefined) {
		alert('Select a record first!');
		return false;
	}
	return true;
}
function fillEditForm() {
	var selected = $('input:radio[name=index]:checked').val();
	$('#editDominio').val($('#tableCatastrofes').data('model')[selected].dominio);	
}
function resetNewForm() {
	$('#newDominio').val('');	
}
function resetEditForm() {
	$('#editDominio').val('');
}
function toggleForms(id) {
	if (id == 'hide') {
		$('#newForm').hide();
		$('#editForm').hide();
	} else if (id == 'new') {
		resetNewForm();
		$('#newForm').show();
		$('#editForm').hide();
	} else if (id == 'edit') {
		resetEditForm();
		$('#newForm').hide();
		$('#editForm').show();
	}
}
function toggleCrudButtons(id) {
	if (id == 'show') {
		$('#newBtn').removeAttr('disabled');
		$('#editBtn').removeAttr('disabled');	
		$('#reloadBtn').removeAttr('disabled');
	} else if (id == 'hide') {
		$('#newBtn').attr('disabled', 'disabled');
		$('#editBtn').attr('disabled', 'disabled');	
		$('#reloadBtn').attr('disabled', 'disabled');
	}
}