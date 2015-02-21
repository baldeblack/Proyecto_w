<!-- Modal Registro-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Registro</h4>
		      </div>
		      <div class="modal-body">		        
					<form role="form" data-toggle="validator">
						<h2 id="responseReg"></h2>
						<div class="row">
							<div class="col-xs-12 ">
								<div class="form-group">
									<label class="control-label" for="nombre_usuario">Nombre</label>
			                        <input type="text" name="nombre_usuario" id="nombre_usuario" class="form-control" placeholder=" " tabindex="1" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							
							
								<div class="form-group">
									<label class="control-label" for="apellido_usuario" >Apellido</label>
									<input type="text" name="apellido_usuario" id="apellido_usuario" class="form-control" placeholder=" " tabindex="2" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							
							
								<div class="form-group">
									<label class="control-label" for="nick_usuario">Nick</label>
									<input type="text" name="nick_usuario" id="nick_usuario" class="form-control" placeholder="" tabindex="3" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							
							
								<div class="form-group">
									<label class="control-label" for="email" >Email</label>
									<input type="email" name="email" id="email" class="form-control" placeholder="john_doe@example.com" tabindex="4" required>
								    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							


							
								<div class="form-group">
									<label class="control-label" for="password">Password</label>
									<input type="password" name="password" id="password" class="form-control" placeholder=" " tabindex="4" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							
								<div class="form-group">
									<label class="control-label" for="password_confirmation">Confirmacion Password</label>
									<input type="password" name="password_confirmation" id="password_confirmation" class="form-control" placeholder=" " tabindex="5" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
	
								<div class="form-group">
									<label class="control-label" for="fecha_nacimiento">Fecha de nacimiento</label>
									<input type="date" name="fecha_nacimiento" id="fecha_nacimiento" class="form-control" placeholder="" tabindex="6" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
				
								<div class="form-group">
									<label class="control-label" for="sexo_usuario">Sexo</label>
									<select  id="sexo_usuario" class="form-control" tabindex="7" required>
										<option value="F" selected="selected">Femenino</option>
										<option value="M">Masculino</option>
										<option value="O">Otro</option>
									</select>
									<!-- <span class="glyphicon form-control-feedback" aria-hidden="true"></span> -->
                					<!-- <div class="help-block with-errors"></div> -->
								</div>													
							


							
								<div class="form-group">
									<label class="control-label" for="celular_usuario">Celular</label>
									<input type="text" name="celular_usuario" id="celular_usuario" class="form-control" placeholder=" " tabindex="7" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>
							
								<div class="form-group">
									<label class="control-label" for="direccion_usuario">Direccion</label>
									<input type="text" name="direccion_usuario" id="direccion_usuario" class="form-control" placeholder=" " tabindex="8" required>
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                					<!-- <div class="help-block with-errors"></div> -->
								</div>	
							</div>
							
						</div>


					</form>

		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal" id="closeReg">Cerrar</button>
		        <button type="button" class="btn btn-warning" onclick="RegistUser()">Registrar</button>
		      </div>
		    </div>
		  </div>
		</div>