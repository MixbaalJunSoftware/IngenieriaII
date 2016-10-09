<%-- 
    Document   : EditarProyecto
    Created on : 8/10/2016, 09:52:43 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        function myFunction() {
            correo = document.f1.correo.value;
            area  = document.f1.area.value;
            tipo = document.f1.tipo.value;
            if (correo === area && area === tipo)
                alert("Debes llenar almenos un campo");
            else
                document.getElementById("f1").submit();
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/EditarCliente.css"/> ">
        <title>Editar Proyecto</title>
    </head>
    <body>
        <header>
            <br/>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
            <div class="container">
        <h1 style="color:blue;">Ingresa los campos que deseas editar</h1>
        <br/>
        <form id = "f1" name="f1" method="POST" action="/HumanQualityResearch/editar-proyecto" >
            <label for="correo">Correo del cliente:</label>
            <input id = "correo" name = "correo" style="margin-left: 2cm"/>
            <br/>
            <br/>
            <label for="area">Area del proyecto:</label>
            <input id = "area" name = "area" style="margin-left: 2.5cm"/>
            <br/>
            <br/>
            <label for="tipo">Tipo del proyecto:</label>
            <input id = "tipo" name = "tipo" style="margin-left: 1.7cm"/>
            <br/>
            <br/>
            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
            <input type="button" onclick="myFunction()" value="Aceptar" class="btn btn-default btn-lg active">
            <br/>
        </form>
            </div>
            <form action="/HumanQualityResearch/home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
            <br/>
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   

    </body>
</html>
