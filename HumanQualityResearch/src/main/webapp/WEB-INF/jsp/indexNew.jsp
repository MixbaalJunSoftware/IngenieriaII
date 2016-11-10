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
  </head>
  <style>
    .principal{
            background-color: #5389C4;
            color: #fff;
            padding: 100px 25px;
    }
    .bg-1{
        background-color: #7D9ED3;
    }
    
    .bg-2 {
      background-color: #A5B8E0;
  }
  .container-fluid {
      padding: 60px 50px;
  }
  .logo{
      font-size: 200px;
  }
  .navbar {
    margin-bottom: 0;
    z-index: 9999;
    border: 0;
    font-size: 20px !important;
    line-height: 1.42857143 !important;
    letter-spacing: 4px;
    border-radius: 0;
}
  
    .navbar li a, .navbar .navbar-brand {
    color: #fff !important;
}

    .navbar-nav li a:hover, .navbar-nav li.active a {
    color: #5389C4 !important;
    background-color: #fff !important;
}

    
.navbar-default .navbar-toggle {
    border-color: transparent;
    color: #fff !important;
}

    </style>
  <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="100">
      <nav class="navbar navbar-default navbar-fixed-top" style="background-color:#5389C4;">
  <div class="container" >
    <div class="navbar-header" >
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#myPage">Human Quality Research</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#registrar">Registrarse</a></li>
        <li><a href="#sesion">Iniciar sesión</a></li>
        
      </ul>
    </div>
  </div>
</nav>
      
    <div class="principal text-center">
        <img src="<c:url value="/imagenes/logo_hqr.jpg"/>" alt="Logo HQR"/>
        <h1 id="slogan">La solución que facilita tu evaluación para identificar tu talento.</h1> 
    </div>
          
          <!-- Container (About Section) -->
    <div id="registrar" class="container-fluid bg-1">
        <div class="row">   
            <div class="col-sm-8">
                <h2 id="nuevo" style="color:#1F73BB">¿Terminarás tu registro?</h2>
                <br/>
                <h2 id="registrarte" style="color:white">Al registrarte podrás comenzar tus evaluaciones.</h2>
                <br/>
                <br/>
                <div align="center" class="row">
                    <div class="col-md-3" style="margin-left: 2cm">
                        <br/>
                        <button type="button" class="btn btn-primary btn-lg" position="center" data-toggle="modal" data-target="#registrarModal" style="margin-left: 2.5cm;">Registrate</button>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <span class="glyphicon glyphicon-pencil logo" style="color:white;"></span>
            </div>
        </div>
    </div>
            
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
		      <input type="button" class="btn btn-primary" name="enviar-correo" id="enviar-correo" value="enviar">
		    </form>
		  </div>
		  <div class="modal-footer">
		    <button  class="btn btn-primary" data-dismiss="modal">Cerrar</button>
		  </div>
		</div>
	      </div>
	    </div>

    <div id="sesion" class="container-fluid bg-2">
        <div class="col-sm-8">
        <h1 id="hqr" style="color:#1F73BB">¿Ya estás registrado en Human Quality Research?</h1>
	<br/>
	<form class="form-horizontal" action="/HumanQualityResearch/login" method="POST">
	  <div class="form-group">
	    <label style="color:#1F73BB;font-size:20px;">Usuario</label>
            <input id="username" name="username" type="text" class="col-md-offset-1" style="margin-left:2.9cm;"/>
	  </div>
	  <div class="form-group">
	    <label style="color:#1F73BB;font-size:20px;">Contraseña</label>
	    <input id="password" name="password" type="password" class="col-md-offset-1"/>
	  </div>
	  <br/>
	  <div class="form-group">
              <button class="btn btn-primary btn-lg" style="margin-left:5.8cm;">Ingresar</button>
	  </div>
	</form>
	<br/>
	<p style="color:#1D14A4;margin-left:3cm;">Si olvidaste tu contraseña o usuario haz click
	  <a  data-toggle="modal" data-target="#recoverModal">aquí</a>
	</p>
        </div>
        <div class="col-sm-4">
            <span class="glyphicon glyphicon-user logo" style="color:white;"></span>
        </div>
	
    </div>
             
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
  
                
                
  </body>
  
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
    <script src=" <c:url value="/js/validaCorreo.js" /> "></script>
    <script src=" <c:url value="/js/validaCorreoRecover.js" /> "></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>

