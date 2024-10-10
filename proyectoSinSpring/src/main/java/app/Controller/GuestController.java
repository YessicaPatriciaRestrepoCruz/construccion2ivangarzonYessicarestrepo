package app.Controller;

import app.Dto.GuestDto;
import app.service.Interface.GuestServiceInterface;
import app.service.PersonService;
import java.util.Scanner;


public class GuestController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desea \n" +
                                        "1. crear invitado. \n" +
                                        "2. modificar invitado. \n" +
                                        "3. borrar invitado. \n" +
                                        "4. Para cerrar sesión.";

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
                 // createGuest(); // guestService.createguest(dto)
                return true;
                
             case "2":
                 // updateGuest();
                return true;
                
            case "3":
                //  deleteGuest();
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

