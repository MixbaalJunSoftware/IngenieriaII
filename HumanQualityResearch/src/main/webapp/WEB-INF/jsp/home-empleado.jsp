<%-- 
    Document   : home-empleado
    Created on : 23/10/2016, 12:02:01 PM
    Author     : danii
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
                        <form action = "/HumanQualityResearch/empleado/contestarPrueba">
                            <button class="btn btn-default btn-lg" id="modal">Contestar Prueba</button>
                        </form>
                        <br/>
                        <br/>
                        <br/>
                        <form action = "/HumanQualityResearch/empleado/previoActualizarEmpleado">
                            <button class="btn btn-default btn-lg" id="modal">Editar Datos</button>
                        </form>   
                        <br/>
                        <br/>
                        <br/>
                        <form action = "/HumanQualityResearch/logout">
                            <button class="btn btn-default btn-lg" id="modal">Salir</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
