package model;

public class User {
	private String mobileno;
	private String customername;
	private String fDate;
	
	
	public User(String mobileno, String customername,String fDate) {
		
		this.mobileno = mobileno;
		this.customername = customername;
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
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	
}
