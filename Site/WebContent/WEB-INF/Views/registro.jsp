<!-- Modal Registro-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Registro</h4>
		      </div>
		      <div class="modal-body">		        
					<form role="form">
						<!--<h2>Please Sign Up <small>It's free and always will be.</small></h2>-->

						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
			                        <input type="text" name="nombre_usuario" id="nombre_usuario" class="form-control input-lg" placeholder="Nombre" tabindex="1">
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="apellido_usuario" id="apellido_usuario" class="form-control input-lg" placeholder="Apellido" tabindex="2">
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" name="nick_usuario" id="nick_usuario" class="form-control input-lg" placeholder="Nick" tabindex="3">
						</div>
						<div class="form-group">
							<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4">
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="4">
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="5">
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="date" name="fecha_nacimiento" id="fecha_nacimiento" class="form-control input-lg" placeholder="" tabindex="6">
						</div>
						<div class="form-group">
							<input type="text" name="celular_usuario" id="celular_usuario" class="form-control input-lg" placeholder="Celular" tabindex="7">
						</div>
						<div class="form-group">
							<input type="text" name="direccion_usuario" id="direccion_usuario" class="form-control input-lg" placeholder="Direccion" tabindex="8">
						</div>
					</form>

		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		        <button type="button" class="btn btn-warning">Registrar</button>
		      </div>
		    </div>
		  </div>
		</div>