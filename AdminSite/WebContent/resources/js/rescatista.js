$(document).ready(function() {

    $( '#contenedor-busqueda' ).searchable({
        searchField: '#buscador2',
        selector: '.well-sm',
        childSelector: '.text',
        show: function( elem ) {
            elem.slideDown(100);
        },
        hide: function( elem ) {
            elem.slideUp( 100 );
        }
    });

});