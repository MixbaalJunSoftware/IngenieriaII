<%-- 
    Document   : CrearEmpleado
    Author     : danii
--%>

%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/CrearCliente.css"/> ">
        <title>Completar Registro Empleado</title>
    </head>
    <body>
        <br/>
        <header>
            <div class="he1" align="left">
            <img class="logoHQR" src="<c:url value="/imagenes/logo_hqr.jpg"/>" width=90 height=100 alt="Logo HQR" style="margin-left:3cm">
            </div>
            <hr/>
        </header>
        <div class ="container">
            <div class="row">
                <form id = "termina-registro" name="termina-registro" method="POST" action="/HumanQualityResearch/completarRegistro-empleado" >
            <p id="registro">Registro del Empleado</p>
            <br/>
            <br/>
            <div class="col-md-4">
            <label for="nombre" style="color:#1D14A4;">Nombre:</label>
            <input required="true" id = "nombre" name = "nombre" style="margin-left:2cm"/>
            <br/>
            <br/>
            <label for="app" style="color:#1D14A4;">Apellido Paterno:</label>
            <input required="true" id = "app" name = "app" style="margin-left:0.4cm"/>
            <br/>
            <br/>
            <label for="apm" style="color:#1D14A4;">Apellido Materno:</label>
            <input required="true" id = "apm" name = "apm" style="margin-left:0.3cm"/>
            <br/>
            <br/>
            <label for="fecha" style="color:#1D14A4;">Fecha de nacimiento:</label>
            <!--<input required="true" id = "fecha" name = "fecha" style="margin-left:"/>-->
            <select name="fecha" id="dia">
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
            <select name="fecha" id="mes">
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
            <select name="fecha" id="anio">
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
            <br/>
            <br/>
            <label for="genero" style="color:#1D14A4;">Género:</label>
                <label class="radio-inline" style="color:#1D14A4;margin-left: 2cm;">
                    <input type="radio" name="genero" id="genero" value="M" > Masculino
                </label>
                <label class="radio-inline" style="color:#1D14A4;">
                    <input type="radio" name="genero" id="genero" value="F" > Femenino
                </label>
            <!--<input id = "genero" name = "genero" style="margin-left:"/>-->
            <br/>
            <br/>
            </div>
            <div class="col-md-4">
            <label for="puesto" style="color:#1D14A4;">Puesto:</label>
            <input required="true" id = "puesto" name = "puesto" style="margin-left:1.8cm;"/>
            <br/>
            <br/>
            <label for="telefono" style="color:#1D14A4;">Telefono:</label>
            <input required="true"  id = "telefono" name = "telefono" style="margin-left:1.5cm;"/>
            <br/>
            <br/>
            <label for="celular" style="color:#1D14A4;">Celular:</label>
            <input required="true" id = "celular" name = "celular" style="margin-left:1.8cm;"/>
            <br/>
            <br/>
            </div>
            <div class="col-md-4">
                <input id = "correo" name = "correo" value="${correoRegistrado}" hidden="true"/>
            <label for="pass" style="color:#1D14A4;">Contraseña:</label>
            <input required="true" id = "pass" name = "pass" type="password" style="margin-left:1cm;"/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary btn-lg active">Aceptar</button>
            </div>
            
        </form>
                
            </div>
        </div>
            <form method="POST" action="/HumanQualityResearch/" >
                <button type="submit"  class="btn btn-primary btn-lg active" style="margin-left: 27cm;">Regresar</button>
            </form>
            <br/>
    </body>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
</html>

