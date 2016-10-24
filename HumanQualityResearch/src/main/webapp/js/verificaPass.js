$(document).ready(function() {
    // check name availability on focus lost
    $('#verifica-boton').click(function() {
        verificaPassword();
    });
});

function verificaPassword() {
    $.getJSON("/HumanQualityResearch/account-availability", 
        { correo: $('#correo').val() }, 
        function (value) {
            puesto = document.f1.puesto.value;
            area = document.f1.area.value;
            tel = document.f1.tel.value;
            cel = document.f1.cel.value;
            clave1 = document.f1.pass.value; 
            clave2 = "${usuario.getContrasenia()}";
            if (puesto === area && area === tel && tel === cel && cel === clave1)
                alert("Debes llenar almenos un campo");
            else if (clave1 !== "" && clave1 !== clave2){ 
                alert("La contraseña anterior no coincide");
            }else
                document.getElementById("f1").submit(); 
        }
    );
}