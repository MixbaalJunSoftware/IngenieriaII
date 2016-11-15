/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.RAdaptabilidad;
import Mapeo.RClimaLaboral;
import Modelo.RespuestaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 *
 * @author Mixbaal
 */
public class Reportes {
    
    @Autowired
    private RespuestaDAO respuesta_bd;
    
    private String efGetText(int ef){
        if(10<=ef && ef<=33)
            return "Se apega fielmente a los métodos y prácticas con los que se siente familiarizado, "
                  + "sin considerar la necesidad de ajustarlos cuando se presenta una situación inesperada.";
        else if(34<=ef && ef<=36)
            return "Tiende a oponerse ante la necesidad de ajustar los prácticas laborales que permitan"
                  + " alcanzar una mayor eficacia y efectividad en eventos inesperados.";
        else if(37<=ef && ef<=39)
            return "Reconoce la importancia de modificar la dinámica de trabajo, sin embargo muestra una "
                  + "actitud poco flexible ante de las situaciones imprevistas.";
        else if(40<=ef && ef<=42)
            return "Ajusta su conducta y su estilo de trabajo a las nuevas condiciones, reajustando los "
                  + "objetivos, prioridades, planes y acciones.";
        else if(43<=ef && ef<=47)
            return "Visualiza el cambio de manera positiva, lo cual le permite modificar ágilmente las "
                  + "condiciones que le resultan ineficaces,  situándose en un proceso continuo de aprendizaje.";
        else if(48<=ef && ef<=50)
            return "Es necesario entrevistar al trabajador para ahondar en las respuestas obtenidas.";
        return "error";
    }
    
    private String crGetText(int cr){
        if(9<=cr && cr<=28)
            return "Presenta la tendencia de formular y analizar los problemas desde una misma perspectiva;"
                 + " se le dificulta resolver problemas novedosos porque los analiza desde un solo enfoque,"
                 + " e intenta solucionarlos solamente a través de los métodos preestablecidos.";
        else if(29<=cr && cr<=31)
            return "Tiende a  analizar los problemas desde una misma perspectiva. Puede presentar soluciones"
                 + " útiles ante problemas comunes, sin embargo, no va más allá de los parámetros establecidos,"
                 + " para detectar si existe una alternativa más efectiva.";
        else if(32<=cr && cr<=34)
            return "Puede diseñar soluciones útiles ante problemas comunes, sin embargo, para ir  más allá de"
                 + " los parámetros establecidos y analizar los problemas desde distintas perspectivas necesita"
                 + " de cierto apoyo y motivación.";
        else if(35<=cr && cr<=37)
            return "Puede encontrar soluciones innovadoras ante distintos tipos de  problemas, genra nuevas"
                 + " ideas pensando más allá de los parámetros preestablecidos.";
        else if(38<=cr && cr<=41)
            return "Es capaz de formular y analizar los problemas desde diversas perspectivas para encontrar la"
                 + " mejor solución. Genera nuevas ideas pensando más allá de los parámetros establecidos, puede"
                 + " desarrollar métodos innovadores para obtener o usar los recursos disponibles en el trabajo.";
        else if(42<=cr && cr<=45)
            return "Es necesario entrevistar al trabajador para ahondar en las respuestas obtenidas.";
        return "error";
    }
    
    private String riGetText(int ri){
        if(10<=ri && ri<=28)
            return "Se le dificulta establecer relaciones interpersonales en el trabajo, lo cual se puede"
                 + " reflejar como aislamiento, mostrar una actitud renuente para integrarse en un equipo"
                 + " distinto, ante situaciones o personas estresantes puede responder de forma agresiva o"
                 + " muy sumisa, tener una comunicación limitada y poco asertiva. Se recomienda realizar una"
                 + " sesión con la persona para profundizar las causas que están provocando estas conductas"
                 + " y que pueden afectar su desempeño.";
        else if(29<=ri && ri<=33)
            return "Tiende a limitar significativamente las relaciones interpersonales del trabajo, el interés"
                 + " que muestra para relacionarse con sus compañeros es sólo profesional, suele mostrar"
                 + " desconfianza con su equipo y en su persona, lo cual posiblemente dificulte el intercambio"
                 + " de información y le puede causar disgusto escuchar comentarios sobre su trabajo.";
        else if(34<=ri && ri<=36)
            return "Es capaz de fomentar relaciones interpersonales en el trabajo, con el tiempo crea lazos de"
                 + " confianza con su equipo, la información que comparte con sus compañeros es moderada y necesaria,"
                 + " muestra tolerancia ante las opiniones de los demás y acepta las críticas hacia su trabajo.";
        else if(37<=ri && ri<=40)
            return "Se le facilita establecer relaciones interpersonales en el ámbito laboral, transmite"
                 + " información clara y confiable, apoya a sus compañeros cuando se requiere, crea lazos"
                 + " fuertes de compañerismo, le gusta y busca recibir feedback sobre su trabajo, ante situaciones"
                 + " estresantes se muestra ecuánime, se expresa de manera asertiva y respetuosa.";
        else if(41<=ri && ri<=45)
            return "Suele ser muy sociable lo cual agiliza establecer relaciones interpersonales en el entorno"
                 + " laboral, transmite una seguridad en su persona y hacia su equipo que favorece que sus"
                 + " compañeros confíen en él/ella, fomenta un clima de respeto y da el ejemplo, se expresa de"
                 + " forma directa y diplomática, promueve el convivio fuera de las oficinas, su actitud es"
                 + " amable y ofrece un apoyo incondicional hacia sus compañeros.";
        else if(46<=ri && ri<=50)
            return "Es necesario entrevistar al trabajador para ahondar en las respuestas obtenidas.";
        return "error";
    }
    
