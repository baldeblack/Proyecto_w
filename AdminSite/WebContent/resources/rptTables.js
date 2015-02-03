var flag = true;
	var json = '[{"id": "g", "ongs": 1,"ayuda": 2,"desaparecidos": 3,"usuarios": 4}, {"id": "g", "ongs": 5,"ayuda": 6,"desaparecidos": 7,"usuarios": 8}, {"id": "g","ongs": 9,"ayuda": 10,"desaparecidos": 11,"usuarios": 12}]';
	var jsondos = '[{"id": "0", "ongs": 13,"ayuda": 14,"desaparecidos": 15,"usuarios": 16}, {"id": "0", "ongs": 17,"ayuda": 18,"desaparecidos": 19,"usuarios": 20}, {"id": "0","ongs": 21,"ayuda": 22,"desaparecidos": 23,"usuarios": 24}]';

	var jsonp = '[{"id": "g", "ongs": 1,"ayuda": 2,"desaparecidos": 3}, {"id": "g", "ongs": 5,"ayuda": 6,"desaparecidos": 7}, {"id": "g","ongs": 9,"ayuda": 10,"desaparecidos": 11}]';
	var jsondosp = '[{"id": "0", "ongs": 13,"ayuda": 14,"desaparecidos": 15}, {"id": "0", "ongs": 17,"ayuda": 18,"desaparecidos": 19}, {"id": "0","ongs": 21,"ayuda": 22,"desaparecidos": 23}]';
	var graf = '[{"idTenant":25,"coneccion":"rere","desaparecidos":3,"ongs":3,"pedidos":3,"usuarios":3}]';
	
	var isGraf = false;
	 function initialize () {		
				var name;
			$('#clickinpt').click(function() {		
			 $('#radios input').each(function(){   
			 
					if($(this).is(':checked') == true){
						name = $(this).attr('name');
					}    	  	
				});
				
			
		
				if(name == 'donRbt'){
						$('#divTable').empty();
						$('#divTable').append('<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"><thead><tr></tr></thead><tfoot><tr></tr></tfoot><tbody></tbody></table>')		
						
						LoadDon($("#select").val(), $('#start').val(), $('#end').val(), function(data) {
							drawTable(data, name);							
						});		
						
						isGraf = false;
						
							}else if(name == 'usoRbt'){
							isGraf = true;
							$('#divTable').empty();
							$('#divTable').append('<div id="chart_lines" style="width: 900px; height: 500px;"></div>');
							
						LoadGrafica($("#select").val(), function(data) {
							drawChart(data);						
						});
						
					
							}else if(name == 'pedRbt'){
								
							$('#divTable').empty();
						$('#divTable').append('<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"><thead><tr></tr></thead><tfoot><tr></tr></tfoot><tbody></tbody></table>')		
							
						LoadAyuda($("#select").val(), $('#start').val(), $('#end').val(), function(data) {
							drawTable(data, name);							
						});	
						
						isGraf = false;							
					 }
		if(isGraf == false){
			

				}
				});
		
			
					$("input:radio").click(function(){
				var current = $(this).attr('name');
			 $('#radios input').each(function(){    		  
					if($(this).attr('name') != current){
						$(this).attr('checked', false);
					}    	
				});
	
			});	
		}
		
		function drawTable(obj, name) {			
			//var datap = JSON.parse(obj);
			var datap = obj;	
			
		var result = datap[0];			
				for(key in result) {	
					inHead(key);
					inFoot(key);
				}
		  
			for(i=0; i < datap.length; i++){
			if(name == 'donRbt'){
						inBody(datap[i]);	
					}else if(name == 'pedRbt'){
					 inBodyP(datap[i]);					 
					 }
												
		}	
		
			var table = $('#example').DataTable({
		        "language": 
		        {
		        	"sProcessing":     "Procesando...",
		        	"sLengthMenu":     "Mostrar _MENU_ registros",
		        	"sZeroRecords":    "No se encontraron resultados",
		        	"sEmptyTable":     "Ningun dato disponible en esta tabla",
		        	"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		        	"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
		        	"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
		        	"sInfoPostFix":    "",
		        	"sSearch":         "Buscar:",
		        	"sUrl":            "",
		        	"sInfoThousands":  ",",
		        	"sLoadingRecords": "Cargando...",
		        	"oPaginate": {
		        		"sFirst":    "Primero",
		        		"sLast":     "Ultimo",
		        		"sNext":     "Siguiente",
		        		"sPrevious": "Anterior"
		        	},
		        	"oAria": {
		        		"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		        		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
		        	}
		        }});
					var tt = new $.fn.dataTable.TableTools( table );
				 
					$( tt.fnContainer() ).insertBefore('div.dataTables_wrapper');
					
					var ttInstances = TableTools.fnGetMasters();

					for (i in ttInstances) {						 
						ttInstances[i].fnResizeButtons();
					}
	  }
	  
	  function drawChart(obj) {
			//var datap = JSON.parse(obj);
			var datap = obj;	
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
        chart.draw(data, options);	
      }
	  google.setOnLoadCallback(initialize);
	  google.load("visualization", "1", {packages:["corechart"]});
	  
	    function inHead(key){
		$('#example thead tr').append('<th>' +key+ '</th>');
	  }
	
	  function inFoot(key){	  
		$('#example tfoot tr').append('<th>' +key+ '</th>');
	  }
	  
	  function inBody(key){	
		$('#example tbody').append('<tr><td>' +key.IdTipoDonacion+ '</td><td>' +key.Cantidad+ '</td><td>' +key.Moneda+ '</td><td>' +key.Monto+ '</td><td>' +key.HsServicio+ '</td><td>' +key.Nombre+ '</td><td>' +key.Apellido+ '</td><td>' +key.Nombreong+ '</td><td>' +key.Email+ '</td></tr>');
	  }
	
	   function inBodyP(key){	
		$('#example tbody').append('<tr><td>' +key.TipoSolicitor+ '</td><td>' +key.Canal+ '</td><td>' +key.Ubicacion+ '</td><td>' +key.Fecha+ '</td></tr>');
	  }
	   
	   
	   function LoadGrafica(id, callback) {
			  return $.ajax({
			        url : '/BackOffice/rpt/rptuso',
			        type: 'POST',
			        data: JSON.stringify({
			            "id" : id
			        }),
			        beforeSend: function(xhr) {
			          xhr.setRequestHeader("Accept", "application/json");
			          xhr.setRequestHeader("Content-Type", "application/json");
			        },
			        success : function(data) {
			        	callback(data);
			        },
			        error:function(data,status,er) { 
			        	alert("error Lost: "+data+" status: "+status+" er:"+er);
			        }
			    });
			}
		  
		  function LoadDon(id, start, end, callback) {
			  return $.ajax({
			        url : '/BackOffice/rpt/rptdon',
			        type: 'POST',
			        data: JSON.stringify({
			            "id" : id,
			            "start" : start,
			            "end" : end
			        }),
			        beforeSend: function(xhr) {
			          xhr.setRequestHeader("Accept", "application/json");
			          xhr.setRequestHeader("Content-Type", "application/json");
			        },
			        success : function(data) {
			        	callback(data);
			        },
			        error:function(data,status,er) { 
			        	alert("error Lost: "+data+" status: "+status+" er:"+er);
			        }
			    });
			}
		  
		  function LoadAyuda(id, start, end, callback) {
			  return $.ajax({
			        url : '/BackOffice/rpt/rptayuda',
			        type: 'POST',
			        data: JSON.stringify({
			            "id" : id,
			            "start" : start,
			            "end" : end
			        }),
			        beforeSend: function(xhr) {
			          xhr.setRequestHeader("Accept", "application/json");
			          xhr.setRequestHeader("Content-Type", "application/json");
			        },
			        success : function(data) {
			        	callback(data);
			        },
			        error:function(data,status,er) { 
			        	alert("error Lost: "+data+" status: "+status+" er:"+er);
			        }
			    });
			}
		  
	   
	   
	   
	   
	  