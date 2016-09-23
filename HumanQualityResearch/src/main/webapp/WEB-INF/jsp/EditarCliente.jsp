<%-- 
    Document   : EditarCliente
    Created on : 23/09/2016, 01:40:58 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <h1>${id}</h1>
        <h1>Ingresa los campos que deseas editar</h1>
        <form method="POST" action="/HumanQualityResearch/actualizar-cliente" >
            <label for="puesto">Puesto:</label>
            <input id = "puesto" name = "puesto"/>
            <br/>
            <label for="tel">Telefono:</label>
            <input id = "tel" name = "tel"/>
            <br/>
            <label for="cel">Celular:</label>
            <input id = "cel" name = "cel"/>
            <br/>
            <label for="correo">Correo:</label>
            <input id = "correo" name = "correo"/>
            <br/>
            <input id="idcliente" name="idcliente" hidden="true" value="${id}">
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
