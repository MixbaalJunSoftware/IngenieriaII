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
            puesto = document.f1.puesto.value;
            area = document.f1.area.value;
            tel = document.f1.tel.value;
            cel = document.f1.cel.value;
            clave1 = document.f1.pass.value; 
            clave2 = document.f1.rpass.value;
            if (puesto === area && area === tel && tel === cel && cel === clave1)
                alert("Debes llenar almenos un campo");
            else if (clave1 !== clave2){ 
                alert("Las contraseñas no coinciden");
            }else
                document.getElementById("f1").submit(); 
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
        <form id = "f1" name="f1" method="POST" action="/HumanQualityResearch/actualizar-cliente-accion" >
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
            <label for="pass">Contraseña:</label>
            <input type="password" id = "pass" name = "pass" style="margin-left: 1cm"/>
            <br/>
            <br/>
            <label for="newpass">Repite la contraseña:</label>
            <input type="password" id = "rpass" name = "rpass" style="margin-left: 1.3cm"/>
            <br/>
            <br/>
            <input id="idcliente" name="idcliente" hidden="true" value="${usuario.persona.idPersona}">
            <input type="button" onclick="myFunction()" value="Aceptar" class="btn btn-default btn-lg active">
            <br/>
        </form>
            </div>
            <form action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
            <br/>
                <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   

    </body>
</html>
