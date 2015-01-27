
var login = function(mail, passwd){
	 var url = "/Site/access/logon";
	 
	 $.ajax({
	        url : url,
	        type : "POST",
	        cache : false,
	        async : false,
	        contentType : "application/json; charset=UTF-8",
	        data : JSON.stringify({
	            "email" : mail,
	            "password" : passwd
	        }),
	        datatype : "json",
	        success : function(data) {
	        	if(data==="onError"){
	        		alert("Usuario o contraseña no válida.");
	        	}
	        	else{
	        		 location.reload();
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
}

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
    var username = $("#exampleInputEmail2").val();
    var password = $("#exampleInputPassword2").val();
    login(username,password);
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
		            	$("#responseHelp").html("Hubo un error al procesar su solicitud por favor vuelva a intentarlo o comuniquece al: 112233");
		            	setTimeout(function(){
		            		$("#responseHelp").html("");
		            	}, 8000);
		            	
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
}

var validateReg = function(){
	var error = false;
	if($('#password').val() !=$('#password_confirmation').val()){
		error = true;
	}
	if( $('#nombre_usuario').val() == "")
	{
		error = true;
	}
	if( $('#apellido_usuario').val() == "")
	{
		error = true;
	}
	if( $('#email').val() == "")
	{
		error = true;
	}
	if( $('#nick_usuario').val() == "")
	{
		error = true;
	}
	if( $('#password').val() == "")
	{
		error = true;
	}
	return !error;
}


function RegistUser(){
	if(validateReg())
	{
		 var url = "/Site/access/register";
		 var name = $('#nombre_usuario').val();
		 var lastName = $('#apellido_usuario').val();
		 var nic = $('#nick_usuario').val();
		 var email = $('#email').val();
		 var psswd = $('#password').val();
		 var confpswd = $('#password_confirmation').val();
		 var fn = $('#fecha_nacimiento').val();
		 var cel = $('#celular_usuario').val();
		 var dir = $('#direccion_usuario').val();
		 var sex = $('#sexo_usuario').val();
	 
	    $.ajax({
	        url : url,
	        type : "POST",
	        cache : false,
	        async : false,
	        contentType : "application/json; charset=UTF-8",
	        data : JSON.stringify({
	        	 "apellido" : lastName,
	             "celular" : cel,
	             "direccion":dir,
	             "email":email,
	             "fechaNacimiento" : fn,
	             "nik" : nic,
	             "nombre" : name,
	             "password" : psswd,
	             "sexo" : sex
	        }),
	        datatype : "json",
	        success : function(data) {
	        	 if(data==="success"){ 
		            	login(email,psswd);
		            }
		            else {
		            	$("#responseReg").html("Hubo un error al procesar su solicitud por favor vuelva a intentarlo o comuniquece al: 112233");
		            	setTimeout(function(){
		            		$("#responseReg").html("");
		            	}, 8000);
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	}
	    
}

function showData(){
	var tipo = $("#tipo").val();
	if(tipo === "1"){
		$(".eco").css("display", "block");
		$(".servi").css("display", "none");
		$(".bienes").css("display", "none");
		cleanBienes();
		cleanServi();
	}
	else if(tipo === "2"){
		$(".eco").css("display", "none");
		$(".servi").css("display", "none");
		$(".bienes").css("display", "block");
		cleanEco();
		cleanServi();
	}
	else if(tipo === "3"){
		$(".eco").css("display", "none");
		$(".servi").css("display", "block");
		$(".bienes").css("display", "none");
		cleanEco();
		cleanBienes();
	}
}

var cleanBienes = function(){
	$("#cantidad").val("");
	$("#fechaEntrega").val("");
	
}

var cleanEco = function(){
	$("#moneda").val("Dol");
	$("#monto").val("");
}


var cleanServi = function(){
	$("#hsServicio").val("");
	$("#comienzo").val("");
	$("#finalizacion").val("");
}


var cleanAll = function(){
	$("#tipo").val("1");
	$("#descripcion").val("");
	$("#idDonacion").val("");
	
	cleanBienes();
	cleanEco();
	cleanServi();
}

var jsonDataDonacion = function(){
	
	var tipo = $("#tipo").val();
	if(tipo === "1"){//eco
		return JSON.stringify({
		    "moneda":$("#moneda").val(),
		    "monto":$("#monto").val(),
		    "ong":$("#idong").val(),
		    "tipoDonacion":$("#tipo").val(),
		    "descripcion":$("#descripcion").val(),});
	}
	else if(tipo === "2"){//bienes
		return JSON.stringify({
			"cantidad" : $("#cantidad").val(),
		    "fechaEntrega":$("#fechaEntrega").val(),
		    "ong":$("#idong").val(),
		    "tipoDonacion":$("#tipo").val(),
		    "descripcion":$("#descripcion").val(),});
	}
	else if(tipo === "3"){//servi
		return JSON.stringify({
			"comienzoServico":$("#comienzo").val(),
		    "FInalizacionServicio":$("#finalizacion").val(),
		    "hsServicio":$("#hsServicio").val(),
		    "ong":$("#idong").val(),
		    "tipoDonacion":$("#tipo").val(),
		    "descripcion":$("#descripcion").val(),});
	}
}
function Donar(){
	var url = "/Site/ong/donate";
	 
	 $.ajax({
	        url : url,
	        type : "POST",
	        cache : false,
	        async : false,
	        contentType : "application/json; charset=UTF-8",
	        data : jsonDataDonacion(),
	        datatype : "json",
	        success : function(data) {
	        	if(data==="onError"){
	        		$("#responseDonacion").html("Ocurrió un error sepa disculparnos, esperamos vuelva a intentarlo mas tarde.");
	        	}
	        	else{
	        		$("#responseDonacion").html("Su donación ah sido enviada con exito, en breve la ong se pondra en contacto para coordinar las acciones correspondiente.");
	        		cleanAll();
	        		setTimeout(function(){
	        			$("#responseDonacion").html("");
	            		$("#btnDonarClose").click();
	            	}, 8000);
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
}

var jsonDataLost = function(){
	return JSON.stringify({
	    "nombre":$("#nombre").val(),
	    "apellido":$("#apellido").val(),
	    "edad":$("#edad").val(),
	    "fechaDesaparicion":$("#fecha").val(),
	    "nombreContacto":$("#nombre_contacto").val(),
	    "relacionContacto":$("#Parentesco").val(),
	    "sexo":$("#sexo").val(),
	    "telefonoContacto":$("#telefono").val(),
	    "ultimoParadero":$("#paradero").val(),
	    "foto":$("#inputImgDesap").val()});
}

function LostReport(){
	var url = "/Site/lost/save";
	$.ajax({
        url : url,
        type : "POST",
        cache : false,
        async : false,
        contentType : "application/json; charset=UTF-8",
        data : jsonDataLost(),
        datatype : "json",
        success : function(data) {
        	if(data==="onError"){
        		$("#responseLost").html("Ocurrió un error sepa disculparnos, por favor vuelva a intentarlo mas tarde o comuniquece al 1122.");
        	}
        	else{
        		$("#responseLost").html("Su reporte se ah enviado con exito, en la brevedad nos comunicaremos con ud.");
        		cleanAll();
        		setTimeout(function(){
        			$("#responseLost").html("");
            		$("#btnLostClose").click();
            	}, 8000);
        	}
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + " : " + errorThrown);
        }
    });
	
}

function uploadPic(){
	$('#imageform').submit(function() {
		  // Enviamos el formulario usando AJAX
        $.ajax({
            type: 'POST',
            url: $(this).attr('action'),
            data: $(this).serialize(),
            success: function(data) {
            	if(data==="onError"){
            		//mensaje de error de carga
            	}
            	else{
            		$("#inputImgDesap").val(data);
            		$("#imgDesap").attr('src', 'data:image/jpeg;base64,'+data);
            	}
            }
        });        
        return false;
    }); 
}

