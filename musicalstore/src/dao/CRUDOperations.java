package dao;

import java.util.*;

import model.*;
import model.User;

public class CRUDOperations {
	static int value = 0;
	Excelfile excel=new Excelfile();
	static List<User> listc = new ArrayList<User>();
	public List<User> addListUser(User user)throws Exception{
		listc.add(user);
		excel.customerexcelinsert(user,listc); 
		listc.remove(user);
		return listc;
		
	}
	public void getAllUsers(){
		excel.excelreader("CustomerDetails.xlsx");
	}
	
}
