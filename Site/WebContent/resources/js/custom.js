
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
        	// alert("Bienvenido: "+ data);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest.status + " : " + errorThrown);
        }
    });
}

function AskHelp(){
	var url = '/help/ask';
    var username = $("#exampleInputEmail2").val();
    var password = $("#exampleInputPassword2").val();
    $.ajax({
        url : url,
        type : "POST",
        cache : false,
        async : true,
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify({
            "email" : username,
            "password" : password
        }),
        datatype : "json",
        success : function(data) {
            alert("Bienvenido: "+ data);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + " : " + errorThrown);
        }
    });
}

