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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/> ">
        <title>Proyectos</title>
    </head>
    <body>
        <h1>Proyectos</h1>
        
        <c:forEach var="proyecto" items="${lista}">
            ${proyecto.codigo} ${proyecto.areaProyecto} ${proyecto.tipo.tipo}
                <form method="POST" action="/HumanQualityResearch/jactualizar-proyecto" >
                    <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                    <button type="submit" class="btn btn-default btn-lg active">Modificar proyecto</button>
                </form>
                <form method="POST" action="/HumanQualityResearch/elimina-proyecto" >
                    <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                    <button type="submit" class="btn btn-default btn-lg active">Eliminar proyecto</button>
                </form>
            
            <br/>
        </c:forEach>        
    </body>
</html>

