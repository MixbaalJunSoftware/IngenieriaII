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
        <div class="container">
            <p id="bienvenido">Bienvenido</p>
            <hr/>
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-1">
                        <br/>
                        <br/>
                        <form  method="POST"action = "/HumanQualityResearch/ver-clientes">        
                            <button class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Clientes
                            </button>
                        </form>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-book" aria-hidden="true"></span> Proyectos
                        </button>
                        <br/>
                        <br/>
                        <br/>
                        <form action = "/HumanQualityResearch/logout">
                            <button class="btn btn-default btn-lg">Salir</button>
                        </form>
                    </div>
                    <div class="col-md-3 col-md-offset-1">
                        <br/>
                        <br/>
                        <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span> Crear Cliente
                        </button>
 
                        <br/>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Crear Proyecto
                        </button>
                        <br/>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Crear Códigos
                        </button>
                    </div>
                </div>                
            </div>    
        </div>
        
    </body>
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
