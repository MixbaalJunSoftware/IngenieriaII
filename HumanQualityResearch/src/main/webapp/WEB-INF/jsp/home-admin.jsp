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
        <title>home</title>
    </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="100">
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
                        <li><a href="#ver">Ver Clientes</a></li>
                        <li><a href="#crear">Crear Clientes</a></li>
                        <li><a href="#salir">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div id="ver" class="container-fluid bg-1">
            <br/>
            <br/>
            <div class="row">   
                <div class="col-sm-8">
                    <h2 id="listado">Ver listado de clientes registrados</h2>
                    <br/>
                    <h2 id="listado">Con la siguiente información:</h2>
                    <h2 id="listado">nombre, empresa, correo eletrónico y proyectos</h2>
                    <br/>
                    <br/>
                    <div align="center" class="row">
                        <div class="col-md-3" style="margin-left: 2cm;">
                            <br/>
                            <form  method="GET"action = "/HumanQualityResearch/ver-clientes">        
                                <button class="btn btn-primary btn-lg" id="clientes">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true">Clientes</span> 
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
                <h2 id="listado">Crear un nuevo cliente</h2>
                <br/>
                <h2 id="listado">Por medio de su correo eletrónico</h2>
                <br/>
                <br/>
                <button type="button" id="crearCliente" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#clienteModal">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"> CrearCliente</span> 
                </button>
            </div>
            <div class="col-sm-4">
                <span class="glyphicon glyphicon-envelope logo"></span>
            </div>
            
        </div>            
        
        <div id="salir" class="container-fluid bg-3">
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
        
        <!-- Modal del cliente -->
        <div class="modal fade" id="clienteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel" style="color:blue;text-align: center;">Nuevo cliente</h4>
                    </div>
                    <form method="POST" action="/HumanQualityResearch/crear-clienteCorreo" >
                        <div class="modal-body">
                            <label for="correo" style="color:#1D14A4;margin-left: 2.5cm;">Correo del cliente:</label>
                            <input id = "correo" name = "correo" style="margin-left:1cm;"/>
                            <br/>
                            <br/>
                        </div>
                        <div class="modal-footer">
                            
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary">Crear Cliente</button>
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
