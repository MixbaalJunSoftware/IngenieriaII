/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import Mapeo.Participante;
import Mapeo.RAdaptabilidad;
import Mapeo.RClimaLaboral;
import Modelo.PersonaDAO;
import Modelo.RespuestaDAO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author Mixbaal
 */
public class ParticipantesProyectoExcel extends AbstractXlsView{
    
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook wrkbk, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {    
        hsr1.setHeader("Content-Disposition", "attachment; filename=\"ParticipantesProyecto.xls\"");
        Sheet sheet = wrkbk.createSheet("Participantes_informacion");
        List<Participante> participantes = (List) map.get("listaParticipantes");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Apellido paterno");
        header.createCell(2).setCellValue("Apellido materno");
        header.createCell(3).setCellValue("Telefono");
        header.createCell(4).setCellValue("Celular");
        header.createCell(5).setCellValue("Correo");
        header.createCell(6).setCellValue("Puesto");
        int contador = 1;
        for (Participante participante : participantes) {         
            Row courseRow = sheet.createRow(contador);
            courseRow.createCell(0).setCellValue(participante.getPersona().getNombre());
            courseRow.createCell(1).setCellValue(participante.getPersona().getApp());
            courseRow.createCell(2).setCellValue(participante.getPersona().getApm());
            courseRow.createCell(3).setCellValue(participante.getPersona().getTelefono());        
            courseRow.createCell(4).setCellValue(participante.getPersona().getCelular());
            courseRow.createCell(5).setCellValue(participante.getPersona().getCorreo());
            courseRow.createCell(6).setCellValue(participante.getPuestoParticipante());
            contador++;
        }
        RespuestaDAO respuesta_bd = (RespuestaDAO) map.get("respuestabd");
        // Hace que el ancho de la comlumna sea lo suficientemente grande
        // para que la información sea desplegada adecuadamente.
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        
//        Sheet sheet2 = wrkbk.createSheet("Respuestas_Adaptabilidad");
//        Row header2 = sheet2.createRow(0);
//        header2.createCell(0).setCellValue("Nombre");
//        header2.createCell(1).setCellValue("Apellido paterno");
//        header2.createCell(2).setCellValue("Apellido materno");
//        header2.createCell(3).setCellValue("respuesta 1");
//        header2.createCell(4).setCellValue("respuesta 2");
//        header2.createCell(5).setCellValue("respuesta 3");
//        header2.createCell(6).setCellValue("respuesta 4");
//        header2.createCell(7).setCellValue("respuesta 5");
//        header2.createCell(8).setCellValue("respuesta 6");
//        header2.createCell(9).setCellValue("respuesta 7");
//        header2.createCell(10).setCellValue("respuesta 8");
//        header2.createCell(11).setCellValue("respuesta 9");
//        header2.createCell(12).setCellValue("respuesta 10");
//        header2.createCell(13).setCellValue("respuesta 11");
//        header2.createCell(14).setCellValue("respuesta 12");
//        header2.createCell(15).setCellValue("respuesta 13");
//        header2.createCell(16).setCellValue("respuesta 14");
//        header2.createCell(17).setCellValue("respuesta 15");
//        header2.createCell(18).setCellValue("respuesta 16");
//        header2.createCell(19).setCellValue("respuesta 17");
//        header2.createCell(20).setCellValue("respuesta 18");
//        header2.createCell(21).setCellValue("respuesta 19");
//        header2.createCell(22).setCellValue("respuesta 20");
//        header2.createCell(23).setCellValue("respuesta 21");
//        header2.createCell(24).setCellValue("respuesta 22");
//        header2.createCell(25).setCellValue("respuesta 23");
//        header2.createCell(26).setCellValue("respuesta 24");
//        header2.createCell(27).setCellValue("respuesta 25");
//        header2.createCell(28).setCellValue("respuesta 26");
//        header2.createCell(29).setCellValue("respuesta 27");
//        header2.createCell(30).setCellValue("respuesta 28");
//        header2.createCell(31).setCellValue("respuesta 29");
//        header2.createCell(32).setCellValue("respuesta 30");
//        header2.createCell(33).setCellValue("fecha");
//        contador = 1;
//        for (Participante participante : participantes) {         
//            Row courseRow = sheet.createRow(contador);
//            courseRow.createCell(0).setCellValue(participante.getPersona().getNombre());
//            courseRow.createCell(1).setCellValue(participante.getPersona().getApp());
//            courseRow.createCell(2).setCellValue(participante.getPersona().getApm());
//            RAdaptabilidad ra = respuesta_bd.rAdaptabilidadCandidato(participante.getPersona().getIdPersona());
//            if(ra!=null){
//                courseRow.createCell(3).setCellValue(ra.getRespuesta1());        
//                courseRow.createCell(4).setCellValue(ra.getRespuesta2());
//                courseRow.createCell(5).setCellValue(ra.getRespuesta3());
//                courseRow.createCell(6).setCellValue(ra.getRespuesta4());
//                courseRow.createCell(7).setCellValue(ra.getRespuesta5());
//                courseRow.createCell(8).setCellValue(ra.getRespuesta6());        
//                courseRow.createCell(9).setCellValue(ra.getRespuesta7());
//                courseRow.createCell(10).setCellValue(ra.getRespuesta8());
//                courseRow.createCell(11).setCellValue(ra.getRespuesta9());
//                courseRow.createCell(12).setCellValue(ra.getRespuesta10());
//                courseRow.createCell(13).setCellValue(ra.getRespuesta11());        
//                courseRow.createCell(14).setCellValue(ra.getRespuesta12());
//                courseRow.createCell(15).setCellValue(ra.getRespuesta13());
//                courseRow.createCell(16).setCellValue(ra.getRespuesta14());
//                courseRow.createCell(17).setCellValue(ra.getRespuesta15());
//                courseRow.createCell(18).setCellValue(ra.getRespuesta16());        
//                courseRow.createCell(19).setCellValue(ra.getRespuesta17());
//                courseRow.createCell(20).setCellValue(ra.getRespuesta18());
//                courseRow.createCell(21).setCellValue(ra.getRespuesta19());
//                courseRow.createCell(22).setCellValue(ra.getRespuesta20());
//                courseRow.createCell(23).setCellValue(ra.getRespuesta21());        
//                courseRow.createCell(24).setCellValue(ra.getRespuesta22());
//                courseRow.createCell(25).setCellValue(ra.getRespuesta23());
//                courseRow.createCell(26).setCellValue(ra.getRespuesta24());
//                courseRow.createCell(27).setCellValue(ra.getRespuesta25());
//                courseRow.createCell(28).setCellValue(ra.getRespuesta26());        
//                courseRow.createCell(29).setCellValue(ra.getRespuesta27());
//                courseRow.createCell(30).setCellValue(ra.getRespuesta28());
//                courseRow.createCell(31).setCellValue(ra.getRespuesta29());
//                courseRow.createCell(32).setCellValue(ra.getRespuesta30());
//                courseRow.createCell(33).setCellValue(ra.getFechaRespuesta());
//            }
//            contador++;
//        }
//        // Hace que el ancho de la comlumna sea lo suficientemente grande
//        // para que la información sea desplegada adecuadamente.
//        sheet2.autoSizeColumn(0);
//        sheet2.autoSizeColumn(1);
//        sheet2.autoSizeColumn(2);
//        sheet2.autoSizeColumn(3);
//        sheet2.autoSizeColumn(4);
//        sheet2.autoSizeColumn(5);
//        sheet2.autoSizeColumn(6);
//        sheet2.autoSizeColumn(7);
//        sheet2.autoSizeColumn(8);
//        sheet2.autoSizeColumn(9);
//        sheet2.autoSizeColumn(10);
//        sheet2.autoSizeColumn(11);
//        sheet2.autoSizeColumn(12);
//        sheet2.autoSizeColumn(13);
//        sheet2.autoSizeColumn(14);
//        sheet2.autoSizeColumn(15);
//        sheet2.autoSizeColumn(16);
//        sheet2.autoSizeColumn(17);
//        sheet2.autoSizeColumn(18);
//        sheet2.autoSizeColumn(19);
//        sheet2.autoSizeColumn(20);
//        sheet2.autoSizeColumn(21);
//        sheet2.autoSizeColumn(22);
//        sheet2.autoSizeColumn(23);
//        sheet2.autoSizeColumn(24);
//        sheet2.autoSizeColumn(25);
//        sheet2.autoSizeColumn(26);
//        sheet2.autoSizeColumn(27);
//        sheet2.autoSizeColumn(28);
//        sheet2.autoSizeColumn(29);
//        sheet2.autoSizeColumn(30);
//        sheet2.autoSizeColumn(31);
//        sheet2.autoSizeColumn(32);
//        sheet2.autoSizeColumn(33);
//        sheet2.autoSizeColumn(34);
//        
//        Sheet sheet3 = wrkbk.createSheet("Respuestas_Clima");
//        Row header3 = sheet3.createRow(0);
//        header3.createCell(0).setCellValue("Nombre");
//        header3.createCell(1).setCellValue("Apellido paterno");
//        header3.createCell(2).setCellValue("Apellido materno");
//        header3.createCell(3).setCellValue("respuesta 1");
//        header3.createCell(4).setCellValue("respuesta 2");
//        header3.createCell(5).setCellValue("respuesta 3");
//        header3.createCell(6).setCellValue("respuesta 4");
//        header3.createCell(7).setCellValue("respuesta 5");
//        header3.createCell(8).setCellValue("respuesta 6");
//        header3.createCell(9).setCellValue("respuesta 7");
//        header3.createCell(10).setCellValue("respuesta 8");
//        header3.createCell(11).setCellValue("respuesta 9");
//        header3.createCell(12).setCellValue("respuesta 10");
//        header3.createCell(13).setCellValue("respuesta 11");
//        header3.createCell(14).setCellValue("respuesta 12");
//        header3.createCell(15).setCellValue("respuesta 13");
//        header3.createCell(16).setCellValue("respuesta 14");
//        header3.createCell(17).setCellValue("respuesta 15");
//        header3.createCell(18).setCellValue("respuesta 16");
//        header3.createCell(19).setCellValue("respuesta 17");
//        header3.createCell(20).setCellValue("respuesta 18");
//        header3.createCell(21).setCellValue("respuesta 19");
//        header3.createCell(22).setCellValue("respuesta 20");
//        header3.createCell(23).setCellValue("fecha");
//        contador = 1;
//        for (Participante participante : participantes) {         
//            Row courseRow = sheet.createRow(contador);
//            courseRow.createCell(0).setCellValue(participante.getPersona().getNombre());
//            courseRow.createCell(1).setCellValue(participante.getPersona().getApp());
//            courseRow.createCell(2).setCellValue(participante.getPersona().getApm());
//            RClimaLaboral ra = respuesta_bd.rClimaCandidato(participante.getPersona().getIdPersona());
//            if(ra!=null){
//                courseRow.createCell(3).setCellValue(ra.getRespuesta1());        
//                courseRow.createCell(4).setCellValue(ra.getRespuesta2());
//                courseRow.createCell(5).setCellValue(ra.getRespuesta3());
//                courseRow.createCell(6).setCellValue(ra.getRespuesta4());
//                courseRow.createCell(7).setCellValue(ra.getRespuesta5());
//                courseRow.createCell(8).setCellValue(ra.getRespuesta6());        
//                courseRow.createCell(9).setCellValue(ra.getRespuesta7());
//                courseRow.createCell(10).setCellValue(ra.getRespuesta8());
//                courseRow.createCell(11).setCellValue(ra.getRespuesta9());
//                courseRow.createCell(12).setCellValue(ra.getRespuesta10());
//                courseRow.createCell(13).setCellValue(ra.getRespuesta11());        
//                courseRow.createCell(14).setCellValue(ra.getRespuesta12());
//                courseRow.createCell(15).setCellValue(ra.getRespuesta13());
//                courseRow.createCell(16).setCellValue(ra.getRespuesta14());
//                courseRow.createCell(17).setCellValue(ra.getRespuesta15());
//                courseRow.createCell(18).setCellValue(ra.getRespuesta16());        
//                courseRow.createCell(19).setCellValue(ra.getRespuesta17());
//                courseRow.createCell(20).setCellValue(ra.getRespuesta18());
//                courseRow.createCell(21).setCellValue(ra.getRespuesta19());
//                courseRow.createCell(22).setCellValue(ra.getRespuesta20());
//                courseRow.createCell(23).setCellValue(ra.getFechaRespuesta());
//            }
//            contador++;
//        }
//        // Hace que el ancho de la comlumna sea lo suficientemente grande
//        // para que la información sea desplegada adecuadamente.
//        sheet2.autoSizeColumn(0);
//        sheet2.autoSizeColumn(1);
//        sheet2.autoSizeColumn(2);
//        sheet2.autoSizeColumn(3);
//        sheet2.autoSizeColumn(4);
//        sheet2.autoSizeColumn(5);
//        sheet2.autoSizeColumn(6);
//        sheet2.autoSizeColumn(7);
//        sheet2.autoSizeColumn(8);
//        sheet2.autoSizeColumn(9);
//        sheet2.autoSizeColumn(10);
//        sheet2.autoSizeColumn(11);
//        sheet2.autoSizeColumn(12);
//        sheet2.autoSizeColumn(13);
//        sheet2.autoSizeColumn(14);
//        sheet2.autoSizeColumn(15);
//        sheet2.autoSizeColumn(16);
//        sheet2.autoSizeColumn(17);
//        sheet2.autoSizeColumn(18);
//        sheet2.autoSizeColumn(19);
//        sheet2.autoSizeColumn(20);
//        sheet2.autoSizeColumn(21);
//        sheet2.autoSizeColumn(22);
//        sheet2.autoSizeColumn(23);
    }
    
}
