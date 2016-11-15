<%-- 
    Document   : reporteAdaptabilidad
    Created on : 13/11/2016, 09:59:38 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>reporte de adaptabilidad</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 80%; 
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Reporte Adaptabilidad</h1>
        <table >
            <tr>
                <th>Factor</th><th>Puntaje</th><th>Interpretacion</th>
            </tr>
            <tr>
                <td width="10%">eficacia</td><td width="10%">${ef*(100/50)}%</td><td width="80%">${eftxt}</td>
            </tr>
            <tr>
                <td width="10%">creatividad</td><td width="10%">${cr*(100/45)}%</td><td width="80%">${crtxt}</td>
            </tr>
            <tr>
                <td width="10%">relaciones interpersonales</td><td width="10%">${ri*(100/50)}%</td><td width="80%">${ritxt}</td>
            </tr>
            <tr>
                <td width="10%">Adaptabilidad Laboral</td><td width="10%">${ta*(100/145)}%</td><td width="80%">${tatxt}</td>
            </tr>
        </table>
        <br/>
        fecha de repuesta: ${fecha}
    </body>
</html>
