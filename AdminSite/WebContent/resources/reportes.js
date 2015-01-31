    var jCt;
     
	 function drawChart(obj) {
        var data = new google.visualization.DataTable();
			data.addColumn('string', 'attr');
			data.addColumn('number', 'cantidad');
									
			for(key in obj) {	
				if(key != 'idTenant' && key != 'coneccion' ){
					data.addRows([[key, obj[key]]]);
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
		document.getElementById('png').innerHTML = '<a href="' + chart.getImageURI() + '">Printable version</a>';
      }
	  
	  function initialize () {
		$('#clickinpt').click(function() {
			drawChart(json);
		});	
		
		$('#select').on('change', function() {
//			LoadGrafica($(this).val(), function(data) {
//				drawChart(data);	
//			 });		
			
			LoadDon($(this).val(), $('#start').val(), $('#end').val(), function(data) {
				//LoadDon(data);	
//				drawChart(data);	
				alert(data);
			}
			);
		});
	
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
	  
google.setOnLoadCallback(initialize);
google.load("visualization", "1", {packages:["corechart"]});