function Traspass(elem, idT){

	if(idT == "ongs"){
		$(elem).closest('.ongContainer').remove().clone().appendTo('#ongsMod');
	}else if(idT == "ongsMod"){
		$(elem).closest('.ongContainer').remove().clone().appendTo('#ongs');
	}
	updateName("ongs");
	updateName("ongsMod");
}

function updateName(id){
	var ind;

	if(id == "ongs"){
		ind = 0;
		$('#ongs input').each(function(){ 
			
			if($(this).attr('type') == "text"){
			   $(this).attr('name', "ongSistemaLst[" + ind + "].nombre");			
			   ind = ind + 1;   
			} 	    	
		 });
		
		ind = 0;
		$('#ongs input').each(function(){  			
			if($(this).attr('type') == "hidden"){
				$(this).attr('name', "ongSistemaLst[" + ind + "].idONGs");
				ind = ind + 1;
			}
		});
		
	}else if(id == "ongsMod"){		
		ind = 0;
		$('#ongsMod input').each(function(){
			if($(this).attr('type') == "text"){
			    $(this).attr('name', "ongTenantLst[" + ind + "].nombre");
			    	ind = ind + 1;  
				}	
			});
		
		ind = 0;
		$('#ongsMod input').each(function(){ 
			if($(this).attr('type') == "hidden"){
				$(this).attr('name', "ongTenantLst[" + ind + "].idONGs");
				ind = ind + 1;  
			}		      		    	
		});
		
	}	 
}


function LoadOngInfo(id) {
    $.ajax({
        url : '/BackOffice/ongs/getonginfo',
        type: 'POST',
        data: JSON.stringify({
            "id" : id
        }),
        beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },
        success : function(data) {
        	$('#divMail').html(data.email);
        	$('#divWeb').html(data.web);
        	$('#divDir').html(data.direccion);
        	$('#divTel').html(data.telefono);
        },
        error:function(data,status,er) { 
        	alert("error Lost: "+data+" status: "+status+" er:"+er);
        }
    });
}

function fover(elem){
	LoadOngInfo($(elem).next().val());
	$('#divInfo').show();
}

function fout(elem){
	$('#divMail').empty();
	$('#divWeb').empty();
	$('#divDir').empty();
	$('#divTel').empty();
	$('#divInfo').hide();
}
