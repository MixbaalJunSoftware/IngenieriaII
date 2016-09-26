<%-- 
    Document   : AdvEliminaCliente
    Created on : 25/09/2016, 11:49:25 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/CrearCliente.css"/> ">
        <title>Crear Cliente</title>
    </head>
    <body>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR">
            </div>
        </header>
        <div class="bo1" align="center">
            <img class="logoHQR" src="<c:url value="/imagenes/Warning.jpg"/>" width=200 height=200 alt="WarningImg">
        </div>    
        <h2>¿Esta seguro que quiere eliminar este usuario?</h2>
        <br/>
        <br/>
        <br/>
        <button type="button" class="btn btn-default btn-lg active" position="center">Aceptar</button>
        <button type="button" class="btn btn-default btn-lg active" position="center">Cancelar</button>
    </body>
</html>
