package app.Controller;

import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.service.Interface.UserServiceInterface;
import java.util.Scanner;

public class UserController implements ControllerInterface {
    
    private static final String MENU = "Gestión de usuario\n" +
                                        "1. Crear usuario\n" +
                                        "2. Actualizar usuario\n" +
                                        "3. Borrar usuario\n" +
                                        "4. Cerrar sesión.";

    private UserServiceInterface userService;
    private Scanner scanner;
    
    public UserController(UserServiceInterface userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }
    
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
            String option = scanner.nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1":
                createUser();
                return true;
            case "2":
                updateUser();
                return true;
            case "3":
                deleteUser();
                return true;
            case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }

    private void createUser() throws Exception {
        System.out.println("Ingrese el ID del usuario:");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Ingrese el nombre de usuario:");
        String userName = scanner.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = scanner.nextLine();

        System.out.println("Ingrese el rol:");
        String role = scanner.nextLine();

        System.out.println("Ingrese el ID de la persona asociada:");
        long personId = Long.parseLong(scanner.nextLine());

        PersonDto personDto = new PersonDto();
        personDto.setId(personId);

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole(role);
        userDto.setPerson(personDto);

        userService.createUser(userDto);
        System.out.println("Usuario creado con éxito.");
    }

    private void updateUser() throws Exception {
        System.out.println("Ingrese el ID del usuario a actualizar:");
        long id = Long.parseLong(scanner.nextLine());

        UserDto userDto = userService.getUserById(id);

        System.out.println("Ingrese el nuevo nombre de usuario (actual: " + userDto.getUserName() + "):");
        String userName = scanner.nextLine();
        if (!userName.isEmpty()) {
            userDto.setUserName(userName);
        }

        System.out.println("Ingrese la nueva contraseña (actual: " + userDto.getPassword() + "):");
        String password = scanner.nextLine();
        if (!password.isEmpty()) {
            userDto.setPassword(password);
        }

        System.out.println("Ingrese el nuevo rol (actual: " + userDto.getRole() + "):");
        String role = scanner.nextLine();
        if (!role.isEmpty()) {
            userDto.setRole(role);
        }

        userService.updateUser(userDto);
        System.out.println("Usuario actualizado con éxito.");
    }

    private void deleteUser() throws Exception {
        System.out.println("Ingrese el ID del usuario a borrar:");
        long id = Long.parseLong(scanner.nextLine());

        userService.deleteUser(id);
        System.out.println("Usuario borrado con éxito.");
    }
}