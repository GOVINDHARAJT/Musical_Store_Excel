package dao;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Billpdf {
	public void Billpdf(String mobileno, String customername,String id, String iname, String price,String quantity,String fDate) throws Exception, DocumentException{
	Document document=new Document();
	PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("bill.pdf"));
	document.open();
	 Paragraph t = new Paragraph( "*MUSICAL INSTRUMENT STORE*\n");
     t.setAlignment(Paragraph.ALIGN_CENTER);
     document.add(t);
	
	Paragraph h = new Paragraph("Order Bill\n");
	 h.setAlignment(Paragraph.ALIGN_CENTER);
	 document.add(h);
	 
	 Paragraph l = new Paragraph("____________________________________________________________\n");
	 l.setAlignment(Paragraph.ALIGN_CENTER);
	 document.add(l);
	 Paragraph p1 = new Paragraph("Date: "+fDate);
     p1.setAlignment(Paragraph.ALIGN_RIGHT);
     p1.setSpacingAfter(10);
     document.add(p1);
     
     document.add(new Paragraph("Mobileno           : "+mobileno));
     document.add(new Paragraph("Customer Name      : "+customername));
     document.add(new Paragraph("Instrument_Id      : "+id));
     document.add(new Paragraph("Instrument_Name    : "+iname));
     document.add(new Paragraph("Instrument_Price   : "+price));
     document.add(new Paragraph("Instrument_Quantity: "+quantity));
     document.close();
     writer.close();
     System.out.println("PDF Bill is generated please check inbox\n");
	}
}
