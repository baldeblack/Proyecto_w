		var chart;
		var tipoRpt;
		var sitio;
	    var jCt;
	    
		jQuery(document).ready(function($) {
			
			$('.chartMenu').show();
			$('.divider').hide();
			$('.divider.chart').show();		
		    $('.tableMenu').hide();
			$('#dateDiv').hide();
			sitio = "General";
			load("usoRbt");					 
		
			
		    $("input:radio").click(function() {
		        var current = $(this).attr('name');
				var idCurrent = $(this).attr('id');
		        $('#radios input').each(function() {
		            if ($(this).attr('name') != current) {
		                $(this).attr('checked', false);
		            }
		        });
				
		      if (current == 'usoRbt') {
		    	  	load(current);
		            $('.chartMenu').show();
					$('.divider').hide();
					$('.tableMenu').hide();
					$('.divider.chart').show();
					if($("#select option[value=g]").length == 0){
						$("#select").append(new Option("General", "g"));
						$("#select").val('g');
					}
					$('#dateDiv').fadeOut("slow");
		        } else {
						$('.chartMenu').hide();					
					   $('.tableMenu').show();
						$('.divider').show();
						$('.divider.chart').hide();
						$("#select option[value='g']").remove();
						
						sitio = $("#select option:selected").text();
						$('#dateDiv').fadeIn("slow");
						
				}
				
				tipoRpt = $("#"+idCurrent)[0].nextSibling.nodeValue;
				
		    });
				
			$('#select').on('change', function (e) {
				 sitio = $(this).find("option:selected").text();
				 
				 $('#radios input').each(function() {
		            if ($(this).is(':checked') && $(this).attr('name') == "usoRbt") {
						load($(this).attr('name'))
					}
		        });
				
			});
				

			$('#rptform').validator().on('submit', function (e) {

				  if (e.isDefaultPrevented()) {
				    // handle the invalid form...
				  } else {
					  e.preventDefault();
					  $('#radios input').each(function() {
						  var current = $(this).attr('name');
						  if (current != 'usoRbt' && $(this).is(':checked')) {
							  load($(this).attr('name'))
						  }
					    })
					  
				  }
			});

		});



		function load(name) {
		    if (name == 'donRbt') {
		    	LoadDon($("#select").val(), $('#start').val(), $('#end').val(), function(data) {					
					drawTable("donacionesTable", name, data);
				});		
		 
		    } else if (name == 'pedRbt') {			    	
		    	LoadAyuda($("#select").val(), $('#start').val(), $('#end').val(), function(data) {			
					drawTable("pedidosTable", name, data);		
				});	
		    	
			        
		    } else if (name == 'usoRbt') {
		   		$('#rptContainer').empty();
		        $('#rptContainer').append('<div id="chart_lines"></div>');
		        
		    	LoadGrafica($("#select").val(), function(data) {
					drawChart(data);						
				});				
		     
		    }

		}


		function drawChart(jsonResult) {		  
		    var data = new google.visualization.DataTable();
		    data.addColumn('string', 'attr');
		    data.addColumn('number', 'cantidad');								
		    for (key in jsonResult) {
		        if (key != 'idTenant' && key != 'coneccion') {
		            data.addRows([
		                [key, jsonResult[key]]
		            ]);

		        }
		    }

		    var options = {
		        width: 1000,
		        height: 563,
		        hAxis: {
		            title: "Reporte de Uso de " + sitio,
		            gridlines: {
		                count: 10
		            }
		        },
		        vAxis: {
		            title: 'Cantidad'
		        }
		    };

		    chart = new google.visualization.ColumnChart(document.getElementById('chart_lines'));
		    chart.draw(data, options);
		}
		google.load("visualization", "1", {
		    packages: ["corechart"]
		});


		function inHead(key, tablename) {
				
		    $('#' +tablename+' thead tr').append('<th>' + key + '</th>');
		}

		function inBody(key, tablename, rptOption) {
			
						
		    if (rptOption == 'donRbt') {
		    	
		    	var tipodon="";
				if(key.IdTipoDonacion == 1){
					tipodon = 'Economica';
				}else if(key.IdTipoDonacion == 2){
					tipodon = 'De bienes';
				}
				else if(key.IdTipoDonacion == 3){
					tipodon = 'De servicios';
				}
				
				$('#' +tablename+' tbody').append('<tr><td>' + tipodon + '</td><td>' + key.Cantidad + '</td><td>' + key.Moneda + '</td><td>' + key.Monto + '</td><td>' + key.HsServicio + '</td><td>' + key.Nombre + '</td><td>' + key.Apellido + '</td><td>' + key.Nombreong + '</td><td>' + key.Email + '</td></tr>');
			}else if (rptOption == 'pedRbt'){
				$('#' +tablename+' tbody').append('<tr><td>' + key.TipoSolicitor + '</td><td>' + key.Canal + '</td><td>' + key.Ubicacion + '</td><td>' + key.Fecha + '</td></tr>');
			}
		}

		function exportT(elem) {
		    var id = $(elem).attr('id');
		    var dtid = $('#rptContainer table').attr('id');
		    if (id == 'epng') {
		        $("#" + dtid).tableExport({
		            type: 'png',
		            escape: 'false'
		        });
		    } else if (id == 'epdf') {
		        $("#" + dtid).tableExport({
		            type: 'pdf',
		            escape: 'false'
		        });
		    } else if (id == 'exls') {
		        $("#" + dtid).tableExport({
		            type: 'excel',
		            escape: 'false'
		        });

		    } else if (id == 'ecsv') {
		        $("#" + dtid).tableExport({
		            type: 'csv',
		            escape: 'false'
		        });

		    }
		}
		
		function exportChart(elem){
			var id = $(elem).attr('id');
		  
		    if (id == 'eChartpng') {
		        $('#eChartpng').attr('href', chart.getImageURI());
		        $('#eChartpng').attr("download", 'Reporte de Uso de '+sitio+'')
		    } else if (id == 'eChartpdf') {
		        var doc = new jsPDF();
		        var imgData = chart.getImageURI();		   

				doc.setFontSize(20);
				doc.text(40, 25, 'Reporte de Uso de '+sitio+'.');
				doc.addImage(imgData, 'PNG', 15, 40, 180, 160);				
		     // doc.addImage(imgData, 'PNG', 15, 40, 200, 114);
		        doc.save('Reporte de Uso de '+sitio+'.pdf'); 
		    } 
		}
		
		
		function drawTable(tablename, rptOption, jsonResult){
		
			$('#rptContainer').empty();
		    $('#rptContainer').append('<table id="'+tablename+'" class="table table-bordered"><thead><tr></tr></thead><tbody></tbody></table>');
		    var result = jsonResult[0];

		    for (key in result) {				
				inHead(key, tablename);		          
		    }

		        for (i = 0; i < jsonResult.length; i++) {
					inBody(jsonResult[i], tablename, rptOption);
		        }
				
		        $('#'+tablename+'').dynatable();
		        $('#dynatable-query-search-'+tablename+'').val('');
		        var e = jQuery.Event("keypress");
		        e.which = 13;
		        e.keyCode = 13;
		        $('#dynatable-query-search-'+tablename+'').trigger(e);
		        $('#dynatable-per-page-'+tablename+'').val(10).trigger('change');
				
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
		  
			