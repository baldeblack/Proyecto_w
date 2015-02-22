$( document ).ready(function() {
	
	$('#mail').on('keyup', function () {
		$('#lgnerror').hide();
	});

	$('#password').on('keyup', function () {
		$('#lgnerror').hide();
	});

	
	$('#loginbtn').click(function() {
			var mail = $('#mail').val();
			var pass = $('#password').val();
			
			doLogin(mail, pass, function(data) {
				if(data != null){
				  window.location.href = data;
				  }else{
					  $('#lgnerror').show();
				  }
			});
	});
	
	$(document).keypress(function(e) {
		  if(e.which == 13) {
			  var mail = $('#mail').val();
				var pass = $('#password').val();
				
				doLogin(mail, pass, function(data) {
					if(data != null){
					  window.location.href = data;
					  }else{
						  $('#lgnerror').show();
					  }
				});
		  }
		});

});


function doLogin(mail, pass, callback) {
	return $.ajax({
		url : '/BackOffice/dologin',
		type : 'POST',
		data : JSON.stringify({
			"mail" : mail,
			"pass" : pass
		}),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			callback(data);			
		},
		error : function(data, status, er) {
			$('#lgnerror').show();	
		}
	});
}

