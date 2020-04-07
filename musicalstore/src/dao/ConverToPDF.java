package dao;

import com.aspose.cells.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.*;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ConverToPDF {
	static Row row;
	static Cell cell;
	public void ConverToPDF(String file) throws Exception, DocumentException {
		
		
		FileInputStream input_document = new FileInputStream(new File(file));
       
        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document); 
    
        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
        
        Iterator<Row> rowIterator = my_worksheet.iterator();
     
        Document iText_xls_2_pdf = new Document();
        PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("details.pdf"));
        iText_xls_2_pdf.open();
        
        PdfPTable my_table = new PdfPTable(7);
       
        //iText_xls_2_pdf.add(new Paragraph("                                  *MUSICAL INSTRUMENT STORE*                \n "));
        Paragraph p1 = new Paragraph( "*MUSICAL INSTRUMENT STORE*\n\n");
        p1.setAlignment(Paragraph.ALIGN_CENTER);
        iText_xls_2_pdf.add(p1);
        PdfPCell table_cell;
        
        while(rowIterator.hasNext()) {
                Row row = rowIterator.next(); 
                Iterator<Cell> cellIterator = row.cellIterator();
                        while(cellIterator.hasNext()) {
                                Cell cell = cellIterator.next(); 
                                switch(cell.getCellType()) { 
                                        
                                	case Cell.CELL_TYPE_STRING:
                                         table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                         my_table.addCell(table_cell);
                                         break;
                                }
                                
                        }
        
        }
       
        iText_xls_2_pdf.add(my_table);                       
        iText_xls_2_pdf.close();                
        input_document.close(); 
        System.out.println("PDF created successfully");
	}

	
}
