<%-- 
    Document   : CrearCliente
    Created on : 25/09/2016, 04:28:18 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cliente</title>
    </head>
    <body>
        <form method="POST" action="/HumanQualityResearch/crear-cliente" >
            <h1>Datos de un cliente</h1>
            <label for="nombre">Nombre:</label>
            <input id = "nombre" name = "nombre"/>
            <br/>
            <label for="app">Apellido Paterno:</label>
            <input id = "app" name = "app"/>
            <br/>
            <label for="apm">Apellido Materno:</label>
            <input id = "apm" name = "apm"/>
            <br/>
            <label for="fecha">Fecha de nacimiento:</label>
            <input id = "fecha" name = "fecha"/>
            <br/>
            <label for="genero">Género:</label>
            <input id = "genero" name = "genero"/>
            <br/>
            <label for="empresa">Empresa:</label>
            <input id = "empresa" name = "empresa"/>
            <br/>
            <label for="puesto">Puesto:</label>
            <input id = "puesto" name = "puesto"/>
            <br/>
            <label for="correo">Correo:</label>
            <input id = "correo" name = "correo"/>
            <br/>
            <label for="telefono">Telefono:</label>
            <input id = "telefono" name = "telefono"/>
            <br/>
            <label for="celular">Celular:</label>
            <input id = "celular" name = "celular"/>
            <br/>
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
