
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
	        		mensaje("Login","Usuario o contraseña no válida","error");
	        		//alert("Usuario o contrase&ntilde;a no válida.");
	        	}
	        	else{
	        		 location.reload();
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
	            mensaje("Error","No se pudo realizar la operacion","error");
	        }
	    });
}

function doLogin() {
    var username = $("#exampleInputEmail2").val();
    var password = $("#exampleInputPassword2").val();
    if(username == ""){
    	$("#exampleInputEmail2").addClass("has-error has-feedback");
    }
    if (password == ""){
    	$("#exampleInputPassword2").addClass("has-error has-feedback");
    }
    
    if(username != "" && password != "")
    	login(username,password);
}

/********************************/
/**************AYUDA*************/
/********************************/
function SendHelp(){
	if(validateHelp()){
		
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
		            	$("#responseHelp").html("Hubo un error al procesar su solicitud por favor vuelva a intentarlo o comuniquece telefonicaemte");
		            	setTimeout(function(){
		            		$("#responseHelp").html("");
		            	}, 8000);
		            	
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	        	mensaje("Error","No se pudo realizar la operacion","error");
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	}
}

$("#closeModal").click(function(){
	$("#responseHelp").html("");
	$('#typeRequest').val(1);
	$('#message').val("");
	$('#ubicacion_ayuda').val("");
	$('#tel_ayuda').val("");
	$("input").removeClass("has-error has-feedback");
});

var validateHelp = function(){
	var error = false;
	
	if($('#message').val() == ""){
		error = true;
		$("#message").addClass("has-error has-feedback");
	}
	if($('#ubicacion_ayuda').val()==""){
		error = true;
		$("#ubicacion_ayuda").addClass("has-error has-feedback");
	}
	if($('#tel_ayuda').val()==""){
		error = true;
		$("#tel_ayuda").addClass("has-error has-feedback");
	}
	return !error;
}

/********************************/
/************REGISTRO***********/
/********************************/
var validateReg = function(){
	var error = false;
	if($('#password').val() !=$('#password_confirmation').val()){
		error = true;
		$('#password').addClass("has-error has-feedback");
		$('#password_confirmation').addClass("has-error has-feedback");
		
		//alert("La contraseña y su confirmaci&oacute;n no coinciden.")
		mensaje("Valdación","La contraseña y su confirmación no coinciden.","warning");
	}
	if( $('#nombre_usuario').val() == "")
	{
		$('#nombre_usuario').addClass("has-error has-feedback");
		error = true;
	}
	if( $('#apellido_usuario').val() == "")
	{
		$('#apellido_usuario').addClass("has-error has-feedback");
		error = true;
	}
	if( $('#email').val() == "")
	{
		$('#email').addClass("has-error has-feedback");
		error = true;
	}
	if( $('#nick_usuario').val() == "")
	{
		$('#nick_usuario').addClass("has-error has-feedback");
		error = true;
	}
	if( $('#password').val() == "")
	{
		$('#password').addClass("has-error has-feedback");
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
		            	$("#responseReg").html("Hubo un error al procesar su solicitud por favor vuelva a intentarlo o comuniquece telefonicamente.");
		            	setTimeout(function(){
		            		$("#responseReg").html("");
		            	}, 8000);
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	        	mensaje("Error","No se pudo completar la operación","error");
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
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
        	mensaje("Error","No se pudo completar la operacion","error");
        	//alert("error Ongs: "+data+" status: "+status+" er:"+er);
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
	$("input").removeClass("has-error has-feedback");
	
}

var cleanEco = function(){
	$("#moneda").val("Dol");
	$("#monto").val("");
	$("input").removeClass("has-error has-feedback");
}


var cleanServi = function(){
	$("#hsServicio").val("");
	$("#comienzo").val("");
	$("#finalizacion").val("");
	$("input").removeClass("has-error has-feedback");
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
	
	if(validateDonacion()){
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
	        	mensaje("Error","No se pudo completar la operación","error");
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	}
}

var validateDonacion = function(){
	var error = false;
	var tipo = $("#tipo").val();
	if(tipo === "1"){//eco
		if($("#moneda").val() == ""){
			error = true;
			$('#moneda').addClass("has-error has-feedback");
		}
		if($("#monto").val() == ""){
			error = true;
			$('#monto').addClass("has-error has-feedback");
		}
		if($("#descripcion").val() ==  ""){
			error = true;
			$('#descripcion').addClass("has-error has-feedback");
		}
	}
	else if(tipo === "2"){//bienes
		if($("#cantidad").val() ==  ""){
			error = true;
			$('#cantidad').addClass("has-error has-feedback");
		}
		if($("#fechaEntrega").val() == ""){
			error = true;
			$('#fechaEntrega').addClass("has-error has-feedback");
		}
		if($("#descripcion").val() == ""){
			error = true;
			$('#descripcion').addClass("has-error has-feedback");
		}
	}
	else if(tipo === "3"){//servi
		if($("#comienzo").val() ==""){
			error = true;
			$('#comienzo').addClass("has-error has-feedback");
		}
		if($("#finalizacion").val() ==""){
			error = true;
			$('#finalizacion').addClass("has-error has-feedback");
		}
		if($("#hsServicio").val() ==""){
			error = true;
			$('#hsServicio').addClass("has-error has-feedback");
		}
		if($("#descripcion").val()==""){
			error = true;
			$('#descripcion').addClass("has-error has-feedback");
		}
	}
	return !error;
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
        	mensaje("Error","No se pudo completar la operación","error");
        	//alert("error Lost: "+data+" status: "+status+" er:"+er);
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

var validateLost = function(){
	
	var error = false;
	if($("#nombre").val() ==""){
		error = true;
		$('#nombre').addClass("has-error has-feedback");
	}
	if($("#apellido").val()==""){
		error = true;
		$('#apellido').addClass("has-error has-feedback");
	}
	if($("#edad").val() ==""){
		error = true;
		$('#edad').addClass("has-error has-feedback");
	}
	if($("#fecha").val()==""){
		error = true;
		$('#fecha').addClass("has-error has-feedback");
	}
	if($("#nombre_contacto").val()==""){
		error = true;
		$('#nombre_contacto').addClass("has-error has-feedback");
	}
	if($("#telefono").val()==""){
		error = true;
		$('#telefono').addClass("has-error has-feedback");
	}
	if($("#paradero").val()==""){
		error = true;
		$('#paradero').addClass("has-error has-feedback");
	}
	if($("#inputImgDesap").val() ==""){
		error = true;
		$('#file').addClass("has-error has-feedback");
	}
	
	return !error;
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
	 $("input").removeClass("has-error has-feedback");
}

function LostReport(){

	if(validateLost()){
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
	        		$("#responseLost").html("Ocurri&oacute; un error sepa disculparnos, por favor vuelva a intentarlo mas tarde o comuniquece telefonicamente.");
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
	        	mensaje("Error","No se pudo completar la operación","error");
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
	}
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
	        		mensaje("Error","Error al cargar la imagen","error");
	        		//alert("fallo");
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


