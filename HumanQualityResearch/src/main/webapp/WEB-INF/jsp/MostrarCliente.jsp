<%-- 
    Document   : MostrarCliente
    Created on : 23/09/2016, 07:24:03 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>mostrar cliente</title>
    </head>
    <body>
        <c:set var="p" value="${existe}"/>
        <c:if test="${p}">
            <h1>Datos de un cliente</h1>
            <h2>Nombre: ${nombre} ${app} ${apm}</h2>
            <h2>Fecha de nacimiento: ${fecha}</h2>
            <h2>Género: ${genero}</h2>
            <h2>Empresa: ${empresa}</h2>
            <h2>Puesto: ${puesto}</h2>
            <h2>Correo: ${correo}</h2>
            <h2>Telefono: ${telefono}</h2>
            <h2>Celular: ${celular}</h2>
        </c:if>
        <c:if test="${!p}">
            <h1>El usuario no existe</h1>>
        </c:if>
    </body>
</html>
