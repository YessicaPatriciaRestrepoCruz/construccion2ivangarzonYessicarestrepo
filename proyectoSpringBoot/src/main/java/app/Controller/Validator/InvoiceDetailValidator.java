
package app.Controller.Validator;

import app.Dto.InvoiceDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@Component
public class InvoiceDetailValidator extends CommonsValidator {
    
    
    public void validate(InvoiceDetailDto invoiceDetailDto) throws Exception {
        validateInvoiceId(invoiceDetailDto.getInvoiceId());
        validateItem(invoiceDetailDto.getItem());
        validateDescription(invoiceDetailDto.getDescription());
        validateAmount(invoiceDetailDto.getAmount());
    }

    private void validateInvoiceId(Long invoiceId) throws Exception {
        if (invoiceId == null) {
            throw new Exception("El ID de la factura no puede ser nulo.");
        }
    }

    private void validateItem(int item) throws Exception {
        if (item <= 0) {
            throw new Exception("El número de ítem debe ser mayor que cero.");
        }
    }

    private void validateDescription(String description) throws Exception {
        isValidString("Descripción", description); 
    }

    private void validateAmount(double amount) throws Exception {
        isValidPositive("Valor del ítem", amount);
}
}
