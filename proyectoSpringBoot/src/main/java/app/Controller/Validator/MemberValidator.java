
package app.Controller.Validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class MemberValidator extends CommonsValidator {
    public void validateName(String name) throws Exception {
        isValidString("Name", name);
    }

    public long validateId(String id) throws Exception {
        return isValidLong("ID", id);
    }

    public void validateCellNumber(String cellNumber) throws Exception {
        if (cellNumber.length() != 10) {
            throw new Exception("Cell number must be exactly 10 digits");
        }
        if (!cellNumber.matches("\\d+")) {
            throw new Exception("Cell number must contain only digits");
        }
    }

    public void validateUserName(String userName) throws Exception {
        isValidString("Username", userName);
    }

    public void validatePassword(String password) throws Exception {
        isValidString("Password", password);
    }
}

