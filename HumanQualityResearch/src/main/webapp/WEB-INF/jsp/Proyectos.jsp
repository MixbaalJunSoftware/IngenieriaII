<%-- 
    Document   : Proyectos
    Created on : 8/10/2016, 05:49:18 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyectos</title>
    </head>
    <body>
        <h1>Proyectos</h1>
        
        <c:forEach var="tipo" items="${lista}">
            ${tipo.proyecto.codigo} ${tipo.tipo} ${tipo.proyecto.areaProyecto}
            <br>
        </c:forEach>
    </body>
</html>

