package Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.itextpdf.text.DocumentException;

import businesslogic.Validation;
import java.time.*;
import java.time.format.DateTimeFormatter;

import dao.*;
import model.*;
class FirstClass {

	static Map<Integer,User> map= new HashMap<Integer,User>();
	CRUDOperations crud=new CRUDOperations();
//Admin function	
	void admin() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
	
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		
		System.out.println("3.Instrument Details");
		System.out.println("4.Customer Order Details");
		System.out.println("5.Customer Details");
		System.out.println("6.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-6)");
		System.out.println("*----------------------------------------*");
		String id;
		String iname;
		String  price;
		String yn;
		Instrument instrument = null;
		Excelfile excel=new Excelfile();
		ConverToPDF pdf =new ConverToPDF();
		List<Instrument> list1=new ArrayList<Instrument>();
		InstrumentOperations ins=new InstrumentOperations();
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("*----------------------------------------*");
			System.out.println("         Enter Instrument Details         ");
			System.out.println("*----------------------------------------*");
			System.out.print("Enter Instrument ID : ");
			id = sc.next();
			System.out.print("Enter Instrument Name : ");
			iname = sc.next();
			System.out.print("Enter Instrument Price : ");
			price = sc.next();
			instrument = new Instrument(id,iname,price);
			try {
				ins.insert(instrument);
			} catch (Exception e) {
			
				e.getMessage();
			}
			System.out.println("Inserted Successfully!");
			break;
		case 2:
			System.out.println("*----------------------------------------*");
			System.out.println("         Delete Instrument Details        ");
			System.out.println("*----------------------------------------*");
			System.out.print("Enter Instrument ID You Wants to Delete : ");
			id = sc.next();
			excel.deleteitem(id);
			System.out.println("*----------------------------------------*");
			break;
		
		case 3:
			System.out.println("*----------------------------------------*");
			System.out.println("            Instrument Details            ");
			System.out.println("*----------------------------------------*");
			System.out.println("Id         Instrument_Name     Price");
			System.out.println("*----------------------------------------*");
			ins.getAllInstrument();
			System.out.println("*----------------------------------------*");

