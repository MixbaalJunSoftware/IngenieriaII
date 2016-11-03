<%-- 
    Document   : MostrarCliente
    Created on : 23/09/2016, 07:24:03 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/MostrarCliente.css"/> ">
        <title>mostrar cliente</title>
    </head>
    <body>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
            <div class="container">
            <h1 style="color:blue;">Datos del cliente con id:</h1>
            <p>Nombre: ${nombre} ${app} ${apm}</p>
            <p>Fecha de nacimiento: ${fecha}</p>
            <p>Género: ${genero}</p>
            <p>Empresa: ${empresa}</p>
            <p>Puesto: ${puesto}</p>
            <p>Area: ${area}</p>
            <p>Correo: ${correo}</p>
            <p>Telefono: ${telefono}</p>
            <p>Celular: ${celular}</p>
            </div>
            <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
            <br/>
    </body>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</html>
