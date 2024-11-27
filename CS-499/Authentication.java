import java.util.HashMap;

public class Authentication {
	
   // Create a hash map to store key value pair
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
   // Create a constructor for id and password
	Authentication() {
		logininfo.put("user", "pwd");
	}
   // Add getter for the hash map
	protected HashMap<String, String> getLoginInfo() {
		return logininfo;
	}
}
