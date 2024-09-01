package app.Controller;

import app.Dto.GuestDto;
import app.service.Interface.GuestServiceInterface;
import java.util.Scanner;


public class GuestController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desea \n" +
                                        "1. crear invitado. \n" +
                                        "2. modificar invitado. \n" +
                                        "3. borrar invitado. \n" +
                                        "4. Para cerrar sesión.";

    private GuestServiceInterface guestService;
    private Scanner scanner;

    public GuestController(GuestServiceInterface guestService, Scanner scanner) {
        this.guestService = guestService;
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
                  createGuest();
                return true;
                
             case "2":
                  updateGuest();
                return true;
                
            case "3":
                  deleteGuest();
                return true;
            case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
private void createGuest() throws Exception {
        try {
            System.out.println("Ingrese el ID del invitado:");
            Long id = Long.parseLong(scanner.nextLine());

            System.out.println("Ingrese el ID del usuario asociado:");
            Long userId = Long.parseLong(scanner.nextLine());

            System.out.println("Ingrese el ID del miembro asociado:");
            Long memberId = Long.parseLong(scanner.nextLine());

            System.out.println("Ingrese el estado de la invitación:");
            String invitationStatus = scanner.nextLine();

            System.out.println("¿Está activo el invitado? (true/false):");
            boolean isActive = Boolean.parseBoolean(scanner.nextLine());

            GuestDto guestDto = new GuestDto();
            guestDto.setId(id);
            guestDto.setUserId(userId);
            guestDto.setMemberId(memberId);
            guestDto.setInvitationStatus(invitationStatus);
            guestDto.setIsActive(isActive);

            guestService.addGuest(guestDto);
            System.out.println("Invitado creado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los números ingresados.");
        }
    }

    private void updateGuest() throws Exception {
        System.out.println("Ingrese el ID del invitado a modificar:");
        Long id = Long.parseLong(scanner.nextLine());

        GuestDto guestDto = guestService.getGuestById(id);

        System.out.println("Ingrese el nuevo ID del usuario asociado (actual: " + guestDto.getUserId() + "):");
        String userId = scanner.nextLine();
        if (!userId.isEmpty()) {
            guestDto.setUserId(Long.parseLong(userId));
        }

        System.out.println("Ingrese el nuevo ID del miembro asociado (actual: " + guestDto.getMemberId() + "):");
        String memberId = scanner.nextLine();
        if (!memberId.isEmpty()) {
            guestDto.setMemberId(Long.parseLong(memberId));
        }

        System.out.println("Ingrese el nuevo estado de la invitación (actual: " + guestDto.getInvitationStatus() + "):");
        String invitationStatus = scanner.nextLine();
        if (!invitationStatus.isEmpty()) {
            guestDto.setInvitationStatus(invitationStatus);
        }

        System.out.println("¿Está activo el invitado? (actual: " + guestDto.isIsActive() + "):");
        String isActive = scanner.nextLine();
        if (!isActive.isEmpty()) {
            guestDto.setIsActive(Boolean.parseBoolean(isActive));
        }

        guestService.updateGuest(guestDto);
        System.out.println("Invitado actualizado con éxito.");
    }

    private void deleteGuest() throws Exception {
        System.out.println("Ingrese el ID del invitado a borrar:");
        Long id = Long.parseLong(scanner.nextLine());

        guestService.deleteGuest(id);
        System.out.println("Invitado borrado con éxito.");
    }
}

