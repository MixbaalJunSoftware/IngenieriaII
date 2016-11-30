<%-- 
    Document   : index
    Created on : 24/09/2016, 06:12:19 AM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Index.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Modal.css"/> ">
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
                        <li><a href="#registrar">Registrarse</a></li>
                        <li><a href="#sesion">Iniciar sesión</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="principal text-center" style=" background-color: #5389C4;">
            <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR"/>
            <h1 id="slogan">La solución que facilita tu evaluación para identificar tu talento.</h1> 
        </div>
        
        <!-- Container (About Section) -->
        <div id="registrar" class="container-fluid bg-1" style="background-color: #7D9ED3">
            <div class="row">   
                <div class="col-sm-8">
                    <h2 id="nuevo">¿Terminarás tu registro?</h2>
                    <br/>
                    <h2 id="letra">Al registrarte podrás comenzar tus evaluaciones.</h2>
                    <br/>
                    <br/>
                    <div align="center" class="row">
                        <div class="col-md-3" style="margin-left: 2cm;">
                            <br/>
                            <button id="btnReg" type="button" class="btn btn-primary btn-lg" position="center" data-toggle="modal" data-target="#registrarModal" >Registrate</button>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-pencil logo"></span>
                </div>
            </div>
        </div>
        
        <!-- Modal de registrar -->
        <div class="modal fade" id="registrarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Ingresa tu correo electrónico</h4>
                    </div>
                    <div class="modal-body">
                        <form id = "f1" name ="f1" method="POST" action="/HumanQualityResearch/completar-registro">
                            <input type="email" id = "correo" name="correo" style="margin-left: 4.3cm;">
                            <input type="button" class="btn btn-primary" name="enviar-correo" id="enviar-correo" value="enviar">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button  class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="sesion" class="container-fluid bg-2" style=" background-color: #5389C4;">
            <div class="col-sm-8">
                <h1 id="letra">¿Ya estás registrado en Human Quality Research?</h1>
                <br/>
                <form class="form-horizontal" action="/HumanQualityResearch/login" method="POST">
                    <div class="form-group">
                        <label id="labSes">Usuario</label>
                        <input id="username" name="username" type="email" class="col-md-offset-1" style="margin-left:2.9cm;"/>
                    </div>
                    <div class="form-group">
                        <label id="labSes">Contraseña</label>
                        <input id="password" name="password" type="password" class="col-md-offset-1"/>
                    </div>
                    <br/>
                    <div class="form-group">
                        <button id="btnSes" class="btn btn-primary btn-lg">Ingresar</button>
                    </div>
                </form>
                <br/>
                <p id="contraseña">Si olvidaste tu contraseña o usuario haz click
                    <a  data-toggle="modal" data-target="#recoverModal">aquí</a>
                </p>
            </div>
            <div class="col-sm-4">
                <span class="glyphicon glyphicon-user logo"></span>
            </div>
            
        </div>
        
        <!-- Modal de recuperar contrasenia -->
        <div class="modal fade" id="recoverModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel" style="color:#1D14A4;">Ingresa tu correo electrónico</h4>
                    </div>
                    <div class="modal-body">
                        <form id = "frecover" name ="frecover" method="POST" action="/HumanQualityResearch/restablecerPassword">
                            <input id = "correoRecover" name="correoRecover" type="email">
                            <input type="button" class="btn btn-primary" name="correo-recover" id="correo-recover" value="enviar">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button  class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        
        
    </body>
    
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>     
    <script src=" <c:url value="/js/encuentraCorreo.js" /> "></script>
    <script src=" <c:url value="/js/correoRestaurar.js" /> "></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

