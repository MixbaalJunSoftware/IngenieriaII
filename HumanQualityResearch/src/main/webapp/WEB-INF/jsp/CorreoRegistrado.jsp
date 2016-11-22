<%-- 
    Document   : CorreoRegistrado
    Created on : 26/09/2016, 11:23:00 AM
    Author     : luis
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/correoRegistrado.css"/> ">
        <title>Correo registrado</title>
    </head>
    <body>
        <div class="principal text-center">
            <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR"/> 
        </div>
        <div class="container-fluid bg-1">
            <h1 id="exito">El correo electrónico ya está registrado</h1>
            <br/>
            <span class="glyphicon glyphicon-remove logo"></span>
            <br/>
            <form method="GET" action="/HumanQualityResearch/redirect-home" >
                <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 16cm;">Regresar</button>
            </form>
            <br/>
            <br/>
        </div>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>