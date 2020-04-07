package businesslogic;

public class Validation{
	public boolean adminlogin(String username,String password) {
		
		if(username.equals("raju@gmail.com") && password.equals("12345"))
				return true;
		else 
				return false;
	}
}