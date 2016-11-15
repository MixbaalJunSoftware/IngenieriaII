<%-- 
    Document   : ParticipantesEliminados
    Created on : 14/11/2016, 11:05:25 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Clientes.css"/> ">
        <title>Participantes Eliminados</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <p id="cliente">Participantes</p>
        <table class="table">
            <thead>
                <tr>
                    <th style="color:#1D14A4;font-size: 20px;">Nombre</th>
                    <th style="color:#1D14A4;font-size: 20px;">Correo Electrónico</th>
                    <th style="color:#1D14A4;font-size: 20px;">Puesto</th>
                    <th style="color:#1D14A4;font-size: 20px;">Fecha de borrado</th>
                </tr>
            </thead>
            <c:forEach var="empleado" items="${lista}">
                <tbody>
                    <tr>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.persona.nombre}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.persona.correo}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.puestoempleado}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.persona.fborrado}</th>
                        <th>
                            <form method="POST" action="/HumanQualityResearch/admin/recuperar-participante" >
                                <input id="id" name="id" hidden="true" value="${empleado.persona.idPersona}">
                                <button type="submit" class="btn btn-primary btn-lg active">Recuperar</button>
                            </form>
                        </th>
                        <th>
                            <form method="POST" action="/HumanQualityResearch/admin/elimina-participante" >
                                <input id="id" name="id" hidden="true" value="${empleado.persona.idPersona}">
                                <button type="submit" class="btn btn-primary btn-lg active">Eliminar</button>
                            </form>
                        </th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
            
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>


