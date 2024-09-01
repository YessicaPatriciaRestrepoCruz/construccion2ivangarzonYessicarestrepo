package app.Controller;


import app.service.Interface.AdminServiceInterface;


public class AdminController implements ControllerInterface {
    private PersonController personController;
    private UserController userController;
    private AdminServiceInterface service;
    private MemberController memberController;
    private GuestController guestController;
    
    
    private static final String MENU = "Bienvenido al Sistema de Gestión del Club \n" +
                                        "1. Gestion de Personas \n" +
                                        "2. Gestion de Usurio \n" +
                                        "3. Gestion de Socios\n" +
                                        "4. Gestion de Invitados\n" +
                                        "5. Cerrar sesión.";

    public AdminController(PersonController personController, UserController userController, 
                           MemberController memberController, GuestController guestController) {
        this.personController = personController;
        this.userController = userController;
        this.memberController = memberController;
        this.guestController = guestController;
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
            System.out.println("Bienvenido" );
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
                this.personController.session();
                return true;
            case "2":
                this.userController.session();
                return true;
                
            case "3":
                this.memberController.session();
                return true;
            case "4":
                this.guestController.session();
                return true;
            
            case "5":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
}
// adminParnerInterface
    //clases e interfaces en paquetes para que se diferencien
    
    