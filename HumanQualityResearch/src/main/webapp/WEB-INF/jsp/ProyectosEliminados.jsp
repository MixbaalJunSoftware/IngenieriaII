<%-- 
    Document   : ProyectosEliminados
    Created on : 15/11/2016, 12:12:41 PM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Proyectos.css"/> ">
        <title>Proyectos</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <p id="proyecto">Proyectos</p>
        <table class="table">
            <thead>
                <tr>
                    <th style="color:#1D14A4;font-size: 20px;">Código</th>
                    <th style="color:#1D14A4;font-size: 20px;">Área</th>
                    <th style="color:#1D14A4;font-size: 20px;">Tipo</th>
                    <th style="color:#1D14A4;font-size: 20px;">Fecha de borrado</th> 
                    
                </tr>
            </thead>
        
        <c:forEach var="proyecto" items="${lista}">
            <tbody>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.codigo}</th>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.areaProyecto}</th>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.tipo.tipo}</th>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.fborrado}</th>
                <th>
                    <form method="POST" action="/HumanQualityResearch/admin/recuperar-proyecto" >
                        <input id="id" name="id" hidden="true" value="${proyecto.idProyecto}">
                        <button type="submit" class="btn btn-primary btn-lg active">Recuperar</button>
                    </form>
                </th>
                <th>
                    <form method="POST" action="/HumanQualityResearch/admin/elimina-proyecto" >
                        <input id="id" name="id" hidden="true" value="${proyecto.idProyecto}">
                        <button type="submit" class="btn btn-primary btn-lg active">Eliminar</button>
                    </form>
                </th>
            </tbody>
            
        </c:forEach>
        </table>
        <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
    </body>
        <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</html>


