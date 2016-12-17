<%-- 
    Document   : reporteAdaptabilidad
    Created on : 13/11/2016, 09:59:38 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuentePrueba.css"/> ">        
        <title>Reporte de Clima Laboral</title>
    </head>
    <body style="background-color: #5389C4;">
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
                        <li><a href="#participantes">Reporte Clima Laboral</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>                        
                    </ul>
                </div>
            </div>
        </nav>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <h2 style="color:white;text-align: center;">Fecha de Repuesta: ${fecha}</h2>
        <br/>
        <br/>
        <br/>
        <table class="container">
            <tr>
                <th>Factor</th><th>Puntaje</th><th>Interpretacion</th>
            </tr>
            <tr>
                <td width="10%">Interacción con las Autoridades</td><td width="10%">${ia*(100/50)}%</td><td width="80%">${iatxt}</td>
            </tr>
            <tr>
                <td width="10%">Carga de Trabajo</td><td width="10%">${ct*(100/45)}%</td><td width="80%">${cttxt}</td>
            </tr>
            <tr>
                <td width="10%">Ambiente Físico</td><td width="10%">${af*(100/50)}%</td><td width="80%">${aftxt}</td>
            </tr>
            <tr>
                <td width="10%">Total Clima Social Organizacional</td><td width="10%">${tc*(100/120)}%</td><td width="80%">${tctxt}</td>
            </tr>
        </table>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
