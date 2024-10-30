
package app.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
public class CreateInvoiceDetailRequest {
    
    private int item;          
    private String description; 
    private double amount;     
    
}
