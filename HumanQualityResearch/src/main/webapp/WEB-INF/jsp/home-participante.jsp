<%-- 
    Document   : home-participante
    Created on : 23/10/2016, 12:02:01 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/HomeAdmin.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>home</title>
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="100" style="background-color: #00008B;">
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
                        <li><a href="#editar">Editar Mis Datos</a></li>
                        <li><a href="#prueba">Pruebas</a></li>
                        <li><a href="#salir">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div id="editar" class="container-fluid bg-1">
            <br/>
            <br/>
            <br/>
            <br/>
            <div class="row">   
                <div class="col-sm-8">
                    <h2 id="listado">Editar mi información</h2>
                    <br/>
                    <br/>
                    <div align="center" class="row">
                        <div class="col-md-3" style="margin-left: 2cm;">
                            <br/>
                            
                            <form action = "/HumanQualityResearch/participante/previoActualizarParticipante">
                                <button class="btn btn-primary btn-lg" id="modal">Editar Datos</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-pencil logo"></span>
                </div>
            </div>
        </div>
        
        <div id="prueba" class="container-fluid bg-2">
            <h2 id="listado">Pruebas que deben ser respondidas</h2>
            <br/>
            <br/>
            <br/>
            <div class="col-md-6">
                <c:if test="${adaptab}">
                    <form action = "/HumanQualityResearch/participante/contestarPrueba">
                        <button class="btn btn-primary btn-lg" id="modal" style="margin-left: 2cm;">Contestar Prueba Adaptabilidad Laboral</button>
                    </form>
                    
                </c:if>
            </div>
            <div class="col-md-6">
                <c:if test="${climab}">
                    <form action = "/HumanQualityResearch/participante/contestarPruebaCL">
                        <button class="btn btn-primary btn-lg" id="modal">Contestar Prueba Clima Laboral</button>
                    </form>
                </c:if>
            </div>
            
        </div>
        
        <div id="salir" class="container-fluid bg-1">
            <div class="col-sm-8">
                <h2 id="listado">Salir a la página principal</h2>
                <br/>
                <br/>
                <form action = "/HumanQualityResearch/logout">
                    <button class="btn btn-primary btn-lg" id="btnSalir">Salir</button>
                </form>
            </div>
            <div class="col-sm-4">
                <span class="glyphicon glyphicon-log-out logo"></span>
            </div>            
        </div>
        
        
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

