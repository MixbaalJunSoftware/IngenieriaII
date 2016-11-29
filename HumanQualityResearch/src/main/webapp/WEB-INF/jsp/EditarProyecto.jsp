<%-- 
    Document   : EditarProyecto
    Created on : 8/10/2016, 09:52:43 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <script>
        function myFunction() {
            correo = document.f1.correo.value;
            area  = document.f1.area.value;
            tipo = document.f1.tipo.value;
            if (correo === area && area === tipo)
                alert("Debes llenar almenos un campo");
            else
                document.getElementById("f1").submit();
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Editar Proyecto</title>
    </head>
    <body style="background-color: #5389C4;">
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
                        <li><a href="#editaProyecto">Editar Proyecto</a></li>                        
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
            <h2 style="color:white;font-size: 50px;text-align: center;" id="editar">Ingresa los campos que deseas editar</h2>
            <br/>
            <br/>
            <br/>
            <form id = "f1" name="f1" method="POST" action="/HumanQualityResearch/editar-proyecto" >
                <label for="correo" style="margin-left: 4cm;color:white;font-size: 20px;">Correo del cliente:</label>
                <input id = "correo" name = "correo" type="email" style="margin-left: 2cm"/>
                <br/>
                <br/>
                <label for="area" style="margin-left: 4cm;color:white;font-size: 20px;">Area del proyecto:</label>
                <input id = "area" name = "area" style="margin-left: 2cm"/>
                <br/>
                <br/>
                <label for="tipo" style="margin-left: 4cm;color:white;font-size: 20px;">Tipo del proyecto:</label>
                <input id = "tipo" name = "tipo" style="margin-left: 2cm"/>
                <br/>
                <br/>
                <br/>
                <br/>
                <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                <input style="margin-left: 4cm;" type="button" onclick="myFunction()" value="Aceptar" class="btn btn-primary btn-lg active">
                <br/>
            </form>
        </div>
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
        
    </body>
</html>
