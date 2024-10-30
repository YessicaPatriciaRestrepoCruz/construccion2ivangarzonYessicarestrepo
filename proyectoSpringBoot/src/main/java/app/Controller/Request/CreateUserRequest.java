
package app.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequest {
    
    private Long id;           
    private String username;   
    private String password;   
    private String role;  
    
    
}
