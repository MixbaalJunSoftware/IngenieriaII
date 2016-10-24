$(document).ready(function() {
    // check name availability on focus lost
    $('#enviar-correo').click(function() {
        checkAvailabilityRecover();
    });
});

function checkAvailabilityRecover() {
    $.getJSON("/HumanQualityResearch/account-availability", 
        { correo: $('#correo').val() }, 
        function(disponible) {
            if (disponible) {
               $('#f1').submit();
            } else {
                alert("correo invalido");
            }
    });
}