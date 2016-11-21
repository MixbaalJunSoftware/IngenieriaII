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
        <h1>Reporte Clima Laboral</h1>
        <table >
            <tr>
                <th>Factor</th><th>Puntaje</th><th>Interpretacion</th>
            </tr>
            <tr>
                <td width="10%">Interacción con las Autoridades</td><td width="10%">${ia*(100/50)}%</td><td width="80%">${iatxt}</td>
            </tr>
            <tr>
                <td width="10%">Carga de Trabajo</td><td width="10%">${ct*(100/45)}%</td><td width="80%">${cttxt}</td>
            </tr>
            <tr>
                <td width="10%">Ambiente Físisco</td><td width="10%">${af*(100/50)}%</td><td width="80%">${aftxt}</td>
            </tr>
            <tr>
                <td width="10%">Total Clima Social Organizacional</td><td width="10%">${tc*(100/120)}%</td><td width="80%">${tctxt}</td>
            </tr>
        </table>
        <br/>
        fecha de repuesta: ${fecha}
    </body>
</html>
