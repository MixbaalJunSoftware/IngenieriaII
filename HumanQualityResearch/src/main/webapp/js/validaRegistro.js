/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var frmvalidator = new Validator("termina-registro");
 
 
 frmvalidator.addValidation("telefono","maxlen=50");
 frmvalidator.addValidation("telefono","numeric");

 frmvalidator.addValidation("celular","maxlen=50");
 frmvalidator.addValidation("celular","numeric");
 


