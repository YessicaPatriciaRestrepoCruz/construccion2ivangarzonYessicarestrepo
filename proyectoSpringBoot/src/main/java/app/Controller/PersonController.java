package app.Controller;

import app.Dto.PersonDto;
import app.service.Interface.PersonServiceInterface;
import app.service.PersonService;
import java.util.Scanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Setter
@Getter
@NoArgsConstructor

public class PersonController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desee \n" +
                                        "1. Crear persona \n" +
                                        "2. Actualizar persona \n" +
                                        "3. Borrar persona \n" +
                                        "4. cerrar sesion\n";
                                        
    private PersonService personservice = new PersonService();
    
    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println("Bienvenido");
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1":
                
               this.personservice.createPerson();
            
                return true;
            case "2":
               // updatePerson
                return true;
            case "3":
                //deletePerson();
                return true;
           case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
}