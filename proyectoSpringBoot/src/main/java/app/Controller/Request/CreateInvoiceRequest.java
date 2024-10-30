
package app.Controller.Request;

import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateInvoiceRequest {
    
     private Long personId; 
    private Long memberId;  
    private Date creationDate;
    private double amount; 
    private String status; 
    private List<CreateInvoiceDetailRequest> details;
    
}
