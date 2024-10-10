package app.Controller;

import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.service.Interface.UserServiceInterface;
import app.service.PersonService;
import app.service.UserService;
import java.util.Scanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Setter
@Getter
@NoArgsConstructor


public class UserController implements ControllerInterface {
    
    private static final String MENU = "Gestión de usuario\n" +
                                        "1. Crear usuario\n" +
                                        "2. Actualizar usuario\n" +
                                        "3. Borrar usuario\n" +
                                        "4. Cerrar sesión.";

    private UserService userService = new UserService();
    
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
               // createUser();
                return true;
            case "2":
               // updateUser();
                return true;
            case "3":
               // deleteUser();
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