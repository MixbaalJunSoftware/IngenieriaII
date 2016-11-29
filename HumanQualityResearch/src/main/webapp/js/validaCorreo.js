/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var frmvalidator = new Validator("creaclientecorreo");
 
 
frmvalidator.addValidation("correo","maxlen=50");
frmvalidator.addValidation("correo","req","Ingresa un valor en el campo correo");
frmvalidator.addValidation("correo","email","Ingresa un correo valido");

