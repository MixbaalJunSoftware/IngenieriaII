<%-- 
    Document   : CorreoCorrecto
    Created on : 9/10/2016, 07:31:34 PM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/CorreoCorrecto.css"/> ">
        <title>Correo ingresado</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
            <p id="exito">Se agregó exitosamente el correo electrónico del cliente</p>
            <br/>
            <br/>
            <br/>
            <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 15cm;color:#1662B2;">Regresar</button>
            </form>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
