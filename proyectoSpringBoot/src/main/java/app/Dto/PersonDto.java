
package app.Dto;


import app.Controller.Validator.PersonValidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
public class PersonDto  {
    private long Id;
    private long document; //long
    private String name;
    private long phoneNumber;
    
    private final PersonValidator personValidator = new PersonValidator();
    

}
