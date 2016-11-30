<%-- 
    Document   : home
    Created on : 30/09/2016, 10:24:23 AM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/HomeAdmin.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Home-Cliente</title>
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
                        <li><a href="#ver">Ver Proyectos</a></li>
                        <li><a href="#crear">Crear Proyectos</a></li>
                        <li><a href="#salir">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div id="ver" class="container-fluid bg-1">
            <br/>
            <br/>
            <br/>
            <br/>
            <div class="row">   
                <div class="col-sm-8">
                    <h2 id="listado">Ver listado de mis proyectos registrados</h2>
                    <br/>
                    <h2 id="listado">Con la siguiente información:</h2>
                    <h2 id="listado">código, área y tipo de proyecto</h2>
                    <br/>
                    <br/>
                    <div align="center" class="row">
                        <div class="col-md-3" style="margin-left: 2cm;">
                            <br/>
                            <form  method="GET" action = "/HumanQualityResearch/cliente/ver-proyectos"> 
                                <button class="btn btn-primary btn-lg">
                                    <span class="glyphicon glyphicon-book" aria-hidden="true" id="modal"> Proyectos</span> 
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-list-alt logo"></span>
                </div>
            </div>
        </div>
        
        <div id="crear" class="container-fluid bg-2">
            <div class="col-sm-8">
                <h2 id="listado">Crear un nuevo proyecto</h2>
                <br/>
                <h2 id="listado">Designando el área y tipo del proyecto</h2>
                <br/>
                <h2 id="listado">Y seleccionando las pruebas</h2>
                <br/>
                
                <br/>
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#proyectoModal" style="margin-left: 2.5cm;">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" id="modal"> CrearProyecto</span> 
                </button>
            </div>
            <div class="col-sm-4">
                <span class="glyphicon glyphicon-folder-open logo"></span>
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
        
        
        
        <!-- Modal del proyecto -->
        <div class="modal fade" id="proyectoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel" style="color:blue;text-align: center;">Nuevo Proyecto</h4>
                    </div>
                    <form method="POST" action="/HumanQualityResearch/cliente/crear-proyecto" >
                        <div class="modal-body">
                            <div class ="container">
                                <div class="row">
                                    <div class="col-md-4">
                                        <label for="area" style="color:#1D14A4;margin-left: 1cm;">Area del proyecto:</label>
                                        <input id = "area" name = "area" style="margin-left:0.3cm;"/>
                                        <br/>
                                        <br/>
                                        <label for="tipo" style="color:#1D14A4;margin-left: 1cm;">Tipo de proyecto:</label>
                                        <input id = "tipo" name = "tipo" style="margin-left:0.5cm;"/>
                                        <h3>Agregar pruebas</h3>
                                        <c:if test="${al}">
                                        <input type="checkbox" name="adapt" value="1">Adaptabilidad Laboral<br>
                                        </c:if>
                                        <c:if test="${cl}">
                                        <input type="checkbox" name="clima" value="2" checked>Clima Laboral<br>
                                        </c:if>
                                        <br/>
                                        <br/>
                                    </div>
                                </div>
                            </div>
                        </div>    
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Crear Proyecto</button>
                        </div>
                    </form>     
                </div>
            </div>
        </div>
        
        
        
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
