<%-- 
    Document   : EditarCliente
    Created on : 23/09/2016, 01:40:58 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        function myFunction() {
        clave1 = document.f1.pass.value; 
        clave2 = ${usuario.getContrasenia()};
        if (clave1 === clave2) 
            document.getElementById("f1").submit();
        else 
            alert("El correo anterior no coincide"); 
    }
</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <h1>${id}</h1>
        <h1>Ingresa los campos que deseas editar</h1>
        <form id = "f1" name="f1" method="POST" action="/HumanQualityResearch/actualizar-cliente" >
            <label for="puesto">Puesto:</label>
            <input id = "puesto" name = "puesto"/>
            <br/>
            <label for="area">Area:</label>
            <input id = "area" name = "area"/>
            <br/>
            <label for="tel">Telefono:</label>
            <input id = "tel" name = "tel"/>
            <br/>
            <label for="cel">Celular:</label>
            <input id = "cel" name = "cel"/>
            <br/>
            <h2>Modificar contraseña</h2>
            <label for="pass">Contraseña anterior:</label>
            <input id = "pass" name = "pass"/>
            <br/>
            <label for="newpass">Nueva contraseña:</label>
            <input id = "newpass" name = "newpass"/>
            <br/>
            <input id="idcliente" name="idcliente" hidden="true" value="${usuario.persona.idPersona}">
            <button type="submit" onclick="validaPass()" >Aceptar</button>
        </form>
    </body>
</html>
