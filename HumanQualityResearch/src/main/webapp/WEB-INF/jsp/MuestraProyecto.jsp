<%-- 
    Document   : MuestraProyecto
    Created on : 15/11/2016, 10:32:39 AM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Detalles del proyecto</title>
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
                        <li><a href="#proyectoInfo">Información del Proyecto</a></li>
                        <li><a href="/HumanQualityResearch/ver-clientes">Regresar a Clientes</a></li>
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
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <h2 style="color:white;">Codigo: ${codigo}</h2>
            <h2 style="color:white;">Area: ${area}</h2>
            <h2 style="color:white;">Tipo: ${tipo}</h2>
            <h2 style="color:white;">Cliente: ${nombre} ${app} ${apm}</h2>
            
        </div>
       
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
</html>
