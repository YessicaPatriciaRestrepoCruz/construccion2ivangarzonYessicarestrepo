
package app.Controller;

import app.Dto.InvoiceDetailDto;
import app.Dto.InvoiceDto;
import app.Dto.MemberDto;
import app.Dto.PersonDto;
import app.service.Interface.InvoiceDetailServiceInterface;
import app.service.Interface.InvoiceServiceInterface;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Yessica
 */


@Controller
@Setter
@Getter
@NoArgsConstructor

public class InvoiceController implements ControllerInterface {
    
    
    private static final String MENU = "Gestión de Facturas\n" +
            "1. Crear Factura\n" +
            "2. Actualizar Factura\n" +
            "3. Borrar Factura\n" +
            "4. Listar Facturas\n" +
            "5. Cerrar sesión.";

    @Autowired
    private InvoiceServiceInterface invoiceService;
    
     @Autowired
    private InvoiceDetailServiceInterface invoiceDetailService;
    
    

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
                return createInvoice();
            case "2":
                return updateInvoice();
            case "3":
                return deleteInvoice();
            case "4":
                return listInvoices();
            case "5":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }  
}
        
          private boolean createInvoice() {
        Scanner scanner = new Scanner(System.in);
        InvoiceDto newInvoice = new InvoiceDto();
        List<InvoiceDetailDto> details = new ArrayList<>();

        try {
             System.out.println("Ingrese el ID de la persona que realiza el consumo:");
            PersonDto person = new PersonDto();
            person.setId(Long.parseLong(scanner.nextLine()));
            newInvoice.setPersonId(person);
        
            System.out.println("Ingrese el ID del socio que paga el consumo:");
             MemberDto member = new MemberDto();
             member.setId(Long.parseLong(scanner.nextLine()));
             newInvoice.setMemberId(member);

            System.out.println("Ingrese la fecha de generación (YYYY-MM-DD):");
            newInvoice.setCreationDate(Date.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el monto total:");
            newInvoice.setAmount(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ingrese el estado (Pagada/Sin pagar):");
            newInvoice.setStatus(scanner.nextLine());
               
            
            boolean addingDetails = true;
            int itemNumber = 1; // Para el número de ítem
            while (addingDetails) {
                InvoiceDetailDto detail = new InvoiceDetailDto();
                detail.setItem(itemNumber);

                System.out.println("Ingrese la descripción del ítem:");
                detail.setDescription(scanner.nextLine());

                System.out.println("Ingrese el valor del ítem:");
                detail.setAmount(Double.parseDouble(scanner.nextLine()));
                
                details.add(detail);
                itemNumber++;

                System.out.println("¿Desea agregar otro detalle? (s/n):");
                addingDetails = scanner.nextLine().equalsIgnoreCase("s");
            }

            newInvoice.setDetails(details); // Establecer los detalles en la factura
            invoiceService.createInvoice(newInvoice);
            System.out.println("Factura y detalles creados exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear factura: " + e.getMessage());
        }

        return true;
    }
            
         

    private boolean updateInvoice() {
        Scanner scanner = new Scanner(System.in);
        InvoiceDto updatedInvoice = new InvoiceDto();

        try {
            System.out.println("Ingrese el ID de la factura a actualizar:");
            updatedInvoice.setId(Long.parseLong(scanner.nextLine()));
            
            System.out.println("Ingrese el nuevo ID de la persona que realiza el consumo:");
            PersonDto person = new PersonDto();
            person.setId(Long.parseLong(scanner.nextLine()));
            updatedInvoice.setPersonId(person);
            
             System.out.println("Ingrese el nuevo ID del socio que paga el consumo:");
             MemberDto member = new MemberDto();
             member.setId(Long.parseLong(scanner.nextLine()));
            updatedInvoice.setMemberId(member);


            System.out.println("Ingrese la nueva fecha de generación (YYYY-MM-DD):");
            updatedInvoice.setCreationDate(Date.valueOf(scanner.nextLine()));

            System.out.println("Ingrese el nuevo monto total:");
            updatedInvoice.setAmount(Double.parseDouble(scanner.nextLine()));

            System.out.println("Ingrese el nuevo estado (Pagada/Sin pagar):");
            updatedInvoice.setStatus(scanner.nextLine());

            invoiceService.updateInvoice(updatedInvoice);
            System.out.println("Factura actualizada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar factura: " + e.getMessage());
        }

        return true;
    }

    private boolean deleteInvoice() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el ID de la factura a borrar:");
            long id = Long.parseLong(scanner.nextLine());

            invoiceService.deleteInvoice(id);
            System.out.println("Factura borrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar factura: " + e.getMessage());
        }

        return true;
    }

    private boolean listInvoices() {
        try {
            List<InvoiceDto> invoices = invoiceService.getAllInvoices();
            if (invoices.isEmpty()) {
                System.out.println("No hay facturas registradas.");
            } else {
                for (InvoiceDto invoice : invoices) {
                    System.out.println(invoice); // ojooo toString() en InvoiceDto
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar facturas: " + e.getMessage());
        }
        return true;
    }
}

