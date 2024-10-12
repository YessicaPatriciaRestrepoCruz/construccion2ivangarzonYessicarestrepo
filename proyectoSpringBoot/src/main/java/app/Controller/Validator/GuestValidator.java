
package app.Controller.Validator;

import app.Model.Member;
import app.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class GuestValidator extends CommonsValidator {
   
public void validateStatus(String status) throws Exception {
        isValidString("Status", status);
    }
  

    public void validateUser(User user) throws Exception {
        if (user == null || user.getId() == null) {
            throw new Exception("El usuario debe ser válido.");
        }
    }
    
    public void validateMember(Member member) throws Exception {
        if (member == null || member.getId() == null) {
            throw new Exception("El miembro debe ser válido.");
        }
    }
}
    



