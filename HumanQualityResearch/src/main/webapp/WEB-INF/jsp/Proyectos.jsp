<%-- 
    Document   : Proyectos
    Created on : 8/10/2016, 05:49:18 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fuente.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Modal.css"/> ">        
        <title>Proyectos</title>
    </head>
    <body style="background-color: #5389C4;">
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
                        <li><a href="#proyectos">Proyectos</a></li>
                        <li><a href="/HumanQualityResearch/admin/ver-clientes">Regresar a Clientes</a></li>
                        <li><a href="/HumanQualityResearch/home">Regresar al menú</a></li>
                        
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <div id="proyectos" class="principal">
            <br/>
            <br/>
            <br/>
            <table class="table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Área</th>
                        <th>Tipo</th>
                        <th>Detalles</th> 
                        <th>Participantes</th> 
                        <th>Modificar</th>
                        <th>Eliminar</th>           
                        <th>Agregar</th> 
                        
                    </tr>
                </thead>
                <c:forEach var="proyecto" items="${lista}">
                    <tbody>
                    <th>${proyecto.codigo}</th>
                    <th>${proyecto.areaProyecto}</th>
                    <th>${proyecto.tipo.tipo}</th>
                    <th>
                        <form method="POST" action="/HumanQualityResearch/admin/muestra-proyecto" >
                            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                            <button type="submit" class="btn btn-primary btn-lg active">Detalles</button>
                        </form>
                        
                    </th>
                    <th>
                        <form method="GET" action="/HumanQualityResearch/admin/ver-participantes" >
                            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                            <button type="submit" class="btn btn-primary btn-lg active">Participantes</button>
                        </form>
                        
                    </th>
                    <th>
                        <form method="POST" action="/HumanQualityResearch/jactualizar-proyecto" >
                            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                            <button type="submit" class="btn btn-primary btn-lg active">ModificarProyecto</button>
                        </form>
                    </th>
                    <th>
                        <button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#eliminaModal${proyecto.idProyecto}">
                            <span aria-hidden="true" id="modal" >Eliminar</span> 
                        </button>
                        <!-- Modal del cliente -->
                        <div class="modal fade" id="eliminaModal${proyecto.idProyecto}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel" >¿Seguro qué quieres eliminar el proyecto?</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form method="POST" action="/HumanQualityResearch/borradol-proyecto" >
                                            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                                            <button type="submit" class="btn btn-danger btn-lg active" style="margin-left: 5cm;">Eliminar proyecto</button>
                                        </form>
                                        
                                    </div>
                                    <div class="modal-footer">    
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>    
                                    </div>
                                </div>                                  
                            </div>
                        </div>
                        </div>
                        
                    </th>
                    <th>
                        <button type="button" class="btn btn-primary btn-lg active" data-toggle="modal" data-target="#clienteModal${proyecto.idProyecto}">CrearParticipante 
                        </button>                             
                        <!-- Modal crear participante -->
                        <div class="modal fade" id="clienteModal${proyecto.idProyecto}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Nuevo Participante</h4>
                                    </div>
                                    <form id="creaclientecorreo${proyecto.idProyecto}" method="POST" action="/HumanQualityResearch/admin/crear-participanteCorreo" >
                                        <div class="modal-body">
                                            <label for="correo" >Correo del participante:</label>
                                            <input type="email" id = "correo" name = "correo" style="margin-left:1cm;color:black;"/>
                                            <input id="idproyectoCrea" name="idproyectoCrea" hidden="true" value="${proyecto.idProyecto}">
                                            
                                            <br/>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                                            <button type="submit" class="btn btn-primary">Crear Participante</button>
                                        </div>
                                    </form>                           
                                </div>
                            </div>
                        </div>
                    </th>
                    </tbody>
                    
                </c:forEach>
            </table>
        </div>
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
</html>

