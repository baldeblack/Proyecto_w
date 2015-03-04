<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>
<!-- Modal Ayuda-->
<div class="modal fade" id="modalOng" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header panel-heading">
        <button type="button" class="close" data-dismiss="modal" id="closeModal"><i class="glyphicon glyphicon-remove"></i><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Alta ONG</h4>        
        <h3 id="responseOng"></h3>
      </div>
   
		<div class="modal-body">
		      <div class="row">
			<div class="col-md-12"><br>
		            <div class="panel panel-primary ani_panel animated bounceInUp">
		                <div class="panel-heading"></div>
		                <div class="panel-body">
		                <form id="loginForm" method="post" data-toggle="validator" role="form">
		                	<div class="col-md-6">		            
		                      <div class="form-group">
		                        <label for="nombre" class="control-label">Nombre</label>
		                        <input id="nombre" class="form-control" required/>
							 <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>
		                      </div>
		                      <div class="form-group">
		                        <label for="email" class="control-label">Mail</label>
		                        <input id="email" type="text" class="form-control" required/>
		                     <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>
		                      </div>
		                    </div>
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="web" class="control-label">Web</label>		                 
		                        <input id="web" type="text" class="form-control" required/>
		                   <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>
		                      </div>
		                      <div class="form-group">
		                        <label for="tel" class="control-label">Telefono</label>
		                        <input id="telefono" type="text" class="form-control" required/>	
		                         <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>	                      
		                      </div>
		                    </div>
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="direccion" class="control-label">Direccion</label>
		                            <input id="direccion" type="text" class="form-control" required/>
		                             <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>
		                      </div>
		                 
		                      <div class="form-group">
		                        <label for="pay" class="control-label">Datos PayPal</label>
		                              <input id="datosPayPal" type="text" class="form-control" required/>	
		                               <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>	                        
		                      </div>
		                    </div>
		                    
		                    <div class="col-md-6">
		                      <div class="form-group">
		                        <label for="origen" class="control-label">Origen</label>
		                             <input id="origen" type="text" class="form-control" required/>	
		                              <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						           <div class="help-block with-errors"></div>	                      
		                      </div>		                    
		                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-3">
                            <button type="submit" class="btn btn-default">Login</button>
                        </div>
                    </div>	 
                         </div>                  
		     </form> 
		                </div>
		            </div>
		        </div>
		        </div>
		</div>
		<div class="modal-footer">
		     <button type="button" class="btn btn-default" data-dismiss="modal" tabindex="5">Crear</button>
		</div>

    </div>
  </div>
</div>
