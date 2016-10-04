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
        <title>Clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>
        
        <c:forEach var="cliente" items="${lista}">
            ${cliente.persona.nombre} ${cliente.empresa} ${cliente.persona.correo}
            <br>
        </c:forEach>
    </body>
</html>