    private String iaGetText(int ia){
        if(ia<=11)
            return "Se percibe que en la organización no hay mucho contacto con las autoridades excepto para"
                 + " supervisión, no existe mucha apertura al cambio y se espera que los empleados cubran"
                 + " reglas y procedimientos estrictos.";
        else if(12<=ia && ia<=22)
            return "Hay un nivel medio de comunicación y apertura de las autoridades a los empleados de la"
                 + " organización, se busca cubrir reglasy procedimientos establecidos en general.";
        else if(23<=ia)
            return "Se percibe que existe apertura al cambio y alta comunicación y flexibilidad con los empleados.";
        return "error";
    }
    
    private String ctGetText(int ct){
        if(ct<=10)
            return "Se percibe que en la organización se busca que los empleados hagan grandes cantidades de"
                 + " trabajo, lo que implica mucho esfuerzo de su parte, lo que no necesariamente aumenta la"
                 + " productividad pero pone a los empleados en riesgo de salud.";
        else if(11<=ct && ct<=19)
            return "Se percibe que en la organización se busca que haya un nivelintermedio de trabajo"
                 + " realizado por los empleados, lo cual es adecuado. ";
        else if(20<=ct)
            return "En la organización no es muyimportante hacer grandes cantidades de trabajo, es importante"
                 + " se r cuidadoso con esto ya que puede afectar al logro de metas y"
                 + " la motivación de los empleados.";
        return "error";
    }
    
    private String afGetText(int af){
        if(af<=10)
            return "Se percibe que hay problemas con las instalaciones físicas, las cuales no apoyan a"
                + " los empleados para hacer su trabajo.";
        else if(11<=af && af<=21)
            return "Se percibe que las instalaciones son adecuadas y cumplen su función.";
        else if(21<=af)
            return "Se percibe que las instalaciones son cómodas, funcionales y agradables para los empleados.";
        return "error";
    }
    
    
    private ModelAndView raCliente(ModelMap model,int idCandidato){
        RAdaptabilidad ra = respuesta_bd.rAdaptabilidadCandidato(idCandidato);
        if(ra == null)
            return new ModelAndView("error403"); 
        int ef = ra.getRespuesta1()+ra.getRespuesta2()+ra.getRespuesta3()+ra.getRespuesta4()+ra.getRespuesta5()+
                 ra.getRespuesta6()+ra.getRespuesta7()+ra.getRespuesta8()+ra.getRespuesta9()+ra.getRespuesta10();
        int cr = ra.getRespuesta11()+ra.getRespuesta12()+ra.getRespuesta13()+ra.getRespuesta14()+ra.getRespuesta15()+
                 ra.getRespuesta17()+ra.getRespuesta18()+ra.getRespuesta19()+ra.getRespuesta20();
        int ri = ra.getRespuesta21()+ra.getRespuesta22()+ra.getRespuesta23()+ra.getRespuesta24()+ra.getRespuesta25()+
                 ra.getRespuesta26()+ra.getRespuesta27()+ra.getRespuesta28()+ra.getRespuesta29()+ra.getRespuesta30();
        String efTxt = efGetText(ef);
        String crTxt = crGetText(cr);
        String riTxt = riGetText(ri);        
        model.addAttribute("respuesta", ra);
        model.addAttribute("ef",ef);
        model.addAttribute("eftxt",efTxt);
        model.addAttribute("cr",cr);
        model.addAttribute("crtxt",crTxt);
        model.addAttribute("ri",ri);
        model.addAttribute("ritxt",riTxt);
        model.addAttribute("ta",ef+cr+ri);
        model.addAttribute("fecha", ra.getFechaRespuesta());
        return new ModelAndView("reporteAdaptabilidad");
    }
    
    private ModelAndView rcCliente(ModelMap model,int idCandidato){
        RClimaLaboral rc = respuesta_bd.rClimaCandidato(idCandidato);
        if(rc == null)
            return new ModelAndView("error403");
        int ia = rc.getRespuesta3()+rc.getRespuesta8()+rc.getRespuesta10()+
                 rc.getRespuesta15()+rc.getRespuesta16()+rc.getRespuesta16();
        int ct = rc.getRespuesta5()+rc.getRespuesta7()+rc.getRespuesta18()+rc.getRespuesta20();
        int af = rc.getRespuesta1()+rc.getRespuesta2()+rc.getRespuesta4()+rc.getRespuesta4()+
                 rc.getRespuesta6()+rc.getRespuesta9()+rc.getRespuesta11()+rc.getRespuesta12()+
                 rc.getRespuesta13()+rc.getRespuesta14()+rc.getRespuesta19();
        String iaTxt = iaGetText(ia);
        String ctTxt = ctGetText(ct);
        String afTxt = afGetText(af);        
        model.addAttribute("ia",ia);
        model.addAttribute("iatxt",iaTxt);
        model.addAttribute("ct",ct);
        model.addAttribute("cttxt",ctTxt);
        model.addAttribute("af",af);
        model.addAttribute("aftxt",afTxt);
        model.addAttribute("tc", ia+ct+af);
        model.addAttribute("respuesta",rc);
        model.addAttribute("fecha", rc.getFechaRespuesta());
        return new ModelAndView("reporteClima");
    }
    
    @RequestMapping("/reportes/candidato/adaptabilidad")
    public ModelAndView muestraRClienteA(ModelMap model,@RequestParam("r2")int idCandidato){
        return raCliente(model,idCandidato); 

    }
    
    @RequestMapping("/reportes/candidato/climalaboral")
    public ModelAndView muestraRClienteC(ModelMap model,@RequestParam("r2")int idCandidato){
        return rcCliente(model,idCandidato);
    }
    
}
