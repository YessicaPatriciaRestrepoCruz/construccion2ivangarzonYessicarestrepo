
package app.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreatePersonRequest {
    
    
    private Long id;            
    private Long document;    
    private String name;        
    private Long phoneNumber;
    
}
