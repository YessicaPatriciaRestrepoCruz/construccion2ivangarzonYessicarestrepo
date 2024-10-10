
package app.Dto;

import app.Controller.Utils;
import app.Controller.Validator.PersonValidator;
import app.Dto.Interfaces.PersonDtoInterfaces;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
public class PersonDto implements PersonDtoInterfaces {
    private long id;
    private long document;
    private String name;
    private long phoneNumber;
    
    private final PersonValidator personValidator = new PersonValidator();
    
    @Override
    public void getPersonNameDto() throws Exception {
        System.out.println("Ingrese el nombre de la persona");
        String personNameDto = Utils.getReader().nextLine();
        this.personValidator.validateName( personNameDto );
        this.name = personNameDto;
    }

    @Override
    public void getPersonCellNumberDto() throws Exception {
        System.out.println("Ingrese el número de celular");
        String personCellNumberDto = Utils.getReader().nextLine();
        this.phoneNumber = personValidator.validCellPhone( personCellNumberDto );
    }

    @Override
    public void getPersonDocumentDto() throws Exception {
        System.out.println("Ingrese el documento de identidad");
        String personDocumentDto = Utils.getReader().nextLine();
        this.document = personValidator.validDocument( personDocumentDto );
    }
    
    @Override
    public void getPersonDocumentDto( String message ) throws Exception {
        System.out.println( message );
        String personDocumentDto = Utils.getReader().nextLine();
        this.document = personValidator.validDocument( personDocumentDto );
    }


}
