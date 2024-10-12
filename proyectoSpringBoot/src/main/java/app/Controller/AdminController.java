package app.Controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;




@Controller
@Setter
@Getter
@NoArgsConstructor
public class AdminController implements ControllerInterface {
    
     @Autowired
    private PersonController personController;
    
    @Autowired
    private UserController userController;
    
    @Autowired
    private MemberController memberController;
    
    @Autowired
    private GuestController guestController;
    
    
   
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
                this.personController.session();
                return true;
            case "2":
                this.userController.session();
                return true;
                
            case "3":
                this.memberController.session();
                return true;
            case "4":
                guestController.session();
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

    
    