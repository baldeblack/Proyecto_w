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
					    	<form role="form" data-toggle="validator">
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<label class="control-label" for="nombre">Nombre</label>
					                        <input type="text" name="nombre" id="nombre" class="form-control" placeholder="" tabindex="1" required>
											<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                							<!-- <div class="help-block with-errors"></div> -->
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<label class="control-label">Apellido</label>
											<input type="text" name="apellido" id="apellido" class="form-control" placeholder="" tabindex="2" required>
											<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                							<!-- <div class="help-block with-errors"></div> -->
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<label class="control-label">Edad</label>
											<input type="number" name="edad" id="edad" class="form-control" placeholder="" tabindex="3" required>
											<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                							<!-- <div class="help-block with-errors"></div> -->
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<label class="control-label">Sexo</label>
										<select  id="sexo" class="form-control" tabindex="4">
											<option value="F" selected="selected">Femenino</option>
											<option value="M">Masculino</option>
											<option value="O">Otro</option>
										</select>
										<!-- <span class="glyphicon form-control-feedback" aria-hidden="true"></span> -->
               							<!-- <div class="help-block with-errors"></div> -->
									</div>
									</div>
								</div>
								<div class="form-group">
									<label>Fecha creacion</label>
									<input type="date" name="fecha" id="fecha" class="form-control" placeholder="" tabindex="5" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
              						<!-- <div class="help-block with-errors"></div> -->
								</div>
								<div class="form-group">
									<label>Ultimo paradero</label>
									<input type="text" name="paradero" id="paradero" class="form-control" placeholder="" tabindex="6" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
              						<!-- <div class="help-block with-errors"></div> -->								
								</div>
												
							</form>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="contacto">
							<!-- <form role="form-horizontal"> -->
								<div class="form-group">
									<label>Nombre contacto</label>
									<input type="text" name="nombre_contacto" id="nombre_contacto" class="form-control" placeholder="" tabindex="1" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
              						<!-- <div class="help-block with-errors"></div> -->
								</div>
								<div class="form-group">
									<label>Telefono contacto</label>
									<input type="text" name="telefono" id="telefono" class="form-control" placeholder="" tabindex="4" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
              						<!-- <div class="help-block with-errors"></div> -->
								</div>
								<div class="form-group">
									<!--<input type="text" name="phone" id="phone" class="form-control input-lg" placeholder="Email Address" tabindex="4">-->

									<!--<input type="text" name="estado" id="estado" class="form-control input-lg" placeholder="Estado" tabindex="6">-->
									<label>Parentesco</label>
									<select name="Parentesco" id="Parentesco" placeholder="Seleccione estado" class="form-control" tabindex="6">
									  <option value="1">Padre/Madre</option>
									  <option value="2">Hermanos</option>
									  <option value="3">Pareja</option>
									  <option value="4">Otros</option>
									</select>
									<!-- <span class="glyphicon form-control-feedback" aria-hidden="true"></span>  -->
              						<!-- <div class="help-block with-errors"></div> -->
								</div>
							<!-- </form>-->
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
		        <button type="button" class="btn btn-warning" onclick="LostReport()">Reportar</button>
		      </div>
		    </div>
		  </div>
		</div>