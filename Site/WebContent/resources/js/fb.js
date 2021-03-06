// This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
    	mensaje("Error","Por favor loguese en la aplicación","error");
    	//alert('Please log ' + 'into this app.');
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
    	//alert('Please log ' + 'into Facebook.');
    	mensaje("Error","Por favor loguese en facebook","error")
    }
  }
  
  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }
  
  window.fbAsyncInit = function() {
	  FB.init({
	    appId      : $('#fbKey').val(),
	    cookie     : true,  // enable cookies to allow the server to access 
	                        // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.1' // use version 2.1
	  });
	  
	  FB.getLoginStatus(function(response) {
		    statusChangeCallback(response);
		  });
  };
  
  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  
  
  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
    	
      console.log('Successful login for: ' + response.name);
      Loginfb(response);
      //alert('Thanks for logging in, ' + response.name + '!' +response.first_name);
        
    });
  }
  
  function Loginfb(responsefb){
	  var sex  ="F"
		  if(responsefb.gender != "female")
			sex ="M";
	  var url = "/Site/access/logonfb";
	  $.ajax({
	        url : url,
	        type : "POST",
	        cache : false,
	        async : false,
	        contentType : "application/json; charset=UTF-8",
	        data : JSON.stringify({
	        	 "apellido" : responsefb.last_name,
	             "celular" : 'N/A',
	             "email":responsefb.email,
	             "nik" : responsefb.name,
	             "nombre" : responsefb.first_name,
	             "password" : 'FB',
	             "sexo" : sex,
	             "fechaNacimiento" : '01-01-1900',
	        }),
	        datatype : "json",
	        success : function(data) {
	        	 if(data==="success"){ 
	        		 location.reload();
		            }
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	        	mensaje("Error","No se pudo cargar la operación","error");
	            //alert(XMLHttpRequest.status + " : " + errorThrown);
	        }
	    });
  }
	 
