<%-- 
    Document   : Ok
    Created on : 23/09/2016, 03:05:10 PM
    Author     : luis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Ok.css"/> ">
        <title>Operación exitosa</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
            <p id="exito">La operación se realizó con éxito</p>
            <br/>
            <br/>
            <br/>
            <form method="POST" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 15cm;color:#1662B2;">Regresar</button>
            </form>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
