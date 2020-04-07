package dao;
import model.*;
import java.util.*;
import java.io.*;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfile {
	static Workbook wb;
	static Sheet sh;
	static Row row;
	static Cell cell;
	static FileInputStream in;
	static FileOutputStream out;
	   int i=0;

//Insert instrument details in excel file	
	public void excelgenerator(Instrument instrument, List<Instrument> list) throws Exception {
		
		try {
			in = new FileInputStream("InstrumentDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			 
			for(Instrument instrument1 :list) {
				 Row row = sheet.createRow(++rowCount);
				 int columnCount = 0;
				 Cell cell = row.createCell(columnCount);
				 cell.setCellValue(rowCount);
				 
				 row.createCell(0).setCellValue(instrument1.getId());
				 row.createCell(1).setCellValue(instrument1.getIname());
				 row.createCell(2).setCellValue(instrument1.getPrice()); 
			 	 }
			   
		    out = new FileOutputStream(new File("InstrumentDetails.xlsx"));
	        workbook.write(out);
	        out.close();
	                    
		    }catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
	}
//Insert Customer Order Details in excel file
public void ordergenerator(Order instrument, List<Order> list) throws Exception {
		
		try {
			in = new FileInputStream("CustomerOrderDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			 
			for(Order instrument1 :list) {
				 Row row = sheet.createRow(++rowCount);
				 int columnCount = 0;
				 Cell cell = row.createCell(columnCount);
				 cell.setCellValue(rowCount);
				 
				 row.createCell(0).setCellValue(instrument1.getMobileno());
				 row.createCell(1).setCellValue(instrument1.getCustomername());
				 row.createCell(2).setCellValue(instrument1.getId()); 
				 row.createCell(3).setCellValue(instrument1.getIname()); 
				 row.createCell(4).setCellValue(instrument1.getPrice());
				 row.createCell(5).setCellValue(instrument1.getQuantity());
				 row.createCell(6).setCellValue(instrument1.getfDate()); 
			 	 }
			   
		    out = new FileOutputStream(new File("CustomerOrderDetails.xlsx"));
	        workbook.write(out);
	        out.close();
	                    
		    }catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
	}
	
//Insert Customer Details in Excel file	
public void customerexcelinsert(User user, List<User> list) throws Exception {
		
		try {
			in = new FileInputStream("CustomerDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			 
			for(User user1 :list) {
				 Row row = sheet.createRow(++rowCount);
				 int columnCount = 0;
				 Cell cell = row.createCell(columnCount);
				 cell.setCellValue(rowCount);
				 
				 row.createCell(0).setCellValue(user1.getMobileno());
				 row.createCell(1).setCellValue(user1.getCustomername());
				 row.createCell(2).setCellValue(user1.getfDate());
			 	 }
			   
		    out = new FileOutputStream(new File("CustomerDetails.xlsx"));
	        workbook.write(out);
	        out.close();
	                    
		    }catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
	}


//Read All Data in Excel file
	public void excelreader(String fname) {
		try
      {
          FileInputStream file = new FileInputStream(new File(fname));
          XSSFWorkbook workbook = new XSSFWorkbook(file);
          XSSFSheet sheet = workbook.getSheetAt(0);
          Iterator<Row> rowIterator = sheet.iterator();
        int i=0;
          while (rowIterator.hasNext()) 
          {
              row = rowIterator.next();
              if(i!=1) {
              	 row = rowIterator.next();
              	 i++;
              }
              //For each row, iterate through all the columns
              Iterator<Cell> cellIterator = row.cellIterator();
               
              while (cellIterator.hasNext()) 
              {
                  Cell cell = cellIterator.next();
                  //Check the cell type and format accordingly
                  switch (cell.getCellType()) 
                  {
                      //case Cell.CELL_TYPE_NUMERIC:
                         // System.out.print(cell.getNumericCellValue() + "\t");
                          //break;
                      case Cell.CELL_TYPE_STRING:
                          System.out.print(cell.getStringCellValue() + "\t\t");
                          break;
                  }
              }
              System.out.println("");
          }
          file.close();
      
      }catch (Exception e) {
      	System.out.println(e.getMessage());
      }
		
	}
	
//Order items 
	/*public void orderitem(String id) {
	
		try
	      {
	          FileInputStream file = new FileInputStream(new File("InstrumentDetails.xlsx"));
	          XSSFWorkbook workbook = new XSSFWorkbook(file);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	        	  row = sheet.getRow(rowIndex);
	        	  if (row != null) {
	        	    Cell cell = row.getCell(0);
	        	    String value=cell.getStringCellValue();
	        	    if (value.equals(id)) {
	        	    	System.out.print("Your Instrument Name : ");
	        	    	System.out.println(row.getCell(1).getStringCellValue());
	        	    	System.out.print("Your Instrument Price : ");
	        	    	System.out.println(row.getCell(2).getStringCellValue()); 
	        	    	
	        	    }
	        	  }
	        	}
	       }catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}*/
	
	
	//delete item
	
	public void deleteitem(String id) {
		try
	      {
			
	          FileInputStream file = new FileInputStream(new File("InstrumentDetails.xlsx"));
	          XSSFWorkbook workbook = new XSSFWorkbook(file);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	        	  row = sheet.getRow(rowIndex);
	        	  if (row != null) {
	        	    Cell cell = row.getCell(0);
	        	    String value=cell.getStringCellValue();
	        	    if (value.equals(id)) {
	        	    	sheet.removeRow(sheet.getRow(rowIndex));
	        	    	//sheet.shiftRows(rowIndex+1,sheet.getLastRowNum(), -1);
	        	    	 System.out.println("Deleted Successfully!");
	        	    }
	        	  }
	        	}
	            out = new FileOutputStream(new File("InstrumentDetails.xlsx"));
		        workbook.write(out);
		        out.close();
	     
	       }catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}
	
	
//Particular customer order details 
	public void userorderdetails(String mobileno) {
		try
	      {
	          FileInputStream file = new FileInputStream(new File("CustomerOrderDetails.xlsx"));
	          XSSFWorkbook workbook = new XSSFWorkbook(file);
	          XSSFSheet sheet = workbook.getSheetAt(0);
	          Iterator<Row> rowIterator = sheet.iterator();
	          int flag=0;
	          for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	        	  row = sheet.getRow(rowIndex);
	        	  if (row != null) {
	        	    Cell cell = row.getCell(0);
	
	        	    String value=cell.getStringCellValue();
	        	    if (value.equals(mobileno)) {
	        	    
	        	    	System.out.print(row.getCell(0).getStringCellValue()+"\t\t");//getStringCellValue() + "\t\t");
	        	    	System.out.print(row.getCell(1).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(2).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(3).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(4).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(5).getStringCellValue()+"\t\t");
	        	    	System.out.print(row.getCell(6).getStringCellValue());
	        	    	flag=1;
	        	    }
	        	    if(flag==1) {
	        	    System.out.println("");
	        	    flag=0;
	        	    }
	        	  }
	        	}
	        file.close();
	      	}catch (Exception e) {
	        	System.out.println(e.getMessage());
	      }
	}
}

