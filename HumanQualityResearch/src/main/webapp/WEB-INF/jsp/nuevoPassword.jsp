<%-- 
    Document   : nuevoPassword
    Created on : 23/10/2016, 03:37:00 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nueva contraseña</title>
        <script>
            function confirmaCorreo() {
                clave1 = document.fnuevoPass.newPass1.value; 
                clave2 = document.fnuevoPass.newPass2.value;
                if (clave1 === clave2 && clave1 === "")
                    alert("Escribe una nueva contraseña");
                else if (clave1 !== clave2){ 
                    alert("Las contraseñas no coinciden");
                }else
                    document.getElementById("fnuevoPass").submit(); 
            }
        </script>
    </head>
    <style>
        .principal{
            background-color: #5389C4;
            color: #fff;
            padding: 50px 50px;
        }
        .bg-1{
            background-color: #7D9ED3;
            padding: 25px 25px;
        }
        
    </style>
    <body>
        
        <div class="principal text-center">
            <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR"/>
            <h1 id="slogan">La solución que facilita tu evaluación para identificar tu talento.</h1> 
        </div>
        <div class="container-fluid bg-1">    
            <h1 style="margin-left: 11cm;color: white;">Escribe una nueva contraseña</h1>
            <br/>
            <form id="fnuevoPass" name="fnuevoPass" action="/HumanQualityResearch/cambiarPassword" method="POST">
                <label style="font-size: 20px;margin-left: 11cm;color: white;">Nueva Contraseña:</label>
                <input style="margin-left: 1cm;" type="text" name="newPass1" id="newPass1">
                <br/>
                <br/>
                <label style="font-size: 20px;margin-left: 11cm;color: white;">Repite la contraseña:</label>
                <input style="margin-left: 0.5cm;" type="text" name="newPass2" id="newPass2">
                <br/>
                <br/>
                <input type="button" style="margin-left: 16cm;" value="aceptar" class="btn btn-primary" name="npboton" id="npboton" onclick="confirmaCorreo()">
            </form>
        </div>
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
</html>
