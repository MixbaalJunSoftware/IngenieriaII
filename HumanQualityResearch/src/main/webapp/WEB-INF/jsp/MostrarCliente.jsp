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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Detalles del cliente</title>
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="100" style="background-color: #5389C4;">
        <nav class="navbar navbar-default navbar-fixed-top" style="background-color:#5389C4;">
            <div class="container" >
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR" width="50" height="50"/>    
                    <a  href="#myPage" style="color:white;">Human Quality Research </a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#clienteInfo">Información del Cliente</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <br/>
            <br/>
            <br/>
            <br/>
            <h2 style="color:white;">Nombre: ${nombre} ${app} ${apm}</h2>
            <h2 style="color:white;">Fecha de nacimiento: ${fecha}</h2>
            <h2 style="color:white;">Género: ${genero}</h2>
            <h2 style="color:white;">Empresa: ${empresa}</h2>
            <h2 style="color:white;">Puesto: ${puesto}</h2>
            <h2 style="color:white;">Área: ${area}</h2>
            <h2 style="color:white;">Correo: ${correo}</h2>
            <h2 style="color:white;">Teléfono: ${telefono}</h2>
            <h2 style="color:white;">Celular: ${celular}</h2>
        </div>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
</html>
