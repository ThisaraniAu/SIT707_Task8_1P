package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	public static boolean login(String username, String password, String dob) {
        // Update the authentication logic as needed
        if(username != null && !username.isEmpty() &&
           password != null && !password.isEmpty() &&
           dob != null && !dob.isEmpty()) {
            // For simplicity, let's assume any non-empty input is considered valid
            return true;
        } else {
            return false;
        }
        
	}
    


	
	
}
