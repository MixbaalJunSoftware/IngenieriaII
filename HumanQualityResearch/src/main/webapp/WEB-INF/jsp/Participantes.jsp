<%-- 
    Document   : aParticipantes
    Created on : 24/10/2016, 12:36:20 AM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuente.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Participantes</title>
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
                        <li><a id="exportar_boton" href=" <c:url value="/cliente/ParticipantesProyectoExcel?p=${idProyecto}" /> ">&#11015; Exportar a excel</a></li>
                        <li><a href="#participantes">Participantes</a></li>
                        <li><a href="/HumanQualityResearch/admin/ver-clientes">Regresar a Clientes</a></li>                        
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>                        
                    </ul>
                </div>
            </div>
        </nav>
        <div id="participantes" class="principal">
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Correo Electrónico</th>
                        
                    </tr>
                </thead>
                <c:forEach var="participante" items="${listaParticipantes}">
                    <tbody>
                        <tr>
                            <th>${participante.persona.nombre}</th>
                            <th>${participante.persona.correo}</th>
                            <th>
                                <form action="/HumanQualityResearch/muestra-participante">
                                    <input name = "idparticipante" value = "${participante.persona.idPersona}" hidden="true" >
                                    <button>Detalles</button>
                                </form>
                            </th>
                            <th>
                                <form action="/HumanQualityResearch/reportes/candidato/adaptabilidad">
                                    <input name = "r2" value = "${participante.persona.idPersona}" hidden="true" >
                                    <button>reporte Adaptabilidad</button>
                                </form>
                            </th>
                            <th>
                                <form action="/HumanQualityResearch/reportes/candidato/climalaboral">
                                    <input name = "r2" value = "${participante.persona.idPersona}" hidden="true" >
                                    <button>reporte Clima Laboral</button>
                                </form>
                            </th>
                            <th>
                                <form method="POST" action="/HumanQualityResearch/borradol-participante" >
                                    <input id="id" name="id" hidden="true" value="${participante.persona.idPersona}">
                                    <button type="submit" class="btn btn-danger btn-lg active">Eliminar</button>
                                </form>
                            </th>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