			break;
		case 4:
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                                               Customer Order Details                                                     ");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("Mobile_No\t\tCustomer_Name\tIns_Id\t\tIns_Name\tPrice\t\tQuantity\tOrder Date & Time");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			ins.getOrderDetails();
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.print("Do you want to generate PDF(Press : Y/N) : ");
			yn = sc.next();
			if(yn.equals("Y")||yn.equals("y")) {
				try {
					pdf.ConverToPDF("CustomerOrderDetails.xlsx");
					
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
				System.out.println("Cancelled");
			System.out.println("*----------------------------------------*");
			break;
		case 5:
			System.out.println("*---------------------------------------------------------*");
			System.out.println("                    Customer Details               ");
			System.out.println("*---------------------------------------------------------*");
			System.out.println("Mobile_Number       Customer_Name            Date & Time");
			System.out.println("*---------------------------------------------------------*");
			crud.getAllUsers();
			System.out.println("*---------------------------------------------------------*");		
			break;
		case 6:
			 
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	 }while(choice!=6);
	}
	
	
	//Customer function	
	@SuppressWarnings("null")
	void customer(String customername,String mobileno ) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("*----------------------------------------*");
		System.out.println("   WELCOME TO  MUSICAL INSTRUMENT STORE   ");
		System.out.println("\t\t"+customername.toUpperCase());
		System.out.println("*----------------------------------------*");
		do {
		System.out.println("1.Instrument Details");
		System.out.println("2.Order Instrument");
		System.out.println("3.Your Orders");
		System.out.println("4.Exit");
		System.out.println("*----------------------------------------*");
		String id;
		String iname;
		String  price;
		String quantity;
		String yn;
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fDate = myDateObj.format(myFormatObj);
		Order instrument =null;
	    choice = sc.nextInt();
	    Excelfile excel=new Excelfile();
	    Billpdf bill = new Billpdf();
		List<Instrument> list1=new ArrayList<Instrument>();
		InstrumentOperations ins=new InstrumentOperations();
		switch (choice) {
		case 1:
			System.out.println("*----------------------------------------*");
			System.out.println("            Instrument Details               ");
			System.out.println("*----------------------------------------*");
			System.out.println("Id         Instrument_Name     Price");
			System.out.println("*----------------------------------------*");
			ins.getAllInstrument();
			System.out.println("*----------------------------------------*");
			
			break;
		case 2:
			System.out.print("Enter Your Instrument ID : ");
			id = sc.next();
			System.out.print("Enter Your Instrument Name : ");
			iname = sc.next();
			System.out.print("Enter Your Instrument Price : ");
			price = sc.next();
			System.out.print("Enter Your Instrument Quantity : ");
			quantity = sc.next();
			System.out.print("Confirm Your Order(Press : Y/N) : ");
			yn = sc.next();
			if(yn.equals("Y")||yn.equals("y")) {
				instrument = new Order(mobileno,customername,id,iname,price,quantity,fDate);
				try {
					ins.order(instrument);
				} catch (Exception e) {
			
					e.getMessage();
				}
				System.out.println("Order Successfull!");
				System.out.print("Do you want bill(Press : Y/N) : ");
				yn = sc.next();	
				if(yn.equals("Y")||yn.equals("y")) {
					try {
						bill.Billpdf(mobileno,customername,id,iname,price,quantity,fDate);
					} catch (DocumentException e) {
			
						e.printStackTrace();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("*----------------------------------------*");
			}
			else
				System.out.println("Order Cancelled");
			System.out.println("*----------------------------------------*");
				
			break;
		case 3:
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                                              "+customername+" Order Details                                              ");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("Mobile_No\t\tCustomer_Name\tIns_Id\t\tIns_Name\tPrice\t\tQuantity\tOrder Date & Time");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			excel.userorderdetails(mobileno);
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			break;
		case 4:
			System.out.println("THANK YOU COME AGAIN!");
			System.out.println("*----------------------------------------*");
			
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	  }while(choice!=4);
   }
}	

public class Main {
	static Map<Integer,User> map= new HashMap<Integer,User>();
	CRUDOperations crud=new CRUDOperations();
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("*----------------------------------------*");
		System.out.println("        MUSICAL INSTRUMENT STORE          ");
		System.out.println("*----------------------------------------*");
		while (true) {
			System.out.println("1.Admin");
			System.out.println("2.Customer");
			System.out.println("3.Exit");
			System.out.println("*----------------------------------------*");
			String username;
			String password;
			String mobileno;
			String customername;
			User user = null;
			FirstClass fc = new FirstClass();
			CRUDOperations crud=new CRUDOperations();
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String fDate = myDateObj.format(myFormatObj);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int choice = sc.nextInt();
			
			Validation validate=new Validation();
			switch(choice) {
				case 1:
					System.out.print("Enter your username : ");
				    username = sc.next();
					System.out.print("Enter you password :");
					password = sc.next();
					if(validate.adminlogin(username,password) ){
						System.out.println("Login Successfull!");
						System.out.println("*----------------------------------------*");
						fc.admin();
					}
					else
						System.out.println("Check your username and password");
					    System.out.println("*----------------------------------------*");
					break;
				
				case 2:
					System.out.print("Enter your mobile number : ");
					mobileno = br.readLine();
					System.out.print("Enter your name : ");
					customername = br.readLine();
					user=new User(mobileno,customername,fDate);
										
					try {
						crud.addListUser(user);
					} catch (Exception e) {
					
						e.getMessage();
					}
					fc.customer(customername,mobileno);
					break;
				case 3:
					System.out.println("THANK YOU!");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Choice!!");
					break;
				}
	        }
		}
	}




