package app.Controller;

import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;
import app.service.MemberService;
import java.util.Scanner;

public class MemberController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desea \n" +
                                        "1. Crear socio  \n" +
                                        "2. actualizar socio \n" +
                                        "3. borrar socio \n"+
                                        "4. cerrar sesión.";

    private MemberServiceInterface memberService;
    private Scanner scanner;

    public MemberController(MemberServiceInterface memberService, Scanner scanner) {
        this.memberService = memberService;
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
                
                  createMember();
                
                return true;
            case "2":
                updateMember();
                return true;
            case "3":
                deleteMember();
                return true;
            case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
    private void createMember() throws Exception {
        System.out.println("Ingrese el ID del socio:");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Ingrese el ID de usuario asociado:");
        Long userId = Long.parseLong(scanner.nextLine());

        System.out.println("Ingrese el monto:");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese el tipo de suscripción:");
        String type = scanner.nextLine();

        System.out.println("Ingrese la fecha de afiliación (YYYY-MM-DD):");
        String dateStr = scanner.nextLine();
        java.util.Date affiliationDate = java.sql.Date.valueOf(dateStr);  // Suponiendo que estás usando java.sql.Date

        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);
        memberDto.setUserId(userId);
        memberDto.setAmount(amount);
        memberDto.setSubscriptionType(type);
        memberDto.setAffiliationDate(affiliationDate);

        memberService.createMember(memberDto);
        System.out.println("Socio creado con éxito.");
    }

    private void updateMember() throws Exception {
        System.out.println("Ingrese el ID del socio a actualizar:");
        long id = Long.parseLong(scanner.nextLine());

        MemberDto memberDto = memberService.getMemberById(id);

        System.out.println("Ingrese el nuevo monto (actual: " + memberDto.getAmount() + "):");
        String amountStr = scanner.nextLine();
        if (!amountStr.isEmpty()) {
            memberDto.setAmount(Double.parseDouble(amountStr));
        }

        System.out.println("Ingrese el nuevo tipo de suscripción (actual: " + memberDto.getType() + "):");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            memberDto.setSubscriptionType(type);
        }

        System.out.println("Ingrese la nueva fecha de afiliación (YYYY-MM-DD, actual: " + memberDto.getAffiliationDate() + "):");
        String dateStr = scanner.nextLine();
        if (!dateStr.isEmpty()) {
            java.util.Date affiliationDate = java.sql.Date.valueOf(dateStr); // Suponiendo que estás usando java.sql.Date
            memberDto.setAffiliationDate(affiliationDate);
        }

        memberService.updateMember(memberDto);
        System.out.println("Socio actualizado con éxito.");
    }

    private void deleteMember() throws Exception {
        System.out.println("Ingrese el ID del socio a borrar:");
        long id = Long.parseLong(scanner.nextLine());

        memberService.deleteMember(id);
        System.out.println("Socio borrado con éxito.");
    }
}


