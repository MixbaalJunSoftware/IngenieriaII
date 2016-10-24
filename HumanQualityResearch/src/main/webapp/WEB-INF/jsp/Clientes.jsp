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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Clientes.css"/> ">
        <title>Clientes</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <p id="cliente">Clientes</p>
        <table class="table">
            <thead>
                <tr>
                    <th style="color:#1D14A4;font-size: 20px;">Nombre</th>
                    <th style="color:#1D14A4;font-size: 20px;">Empresa</th>
                    <th style="color:#1D14A4;font-size: 20px;">Correo Electrónico</th>
                    <th style="color:#1D14A4;font-size: 20px;">Proyectos</th>
                </tr>
            </thead>
            <c:forEach var="cliente" items="${lista}">
                <tbody>
                    <tr>
                        <th style="color:#1D14A4;font-size: 20px;">${cliente.persona.nombre}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${cliente.empresa}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${cliente.persona.correo}</th>
                        <th>
                            <form method="POST" action="/HumanQualityResearch/admin/ver-proyectos" >
                                <input id="idcliente" name="idcliente" hidden="true" value="${cliente.persona.idPersona}">
                                <button type="submit" class="btn btn-primary btn-lg active">Proyectos</button>
                            </form>
                        </th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <form method="POST" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
            
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
