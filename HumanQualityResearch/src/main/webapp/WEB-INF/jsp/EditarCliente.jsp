<%-- 
    Document   : EditarCliente
    Created on : 23/09/2016, 01:40:58 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <script>
        function myFunction() {
        clave1 = document.f1.pass.value; 
        clave2 = "${usuario.getContrasenia()}";
        if (clave1 === clave2){ 
            document.getElementById("f1").submit();
        }else 
            alert("El correo anterior no coincide"); 
    }
</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/EditarCliente.css"/> ">
        <title>Editar Cliente</title>
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
        <form id = "f1" name="f1" method="POST" action="/HumanQualityResearch/actualizar-cliente" >
            <label for="puesto">Puesto:</label>
            <input id = "puesto" name = "puesto" style="margin-left: 2cm"/>
            <br/>
            <br/>
            <label for="area">Area:</label>
            <input id = "area" name = "area" style="margin-left: 2.5cm"/>
            <br/>
            <br/>
            <label for="tel">Telefono:</label>
            <input id = "tel" name = "tel" style="margin-left: 1.7cm"/>
            <br/>
            <br/>
            <label for="cel">Celular:</label>
            <input id = "cel" name = "cel" style="margin-left: 2cm"/>
            <br/>
            <br/>
            <h1 style="color:blue;">Modificar contraseña</h1>
            <br/>
            <label for="pass">Contraseña anterior:</label>
            <input id = "pass" name = "pass" style="margin-left: 1cm"/>
            <br/>
            <br/>
            <label for="newpass">Nueva contraseña:</label>
            <input id = "newpass" name = "newpass" style="margin-left: 1.3cm"/>
            <br/>
            <br/>
            <input id="idcliente" name="idcliente" hidden="true" value="${usuario.persona.idPersona}">
            <input type="button" onclick="myFunction()" value="Aceptar" class="btn btn-default btn-lg active">
            <br/>
        </form>
            </div>
            <form method="POST" action="/HumanQualityResearch/opciones" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
            <br/>
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   

    </body>
</html>
