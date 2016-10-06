<%-- 
    Document   : home
    Created on : 30/09/2016, 10:24:23 AM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/> ">
        <title>home</title>
    </head>
    <body>
        <div class="container">
            <p id="bienvenido">Bienvenido</p>
            <hr/>
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-1">
                        <br/>
                        <br/>
                        <form  method="POST"action = "/HumanQualityResearch/ver-clientes">        
                            <button class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Clientes
                            </button>
                        </form>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-book" aria-hidden="true"></span> Proyectos
                        </button>
                        <br/>
                        <br/>
                        <br/>
                        <form action = "/HumanQualityResearch/logout">
                            <button class="btn btn-default btn-lg">Salir</button>
                        </form>
                    </div>
                    <div class="col-md-3 col-md-offset-1">
                        <br/>
                        <br/>
                        <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#clienteModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span> Crear Cliente
                        </button>
                                                 
                        <!-- Modal del cliente -->
                        <div class="modal fade" id="clienteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Nuevo cliente</h4>
                                    </div>
                                    <div class="modal-body">
                                    ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                        <button type="button" class="btn btn-primary">Crear Cliente</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <br/>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg" data-toggle="modal" data-target="#proyectoModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Crear Proyecto
                        </button>
                        
                        <!-- Modal del proyecto -->
                        <div class="modal fade" id="proyectoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Nuevo Proyecto</h4>
                                    </div>
                                    <div class="modal-body">
                                    ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                        <button type="button" class="btn btn-primary">Crear Proyecto</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <br/>
                        <br/>
                        <br/>
                        <button class="btn btn-default btn-lg" data-toggle="modal" data-target="#codigoModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Crear Códigos
                        </button>
                        
                        <!-- Modal del cliente -->
                        <div class="modal fade" id="codigoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Nuevo código</h4>
                                    </div>
                                    <div class="modal-body">
                                    ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                        <button type="button" class="btn btn-primary">Crear Código</button>
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
    
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
