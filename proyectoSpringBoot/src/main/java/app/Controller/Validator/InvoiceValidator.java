package app.Controller.Validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InvoiceValidator extends CommonsValidator {
    
    
    public void validateAmount(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("El monto no puede ser negativo.");
        }
    }

    public void validateStatus(String status) throws Exception {
        if (status == null || status.isEmpty()) {
            throw new Exception("El estado no puede ser nulo o vacío.");
        }
    }
}
