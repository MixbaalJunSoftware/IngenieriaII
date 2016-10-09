<%-- 
    Document   : index
    Created on : 24/09/2016, 06:12:19 AM
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/> ">
  </head>
  <body>
    <div class="container">
      <br/>
      <header>
        <br/>
        <br/>
        <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR"/>
      </header>
      <hr/>
      <slogan>
        <h1 id="slogan">La solución que facilita tu evaluación para identificar tu talento.</h1>
      </slogan>
      <br/>
      <div class="container">
        <div class="row">
          <div class="col-md-5 col-md-offset-1">
            <h1 id="nuevo">¿Eres nuevo?</h1>
            <br/>
            <h1 id="registrarte">Al registrarte podrás comenzar tus evaluaciones.</h1>
            <br/>
            <br/>
            <div align="center" class="row">
                <div class="col-md-3" style="margin-left: 2cm">
                    <button type="button" class="btn btn-default btn-lg active" position="center" data-toggle="modal" data-target="#registrarModal">Registrate</button>
                    
                    <!-- Modal de registrar -->
                        <div class="modal fade" id="registrarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Ingresa tu correo electrónico</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form id = "f1" name ="f1" method="POST" action="/HumanQualityResearch/completar-regitro">
                                            <input id = "correo" name="correo" type="text">
                                            <input type="button" name="enviar-correo" id="enviar-correo" value="enviar">
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button  class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                </div>
                <div class="col-md-7">
                 <form  action="/HumanQualityResearch/opciones" >
                    <button type="submit"  class="btn btn-default btn-lg active" position="center">Opciones</button>
                </form>
                </div>  
            </div>
          </div>
          <div class="col-md-4">
            <h1 id="evaluatest">¿Ya estás registrado en Evaluatest?</h1>
            <br/>
            <form class="form-horizontal" action="/HumanQualityResearch/login" method="POST">
              <div class="form-group">
                <label>Usuario</label>
                <input id="username" name="username" type="text" class="col-md-offset-2"/>
              </div>
              <div class="form-group">
                <label>Contraseña</label>
                <input id="password" name="password" type="password" class="col-md-offset-1"/>
              </div>
               <br/>
               <div class="form-group" align="center">
                 <button class="btn btn-default btn-lg active" position="center">Ingresar</button>
               </div>
            </form>
            <br/>
            <p>Si olvidaste tu contraseña o usuario haz click
              <a href="link">aquí</a>
            </p>
          </div>
        </div>
      </div>
    </div>
      <form action = "/HumanQualityResearch/coso" method="POST">
        <input type="text" name="coso">
        <button>enviar</button>
    </form>
  </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
    <script src=" <c:url value="/js/validaCorreo.js" /> "></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

