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
            <hr/>
        </header>
        <div class ="container">
        <form method="POST" action="/HumanQualityResearch/crear-cliente" >
            <p id="registro">Registro del cliente</p>
            <label for="nombre">Nombre:</label>
            <input id = "nombre" name = "nombre" style="margin-left: 4cm"/>
            <br/>
            <br/>
            <label for="app">Apellido Paterno:</label>
            <input id = "app" name = "app" style="margin-left:2.4cm "/>
            <br/>
            <br/>
            <label for="apm">Apellido Materno:</label>
            <input id = "apm" name = "apm" style="margin-left: 2.3cm"/>
            <br/>
            <br/>
            <label for="fecha">Fecha de nacimiento:</label>
            <input id = "fecha" name = "fecha" style="margin-left: 1.65cm"/>
            <br/>
            <br/>
            <label for="genero">Género:</label>
            <input id = "genero" name = "genero" style="margin-left: 4.1cm"/>
            <br/>
            <br/>
            <label for="empresa">Empresa:</label>
            <input id = "empresa" name = "empresa" style="margin-left:3.9cm "/>
            <br/>
            <br/>
            <label for="puesto">Puesto:</label>
            <input id = "puesto" name = "puesto" style="margin-left: 4.2cm"/>
            <br/>
            <br/>
            <label for="correo">Correo:</label>
            <input id = "correo" name = "correo" style="margin-left:4.2cm "/>
            <br/>
            <br/>
            <label for="pass">Contraseña:</label>
            <input id = "pass" name = "pass" type="password" style="margin-left:3.35cm "/>
            <br/>
            <br/>
            <label for="telefono">Telefono:</label>
            <input id = "telefono" name = "telefono" style="margin-left:3.9cm "/>
            <br/>
            <br/>
            <label for="celular">Celular:</label>
            <input id = "celular" name = "celular" style="margin-left:4.2cm "/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-default btn-lg active">Aceptar</button>
        </form>
        </div>
            <form method="POST" action="/HumanQualityResearch/" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
</html>
