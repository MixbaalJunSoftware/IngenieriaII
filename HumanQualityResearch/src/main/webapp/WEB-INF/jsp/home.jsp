<%-- 
    Document   : home
    Created on : 30/09/2016, 10:24:23 AM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <form action = "/HumanQualityResearch/logout">
            <button>Salir</button>
        </form>
        <form  method="POST"action = "/HumanQualityResearch/ver-clientes">
            <button>Clientes</button>
        </form>
    </body>
</html>
