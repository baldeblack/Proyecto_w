
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