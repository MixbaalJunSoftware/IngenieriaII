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
  #section3 {padding-top:50px;height:500px;color: #fff; background-color: #5389C4;}
  #section4 {padding-top:50px;height:500px;color: #fff; background-color: #7D9ED3;}
  #section5 {padding-top:50px;height:500px;color: #fff; background-color: #5389C4;}
  #section6 {padding-top:50px;height:500px;color: #fff; background-color: #7D9ED3;}
  #section7 {padding-top:50px;height:500px;color: #fff; background-color: #5389C4;}
  #pregunta {color:white;font-size: 20px;}
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
          <li><a href="#section6">Preguntas 21-25</a></li>
          <li><a href="#section7">Preguntas 26-30</a></li>          
          <li><a href="/HumanQualityResearch/home">Regresar</a></li>                 
          
        </ul>
      </div>
    </div>
  </div>
</nav>
      <form  method="POST" action = "/HumanQualityResearch/participante/guardaPruebaAdapt">

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
  
    <label class="radio-inline">
      <input required="true" type="radio" name="r1" value="1">1. Totalmente en desacuerdo
    </label>
    <label class="radio-inline">
      <input required="true" type="radio" name="r1" value="2">2. En desacuerdo
    </label>
    <label class="radio-inline">
      <input required="true" type="radio" name="r1" value="3">3. Ni de acuerdo ni en desacuerdo
    </label>
    <label class="radio-inline">
      <input required="true" type="radio" name="r1" value="4">4. De acuerdo
    </label>
    <label class="radio-inline">
      <input required="true" type="radio" name="r1" value="5">5. Totalmente de acuerdo
    </label>  
  
    <br/>  
    <br/>
    <p id="pregunta">2. Aunque las situaciones no sean estables, soy totalmente competente.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r2" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r2" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r2" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r2" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">3. Es difícil para mí encarar eventos inesperados.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r3" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">4. Me cuesta trabajo ser una persona madura.</p>
    
        <label class="radio-inline">
            <input  required="true" type="radio" name="r4" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r4" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r4" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r4" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r4" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">5. Mi desempeño es igual de bueno en diferentes entornos.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r5" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r5" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r5" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r5" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r5" value="5">5. Totalmente de acuerdo
        </label>  
    
    
</div>
<div id="section3" class="container-fluid">
 
    <p id="pregunta">6. Tengo agilidad mental.</p> 
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r6" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r6" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r6" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r6" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r6" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>  
    <br/>
    <p id="pregunta">7. Soy una persona madura que sabe cómo actuar en eventos impredecibles.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r7" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r7" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r7" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r7" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r7" value="5">5. Totalmente de acuerdo
        </label>  
  
    <br/>
    <br/>
    <p id="pregunta">8. Me considero hábil para resolver eventos inesperados.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r8" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r8" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r8" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r8" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r8" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">9. Aunque las situaciones en mi trabajo sean inciertos, soy capaz de encararlas.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r9" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r9" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r9" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r9" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r9" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">10. Aunque no conozca a fondo la situación en la que me encuentre salgo adelante.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r10" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r10" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r10" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r10" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r10" value="5">5. Totalmente de acuerdo
        </label>  
    
    
</div>  
  
<div id="section4" class="container-fluid">

    <p id="pregunta">11. Me siento entusiasmado cuando me enfrento a un reto difícil de resolver.</p> 
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r11" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r11" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r11" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r11" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r11" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">12. Resuelvo los conflictos de forma eficaz.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r12" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r12" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r12" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r12" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r12" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">13. No soy innovador.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r13" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r13" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r13" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r13" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r13" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">14. Muchos me consideran una persona cuadrada.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r14" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r14" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r14" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r14" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r14" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">15. Soy astuto para salir de los apuros.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r15" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r15" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r15" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r15" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r15" value="5">5. Totalmente de acuerdo
        </label>  
    
    
</div>
<div id="section5" class="container-fluid">

    <p id="pregunta">16. ¿Cuál es la respuesta correcta de la siguiente operación 38+21-66?</p> 
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r16" value="1">1. -5
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r16" value="2">2. -6
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r16" value="3">3. 7
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r16" value="4">4. 6
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r16" value="5">5. -7
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">17. Soluciono conflictos hábilmente.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r17" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r17" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r17" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r17" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r17" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">18. Me causa desconfianza escuchar a personas que no siguen los pasos específicos necesarios 
        para alcanzar una meta.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r18" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r18" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r18" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r18" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r18" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">19. Soy creativo, a menudo se me ocurren diferentes formas de hacer las cosas.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r19" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r19" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r19" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r19" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r19" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">20. Encuentro rápidamente respuestas a los problemas.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r20" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r20" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r20" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r20" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r20" value="5">5. Totalmente de acuerdo
        </label>  
    
    
</div>

<div id="section6" class="container-fluid">

    <p id="pregunta">21. Se me dificulta establecer nuevas relaciones personales en la empresa.</p> 
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r21" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r21" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r21" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r21" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r21" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">22. No soy comunicativo.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r22" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r22" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r22" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r22" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r22" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">23. Algunas personas dicen que soy irritante.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r23" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r23" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r23" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r23" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r23" value="5">5. Totalmente de acuerdo
        </label>  

    <br/>
    <br/>
    <p id="pregunta">24. La relación con mis compañeros de trabajo es limitada.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r24" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r24" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r24" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r24" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r24" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">25. Prefiero estar solo que mal acompañado.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r25" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r25" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r25" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r25" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r25" value="5">5. Totalmente de acuerdo
        </label>  
</div> 

<div id="section7" class="container-fluid">

    <p id="pregunta">26. A veces soy inmaduro en mi trabajo.</p> 
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r26" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r26" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r26" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r26" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r26" value="5">5. Totalmente de acuerdo
        </label>  

    <br/>
    <br/>
    <p id="pregunta">27. Me enojo muy rápido si alguien me contradice.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r27" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r27" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r27" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r27" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r27" value="5">5. Totalmente de acuerdo
        </label>  
    <br/>
    <br/>  
    <p id="pregunta">28. Soy agresivo con aquellos que me provocan.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r28" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r28" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r28" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r28" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r28" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>
    <br/>
    <p id="pregunta">29. Soy tímido, me cuesta trabajo hablar con desconocidos.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r29" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r29" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r29" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r29" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r29" value="5">5. Totalmente de acuerdo
        </label>  
    
    <br/>  
    <br/>           

    <p id="pregunta">30. Puedo ser irrespetuoso.</p>
    
        <label class="radio-inline">
            <input required="true" type="radio" name="r30" value="1">1. Totalmente en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r30" value="2">2. En desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r30" value="3">3. Ni de acuerdo ni en desacuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r30" value="4">4. De acuerdo
        </label>
        <label class="radio-inline">
            <input required="true" type="radio" name="r30" value="5">5. Totalmente de acuerdo
        </label>  
    
     

</div>    
             
          <br/>
    <button type="submit" class="btn btn-primary btn-lg active" style="margin-left: 16cm;">Aceptar</button>        
     </form>
      <br/>


  </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
