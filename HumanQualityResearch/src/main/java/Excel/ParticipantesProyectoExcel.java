/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import Mapeo.Participante;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author Mixbaal
 */
public class ParticipantesProyectoExcel extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook wrkbk, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {    
        hsr1.setHeader("Content-Disposition", "attachment; filename=\"ParticipantesProyecto.xls\"");
        Sheet sheet = wrkbk.createSheet("Participantes_proyecto");
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
        // Hace que el ancho de la comlumna sea lo suficientemente grande
        // para que la información sea desplegada adecuadamente.
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
    }
    
}
