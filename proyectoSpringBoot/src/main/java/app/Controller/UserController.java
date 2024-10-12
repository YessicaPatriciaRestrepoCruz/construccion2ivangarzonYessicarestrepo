package app.Controller;

import app.Dto.UserDto;
import app.service.Interface.UserServiceInterface;
import java.util.Scanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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

 @Autowired
    private UserServiceInterface userService;
 
 private Scanner scanner = new Scanner(System.in);
    
    
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
               
                return createUser();
                
            case "2":
               
                return updateUser();
            case "3":
               
                return deleteUser();
            case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
    
    private boolean createUser() {
        Scanner scanner = new Scanner(System.in);
        UserDto newUser = new UserDto();

        try {
            System.out.println("Ingrese el ID del usuario:");
            newUser.setId(Long.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el nombre de usuario:");
            newUser.setUserName(scanner.nextLine());

            System.out.println("Ingrese la contraseña:");
            newUser.setPassword(scanner.nextLine());

            System.out.println("Ingrese el rol:");
            newUser.setRole(scanner.nextLine());

            userService.createUser(newUser);
            System.out.println("Usuario creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }

        return true;
    }

    private boolean updateUser() {
        Scanner scanner = new Scanner(System.in);
        UserDto updatedUser = new UserDto();

        try {
            System.out.println("Ingrese el ID del usuario a actualizar:");
            updatedUser.setId(Long.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el nuevo nombre de usuario:");
            updatedUser.setUserName(scanner.nextLine());

            System.out.println("Ingrese la nueva contraseña:");
            updatedUser.setPassword(scanner.nextLine());

            System.out.println("Ingrese el nuevo rol:");
            updatedUser.setRole(scanner.nextLine());

            userService.updateUser(updatedUser);
            System.out.println("Usuario actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }

        return true;
    }

    private boolean deleteUser() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el ID del usuario a borrar:");
            long id = Long.parseLong(scanner.nextLine());

            userService.deleteUser(id);
            System.out.println("Usuario borrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar usuario: " + e.getMessage());
        }

        return true;
    }
    
}