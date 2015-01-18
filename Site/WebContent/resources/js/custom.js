
function LoadLostList(callback) {
    $.ajax({
        url : '/Site/lost/getAllView',
        type: 'GET',
        beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },
        success : function(data) {
            callback(data);
        },
        error:function(data,status,er) { 
        	alert("error Lost: "+data+" status: "+status+" er:"+er);
        }
    });
}

function LoadOngList() {
    $.ajax({
        url : '/Site/ong/getAll',
        type: 'GET',
        beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },
        success : function(data) {
            $('#secOngs').html(data);
        },
        error:function(data,status,er) { 
        	alert("error Ongs: "+data+" status: "+status+" er:"+er);
        }
    });
}

function doLogin() {
    var url = "/Site/access/logon";
    var username = $("#exampleInputEmail2").val();
    var password = $("#exampleInputPassword2").val();
    $.ajax({
        url : url,
        type : "POST",
        cache : false,
        async : false,
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify({
            "email" : username,
            "password" : password
        }),
        datatype : "json",
        success : function(data) {
        	if(data==="onError"){
        		alert("Usuario o contraseña no válida.");
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + " : " + errorThrown);
        }
    });
}

function SendHelp(){
	 var url = "/Site/help/ask";
	 	var request = $('#typeRequest').val();
	    var msg = $('#message').val();
	    var tel = $('#tel_ayuda').val();
	    var loc = $('#ubicacion_ayuda').val();
	    $.ajax({
	        url : url,
	        type : "POST",
	        cache : false,
	        async : false,
	        contentType : "application/json; charset=UTF-8",
	        data : JSON.stringify({
	        	 "typeRequest" : request,
	             "message" : msg,
	             "location":loc,
	             "telefono":tel
	        }),
	        datatype : "json",
	        success : function(data) {
	        	 if(data==="success"){ 
		            	$("#responseHelp").html("Su pedido de ayuda fue enviado con exito, en minutos personal calificado se podra en contacto con ud.");
		            	$('#typeRequest').val(1);
		            	$('#message').val("");
		            	$('#ubicacion_ayuda').val("");
		            	$('#tel_ayuda').val("");
		            	setTimeout(function(){
		            		$("#closeModal").click();
		            		$("#responseHelp").html("");
		            	}, 5000);
		            	
		            }
		            else {
		            	$("#responseHelp").html("Hubo un error al procesar su solicitud por fabor vuelva a intentarlo o comuniquece al: 112233");
		            	setTimeout(function(){
		            		$("#responseHelp").html("");
		            	}, 8000);
		            	
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	    
	/*var url = "/Site/help/ask";
	var typeRequest = $('#typeRequest').val();
    var messaje = $('#message').val();
    var tel = $('#tel_ayuda').val();
    var location = $('#ubicacion_ayuda').val();
    
    $.ajax({
        url :  url,
        type : "POST",
        cache : false,
        async : false,
        contentType : "application/json; charset=UTF-8",
        data: JSON.stringify({
            "typeRequest" : typeRequest,
            "message" : message,
            "location":location,
            "telefono":tel
        }),
        datatype : "json",
        success : function(data) {
        	alert("ahhhh");
        	 if(data==="success"){ 
	            	$("#responseHelp").html("Su pedido de ayuda fue enviado con exito, en minutos personal calificado se podra en contacto con ud.");
	            	$('#typeRequest').val(1);
	            	$('#message').val("");
	            	$('#ubicacion_ayuda').val("");
	            	$('#tel_ayuda').val("");
	            	$("#closeModal").click();
	            }
	            else {
	            	$("#responseHelp").html("Hubo un error al procesar su solicitud por fabor vuelva a intentarlo o comuniquece al: 112233");
	            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + " : " + errorThrown);
        }
    });*/
}
