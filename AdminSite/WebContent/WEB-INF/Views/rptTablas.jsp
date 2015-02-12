<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script type="text/javascript" async="" src="http://www.google-analytics.com/ga.js"></script>
  <script id="twitter-wjs" src="http://platform.twitter.com/widgets.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="resources/reportes/tableExport.js"></script>
	<script type="text/javascript" src="resources/reportes/jquery.base64.js"></script>
	<script type="text/javascript" src="resources/reportes/html2canvas.js"></script>
	<script type="text/javascript" src="resources/reportes/sprintf.js"></script>
	<script type="text/javascript" src="resources/reportes/base64.js"></script>
	<script type="text/javascript" src="resources/reportes/jquery.dynatable.js"></script>
	 <script type="text/javascript" src="resources/reportes/jsapi.js"></script>
	 	 <script type="text/javascript" src="resources/reportes/jspdf.js"></script>
	 <script type="text/javascript" src="resources/reportes/jspdf.plugin.addhtml.js"></script>
	 <script type="text/javascript" src="resources/reportes/png.js"></script>
	 <script type="text/javascript" src="resources/reportes/zlib.js"></script>
    <script type="text/javascript" src="resources/reportes/jspdf.plugin.addimage.js"></script>
	 <script type="text/javascript" src="resources/reportes/jspdf.plugin.from_html.js"></script>
	  <script type="text/javascript" src="resources/reportes/jspdf.plugin.png_support.js"></script>
	   <script type="text/javascript" src="resources/reportes/jspdf.plugin.standard_fonts_metrics.js"></script>
	   <script type="text/javascript" src="resources/reportes/FileSaver.js"></script>
    <link rel="stylesheet" media="all" href="https://s3.amazonaws.com/dynatable-docs-assets/css/bootstrap-2.3.2.min.css" />
    
	    
    <link rel="stylesheet" media="all" href="https://s3.amazonaws.com/dynatable-docs-assets/css/jquery.dynatable.css" />
    <script type="text/javascript">
					
		var myRecords = JSON.parse('[{"IdTipoDonacion":2,"Cantidad":4545,"Moneda":"$","Monto":456456.00,"HsServicio":3,"Nombre":"Sandino","Apellido":"Fratti","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"}]');
		var myRecordsdos = JSON.parse('[{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"ertwrwr","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"sdfsdfs","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"sdasda","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"}]');
		var myRecordstres = JSON.parse('{"desaparecidos":4,"ongs":3,"pedidos":4,"usuarios":4}');
		
		jQuery(document).ready(function($) {	
		
			$('#clickinpt').click(function() {		
			 $('#radios input').each(function(){   
			 
					if($(this).is(':checked') == true){
						load($(this).attr('name'));
					}    	  	
				});
				
			});
			
					$("input:radio").click(function(){
				var current = $(this).attr('name');
			 $('#radios input').each(function(){    		  
					if($(this).attr('name') != current){
						$(this).attr('checked', false);
					}    	
				});
				
				if(current == 'usoRbt'){
				$('#exportdp').hide();
				$('#asimg').show();
				
				}else {
				$('#exportdp').show();
				$('#asimg').hide();
				}
			});
			
		});
	
		
		
		function load(name){
					
									if(name == 'donRbt'){
									
								//myRecords = JSON.parse('[{"IdTipoDonacion":2,"Cantidad":4545,"Moneda":"$","Monto":456456.00,"HsServicio":3,"Nombre":"Sandino","Apellido":"Fratti","Nombreong":"ongUnod","Email":"ongUno@gmail.com"},{"IdTipoDonacion":1,"Cantidad":3,"Moneda":"$","Monto":43.00,"HsServicio":3,"Nombre":"yenni","Apellido":"herr","Nombreong":"ongUnod","Email":"ongUno@gmail.com"}]');
										}else if(name == 'usoRbt'){
									//	myRecords = JSON.parse('{"idTenant":25,"coneccion":"rere","desaparecidos":85,"ongs":3,"pedidos":4,"usuarios":4}');
							
										}else if(name == 'pedRbt'){
									//	myRecords = JSON.parse('[{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"ertwrwr","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"sdfsdfs","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"sdasda","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"},{"TipoSolicitor":"Anonimo","Canal":"Web","Ubicacion":"en tu casa","Fecha":"2015/01/18"}]');
									}
									
if(name == 'donRbt'){

$('#vamo').empty();
		$('#vamo').append('<table id="customersdos" class="table table-bordered"><thead><tr></tr></thead><tbody></tbody></table>');
		var result = myRecords[0];	
			//	$('#customers thead tr').empty();
				//$('#customers tbody').empty();				
							for(key in result) {	
								inHeaddos(key);
							}
							
						for(i=0; i < myRecords.length; i++){
		
						inBody(myRecords[i]);	
							 
					 }
					$('#customersdos').dynatable();		
					$('#dynatable-query-search-customersdos').val('');
				var e = jQuery.Event("keypress");
e.which = 13; //choose the one you want
e.keyCode = 13;
$('#dynatable-query-search-customersdos').trigger(e);
$('#dynatable-per-page-customersdos').val(10).trigger('change');

		
}else if(name == 'pedRbt'){

		var result = myRecordsdos[0];	
		$('#vamo').empty();
		$('#vamo').append('<table id="customers" class="table table-bordered"><thead><tr></tr></thead><tbody></tbody></table>');
				//$('#customers thead tr').empty();
				//$('#customers tbody').empty();				
							for(key in result) {	
								inHead(key);
							}
							
						for(i=0; i < myRecordsdos.length; i++){
			
					 inBodyP(myRecordsdos[i]);					 
					
												
		}	
		$('#customers').dynatable();
			$('#dynatable-query-search-customers').val('');
			var e = jQuery.Event("keypress");
e.which = 13; //choose the one you want
e.keyCode = 13;
$('#dynatable-query-search-customers').trigger(e);
			$('#dynatable-per-page-customers').val(10).trigger('change');
}else if(name == 'usoRbt'){
var result = myRecordstres;	
		$('#vamo').empty();
				$('#vamo').append('<div id="chart_lines" style="width: 900px; height: 500px;"></div>');
drawChart(myRecordstres);
	
}
			
					
					
					
		 }
		 
		 
