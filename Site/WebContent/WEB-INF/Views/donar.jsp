<%@ page session="true"%>
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
					<form role="form" data-toggle="validator">
						<div class="form-group">
							<label>Estado</label>
							<select id="tipo" placeholder="Seleccione estado" class="form-control" tabindex="1" onchange="showData()" required>
							  <option value="1">Econ&oacute;mica</option>
							  <option value="2">De bienes</option>
							  <option value="3">De servicios</option>
							</select>
						</div>
						<div class="form-group">
							<label class="control-label" >Descripcion</label>
							<textarea id="descripcion" class="form-control" placeholder="Descripcion.." rows="3" tabindex="2" required></textarea><br>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->		
						</div>
						<div class="form-group bienes">
							<label class="control-label">Cantidad</label>
							<input type="number"  name="cantidad" id="cantidad" class="form-control" placeholder="" tabindex="3" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->		
						</div>
						<div class="form-group bienes">
							<label class="control-label">Fecha entrega</label>
							<input type="date" name="fechaEntrega" id="fechaEntrega" class="form-control" placeholder="" tabindex="4" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->		
						</div>
						<div class="form-group eco">
							<label class="control-label">Moneda</label>
							<select id="moneda" placeholder="Seleccione moneda" class="form-control" tabindex="3" required>
							  <option value="Dol">Dolares</option>
							  <option value="Pes">Pesos</option>
							  <option value="Eur">Euros</option>
							</select>
						</div>
						<div class="form-group eco">
								para realizar una donaci&oacute;n economica, puede indicar el monto y precionar donar, con lo cual un agente de la Ong se estar&aacute; contactando con ud.
								o simplemente si cuenta con una cuenta pay pal debe presionar el boton de "Donate" pay pal y realizar la transferencia automatica de dinero.
								desde ya le estamos agradecidos.
						</div>
						<div class="form-group eco">
							
						
							<label class="control-label">Monto</label>
							<input type="number" name="monto" id="monto" class="form-control" placeholder="" tabindex="4" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->		
						</div>
						
						<div class="form-group servi">
							<label class="control-label">Hs de Servicio</label>
							<input type="number" name="hsServicio" id="hsServicio" class="form-control" placeholder="" tabindex="3" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->								
						</div>
						<div class="form-group servi">
							<label class="control-label">Comienzo servicio</label>
							<input type="date" name="comienzo" id="comienzo" class="form-control" placeholder="" tabindex="4" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->		
						</div>
						<div class="form-group servi">
							<label class="control-label">Finalización servicio</label>
							<input type="date" name="finalizacion" id="finalizacion" class="form-control" placeholder="" tabindex="5" required>
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                			<!-- <div class="help-block with-errors"></div> -->						
						</div>
					</form>
					<div class="form-group eco">
						<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
							<input type="hidden" name="cmd" value="_donations">
							<input type="hidden" name="business" value="JGS9UFT3MLTHN">
							<input type="hidden" name="lc" value="AL">
							<input type="hidden" name="item_name" value="${sessionScope.catastrofe.nombre}">
							<input type="hidden" name="no_note" value="0">
							<input type="hidden" name="cn" value="Dar instrucciones especiales al vendedor:">
							<input type="hidden" name="no_shipping" value="1">
							<input type="hidden" name="currency_code" value="USD">
							<input type="hidden" name="bn" value="PP-DonationsBF:btn_donateCC_LG.gif:NonHosted">
							<input type="image" src="https://www.paypalobjects.com/es_XC/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
							<img alt="" border="0" src="https://www.paypalobjects.com/es_XC/i/scr/pixel.gif" width="1" height="1">
						</form>
						
						</div>
						
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnDonarClose">Cerrar</button>
		        <button type="button" class="btn btn-warning" onclick="Donar()">Donar</button>
		      </div>
		    </div>
		  </div>
		</div>