<%-- 
    Document   : Opciones
    Created on : 25/09/2016, 10:52:07 PM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Opciones.css"/> ">
        <title>Opciones</title>
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
            <br/>
            <br/>
            <p id="consulta">Para realizar alguna acción, se debe de proporcionar el id del cliente</p>
            <br/>
            <br/>
            <br/>
            <div class="row">
                <div class="col-md-4">
                    <form method="POST" action="/HumanQualityResearch/muestra-cliente" >
                        <p id="muestra">Mostrar cliente<p>
                        <input id = "id" name = "id"/>
                        <br/>
                        <br/>
                        <button type="submit" class="btn btn-default btn-lg active">Aceptar</button>
                    </form>
                </div>
                <div class="col-md-4">
                    <form method="POST" action="/HumanQualityResearch/prueba-actualiza-cliente" >
                        <p id="actualiza">Actualizar cliente</p>
                        <input id = "id" name = "id"/>
                        <br/>
                        <br/>
                        <button type="submit" class="btn btn-default btn-lg active">Aceptar</button>
                    </form>
                </div>
                <div class="col-md-4">
                    <form method="POST" action="/HumanQualityResearch/elimina-cliente" >
                        <p id="elimina">Eliminar cliente</p>
                        <input id = "id" name = "id"/>
                        <br/>
                        <br/>
                        <button type="submit" class="btn btn-default btn-lg active">Aceptar</button>
                    </form>
                </div>
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
            <form action="/HumanQualityResearch/" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center">Regresar</button>
            </form>
        </div>    
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</html>
