function message(msj, tipo){

    //Setemos la notificacion

    //Removemos clases
    $('.notification').removeClass('notification-error');
    $('.notification').removeClass('notification-succes');
    //Limpiados el msj
    $('.notification').empty();
    

    //Ingresamos msj
    $('.notification').append( msj );

     // Notification
    $('.notification').removeClass('bounceOutRight notification-show animated bounceInRight');
        
    // show notification
    $('.notification').addClass('notification-show notification-'+tipo+' animated bounceInRight');


    $('.notification').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
        setTimeout(function(){
            $('.notification').addClass('animated bounceOutRight');           
        }, 800);

    });
    
}