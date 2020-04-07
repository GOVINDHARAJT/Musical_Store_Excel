package model;
import java.util.Set;

import dao.*;
public class Instrument {

	private String id;
	private String iname;
	private String price;
	
	
	public Instrument(String id, String iname, String price) {

		this.id = id;
		this.iname = iname;
		this.price = price;
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
	
	
}
