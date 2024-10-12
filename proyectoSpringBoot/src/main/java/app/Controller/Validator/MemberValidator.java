
package app.Controller.Validator;

import app.Dto.MemberDto;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static org.springframework.data.util.TypeUtils.type;
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

    public void validateAmount(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("El importe no puede ser negativo.");
        }
    }

    public void validateType(String type) throws Exception {
        if (type == null || type.isEmpty()) {
            throw new Exception("El tipo no puede ser nulo o vacío.");
        }
    }
    
    public void validateAffiliationDate(LocalDate affiliationDate) throws Exception {
        if (affiliationDate == null) {
            throw new Exception("La fecha de afiliación no puede ser nula .");
        }
}

    
}

