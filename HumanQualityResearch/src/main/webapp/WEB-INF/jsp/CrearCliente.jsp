<%-- 
    Document   : CrearCliente
    Created on : 25/09/2016, 04:28:18 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/crearCliente.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Navbar.css"/> ">
        <title>Registro del Cliente</title>
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
                        <li><a href="#registroCliente">Registro del Cliente</a></li>
                        <li><a href="/HumanQualityResearch/">Regresar</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        
        <form id = "termina-registro" name="termina-registro" method="POST" action="/HumanQualityResearch/crear-cliente" >
            <div class="container">
                <div id="registroCliente" class ="container-fluid bg-1" style="background-color:#5389C4;">
                    <br/>
                    <br/>
                    <br/>
                    <h2 id="registro">Termina tu registro como Cliente</h2>
                    <br/>
                    <br/>
                    
                    <label id="palabra" for="nombre">Nombre:</label>
                    <input required="true" id = "nombre" name = "nombre" style="margin-left:0.4cm;"/>
                    <br/>
                    <br/>
                    <br/>
                    <label id="palabra" for="app">Apellido Paterno:</label>
                    <input required="true" id = "app" name = "app" style="margin-left:0.4cm"/>
                    
                    <label id="palabra" for="apm" style="margin-left: 2cm;">Apellido Materno:</label>
                    <input required="true" id = "apm" name = "apm" style="margin-left:0.3cm"/>
                    <br/>
                    <br/>
                    <br/>
                    <label id="palabra" for="fecha">Fecha de nacimiento:</label>
                    <!--<input required="true" id = "fecha" name = "fecha" style="margin-left:"/>-->
                    <select name="fecha1" id="dia">
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    -
                    <select name="fecha2" id="mes">
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    -
                    <select name="fecha3" id="anio">
                        <option value="1940">1940</option>
                        <option value="1941">1941</option>
                        <option value="1942">1942</option>
                        <option value="1943">1943</option>
                        <option value="1944">1944</option>
                        <option value="1945">1945</option>
                        <option value="1946">1946</option>
                        <option value="1947">1947</option>
                        <option value="1948">1948</option>
                        <option value="1949">1949</option>
                        <option value="1950">1950</option>
                        <option value="1951">1951</option>
                        <option value="1952">1952</option>
                        <option value="1953">1953</option>
                        <option value="1954">1954</option>
                        <option value="1955">1955</option>
                        <option value="1956">1956</option>
                        <option value="1957">1957</option>
                        <option value="1958">1958</option>
                        <option value="1959">1959</option>
                        <option value="1960">1960</option>
                        <option value="1961">1961</option>
                        <option value="1962">1962</option>
                        <option value="1963">1963</option>
                        <option value="1964">1964</option>
                        <option value="1965">1965</option>
                        <option value="1966">1966</option>
                        <option value="1967">1967</option>
                        <option value="1968">1968</option>
                        <option value="1969">1969</option>
                        <option value="1970">1970</option>
                        <option value="1971">1971</option>
                        <option value="1972">1972</option>
                        <option value="1973">1973</option>
                        <option value="1974">1974</option>
                        <option value="1975">1975</option>
                        <option value="1976">1976</option>
                        <option value="1977">1977</option>
                        <option value="1978">1978</option>
                        <option value="1979">1979</option>
                        <option value="1980">1980</option>
                        <option value="1981">1981</option>
                        <option value="1982">1982</option>
                        <option value="1983">1983</option>
                        <option value="1984">1984</option>
                        <option value="1985">1985</option>
                        <option value="1986">1986</option>
                        <option value="1987">1987</option>
                        <option value="1988">1988</option>
                        <option value="1989">1989</option>
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                        <option value="1995">1995</option>
                        <option value="1996">1996</option>
                        <option value="1997">1997</option>
                        <option value="1998">1998</option>
                    </select>
                    <label id="palabra" for="genero" style="margin-left: 1.2cm;">Género:</label>
                    <label id="palabra" class="radio-inline" style="margin-left: 0.4cm;">
                        <input type="radio" name="genero" id="genero" value="M" > Masculino
                    </label>
                    <label id="palabra" class="radio-inline">
                        <input type="radio" name="genero" id="genero" value="F" > Femenino
                    </label>
                    
                    <br/>
                    <br/>
                    <br/>
                    
                    <label id="palabra" for="empresa">Empresa:</label>
                    <input required="true" id = "empresa" name = "empresa" style="margin-left:0.4cm;"/>
                    <label id="palabra" for="puesto" style="margin-left: 1cm;">Puesto:</label>
                    <input required="true" id = "puesto" name = "puesto" style="margin-left:0.4cm;"/>
                    <label id="palabra" for="area" style="margin-left: 1cm;">Área:</label>
                    <input required="true" id = "area" name = "area" style="margin-left:0.4cm;"/>
                    <br/>
                    <br/>
                    <br/>
                    <label id="palabra" for="telefono">Telefono:</label>
                    <input required="true"  id = "telefono" name = "telefono" style="margin-left:0.4cm;"/>
                    <label id="palabra" for="celular" style="margin-left: 1cm;">Celular:</label>
                    <input required="true" id = "celular" name = "celular" style="margin-left:0.4cm;"/>
                    <br/>
                    <br/>
                    <br/>
                    
                    <input id = "correo" name = "correo" value="${correoRegistrado}" hidden="true"/>
                    <label id="palabra" for="pass">Contraseña:</label>
                    <input required="true" id = "pass" name = "pass" type="password" style="margin-left:0.4cm;"/>
                    <br/>
                    <br/>
                    <br/>
                    <button type="submit" class="btn btn-primary btn-lg active">Aceptar</button>
                    
                </div>
            </div>
        </form>
        <br/>
        
        
    </body>
    <script src=" <c:url value="/js/validaNumeros.js" /> "></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
</html>
