package model;
import java.util.*;

import dao.*;
public class Order {

	private String mobileno;
	private String customername;
	private String id;
	private String iname;
	private String price;
	private String quantity;
	private String fDate;
	
	public Order(String mobileno, String customername,String id, String iname, String price,String quantity,String fDate) {
		
		this.mobileno = mobileno;
		this.customername = customername;
		this.id = id;
		this.iname = iname;
		this.price = price;
		this.quantity = quantity;
		this.fDate = fDate;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}     
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}     
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	
}
