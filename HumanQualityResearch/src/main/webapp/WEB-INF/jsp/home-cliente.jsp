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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/> ">
        <title>home</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <div class="container">
            <p id="bienvenido">Bienvenido</p>
            <hr/>
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-1">
                        <br/>
                        <br/>
                        <br/>
                        <form  method="GET"action = "/HumanQualityResearch/cliente/ver-proyectos"> 
                            <button class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-book" aria-hidden="true" id="modal"> Proyectos</span> 
                            </button>
                        </form>    
                        <br/>
                        <br/>  
                        <br/>
                        
                        <form action = "/HumanQualityResearch/logout">
                            <button class="btn btn-default btn-lg" id="modal">Salir</button>
                        </form>
                    </div>
                    <div class="col-md-3 col-md-offset-1">
                        <button class="btn btn-default btn-lg" data-toggle="modal" data-target="#proyectoModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" id="modal"> Crear Proyecto</span> 
                        </button>
                                               
                        
                        <br/>
                        <br/>
                        <br/>
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
                                                    <input type="checkbox" name="adapt" value="1">Adaptabilidad Laboral<br>
                                                    <input type="checkbox" name="clima" value="2" checked>Clima Laboral<br>
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
                    </div>
                </div>                
            </div>    
        </div>
        
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
