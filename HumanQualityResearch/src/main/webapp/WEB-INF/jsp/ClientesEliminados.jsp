<%-- 
    Document   : ClientesEliminados
    Created on : 14/11/2016, 09:13:13 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuente.css"/> ">
        <title>Clientes Eliminados</title>
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
                        <li><a href="#clientesElim">Clientes Eliminados</a></li>
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
                        <th>Nombre</th>
                        <th>Empresa</th>
                        <th>Correo Electrónico</th>
                        <th>Fecha de borrado</th>
                    </tr>
                </thead>
                <c:forEach var="cliente" items="${lista}">
                    <tbody>
                        <tr>
                            <th>${cliente.persona.nombre}</th>
                            <th>${cliente.persona.empresa}</th>
                            <th>${cliente.persona.correo}</th>
                            <th>${cliente.persona.fborrado}</th>
                            <th>
                                <form method="POST" action="/HumanQualityResearch/admin/recuperar-cliente" >
                                    <input id="id" name="id" hidden="true" value="${cliente.persona.idPersona}">
                                    <button type="submit" class="btn btn-primary btn-lg active">Recuperar</button>
                                </form>
                            </th>
                            <th>
                                <form method="POST" action="/HumanQualityResearch/admin/elimina-cliente" >
                                    <input id="id" name="id" hidden="true" value="${cliente.persona.idPersona}">
                                    <button type="submit" class="btn btn-danger btn-lg active">Eliminar</button>
                                </form>
                            </th>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

