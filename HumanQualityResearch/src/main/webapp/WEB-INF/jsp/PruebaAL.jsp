<%-- 
    Document   : PruebaAL
    Created on : 17/10/2016, 06:18:16 PM
    Author     : ricardo
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
  #section1 {padding-top:50px;height:500px;color: #fff; background-color: #1a1aff;}
  #section2 {padding-top:50px;height:500px;color: #fff; background-color: #3333ff;}
  #section3 {padding-top:50px;height:500px;color: #fff; background-color: #1a1aff;}
  #section4 {padding-top:50px;height:500px;color: #fff; background-color: #3333ff;}
  #section5 {padding-top:50px;height:500px;color: #fff; background-color: #1a1aff;}
  #section6 {padding-top:50px;height:500px;color: #fff; background-color: #3333ff;}
  #section7 {padding-top:50px;height:500px;color: #fff; background-color: #1a1aff;}
  #pregunta {color:black;font-size: 20px;}
  </style>
  </head>
  <body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
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
          <li><a href="#section6">Preguntas 21-25</a></li>
          <li><a href="#section7">Preguntas 26-30</a></li>          
          <li><a href="/HumanQualityResearch/">Regresar</a></li>                 
          
        </ul>
      </div>
    </div>
  </div>
</nav>

<div id="section1" class="container-fluid">
  <h1>Escala Mexicana de Adaptabilidad Laboral</h1>
  <br/>
  <p style="font-size: 25px;">Instrucciones:</p>
  <br/>
  <p style="font-size: 20px;">A continuación encontrarás una serie de enunciados a los cuales debes responder considerando la
     la forma que has pensado,sentido y actuado ante determinadas situaciones en el ambiente laboral.</p>
  <br/>
  <p style="font-size: 20px;">Te pedimos contestar de la manera más honesta y sincera posible ya que no existen respuestas
     buenas o malas</p>
</div>
      
<div id="section2" class="container-fluid">
    
  <p id="pregunta">1. No pierdo la concentración cuando se presentan eventos inesperados en mi trabajo.</p>
  <form>
    <label class="radio-inline">
      <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio" value="2">2. En desacuerdo
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio" value="4">4. De acuerdo
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
    </label>  
  </form>
    <br/>  
    <p id="pregunta">2. Aunque las situaciones no sean estables, soy totalmente competente.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">3. Es difícil para mí encarar eventos inesperados.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">4. Me cuesta trabajo ser una persona madura.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">5. Mi desempeño es igual de bueno en diferentes entornos.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    
</div>
<div id="section3" class="container-fluid">
 
    <p id="pregunta">6. Tengo agilidad mental.</p> 
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">7. Soy una persona madura que sabe cómo actuar en eventos impredecibles.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">8. Me considero hábil para resolver eventos inesperados.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">9. Aunque las situaciones en mi trabajo sean inciertos, soy capaz de encararlas.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">10. Aunque no conozca a fondo la situación en la que me encuentre salgo adelante.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    
</div>  
  
<div id="section4" class="container-fluid">

    <p id="pregunta">11. Me siento entusiasmado cuando me enfrento a un reto difícil de resolver.</p> 
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">12. Resuelvo los conflictos de forma eficaz.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">13. No soy innovador.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">14. Muchos me consideran una persona cuadrada.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">15. Soy astuto para salir de los apuros.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    
</div>
<div id="section5" class="container-fluid">

    <p id="pregunta">16. ¿Cuál es la respuesta correcta de la siguiente operación 38+21-66?</p> 
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. -5
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. -6
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. 7
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. 6
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. -7
        </label>  
    </form>
    <br/>  
    <p id="pregunta">17. Soluciono conflictos hábilmente.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">18. Me causa desconfianza escuchar a personas que no siguen los pasos específicos necesarios 
        para alcanzar una meta.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">19. Soy creativo, a menudo se me ocurren diferentes formas de hacer las cosas.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">20. Encuentro rápidamente respuestas a los problemas.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    
</div>
<div id="section6" class="container-fluid">

    <p id="pregunta">21. Se me dificulta establecer nuevas relaciones personales en la empresa.</p> 
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">22. No soy comunicativo.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">23. Algunas personas dicen que soy irritante.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">24. La relación con mis compañeros de trabajo es limitada.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">25. Prefiero estar solo que mal acompañado.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>

</div>
<div id="section7" class="container-fluid">

    <p id="pregunta">26. A veces soy inmaduro en mi trabajo.</p> 
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">27. Me enojo muy rápido si alguien me contradice.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">28. Soy agresivo con aquellos que me provocan.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">29. Soy tímido, me cuesta trabajo hablar con desconocidos.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>  
    <p id="pregunta">30. Puedo ser irrespetuoso.</p>
    <form>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input type="radio" name="optradio" value="5">5. Totalmente de acuerdo
        </label>  
    </form>
    <br/>
    <button type="submit" class="btn btn-primary btn-lg active">Aceptar</button>
            

</div>

  </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
