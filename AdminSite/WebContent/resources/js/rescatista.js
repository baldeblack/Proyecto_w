$(document).ready(function() {

    $( '#contenedor-busqueda' ).searchable({
        searchField: '#buscador',
        selector: '.col-sm-3',
        childSelector: '.text',
        show: function( elem ) {
            elem.slideDown(100);
        },
        hide: function( elem ) {
            elem.slideUp( 100 );
        }
    });

});