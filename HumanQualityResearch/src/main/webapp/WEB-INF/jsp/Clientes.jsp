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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuente.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Modal.css"/> ">        
        <title>Clientes</title>
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
                        <li><a href="#clientes">Clientes</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <div id="clientes" class="principal">
            <br/>
            <br/>
            <br/>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Empresa</th>
                        <th>Correo Electrónico</th>
                        <th>Proyectos</th>
                        <th>Gestion de Pruebas</th>
                        <th>Detalles</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <c:forEach var="cliente" items="${lista}">
                    <tbody>
                        <tr>
                            <th>${cliente.persona.nombre}</th>
                            <th>${cliente.persona.empresa}</th>
                            <th>${cliente.persona.correo}</th>
                            <th>
                                <form method="GET" action="/HumanQualityResearch/admin/ver-proyectos" >
                                    <input id="idcliente" name="idcliente" hidden="true" value="${cliente.persona.idPersona}">
                                    <button type="submit" class="btn btn-primary btn-lg active">Proyectos</button>
                                </form>
                            </th>
                            <th>
                                <button type="button" class="btn btn-primary btn-lg active" data-toggle="modal" data-target="#pruebasModal${cliente.persona.idPersona}">Asignar Pruebas 
                                </button>
                                <!-- Modal crear participante -->
                                <div class="modal fade" id="pruebasModal${cliente.persona.idPersona}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel">Asignar Pruebas</h4>
                                            </div>
                                            <form id="asignaPruebas${cliente.persona.idPersona}" method="POST" action="/HumanQualityResearch/admin/asignarpruebas" >
                                                <div class="modal-body">
                                                    <h3 style="color:white;margin-left: 1cm;">Seleciona las pruebas que estaran disponibles para el cliiente</h3>
                                                    <br/>
                                                    <br/>
                                                    <input type="checkbox" name="adapt" value="1" style="margin-left: 1cm;">Adaptabilidad Laboral<br>
                                                    <input type="checkbox" name="clima" value="2" checked style="margin-left: 1cm;">Clima Laboral<br>
                                                    <br/>
                                                    <br/>
                                                    <input id="idcliente" name="idcliente" hidden="true" value="${cliente.persona.idPersona}">
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                                                    <button type="submit" class="btn btn-primary">Aceptar</button>
                                                </div>
                                            </form>                           
                                        </div>
                                    </div>
                                </div>
                            </th>
                            <th>
                                <form method="GET" action="/HumanQualityResearch/admin/muestra-cliente" >
                                    <input id="idcliente" name="idcliente" hidden="true" value="${cliente.persona.idPersona}">
                                    <button type="submit" class="btn btn-primary btn-lg active">Detalles</button>
                                </form>
                            </th>
                            <th>
                                <form method="POST" action="/HumanQualityResearch/admin/borradol-cliente" >
                                    <input id="id" name="id" hidden="true" value="${cliente.persona.idPersona}">
                                    <button type="submit" class="btn btn-danger btn-lg active">Eliminar</button>
                                </form>
                            </th>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>  
        </div>
        <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
        <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    </body>
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
