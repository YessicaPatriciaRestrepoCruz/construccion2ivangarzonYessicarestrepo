package app.Controller;


import app.Dto.GuestDto;
import app.Model.Member;
import app.Model.User;
import app.service.Interface.GuestServiceInterface;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Setter
@Getter
@NoArgsConstructor

public class GuestController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desea \n" +
                                        "1. crear invitado. \n" +
                                        "2. modificar invitado. \n" +
                                        "3. borrar invitado. \n" +
                                         "4. borrar invitado. \n" +
                                        "5. Para cerrar sesión.";
    
     
    @Autowired
    private GuestServiceInterface guestService;

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
                
                return createGuest();
                
             case "2":
                
                return updateGuest();
                
            case "3":
                
                return deleteGuest();
            
            case "4":
                
                return listGuests();
                
            case "5":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
    
    
    private boolean createGuest() {
        Scanner scanner = new Scanner(System.in);
        GuestDto newGuest = new GuestDto();

        try {
            System.out.println("Ingrese el ID del invitado:");
            newGuest.setId(Long.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el ID del usuario asociado:");
            User user = new User(); 
            user.setId(Long.valueOf(scanner.nextLine()));
            newGuest.setUserId(user);

            System.out.println("Ingrese el ID del miembro asociado:");
            Member member = new Member(); //objeto
            member.setId(Long.valueOf(scanner.nextLine()));
            newGuest.setMemberId(member);

            System.out.println("Ingrese el estado del invitado:");
            newGuest.setStatus(scanner.nextLine());

            guestService.createGuest(newGuest);
            System.out.println("Invitado creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear invitado: " + e.getMessage());
        }

        return true;
    }

    private boolean updateGuest() {
        Scanner scanner = new Scanner(System.in);
        GuestDto updatedGuest = new GuestDto();

        try {
            System.out.println("Ingrese el ID del invitado a actualizar:");
            updatedGuest.setId(Long.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el nuevo ID del usuario asociado:");
            User user = new User(); 
            user.setId(Long.valueOf(scanner.nextLine()));
            updatedGuest.setUserId(user);

            System.out.println("Ingrese el nuevo ID del miembro asociado:");
            Member member = new Member(); 
            member.setId(Long.valueOf(scanner.nextLine()));
            updatedGuest.setMemberId(member);

            System.out.println("Ingrese el nuevo estado del invitado:");
            updatedGuest.setStatus(scanner.nextLine());

            guestService.updateGuest(updatedGuest);
            System.out.println("Invitado actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar invitado: " + e.getMessage());
        }

        return true;
    }

    private boolean deleteGuest() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el ID del invitado a borrar:");
            long id = Long.parseLong(scanner.nextLine());

            guestService.deleteGuest(id);
            System.out.println("Invitado borrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar invitado: " + e.getMessage());
        }

        return true;
    }

    private boolean listGuests() {
        try {
            List<GuestDto> guests = guestService.getAllGuests();
            if (guests.isEmpty()) {
                System.out.println("No hay invitados registrados.");
            } else {
                for (GuestDto guest : guests) {
                    System.out.println(guest);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar invitados: " + e.getMessage());
        }
        return true;
    }
}

