<%-- 
    Document   : aProyectos
    Created on : 23/10/2016, 11:39:46 PM
    Author     : danii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Proyectos.css"/> ">
        <title>Proyectos</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <p id="proyecto">Proyectos</p>
        <table class="table">
            <thead>
                <tr>
                    <th style="color:#1D14A4;font-size: 20px;">Código</th>
                    <th style="color:#1D14A4;font-size: 20px;">Área</th>
                    <th style="color:#1D14A4;font-size: 20px;">Tipo</th>
                    <th style="color:#1D14A4;font-size: 20px;">Modificar</th>
                    <th style="color:#1D14A4;font-size: 20px;">Eliminar</th>                    
                </tr>
            </thead>
        
        <c:forEach var="proyecto" items="${lista}">
            <tbody>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.codigo}</th>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.areaProyecto}</th>
                <th style="color:#1D14A4;font-size: 20px;">${proyecto.tipo.tipo}</th>
                <th>
                    <form method="POST" action="/HumanQualityResearch/ver-empleados" >
                    <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                    <button type="submit" class="btn btn-primary btn-lg active">Empleados</button>
                    </form>
                    
                </th>
                <th>
                <form method="POST" action="/HumanQualityResearch/jactualizar-proyecto" >
                    <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                    <button type="submit" class="btn btn-primary btn-lg active">Modificar proyecto</button>
                </form>
                </th>
                <th>
                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#eliminar">
                            <span aria-hidden="true" id="modal" >Eliminar</span> 
                    </button>
                    <!-- Modal del cliente -->
                        <div class="modal fade" id="eliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel" style="color:blue;text-align: center;">¿Seguro qué quieres eliminar el proyecto?</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form method="POST" action="/HumanQualityResearch/elimina-proyecto" >
                                            <input id="idproyecto" name="idproyecto" hidden="true" value="${proyecto.idProyecto}">
                                            <button type="submit" class="btn btn-danger btn-lg active">Eliminar proyecto</button>
                                        </form>
                                            <br/>
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>    
                                    </div>                                  
                                </div>
                            </div>
                        </div>
                
                    </th>
            </tbody>
            
        </c:forEach>
        </table>
        <form method="GET" action="/HumanQualityResearch/redirect-home" >
                    <button type="submit"  class="btn btn-primary btn-lg active" position="center" style="margin-left: 30cm">Regresar</button>
        </form>
    </body>
        <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</html>

