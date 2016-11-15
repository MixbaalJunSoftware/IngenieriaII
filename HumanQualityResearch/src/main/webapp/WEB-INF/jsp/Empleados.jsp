<%-- 
    Document   : aEmpleados
    Created on : 24/10/2016, 12:36:20 AM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Clientes.css"/> ">
        <title>Empleados</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <p id="empleados">Empleados</p>
        <table class="table">
            <thead>
                <tr>
                    <th style="color:#1D14A4;font-size: 20px;">Nombre</th>
                    <th style="color:#1D14A4;font-size: 20px;">Correo Electrónico</th>
                    
                </tr>
            </thead>
            <c:forEach var="empleado" items="${listaEmpleados}">
                <tbody>
                    <tr>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.persona.nombre}</th>
                        <th style="color:#1D14A4;font-size: 20px;">${empleado.persona.correo}</th>
                        <th>
                            <form action="/HumanQualityResearch/reportes/candidato/adaptabilidad">
                                <input name = "r2" value = "${empleado.persona.idPersona}" hidden="true" >
                                <button>reporte Adaptabilidad</button>
                            </form>
                        </th>
                        <th>
                            <form action="/HumanQualityResearch/reportes/candidato/climalaboral">
                                <input name = "r2" value = "${empleado.persona.idPersona}" hidden="true" >
                                <button>reporte Clima Laboral</button>
                            </form>
                        </th>
                        <th>
                            <form method="POST" action="/HumanQualityResearch/admin/borradol-participante" >
                                <input id="id" name="id" hidden="true" value="${empleado.persona.idPersona}">
                                <button type="submit" class="btn btn-primary btn-lg active">Eliminar</button>
                            </form>
                        </th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <a id="exportar_boton" href=" <c:url value="/cliente/EmpleadosProyectoExcel?p=${idProyecto}" /> ">&#11015; Exportar a excel</a>
        <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
            
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

