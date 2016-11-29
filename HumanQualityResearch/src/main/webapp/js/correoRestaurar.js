$(document).ready(function() {
    // check name availability on focus lost
    $('#correo-recover').click(function() {
        checkAvailability();
    });
});

function checkAvailability() {
    $.getJSON("/HumanQualityResearch/account/availabilityRecover", 
        { correoRecover: $('#correoRecover').val() }, 
        function(disponible) {
            if (disponible) {
               $('#frecover').submit();
            } else {
                alert("el correo que ingresaste no existe");
            }
    });
}