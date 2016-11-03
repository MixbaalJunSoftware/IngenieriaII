<%-- 
    Document   : nuevoPassword
    Created on : 23/10/2016, 03:37:00 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nueva contraseña</title>
        <script>
            function confirmaCorreo() {
                clave1 = document.fnuevoPass.newPass1.value; 
                clave2 = document.fnuevoPass.newPass2.value;
                if (clave1 === clave2 && clave1 === "")
                    alert("Escribe una nueva contraseña");
                else if (clave1 !== clave2){ 
                    alert("Las contraseñas no coinciden");
                }else
                    document.getElementById("fnuevoPass").submit(); 
        }
        </script>
    </head>
    <body>
        <h1>Escribe una nueva contraseña</h1>
        <form id="fnuevoPass" name="fnuevoPass" action="/HumanQualityResearch/cambiarPassword" method="POST">
            <h3>Nueva Contraseña:</h3>
            <input type="text" name="newPass1" id="newPass1"><br/><br/>
            <h3>Repite la contraseña:</h3>
            <input type="text" name="newPass2" id="newPass2"><br/><br/>
            <button value="aceptar" name="npboton" id="npboton" onclick="confirmaCorreo()">aceptar</button>
        </form>
    </body>
</html>
