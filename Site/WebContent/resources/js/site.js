function eventLost(callback){
	
	 
}

$(document).ready(function(){
	
//mensaje("Titulo","texto","success");
var estilo_actual=document.getElementsByTagName("link")[1];
	
	 LoadLostList(function(data){
		if(estilo_actual.getAttribute("title")=='Style2.css'){
			$('.navbar-proyecto').addClass('alt');
			$('.navbar-brand').addClass('hidden');
			$('.rss').addClass('col-lg-offset-2');
			
			//$('.menu_login').removeClass('navbar-right');
			$('.glyphicon-warning-sign').addClass('hidden');
			$('.titulo_principal').removeClass('col-md-7').addClass('col-md-12');
			$('.boton_solayu').removeClass('col-md-5').addClass('col-md-12');
			$('.bton-sos').addClass('btn-lg');
			$('.bton-sos').append('Solicitar ayuda');
			$('.columna-desp').removeClass('col-md-6 col-lg-6').addClass('col-md-12 col-lg-12');
			//$('.columna-desp').removeClass('col-lg-6').addClass('col-lg-12');
			$('.botones-desaparecidos').removeClass('col-md-4 col-lg-2 pull-right').addClass('col-lg-12 text-center');
			$('.bton-vermas').removeClass('btn-warning').addClass('btn-default btn-lg');
			$('.bton-reportar').removeClass('btn-warning').addClass('btn-default btn-lg');
			$('.search').removeClass('col-lg-6').addClass('col-lg-12');
		}
		
		 $('#secDesaparecidos').html(data);
		 $('.item:first').addClass('active');
		 $('.estilo2').hide();
		 $(".search").hide();
		 $(".lista_desaparecidos").hide();
		 $(".bton-cerrarvermas").hide();
			$(".bton-vermas").click(function(){
				$("#contenido-principal").hide();
				$(".informacion").hide();
				$(".story").hide();
				$(".noticia_titulo").hide();
				$(".noticias").hide();
				$(".ong_titulo").hide();
				$(".ongs").hide();
				$(".slider_desaparecidos").hide();
				$(".botones-desaparecidos").hide();
				
				$(".search").show();
				$(".bton-cerrarvermas").show();
				$(".lista_desaparecidos").slideDown();
			});
			$(".bton-cerrarvermas").click(function(){
				$(".lista_desaparecidos").slideUp();
				$(".search").hide();
				$(".bton-cerrarvermas").hide();
				$("#contenido-principal").show();
				$(".botones-desaparecidos").show();
				$(".informacion").show();
				$(".story").show();
				$(".ong_titulo").show();
				$(".ongs").show();
				$(".slider_desaparecidos").show();
				$(".noticia_titulo").show();
				$(".noticias").show();
			});
			

			$('.thumbnail').hover(
			        function(){
			            $(this).find('.caption').slideDown(250); //.fadeIn(250)
			        },
			        function(){
			            $(this).find('.caption').slideUp(250); //.fadeOut(205)
			        }
			); 

			$( '#searchable-container' ).searchable({
			    searchField: '#container-search',
			    selector: '.col-md-3',
			    childSelector: '.nm',
			    show: function( elem ) {
			        elem.slideDown(100);
			    },
			    hide: function( elem ) {
			        elem.slideUp( 100 );
			    }
			});
			
			$('#rss').easyTicker({
				direction: 'up', // up or down
				easing: 'swing', // easing options
				speed: 'slow', // animation speed
				interval: 2000,
				height: 'auto',
				visible: 3, // change the number of default visible elements.
				mousePause: 1, // pause on hover
				controls: {
				up: '',
				down: '',
				toggle: '',
				playText: 'Play',
				stopText: 'Stop'
				}
			});


	 });
	 
	 LoadOngList();
	
	 showData();
	 
	 LoadNews()
	 
	$('[data-toggle="tooltip"]').tooltip();
	

	/* smooth scrolling for scroll to top */
	$('body').scrollspy({ target: '.navbar-proyecto' })
	$('[data-spy="scroll"]').each(function () {
	  var $spy = $(this).scrollspy('refresh')
	});

	/*
	$('.scroll-top').click(function(){
	  $('body,html').animate({scrollTop:0},1000);
	})

	$('.scroll-down').click(function(){
	  $('body,html').animate({scrollTop:$(window).scrollTop()+800},1000);
	})
	*/

	$('#carousel-example-generic').carousel({
    	interval: 2000
	});

	/***************
	* = Hover text *
	* Hover text for the last slide
	***************/
	$('.with-hover-text').hover(
		function(e) {
			$(this).css('overflow', 'visible');
			$(this).find('.hover-text')
				.show()
				.css('opacity', 0)
				.delay(200)
				.animate(
					{
						paddingTop: '25px',
						opacity: 1
					},
					'fast',
					'linear'
				);
		},
		function(e) {
			var obj = $(this);
			$(this).find('.hover-text')
				.animate(
					{
						paddingTop: '0',
						opacity: 0
					},
					'fast',
					'linear',
					function() {
						$(this).hide();
						$( obj ).css('overflow', 'hidden');
					}
				);
		}
	);
	
	var img_loaded = 0;
	var j_images = [];
	



/******************
* = Gallery width *
******************/
$(function() {
	var pause = 50; // will only process code within delay(function() { ... }) every 100ms.
	$(window).resize(function() {
		delay(function() {
				var gallery_images = $('#slide-3 img');
				
				var images_per_row = 0;
				if ( gallery_images.length % 2 == 0 ) {
					images_per_row = gallery_images.length / 2;
				} else {
					images_per_row = gallery_images.length / 2 + 1;
				}
				
				var gallery_width = $('#slide-3 img').width() * $('#slide-3 img').length;
				gallery_width /= 2;
				if ( $('#slide-3 img').length % 2 != 0 ) {
					gallery_width += $('#slide-3 img').width();
				}
				
				$('#slide-3 .row').css('width', gallery_width );
				
				var left_pos = $('#slide-3 .row').width() - $('body').width();
				left_pos /= -2;
				
				$('#slide-3 .row').css('left', left_pos);
			
			},
			pause
		);
	});
	$(window).resize();
});

var delay = (function(){
	var timer = 0;
	return function(callback, ms){
		clearTimeout (timer);
		timer = setTimeout(callback, ms);
	};
})();

/******************
* = Gallery hover *
******************/
jQuery(document).ready(function ($) {
	//Cache some variables
	var images = $('#slide-3 a');
	
	images.hover(
		function(e) {
			var asta = $(this).find('img');
			$('#slide-3 img').not( asta ).stop(false, false).animate(
				{
					opacity: .5
				},
				'fast',
				'linear'
			);
			var zoom = $('<div class="zoom"></div>');
			if ( $(this).hasClass('video') ) {
				zoom.addClass('video');
			}
			$(this).prepend(zoom);
		},
		function(e) {
			$('#slide-3 img').stop(false, false).animate(
				{
					opacity: 1
				},
				'fast',
				'linear'
			);
			$('.zoom').remove();
		}
	);
});

/******************
* = Arrows click  *
******************/
jQuery(document).ready(function ($) {
	//Cache some variables
	var arrows = $('#arrows div');
	
	arrows.click(function(e) {
		e.preventDefault();
		
		if ( $(this).hasClass('disabled') )
			return;
		
		var slide = null;
		var datasheet = $('.nav > li.active').data('slide');
		var offset_top = false;
		var offset_left = false;
		
		
		switch( $(this).attr('id') ) {
			case 'arrow-up':
				offset_top = ( datasheet - 1 == 1 ) ? '0px' : $('.slide[data-slide="' + (datasheet-1) + '"]').offset().top;
				break;
			case 'arrow-down':
				offset_top = $('.slide[data-slide="' + (datasheet+1) + '"]').offset().top;
				break;
			case 'arrow-left':
				offset_left = $('#slide-3 .row').offset().left + 452;
				if ( offset_left > 0 ) {
					offset_left = '0px';
				}
				break;
			case 'arrow-right':
				offset_left = $('#slide-3 .row').offset().left - 452;
				if ( offset_left < $('body').width() - $('#slide-3 .row').width() ) {
					offset_left = $('body').width() - $('#slide-3 .row').width();
				}
				break;
		}
		
		if ( offset_top != false ) {
			htmlbody.stop(false, false).animate({
				scrollTop: offset_top
			}, 1500, 'easeInOutQuart');
		}
		
		if ( offset_left != false ) {
			if ( $('#slide-3 .row').width() != $('body').width() ) {
				$('#slide-3 .row').stop(false, false).animate({
					left: offset_left
				}, 1500, 'easeInOutQuart');
			}
		}
	});
});

function mensaje(titulo,texto,tipo){
	swal({
		title: titulo,   
		text: texto,   
		type: tipo,
		});
}


//search
	/*
	$( '#table' ).searchable({
        striped: true,
        oddRow: { 'background-color': '#f5f5f5' },
        evenRow: { 'background-color': '#fff' },
        searchType: 'fuzzy'
    });
    */
   

   
});

