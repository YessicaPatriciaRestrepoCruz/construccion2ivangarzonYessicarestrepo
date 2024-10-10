package app.Controller;

import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;
import app.service.MemberService;
import app.service.PersonService;
import java.util.Scanner;

public class MemberController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desea \n" +
                                        "1. Crear socio  \n" +
                                        "2. actualizar socio \n" +
                                        "3. borrar socio \n"+
                                        "4. cerrar sesión.";

   private MemberService memberService = new MemberService();
    
    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println("Bienvenido, ");
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
                
               //this.memberService.createMember();
                
                return true;
            case "2":
               // updateMember();
                return true;
            case "3":
               // deleteMember();
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


