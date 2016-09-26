<%-- 
    Document   : Opciones
    Created on : 25/09/2016, 10:52:07 PM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opciones</title>
    </head>
    <body>
        <form method="POST" action="/HumanQualityResearch/muestra-cliente" >
            <h1>id cliente(prueba Muestra Cliente)</h1>
            <input id = "id" name = "id"/>
            <br/>
            <button type="submit">Aceptar</button>
        </form>
        <form method="POST" action="/HumanQualityResearch/prueba-actualiza-cliente" >
            <h1>id cliente(prueba Actualiza)</h1>
            <input id = "id" name = "id"/>
            <br/>
            <button type="submit">Aceptar</button>
        </form>
        <form method="POST" action="/HumanQualityResearch/elimina-cliente" >
            <h1>id cliente(prueba Elimina)</h1>
            <input id = "id" name = "id"/>
            <br/>
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
