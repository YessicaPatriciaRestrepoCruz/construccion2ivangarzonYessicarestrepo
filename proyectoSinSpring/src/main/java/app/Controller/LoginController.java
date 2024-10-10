package app.Controller;

import java.util.HashMap;
import java.util.Map;
import app.Controller.Validator.UserValidator;
import app.Dto.UserDto;


import app.service.LoginService;

public class LoginController implements ControllerInterface {
    private UserValidator userValidator;    
    private LoginService loginService;
    private static final String MENU = 
        "Ingrese la opción que desea: \n" +
        "1. Para iniciar sesión. \n" +
        "2. Para detener la ejecución.";
    private Map<String, ControllerInterface> roles; 

     public  LoginController () {
        this.loginService = new LoginService();
        this.userValidator = new UserValidator();
        ControllerInterface adminController = new AdminController();
        ControllerInterface memberController = new MemberController();
        ControllerInterface guestController = new GuestController();

        this.roles = new HashMap<String, ControllerInterface>();
        roles.put("ADMINISTRADOR", adminController);
        roles.put("SOCIO", memberController);
        roles.put("INVITADO", guestController);
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
        userValidator.validateUserName(userName);

        System.out.println("Ingrese la contraseña:");
        String password = Utils.getReader().nextLine();
        userValidator.validatePassword(password); 

        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
        
        this.loginService.login(userDto);

        
       if(this.roles.get(userDto.getRole()) == null) {
            throw new Exception ("Rol invalido");
        }
        this.roles.get(userDto.getRole()).session();
    }
    }

