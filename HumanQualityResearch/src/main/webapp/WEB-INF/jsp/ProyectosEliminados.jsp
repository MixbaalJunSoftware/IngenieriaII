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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuente.css"/> ">
        <title>Proyectos eliminados</title>
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="100" style="background-color: #5389C4;">
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
                        <li><a href="#proyectosElim">Proyectos Eliminados</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="principal">
            <br/>
            <br/>
            <br/>
            <table class="table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Área</th>
                        <th>Tipo</th>
                        <th>Fecha de borrado</th> 
                        
                    </tr>
                </thead>
                
                <c:forEach var="proyecto" items="${lista}">
                    <tbody>
                    <th>${proyecto.codigo}</th>
                    <th>${proyecto.areaProyecto}</th>
                    <th>${proyecto.tipo.tipo}</th>
                    <th>${proyecto.fborrado}</th>
                    <th>
                        <form method="POST" action="/HumanQualityResearch/admin/recuperar-proyecto" >
                            <input id="id" name="id" hidden="true" value="${proyecto.idProyecto}">
                            <button type="submit" class="btn btn-primary btn-lg active">Recuperar</button>
                        </form>
                    </th>
                    <th>
                        <form method="POST" action="/HumanQualityResearch/admin/elimina-proyecto" >
                            <input id="id" name="id" hidden="true" value="${proyecto.idProyecto}">
                            <button type="submit" class="btn btn-danger btn-lg active">Eliminar</button>
                        </form>
                    </th>
                    </tbody>
                    
                </c:forEach>
            </table>
        </div>
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
</html>


