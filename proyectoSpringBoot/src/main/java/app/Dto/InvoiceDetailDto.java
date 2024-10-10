
package app.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
public class InvoiceDetailDto {
    private Long id;
    private Long invoiceId;
    private int item;
    private String description;
    private double amount;

    
}
