package Controlador;

import com.lowagie.text.pdf.AcroFields;;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfStamperView;

import com.lowagie.text.pdf.PdfStamper;

public class PDFView extends AbstractPdfStamperView  {

//    private MessageSource messageSource;
//
//    @Override
//    public void setMessageSource(MessageSource messageSource) {
//        Object[] os = new Object[3];
//        String s = messageSource.getMessage("url", os, Locale.ITALY);
//        System.out.println(s);
//        this.messageSource = messageSource;
//    }

    @Override
    protected void mergePdfDocument(Map<String, Object> model,
            PdfStamper stamper, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        response.setHeader("Content-disposition", "attachment; FILENAME=someName.pdf");
//        stamper.setFormFlattening(true);
//        String customerName = (String) model.get("customerName");
//        Locale locale = request.getLocale();
//        stamper.getAcroFields().setField("customerNameLabel",
//                messageSource.getMessage("label.customername", null, locale));
//        stamper.getAcroFields().setField("customerNameValue", customerName);
//        stamper.close();
         // get the form from the document
        AcroFields form = stamper.getAcroFields();
        String customerName = (String) model.get("customerName");
        // set some values on the form
        form.setField("customerNameLabel", customerName);
        // set the disposition and filename
        response.setHeader("Content-disposition", "attachment; FILENAME=someName.pdf");
    }
    
}