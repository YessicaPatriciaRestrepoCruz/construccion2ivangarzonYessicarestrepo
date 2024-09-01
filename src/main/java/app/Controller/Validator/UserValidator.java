
package app.Controller.Validator;

public class UserValidator extends CommonsValidator {
    
 
    public void validateUserName(String userName) throws Exception {
        isValidString("Username", userName);
        
    }
    
    // Valida la contraseña
    public void validatePassword(String password) throws Exception {
        isValidString("Password", password);
       
    }
    
  
    public void validateRole(String role) throws Exception {
        isValidString("Role", role);
        if (!(role.equals("Member") || role.equals("Guest") || role.equals("Admin"))) {
            throw new Exception("Role must be one of the following: Member, Guest, Admin");
        }
    }
    
   
    public long validateUserId(String userId) throws Exception {
        return isValidLong("User ID", userId);
    }
}
