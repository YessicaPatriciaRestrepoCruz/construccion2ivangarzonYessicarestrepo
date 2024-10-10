
package app.Dto;
// las clases que herdan son los valiodadores 

import app.Model.Member;
import app.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
public class GuestDto {
    
    private Long id;
    private User userId;
    private Member memberId;
    private String status;
    
   
   
   
   
}
    
