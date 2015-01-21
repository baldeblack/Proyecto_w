<!-- Modal Donar-->
	<script type="text/javascript">
		</script>
		<div class="modal fade" id="modalDonar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Donar</h4>
		        <h3 id="responseDonacion"></h3>
		      </div>
		      <input type="hidden" id="idong">
		      <div class="modal-body">		        
					<form role="form">
						<div class="form-group">
							<select id="tipo" placeholder="Seleccione estado" class="form-control input-lg" tabindex="1" onchange="showData()">
							  <option value="1">Econ&oacute;mica</option>
							  <option value="2">De bienes</option>
							  <option value="3">De servicios</option>
							</select>
						</div>
						<textarea id="descripcion" class="form-control" placeholder="Descripcion.." rows="3" tabindex="2"></textarea><br>
						<div class="form-group bienes">
							<input type="number"  name="cantidad" id="cantidad" class="form-control input-lg" placeholder="Cantidad" tabindex="3">
						</div>
						<div class="form-group bienes">
							<input type="date" name="fechaEntrega" id="fechaEntrega" class="form-control input-lg" placeholder="Fecha entrega" tabindex="4">
						</div>
						<div class="form-group eco">
							<select id="moneda" placeholder="Seleccione moneda" class="form-control input-lg" tabindex="3">
							  <option value="Dol">Dolares</option>
							  <option value="Pes">Pesos</option>
							  <option value="Eur">Euros</option>
							</select>
						</div>
						<div class="form-group eco">
							<input type="number" name="monto" id="monto" class="form-control input-lg" placeholder="Monto" tabindex="4">
						</div>
						<div class="form-group servi">
							<input type="number" name="hsServicio" id="hsServicio" class="form-control input-lg" placeholder="Hs de Servicio" tabindex="3">
						</div>
						<div class="form-group servi">
							<input type="date" name="comienzo" id="comienzo" class="form-control input-lg" placeholder="Comienzo servicio" tabindex="4">
						</div>
						<div class="form-group servi">
							<input type="date" name="finalizacion" id="finalizacion" class="form-control input-lg" placeholder="Finalización servicio" tabindex="5">
						</div>
					</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		        <button type="button" class="btn btn-warning" id="btnDonar">Donar</button>
		      </div>
		    </div>
		  </div>
		</div>