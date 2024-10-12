
package app.Controller.Validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component

public class UserValidator extends CommonsValidator {
    
 
    public void validateUserName(String userName) throws Exception {
        isValidString("Nombre de usuario", userName);
    }
    
    public void validatePassword(String password) throws Exception {
        if (password == null || password.length() < 6) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }
    }
    
   
  
    public void validateRole(String role) throws Exception {
        isValidString("Role", role);
        if (!(role.equals("Member") || role.equals("Guest") || role.equals("Admin"))) {
            throw new Exception("El rol debe ser uno de los siguientes: Miembro, Invitado, Administrador");
        }
    }
    
   
    public long validateUserId(String userId) throws Exception {
        return isValidLong("User ID", userId);
    }
}
