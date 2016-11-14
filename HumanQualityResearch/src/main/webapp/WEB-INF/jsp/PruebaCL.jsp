<%-- 
    Document   : PruebaCL
    Created on : Nov 14, 2016, 10:40:23 AM
    Author     : rickjmzmnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/.css"/> ">
        <style>
            body {
                position: relative;
                
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
            #section1 {padding-top:50px;height:500px;color: #fff; background-color: #5389C4;}
            #section2 {padding-top:50px;height:500px;color: #fff; background-color: #7D9ED3;}
            #section3 {padding-top:50px;height:500px;color: #fff; background-color: #A5B8E0;}
            #section4 {padding-top:50px;height:500px;color: #fff; background-color: #5389C4;}
            #section5 {padding-top:50px;height:500px;color: #fff; background-color: #7D9ED3;}
            #section6 {padding-top:50px;height:500px;color: #fff; background-color: #A5B8E0;}
            #pregunta {color:blue;font-size: 20px;}
        </style>
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50" style="background-color: #7D9ED3;">
        
        <nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#5389C4;">
            <div class="container-fluid" >
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">HQR</a>
                </div>
                <div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li><a href="#section1">Presentación</a></li>
                            <li><a href="#section2">Preguntas 1-5</a></li>
                            <li><a href="#section3">Preguntas 6-10</a></li>
                            <li><a href="#section4">Preguntas 11-15</a></li>
                            <li><a href="#section5">Preguntas 16-20</a></li>                    
                            <li><a href="/HumanQualityResearch/home">Regresar</a></li>                 
                            
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <form  method="POST" action = "/HumanQualityResearch/empleado/guardaPrueba">
            
            <div id="section1" class="container-fluid">
                <h1>Escala Clima Laboral</h1>
                <br/>
                <p style="font-size: 25px;">Instrucciones:</p>
                <br/>
                <p style="font-size: 20px;">A continuación, encontrará unas frases relacionadas con el trabajo. Están 
                    pensadas para distintos  ambientes laborales, pero puede que no se ajusten del todo al lugar donde trabaja.<br/>
                <p style="font-size: 20px;">Trate de acomodarlas a su propio caso.</p>
                <p style="font-size: 20px;">El jefe es la persona de autoridad(capataz, encargado, supervisor, director, etc.)
                    con quien usted se relaciona. La palabra empleado se utiliza en sentido general, aplicado a todos los que forman
                    parte del personal del lugar de trabajo.</p>
                <p style="font-size: 20px;">La escala de respuesta va de Totalmente en Desacuerdo(TD) a Totalmente de Acuerdo(TA)
                    y puede elegir cualquiera de las seis opciones.</p>
            </div>
            
            <div id="section2" class="container-fluid">
                
                <p id="pregunta">1. La iluminación es muy buena. (AF)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>  
                <br/>
                <p id="pregunta">2. Esta empresa sería una de las primeras en ensayar nuevas ideas. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">3. La variedad no es especialmente importante aquí. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">4. La gente expresa con franqueza lo que piensa. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>
                
                <br/>
                <br/>
                <p id="pregunta">5. Aquí es importante realizar mucho trabajo. (CT)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                
            </div>
            <div id="section3" class="container-fluid">
                
                <p id="pregunta">6. El personal se siente libre para solicitar un aumento de sueldo. (IJ)</p> 
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>  
                <br/>
                <p id="pregunta">7. Se toma en serio la frase "el trabajo antes que el juego". (CT)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>    
                
                <br/>
                <br/>
                <p id="pregunta">8. Los jefes están siempre controlando al personal. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>
                
                <br/>
                <br/>
                <p id="pregunta">9. Aquí los colores y la decoración hacen agradable el lugar de trabajo. (AF)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">10. Se espera que los empleados cumplan muy estrictamente las reglas y costumbres. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                
            </div>  
            
            <div id="section4" class="container-fluid">
                
                <p id="pregunta">11. Normalmente el trabajo es muy interesante. (CT)</p> 
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>
                
                <br/>
                <br/>
                <p id="pregunta">12. El ambiente está siempre bien ventilado. (AF)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>
                
                <br/>
                <br/>
                <p id="pregunta">13. El mobiliario está bien acomodado. (AF)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label> 
                
                <br/>
                <br/>
                <p id="pregunta">14. Los jefes son accesibles. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">15. El cambio no importa mucho aquí. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                
            </div>
            <div id="section5" class="container-fluid">
                
                <p id="pregunta">16. Los jefes supervisan muy estrechamente al personal. (IJ)</p> 
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">17. Las condiciones de pago no son claras. (IJ)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">18. Siempre se exige cumplir con las metas. (CT)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">19. El ambiente me gusta. (AF)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                <br/>
                <br/>
                <p id="pregunta">20. Aquí se trabaja intensamente. (CT)</p>
                
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="1">Totalmente en desacuerdo
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="2">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="3">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="4">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="5">-
                </label>
                <label class="radio-inline">
                    <input required="true" type="radio" name="r1" value="6">Totalmente de acuerdo
                </label>  
                
                
            </div>            
            
            <br/>
            <button type="submit" class="btn btn-primary btn-lg active" style="margin-left: 16cm;">Aceptar</button>        
        </form>
        <br/>
        
        <div id="section6" class="container-fluid">
            <p style="font-size: 25px;">Desarrollada a partir de la Escala de Clima Social Organizacional de Moos,
                con aumento de reactivos para complementar las subescalas. Con una confiabilidad de &alpha; = 0.89, 
                validada con análisis factorial exploratorio y confirmatorio con prueba de invarianza en sector público y privado.</p>
            <br/>
            <p style="font-size: 20px;">CARGA DE TRABAJO</p>
            <br/>
            <p style="font-size: 20px;">INTERACCIÓN CON EL JEFE</p>
            <br/>
            <p style="font-size: 20px;">AMBIENTE FÍSICO</p>
            <br/>
            <p style="font-size: 20px;">CLIMA LABORAL</p>
            <br/>
            <p style="font-size: 20px;">PUMAGUA-enero-febrero</p>                              
        </div>
        
    </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
