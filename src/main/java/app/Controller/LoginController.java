
package app.Controller;

import java.util.HashMap;
import java.util.Map;
import app.Controller.Validator.UserValidator;
import app.Dto.UserDto;
import app.service.UserService;
import app.service.LoginService;

public class LoginController implements ControllerInterface {
    private UserValidator userValidator;  
    private LoginService service;          
    private static final String MENU = 
        "Ingrese la opción que desea: \n" +
        "1. Para iniciar sesión. \n" +
        "2. Para detener la ejecución.";
    private Map<String, ControllerInterface> roles; 

     public LoginController(UserValidator userValidator, LoginService service, Map<String, ControllerInterface> roles) {
        this.userValidator = userValidator;
        this.service = service;
        this.roles = roles;
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
            case "1": {
                this.login();
                return true;
            }
            case "2": {
                System.out.println("Se detiene el programa.");
                return false;
            }
            default: {
                System.out.println("Ingrese una opción válida.");
                return true;
            }
        }
    }

    private void login() throws Exception {
        System.out.println("Ingrese el nombre de usuario:");
        String userName = Utils.getReader().nextLine();
        userValidator.validateUserName(userName); // Valida el nombre de usuario

        System.out.println("Ingrese la contraseña:");
        String password = Utils.getReader().nextLine();
        userValidator.validatePassword(password); // Valida la contraseña

        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);

        // Autenticación del usuario
        this.service.login(userDto);

        // Redirige al controlador del rol del usuario
        ControllerInterface roleController = roles.get(userDto.getRole());
        if (roleController == null) {
            throw new Exception("Rol inválido.");
        }
        roleController.session();
    }
}
