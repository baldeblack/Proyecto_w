	var PasoCont = 0;
	function addPaso(){
	if(PasoCont < 8){
          	 $('#container').append('<div class="table-row"><div class="col"><input type="text" name="pasos[0].nombre" value=""/></div>' +
					'<div class="col"><textarea name="pasos[0].descripcion" rows="3" cols="20"></textarea></div>' +
						'<div class="col"><input type="image" src="http://localhost/img/ic_cancel_24px.svg" type="image" onclick="javascript:return deletePaso(this)"/></div></div>');
	
				PasoCont = PasoCont + 1
				updateName();
              }
	else{
		alert('El numero de palabras claves no puede ser mayor a 9.');
	} 
		return false;
	}
	
	function deletePaso(elem){
		$(elem).closest('.table-row').remove();
  	  	PasoCont = PasoCont - 1
  	  	updateName();
  	  	return false;
	}
	
	
	
	function updateName(){
		var ind = 0;
		 
			$('#container input').each(function(){    	
				if($(this).attr('type') == 'text'){
			    $(this).attr('name', "pasos[" + ind + "].nombre");    	
			    ind = ind + 1;     		   
				}
			 });
		
		ind = 0;
		
			$('#container textarea').each(function(){
				    $(this).attr('name', "pasos[" + ind + "].descripcion");    	
				    ind = ind + 1;     		   
			 });
		
	}