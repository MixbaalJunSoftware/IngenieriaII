<%-- 
    Document   : EditarCliente
    Created on : Nov 30, 2016, 10:32:14 AM
    Author     : rickjmzmnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <script src=" <c:url value="/js/gen_validatorv4.js" /> "></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Editar.css"/> ">
        <title>Editar mi información</title>
    </head>
    <body style="background-color: #5389C4;">
        <script>
            function myFunction() {
                puesto = document.fparticipante.puesto.value;
                tel = document.fparticipante.tel.value;
                cel = document.fparticipante.cel.value;
                clave1 = document.fparticipante.pass.value; 
                clave2 = document.fparticipante.rpass.value;
                if (puesto === tel && tel === cel && cel === clave1)
                    alert("Debes llenar almenos un campo");
                else if (clave1 !== clave2){ 
                    alert("Las contraseñas no coinciden");
                }else{
                    var vtel = new RegExp("^[0-9]{8}$");
                    var vcel = new RegExp("^[0-9]{10}$");
                    if(tel !== "" && !vtel.test(tel)){
                        alert("el telefono no tiene el formato solicitado");
                    }else if(cel !== "" && !vcel.test(cel)) {
                        alert("el celular no tiene el formato solicitado");
                    }else
                        document.getElementById("fparticipante").submit();
                }
            }
        </script>
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
                        <li><a href="#registroParticipante">Editar Mi Información</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <br/>
            <br/>
            <br/>
            <h2 id="titulo">Ingresa los campos que deseas editar</h2>
            <br/>
            <form id = "fparticipante" name="fparticipante" method="POST" action="/HumanQualityResearch/actualizar-cliente-accion" >
                <label id="palabra" for="puesto" style="margin-left: 10cm;">Puesto:</label>
                <input id = "puesto" name = "puesto" style="margin-left: 2cm"/>
                <br/>
                <br/>
                <label id="palabra" for="puesto" style="margin-left: 10cm;">Área:</label>
                <input id = "puesto" name = "puesto" style="margin-left: 2.7cm"/>
                <br/>
                <br/>
                <label id="palabra" for="tel" style="margin-left: 10cm;">Telefono:</label>
                <input type="tel" pattern="[0-9]{8}" placeholder="ocho digitos" id = "tel" name = "tel" style="margin-left: 1.5cm"/>
                <br/>
                <br/>
                <label id="palabra" for="cel" style="margin-left: 10cm;">Celular:</label>
                <input type="tel" pattern="[0-9]{10}" placeholder="diez digitos" id = "cel" name = "cel" style="margin-left: 2cm"/>
                <br/>
                <br/>
                <h2 id="titulo">Modificar contraseña</h2>
                <br/>
                <label id="palabra" for="pass" style="margin-left: 9cm;">Contraseña:</label>
                <input type="password" id = "pass" name = "pass" style="margin-left: 4cm"/>
                <br/>
                <br/>
                <label id="palabra" for="newpass" style="margin-left: 9cm;">Repite la contraseña:</label>
                <input type="password" id = "rpass" name = "rpass" style="margin-left: 1.2cm"/>
                <br/>
                <br/>
                <input id="idparticipante" name="idparticipante" hidden="true" value="${usuario.persona.idPersona}">
                <input type="button" onclick="myFunction()" value="Aceptar" class="btn btn-primary btn-lg active" style="margin-left: 14cm;">
                <br/>
            </form>
        </div>
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
        
    </body>
</html>

