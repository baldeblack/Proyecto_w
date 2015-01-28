<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Modal Desaparecidos -->
		<div class="modal fade" id="modalDesp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Reportar Desaparecido</h4>
				<h3 id="responseLost"></h3>
		      </div>
		      <div class="modal-body">
		      		<div role="tabpanel">
		      		  <!-- Nav tabs -->
					  <ul class="nav nav-tabs" role="tablist">
					    <li role="presentation" class="active"><a href="#persona" aria-controls="persona" role="tab" data-toggle="tab">Persona</a></li>
					    <li role="presentation"><a href="#imagen" aria-controls="imagen" role="tab" data-toggle="tab">Foto</a></li>
					    <li role="presentation"><a href="#contacto" aria-controls="contacto" role="tab" data-toggle="tab">Contacto</a></li>
					  </ul><br>
					  <!-- Tab panes -->
					  <div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="persona">
					    	<form role="form">
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
					                        <input type="text" name="nombre" id="nombre" class="form-control input-lg" placeholder="Nombre" tabindex="1">
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<input type="text" name="apellido" id="apellido" class="form-control input-lg" placeholder="Apellido" tabindex="2">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<input type="number" name="edad" id="edad" class="form-control input-lg" placeholder="Edad" tabindex="3">
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<select  id="sexo" class="form-control input-lg" tabindex="4">
											<option value="F" selected="selected">Femenino</option>
											<option value="M">Masculino</option>
											<option value="O">Otro</option>
										</select>
									</div>
									</div>
								</div>
								<div class="form-group">
									<input type="date" name="fecha" id="fecha" class="form-control input-lg" placeholder="Fecha creacion" tabindex="5">
								</div>
								<div class="form-group">
									<input type="text" name="paradero" id="paradero" class="form-control input-lg" placeholder="UltimoParadero" tabindex="6">
								</div>
												
							</form>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="contacto">
							<form role="form-horizontal">
								<div class="form-group">
									<input type="text" name="nombre_contacto" id="nombre_contacto" class="form-control input-lg" placeholder="Nombre contacto" tabindex="1">
								</div>
								<div class="form-group">
									<input type="text" name="telefono" id="telefono" class="form-control input-lg" placeholder="Telefono contacto" tabindex="4">
								</div>
								<div class="form-group">
									<!--<input type="text" name="phone" id="phone" class="form-control input-lg" placeholder="Email Address" tabindex="4">-->

									<!--<input type="text" name="estado" id="estado" class="form-control input-lg" placeholder="Estado" tabindex="6">-->
									<select name="Parentesco" id="Parentesco" placeholder="Seleccione estado" class="form-control input-lg" tabindex="6">
									  <option>Padre/Madre</option>
									  <option>Hermanos</option>
									  <option>Pareja</option>
									  <option>Otros</option>
									</select>
								</div>
							</form>
					    </div>
						<div role="tabpanel" class="tab-pane" id="imagen">
							<input type="hidden" id="inputImgDesap"/>
								<form id="imageform" method="post" enctype="multipart/form-data" role="form-horizontal">
									<div class="form-group">
										<input type="file" name="file" id="file"/>
									</div>
									<div class="form-group">
										<div class="color_small">Formatos soportados (jpeg,jpg,gif,bmp,png) </div>
									</div>
									<div class="row">
									<div class="col-xs-6 col-md-6">
									    <a href="#" class="thumbnail">
									    	<img id="imgDesap" alt="...">
									    </a>
									</div>
									</div>
									<button class="btn btn-default" onclick="uploadPic();">Cargar</button>
								</form>
					    </div>
					  </div>
					</div>		        
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnLostClose">Cerrar</button>
		        <button type="button" class="btn btn-warning">Reportar</button>
		      </div>
		    </div>
		  </div>
		</div>