package app.Controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;


@Controller
@Setter
@Getter
@NoArgsConstructor
public class AdminController implements ControllerInterface {
    
    public ControllerInterface PersonController = new PersonController();
    public ControllerInterface UserController = new UserController();
    public ControllerInterface memberController = new MemberController();
    public ControllerInterface GuestController = new GuestController();
    
    
   
    private static final String MENU = "Bienvenido al Sistema de Gestión del Club \n" +
            
                                        "1. Gestion de Personas \n" +
                                        "2. Gestion de Usurio \n" +
                                        "3. Gestion de Socios\n" +
                                        "4. Gestion de Invitados\n" +
                                        "5. Cerrar sesión.";



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
                this.PersonController.session();
                return true;
            case "2":
                this.UserController.session();
                return true;
                
            case "3":
                this.memberController.session();
                return true;
            case "4":
                this.GuestController.session();
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

    
    