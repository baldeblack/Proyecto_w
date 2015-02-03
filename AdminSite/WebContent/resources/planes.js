	var PasoCont = 0;
	function addPaso(){
	if(PasoCont < 8){
          	 $('#container').append('<div class="table-row"><div class="col"><input type="text" name="pasos[0]" value=""/></div>' +
					'<div class="col"><textarea rows="3" cols="20"></textarea></div>' +
						'<div class="col"><input type="image" src="C:\ic_cancel_24px.svg" type="image" onclick="deletePaso(this)"/></div></div>');
	
				PasoCont = PasoCont + 1
              }
	else{
		alert('El numero de palabras claves no puede ser mayor a 9.');
	} 
	}
	
	function deletePaso(elem){
		$(elem).closest('.table-row').remove();
  	  	PasoCont = PasoCont - 1
  	  	return false;
	}