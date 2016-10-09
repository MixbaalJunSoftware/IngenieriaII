<%-- 
    Document   : CrearCliente
    Created on : 25/09/2016, 04:28:18 PM
    Author     : luis
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
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <div class ="container">
            <div class="row">
        <form method="POST" action="/HumanQualityResearch/crear-cliente" >
            <p id="registro">Registro del cliente</p>
            <div class="col-md-4">
            <label for="nombre">Nombre:</label>
            <input required="true" id = "nombre" name = "nombre" style="margin-left:"/>
            <br/>
            <br/>
            <label for="app">Apellido Paterno:</label>
            <input required="true" id = "app" name = "app" style="margin-left:"/>
            <br/>
            <br/>
            <label for="apm">Apellido Materno:</label>
            <input required="true" id = "apm" name = "apm" style="margin-left:"/>
            <br/>
            <br/>
            <label for="fecha">Fecha de nacimiento:</label>
            <input required="true" id = "fecha" name = "fecha" style="margin-left:"/>
            <br/>
            <br/>
            <label for="genero">Género:</label>
                <label class="radio-inline">
                    <input type="radio" name="genero" id="genero" value="M"> Masculino
                </label>
                <label class="radio-inline">
                    <input type="radio" name="genero" id="genero" value="F"> Femenino
                </label>
            <!--<input id = "genero" name = "genero" style="margin-left:"/>-->
            <br/>
            <br/>
            </div>
            <div class="col-md-4">
            <label for="empresa">Empresa:</label>
            <input required="true" id = "empresa" name = "empresa" style="margin-left:"/>
            <br/>
            <br/>
            <label for="puesto">Puesto:</label>
            <input required="true" id = "puesto" name = "puesto" style="margin-left:"/>
            <br/>
            <br/>
            <label for="area">Área:</label>
            <input required="true" id = "area" name = "area" style="margin-left:"/>
            <br/>
            <br/>
            <label for="telefono">Telefono:</label>
            <input required="true"  id = "telefono" name = "telefono" style="margin-left:"/>
            <br/>
            <br/>
            <label for="celular">Celular:</label>
            <input required="true" id = "celular" name = "celular" style="margin-left:"/>
            <br/>
            <br/>
            </div>
            <div class="col-md-4">
                <input id = "correo" name = "correo" value="${correoRegistrado}" hidden="true"/>
            <label for="pass">Contraseña:</label>
            <input required="true" id = "pass" name = "pass" type="password" style="margin-left:"/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-default btn-lg active">Aceptar</button>
            </div>
            
        </form>
                
            </div>
        </div>
            <form method="POST" action="/HumanQualityResearch/" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
            </form>
            <br/>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
</html>
