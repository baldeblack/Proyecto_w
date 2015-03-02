<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="navbar navbar-bright navbar-fixed-top navbar-proyecto" data-spy="affix" data-offset-top="1000">
  <div class="container">
			<div class="navbar-header">
			  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  
			  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse2">
				<span>Login</span>
			  </button>
			  <a href="#" class="navbar-brand">Home</a>
			</div>

			<nav class="collapse navbar-collapse" role="navigation">
			  <ul class="nav navbar-nav menu">
				<li>
				  <a href="#loc">Localizacion</a>
				</li>
				<li>
				  <a href="#desp">Desaparecidos</a>
				</li>
				<li>
				  <a href="#ong">ONG'S</a>
				</li>
				<li>
				  <a href="#cont">Contacto</a>
				</li>
			 </ul>
			</nav>
			<nav class="collapse navbar-collapse2" role="navigation">
			 
 				<c:if test="${empty sessionScope.active_user}">
				  	<ul class="nav navbar-right navbar-nav menu_login">
						<li class="dropdown">
					  		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user fa-lg"></i></a>
					  		<ul class="dropdown-menu" style="padding:12px;">
							  	<form class="form-horizontal" data-toggle="validator">
								  	<div class="row contenedor-form">
									  	<div class="col-xs-12 col-lg-12">
											<div class="form-group">
											    <div class="input-group">
											      <label class="sr-only" class="control-label" for="exampleInputEmail2">Correo</label>
											      <div class="input-group-addon">@</div>
											      <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email" required>
											      <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
               									  <!-- <div class="help-block with-errors"></div> -->
											    </div>
											</div>
										</div>
										<div class="col-xs-12 col-lg-12">
											<div class="form-group">
											  	<div class="input-group">
												    <label class="sr-only" class="control-label" for="exampleInputPassword2">Password</label>
												    <div class="input-group-addon">***</div>
												    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
													<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
               									    <!-- <div class="help-block with-errors"></div> -->
												</div>
											</div>
										</div>
									</div>
									<c:if test="${not empty sessionScope.catastrofe.apiFb}">
										<fb:login-button class="btn btn-facebook btn-lg" scope="public_profile,email" onlogin="checkLoginState();"> </fb:login-button>
						   			</c:if>
						   			<br><br>
								  	<button onclick="doLogin()"  class="btn btn-default bton-login">Iniciar Sesion</button>
									<a data-toggle="modal" class="pull-right bton-registrarse" data-target="#myModal">Registrarse</a>
								 </form>
					  		</ul>
						</li>
					 </ul>
				</c:if>	
				 <c:if test="${not empty sessionScope.active_user}">
					 <ul class="nav navbar-right navbar-nav menu_login">
					 	<!--  <li><h4 style="padding-top: 6px;">Bienvenid@ ${sessionScope.active_user_nick}</h3></li>-->
					 	<li><h4 style="font-size=12px;">Bienvenid@ ${sessionScope.active_user_nick}</h3></li>
					 	<li><a href="/Site/access/logOut" class="btn btn-link">Cerrar Sesion</a></li>	
					 </ul>
				 </c:if>
			 
			</nav>
		  </div>
</header>