
/********************************/
/**************LOGIN*************/
/********************************/

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
	        		alert("Usuario o contrase&ntilde;a no válida.");
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

function doLogin() {
    var username = $("#exampleInputEmail2").val();
    var password = $("#exampleInputPassword2").val();
    login(username,password);
}

/********************************/
/**************AYUDA*************/
/********************************/
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

$("#closeModal").click(function(){
	$("#responseHelp").html("");
	$('#typeRequest').val(1);
	$('#message').val("");
	$('#ubicacion_ayuda').val("");
	$('#tel_ayuda').val("");
});

/********************************/
/************REGISTRO***********/
/********************************/
var validateReg = function(){
	var error = false;
	if($('#password').val() !=$('#password_confirmation').val()){
		error = true;
		alert("La contraseña y su confirmaci&oacute;n no coinciden.")
	}
	if( $('#nombre_usuario').val() == "")
	{
		alert("El nombrre es requerido.")
		error = true;
	}
	if( $('#apellido_usuario').val() == "")
	{
		alert("El apellido es requerido.")
		error = true;
	}
	if( $('#email').val() == "")
	{
		alert("El mail es requerido.")
		error = true;
	}
	if( $('#nick_usuario').val() == "")
	{
		alert("El nick es requerido.")
		error = true;
	}
	if( $('#password').val() == "")
	{
		alert("La contraseña es requerida.")
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

/********************************/
/*************DONACION***********/
/********************************/

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
	        		$("#responseDonacion").html("Ocurri&oacute; un error sepa disculparnos, esperamos vuelva a intentarlo mas tarde.");
	        	}
	        	else{
	        		$("#responseDonacion").html("Su donaci&oacute;n ah sido enviada con exito, en breve la ong se pondra en contacto para coordinar las acciones correspondiente.");
	        		cleanAll();
	        		setTimeout(function(){
	            		$("#btnDonarClose").click();
	            	}, 8000);
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
}

$("#btnDonarClose").click(function(){
	$("#responseDonacion").html("");
	cleanAll();
});
/********************************/
/**********DESAPARECIDOS*********/
/********************************/

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

var cleanLostData= function(){
	 $("#nombre").val("");
	 $("#apellido").val("");
	 $("#edad").val("");
	 $("#fecha").val("");
	 $("#nombre_contacto").val("");
	 $("#Parentesco").val(1);
	 $("#sexo").val("F");
	 $("#telefono").val("");
	 $("#paradero").val("");
	 $("#inputImgDesap").val("");
	 $("#imgDesap").attr('src', '');
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
	        		$("#responseLost").html("Ocurri&oacute; un error sepa disculparnos, por favor vuelva a intentarlo mas tarde o comuniquece al 1122.");
	        	}
	        	else{
	        		$("#responseLost").html("Su reporte se ah enviado con exito, en la brevedad nos comunicaremos con ud.");
	        		cleanLostData();
	        		setTimeout(function(){
	            		$("#btnLostClose").click();
	            		 location.reload();
	            	}, 8000);
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	
}

function uploadPic(){
	$("#imageform").submit(function (e) {
	    e.preventDefault();
	    $.ajax({
	        url: '/Site/lost/upload',
	        data: new FormData($(this)[0]),
	        cache: false,
	        contentType: false,
	        processData: false,
	        type: 'POST',
	        success: function (data) {
	        	if(data==="onError"){
	        		//mensaje de error de carga
	        		alert("fallo");
	        	}
	        	else{
	        		$("#inputImgDesap").val(data);
	        		$("#imgDesap").attr('src', 'data:image/jpeg;base64,'+data);
	        	}
	        }
	    }); 
	});	
}

$("#btnLostClose").click(function(){
	$("#responseLost").html("");
	cleanLostData();
});


