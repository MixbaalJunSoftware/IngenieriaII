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
            <h1 id="nuevo">¿Terminarás tu registro?</h1>
            <br/>
            <h1 id="registrarte">Al registrarte podrás comenzar tus evaluaciones.</h1>
            <br/>
            <br/>
            <div align="center" class="row">
                <div class="col-md-3" style="margin-left: 2cm">
                    <br/>
                    <button type="button" class="btn btn-primary btn-lg active" position="center" data-toggle="modal" data-target="#registrarModal" style="margin-left: 2.5cm;">Registrate</button>
                    
                    <!-- Modal de registrar -->
                        <div class="modal fade" id="registrarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel" style="color:#1D14A4;">Ingresa tu correo electrónico</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form id = "f1" name ="f1" method="POST" action="/HumanQualityResearch/completar-registro">
                                            <input id = "correo" name="correo" type="text">
                                            <input type="button" class="btn btn-primary" name="enviar-correo" id="enviar-correo" value="enviar">
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button  class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                </div>
            </div>
          </div>
          <div class="col-md-4">
            <h1 id="evaluatest">¿Ya estás registrado en Evaluatest?</h1>
            <br/>
            <form class="form-horizontal" action="/HumanQualityResearch/login" method="POST">
              <div class="form-group">
                <label style="color:#1D14A4;">Usuario</label>
                <input id="username" name="username" type="text" class="col-md-offset-2"/>
              </div>
              <div class="form-group">
                <label style="color:#1D14A4;">Contraseña</label>
                <input id="password" name="password" type="password" class="col-md-offset-1"/>
              </div>
               <br/>
               <div class="form-group" align="center">
                 <button class="btn btn-primary btn-lg active" position="center">Ingresar</button>
               </div>
            </form>
            <br/>
            <p style="color:#1D14A4;">Si olvidaste tu contraseña o usuario haz click
               <a  data-toggle="modal" data-target="#recoverModal">aquí</a>
            </p>
            <!-- Modal de recuperar contrasenia -->
                <div class="modal fade" id="recoverModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel" style="color:#1D14A4;">Ingresa tu correo electrónico</h4>
                                </div>
                            <div class="modal-body">
                                <form id = "frecover" name ="frecover" method="POST" action="/HumanQualityResearch/restablecerPassword">
                                    <input id = "correoRecover" name="correoRecover" type="text">
                                    <input type="button" class="btn btn-primary" name="correo-recover" id="correo-recover" value="enviar">
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button  class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </div>
          </div>
        </div>
      </div>
    </div>
 
        
  </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
    <script src=" <c:url value="/js/validaCorreo.js" /> "></script>
    <script src=" <c:url value="/js/validaCorreoRecover.js" /> "></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

