<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<div class="modal fade" id="modalUsuario" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header panel-heading">
				<button type="button" class="close" data-dismiss="modal"
					id="closeModal">
					<i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="modalLabel">Alta Usuario</h4>
				<h3 id="responseUsu"></h3>
			</div>

			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<br>
					
								<form id="usuarioForm" method="post" data-toggle="validator"
									role="form">
									<div class="col-md-6">
										<div class="form-group">
											<label for="nombreu" class="control-label">Nombre</label> <input
												id="nombreu" class="form-control" required /> <span
												class="glyphicon form-control-feedback" aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
										<div class="form-group">
											<label for="apellidou" class="control-label">Apellido</label>
											<input id="apellidou" type="text" class="form-control"
												required /> <span class="glyphicon form-control-feedback"
												aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
									
										<div class="form-group">
											<label for="nick" class="control-label">Nick</label> <input
												id="nick" type="text" class="form-control" required /> <span
												class="glyphicon form-control-feedback" aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
										<div class="form-group">
											<label for="emailu" class="control-label">Mail</label> <input
												id="emailu" type="text" class="form-control" required /> <span
												class="glyphicon form-control-feedback" aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
				
										<div class="form-group">
										<label for="pass" class="control-label">Contraseña</label> <input
											id="pass" type="password" class="form-control" required /> <span
											class="glyphicon form-control-feedback" aria-hidden="true"></span>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
											<label for="celular" class="control-label">Celular</label> <input
												id="celular" type="text" class="form-control" required /> <span
												class="glyphicon form-control-feedback" aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="direccionu" class="control-label">Direccion</label>
											<input id="direccionu" type="text" class="form-control"
												required /> <span class="glyphicon form-control-feedback"
												aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>
										<div class="form-group">
											<label for="sexo" class="control-label">Sexo</label> <select
												id="sexo" class="form-control">
												<option value="M" selected="true">MASCULINO</option>
												<option value="F">FEMENINOD</option>
											</select>
										</div>
									
										<div class="form-group">
											<label for="nacimiento">Fecha de Nacimiento</label> <input
												type="date" id="nacimiento" class="form-control" required />
											<span class="glyphicon form-control-feedback"
												aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>	
											<div class="form-group">
											<label for="tiposrescatistas">Tipo Rescatista</label> <select
												id="tiposrescatistas" class="form-control">

											</select>
										</div>									
									</div>
																		
									<div class="col-lg-12 form-group">
										<div class="col-xs-5 col-xs-offset-3">
											<button type="submit" class="btn btn-default">Crear</button>
										</div>
									</div>
									
								</form>

					</div>
				</div>
			</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal"
				tabindex="5">Cerrar</button>
		</div>
	</div>
	</div>
</div>

