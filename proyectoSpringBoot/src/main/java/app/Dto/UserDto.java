
package app.Dto;
import app.Model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter

public class UserDto {
    private Long id;
    private Person personnId;
    private String userName;
    private String password;
    private String role;
   
}

