<%-- 
    Document   : CrearCliente
    Created on : 25/09/2016, 04:28:18 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/CrearCliente.css"/> ">
        <title>Crear Cliente</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
        </header>
        <br/>
        <div class ="container">
        <form method="POST" action="/HumanQualityResearch/crear-cliente" >
            <p id="registro">Registro del cliente</p>
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
        </div>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
</html>
