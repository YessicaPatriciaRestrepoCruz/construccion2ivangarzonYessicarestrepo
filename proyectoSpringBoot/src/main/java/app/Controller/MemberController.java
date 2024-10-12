package app.Controller;

import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;

import java.sql.Date;
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
// falta de valitador para poner @Autowired 

public class MemberController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opcion que desea \n"+
                                        "1. Crear socio  \n" +
                                        "2. actualizar socio \n" +
                                        "3. borrar socio \n"+
                                        "4. lista de miembros \n"+
                                        "4. cerrar sesión.";
    @Autowired
    
    private MemberServiceInterface memberService;
  
    
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
                
             return createMember();
                
            case "2":
               
                return updateMember();
            case "3":
               
                return deleteMember();
                
            case "4":
               
                return listMembers();
            case "5":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }
    
    private boolean createMember() {
        Scanner scanner = new Scanner(System.in);
        MemberDto newMember = new MemberDto();

        try {
            System.out.println("Ingrese el ID del socio:");
            newMember.setId(Long.parseLong(scanner.nextLine()));

            System.out.println("Ingrese el tipo de socio:");
            newMember.setType(scanner.nextLine());

            System.out.println("Ingrese el monto:");
            newMember.setAmount(Double.parseDouble(scanner.nextLine()));
            
            System.out.println("Ingrese la fecha de afiliación (YYYY-MM-DD):");
            newMember.setAffiliationDate(Date.valueOf(scanner.nextLine()));

            memberService.createMember(newMember); // revisar este dirigido a???
            System.out.println("Socio creado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al crear socio: " + e.getMessage());
        }

        return true;
    }

    private boolean updateMember() {
        Scanner scanner = new Scanner(System.in);
        MemberDto updatedMember = new MemberDto();

        try {
            System.out.println("Ingrese el ID del socio a actualizar:");
            updatedMember.setId(Long.parseLong(scanner.nextLine()));

            System.out.println("Ingrese el nuevo tipo de socio:");
            updatedMember.setType(scanner.nextLine());
           
            
            System.out.println("Ingrese el nuevo monto:");
            updatedMember.setAmount(Double.parseDouble(scanner.nextLine()));
            
            
            System.out.println("Ingrese la nueva fecha de afiliación (YYYY-MM-DD):");
            updatedMember.setAffiliationDate(Date.valueOf(scanner.nextLine()));

            memberService.updateMember(updatedMember);
            System.out.println("Socio actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar socio: " + e.getMessage());
        }

        return true;
    }

    private boolean deleteMember() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el ID del socio a borrar:");
            long id = Long.parseLong(scanner.nextLine());

            memberService.deleteMember(id);
            System.out.println("Socio borrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar socio: " + e.getMessage());
        }

        return true;
    }

    private boolean listMembers() {
        try {
            List<MemberDto> members = memberService.getAllMembers();
            if (members.isEmpty()) {
                System.out.println("No hay socios registrados.");
            } else {
                for (MemberDto member : members) {
                    System.out.println(member); //  toString()dto
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar socios: " + e.getMessage());
        }
        return true;
    }
}
    