function drawChart() {
			//var datap = JSON.parse(obj);
			var datap = myRecordstres;	
        var data = new google.visualization.DataTable();
			data.addColumn('string', 'attr');
			data.addColumn('number', 'cantidad');
			//var result = datap[0];							
			for(key in datap) {
				if(key != 'idTenant' && key != 'coneccion' ){
					data.addRows([[key, datap[key]]]);
					
				}
			}

        var options = {
			width: 1000,
			height: 563,
			hAxis: {
			  title: 'General',
			  gridlines: {count: 10}
			},
			vAxis: {
			  title: 'Cantidad'
			}
		};
  
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_lines'));
		 google.visualization.events.addListener(chart, 'ready', function () {
       	$('#asimg').attr('href',chart.getImageURI());
		$('#asimg').attr("download", "uso")
		
		  var doc = new jsPDF();
    var imgData = chart.getImageURI();
    doc.setFontSize(40);
    doc.text(30, 20, 'Uso del sitio.');
    doc.addImage(imgData, 'PNG', 15, 40, 200, 114);
	doc.save('uso.pdf');
  

      });
        chart.draw(data, options);	
      }
	 google.load("visualization", "1", {packages:["corechart"]});
	
		
    function inHead(key){

		$('#customers thead tr').append('<th>' +key+ '</th>');
	  }
	  
	   function inHeaddos(key){

		$('#customersdos thead tr').append('<th>' +key+ '</th>');
	  }
	  
	  function inBody(key){	
		$('#customersdos tbody').append('<tr><td>' +key.IdTipoDonacion+ '</td><td>' +key.Cantidad+ '</td><td>' +key.Moneda+ '</td><td>' +key.Monto+ '</td><td>' +key.HsServicio+ '</td><td>' +key.Nombre+ '</td><td>' +key.Apellido+ '</td><td>' +key.Nombreong+ '</td><td>' +key.Email+ '</td></tr>');
	  }
	
	   function inBodyP(key){	
		$('#customers tbody').append('<tr><td>' +key.TipoSolicitor+ '</td><td>' +key.Canal+ '</td><td>' +key.Ubicacion+ '</td><td>' +key.Fecha+ '</td></tr>');
	  }
	  

	  	   function inBodyC(key, val){	
          $('#datatable tbody').append('<tr><th>'+key+'</th><td>'+val+'</td></tr>')
	  }
	  
	  function exportT(elem){
	  var id = $(elem).attr('id');
	  var dtid = $('#vamo table').attr('id');
	  if(id == 'epng'){
		$("#" + dtid).tableExport({type:'png',escape:'false'});
	  } 
	  else if(id == 'epdf'){
	  $("#" + dtid).tableExport({type:'pdf',escape:'false'});
	  } 
	  else if(id == 'exls'){
	  $("#" + dtid).tableExport({type:'excel',escape:'false'});
	
	  }
	  else if(id == 'ecsv'){
	  $("#" + dtid).tableExport({type:'csv',escape:'false'});
	
	  }
	  }
	
			</script>

	
  </head>
	
	
    <body>
		 <div id="contenedor_web">  			
								<div class="container-fluid">
									<div id="radios">
						<input type="radio" name="donRbt" value="m" checked="checked">Donaciones en el tiempo.<br>
						<input type="radio" name="pedRbt" value="fe">Pedido de ayuda en el tiempo<br>
						<input type="radio" name="usoRbt" value="fle">Uso sitio<br>
					</div>
						<div id="selectDiv">
						  <select id="select" name="Catastrofes">
									 <option value="g" selected="selected">General</option>
						
						 <option value="25">tsunanimedosa</option>					   
					
						
						 <option value="29">huracan</option>					   
					
						
						 <option value="30">incendio</option>					   
					
						
						 <option value="31">prueba final</option>					   
					
						
						 <option value="32">otra prueba</option>					   
					
						
						 <option value="34">bimbo site</option>					   
					
						
						 <option value="35">fgffggf</option>					   
					
						
						 <option value="36">Nombre </option>					   
					
						
						 <option value="37">SDFSDF</option>					   
					
						
						 <option value="38">inundacion montevideo</option>					   
					
						
						 <option value="39">madrid en llamas</option>					   
					
					
									   </select>
						</div>
						<div id="dateDiv">
							<input id="start" type="date" name="start" required >
							<input id="end" type="date" name="end" required >
						</div>
                    <div class="row">	
					<input id="clickinpt" type="submit" value="Generar" />						
                        <div class="col-md-12">
						
                            <div class="box">
					
                                <div class="box-body table-responsive" id='ptable'>																
									<div id="exportdp" class="btn-group">
										<button class="btn btn-warning btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i> Export Table Data</button>
										<ul class="dropdown-menu " role="menu">	
											<li><a id="ecsv" href="#" onClick ="exportT(this)"> <img src='resources/images/csv.png' width='24px'> CSV</a></li>							
											<li class="divider"></li>	
											<li><a id="exls" href="#" onClick ="exportT(this)"> <img src='resources/images/xls.png' width='24px'> XLS</a></li>							
											<li class="divider"></li>
											<li><a id="epng" href="#" onClick ="exportT(this)"> <img src='resources/images/png.png' width='24px'> PNG</a></li>
												<li class="divider"></li>
											<li><a id="epdf" href="#" onClick ="exportT(this)"> <img src='resources/images/pdf.png' width='24px'> PDF</a></li>
										</ul>
									</div>
									
									<a id="asimg" href="" >Link popup</a>
									<!--<a id="asimg" href="" target="_blank" onclick="window.open(this.href, this.target, "width=300,height=400"); return false;">Link popup</a>-->
					<div id="vamo">	
						</div>			
					
                                </div><!-- /.box-body -->
                               
                            </div><!-- /.box -->

                            
                        </div><!-- /.col -->
                        
                    </div>
				</div>
       	</div>
       
    </body>	
	
</html>