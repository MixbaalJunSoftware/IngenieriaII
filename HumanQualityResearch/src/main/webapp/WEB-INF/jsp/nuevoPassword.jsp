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
    </head>
    <body>
        <h1>Escribe una nueva contraseña</h1>
        <form action="/HumanQualityResearch/cambiarPassword" method="POST">
            <input type="text" name="newPass1" id="newPass1"><br/><br/>
            <input type="text" name="newPass2" id="newPass2"><br/><br/>
            <button value="aceptar" name="npboton" id="npboton">aceptar</button>
        </form>
    </body>
</html>
