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
  #section1 {padding-top:50px;height:500px;color: #fff; background-color: #1E88E5;}
  #section2 {padding-top:50px;height:500px;color: #fff; background-color: #673ab7;}
  #section3 {padding-top:50px;height:500px;color: #fff; background-color: #ff9800;}
  #section4 {padding-top:50px;height:500px;color: #fff; background-color: #00bcd4;}
  #section5 {padding-top:50px;height:500px;color: #fff; background-color: #009688;}
  #section6 {padding-top:50px;height:500px;color: #fff; background-color: #00bcd4;}
  #section7 {padding-top:50px;height:500px;color: #fff; background-color: #009688;}
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
        </ul>
      </div>
    </div>
  </div>
</nav>

<div id="section1" class="container-fluid">
  <h1>Escala Mexicana de Adaptabilidad Laboral</h1>
  <br/>
  <p>Instrucciones:</p>
  <br/>
  <p>A continuación encontrarás una serie de enunciados a los cuales debes responder considerando la
     la forma que has pensado,sentido y actuado ante determinadas situaciones en el ambiente laboral.</p>
  <br/>
  <p>Te pedimos contestar de la manera más honesta y sincera posible ya que no existen respuestas
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
  <h1>Section 3</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section4" class="container-fluid">
  <h1>Section 4 Submenu 1</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section5" class="container-fluid">
  <h1>Section 4 Submenu 2</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section6" class="container-fluid">
  <h1>Section 4 Submenu 2</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section7" class="container-fluid">
  <h1>Section 4 Submenu 2</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>

  </body>
    <script src="<c:url value="/js/jquery-1.12.3.min.js"/> "></script>    
    <script src="<c:url value="/js/bootstrap.min.js"/> "></script>       
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</html>
