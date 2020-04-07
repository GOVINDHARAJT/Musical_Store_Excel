package dao;
import java.util.*;


import model.*;
public class InstrumentOperations {
	Excelfile excel=new Excelfile();
	static List<Instrument> list1 = new ArrayList<Instrument>();
	static List<Order> list2 = new ArrayList<Order>();
//Insert Instrument Details	
	public List<Instrument> insert(Instrument instrument) throws Exception {
			list1.add(instrument);
			excel.excelgenerator(instrument,list1); 
			list1.remove(instrument);
			return list1;
		}
//Delete Instrument Details
	public List<Instrument> delete(Instrument instrument) {
		list1.remove(instrument);
			return list1;
	}
//Order Instrument
	public List<Order> order(Order instrument) throws Exception {
		list2.add(instrument);
		excel.ordergenerator(instrument, list2);
		list2.remove(instrument);
		return list2;
	}

//Get all instrument details	
	public void getAllInstrument(){
		excel.excelreader("InstrumentDetails.xlsx");
	}
//Get Order Details
	public void getOrderDetails(){
		excel.excelreader("CustomerOrderDetails.xlsx");
	}


}




