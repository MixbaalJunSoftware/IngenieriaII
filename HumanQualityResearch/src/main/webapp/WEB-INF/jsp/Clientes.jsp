<%-- 
    Document   : Clientes
    Created on : 26/09/2016, 11:44:34 AM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Clientes.css"/> ">
        <title>Clientes</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <h1>Clientes</h1>
        
        <c:forEach var="cliente" items="${lista}">
            ${cliente.persona.nombre} ${cliente.empresa} ${cliente.persona.correo}
            <br>
        </c:forEach>
        <form method="POST" action="/HumanQualityResearch/admin/home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
            
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
