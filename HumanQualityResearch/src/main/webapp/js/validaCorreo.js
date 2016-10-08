$(document).ready(function() {
    // check name availability on focus lost
    $('#enviar-correo').click(function() {
        checkAvailability();
    });
});

function checkAvailability() {
    $.getJSON("/HumanQualityResearch/account/availability", 
        { correo: $('#correo').val() }, 
        function(disponible) {
            if (disponible) {
               $('#f1').submit();
            } else {
                alert("correo invalido");
            }
    });
}