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
						drawTable(json, name);	
						isGraf = false;
							}else if(name == 'usoRbt'){
							isGraf = true;
							$('#divTable').empty();
						$('#divTable').append('<div id="chart_lines" style="width: 900px; height: 500px;"></div>');
						drawChart(graf);
							}else if(name == 'pedRbt'){
							$('#divTable').empty();
						$('#divTable').append('<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"><thead><tr></tr></thead><tfoot><tr></tr></tfoot><tbody></tbody></table>')		
							drawTable(jsondosp, name);	
						isGraf = false;							
					 }
		if(isGraf == false){
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
			var datap = JSON.parse(obj);
				
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
		
	  }
	  
	  function drawChart(obj) {
	  var datap = JSON.parse(obj);
        var data = new google.visualization.DataTable();
			data.addColumn('string', 'attr');
			data.addColumn('number', 'cantidad');
			var result = datap[0];							
			for(key in result) {
				if(key != 'idTenant' && key != 'coneccion' ){
					data.addRows([[key, result[key]]]);
					
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
		$('#example tbody').append('<tr><td>' +key.id+ '</td><td>' +key.ongs+ '</td><td>' +key.ayuda+ '</td><td>' +key.desaparecidos+ '</td><td>' +key.usuarios+ '</td></tr>');
	  }
	  
	   function inBodyP(key){	
		$('#example tbody').append('<tr><td>' +key.id+ '</td><td>' +key.ongs+ '</td><td>' +key.ayuda+ '</td><td>' +key.desaparecidos+ '</td></tr>');
	  }
	  