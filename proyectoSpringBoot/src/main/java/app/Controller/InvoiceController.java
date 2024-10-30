
package app.Controller;

import app.Controller.Request.CreateInvoiceDetailRequest;
import app.Controller.Request.CreateInvoiceRequest;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yessica
 */


@RestController 
@Setter
@Getter
@NoArgsConstructor

@RequestMapping("/invoices")

public class InvoiceController {
    
   

    @Autowired
    private InvoiceServiceInterface invoiceService;
    
     @Autowired
    private InvoiceDetailServiceInterface invoiceDetailService;
     
     
     @PostMapping 
public ResponseEntity<String> createInvoice(@RequestBody CreateInvoiceRequest request) {
    try {
        InvoiceDto newInvoice = new InvoiceDto();
        PersonDto person = new PersonDto();
        person.setId(request.getPersonId());
        newInvoice.setPersonId(person);

        MemberDto member = new MemberDto();
        member.setId(request.getMemberId());
        newInvoice.setMemberId(member);

        newInvoice.setCreationDate(request.getCreationDate());
        newInvoice.setAmount(request.getAmount());
        newInvoice.setStatus(request.getStatus());

        
        List<InvoiceDetailDto> details = new ArrayList<>();
        for (CreateInvoiceDetailRequest detailRequest : request.getDetails()) {
            InvoiceDetailDto detail = new InvoiceDetailDto();
            detail.setItem(detailRequest.getItem());
            detail.setDescription(detailRequest.getDescription());
            detail.setAmount(detailRequest.getAmount());
            details.add(detail);
        }
        newInvoice.setDetails(details); 

        invoiceService.createInvoice(newInvoice);
        return ResponseEntity.ok("Factura y detalles creados exitosamente.");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error al crear factura: " + e.getMessage());
    }
}
    
@PutMapping("/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable Long id, @RequestBody CreateInvoiceRequest request) {
        try {
            
            InvoiceDto updatedInvoice = new InvoiceDto();
            updatedInvoice.setId(id);
            
            PersonDto person = new PersonDto();
             person.setId(request.getPersonId());
            updatedInvoice.setPersonId(person);
            
             MemberDto member = new MemberDto();
              member.setId(request.getMemberId());
             updatedInvoice.setMemberId(member);
            
             
             updatedInvoice.setCreationDate(request.getCreationDate());
             updatedInvoice.setAmount(request.getAmount());
             updatedInvoice.setStatus(request.getStatus());
             
             List<InvoiceDetailDto> details = new ArrayList<>();
        for (CreateInvoiceDetailRequest detailRequest : request.getDetails()) {
            InvoiceDetailDto detail = new InvoiceDetailDto();
            detail.setItem(detailRequest.getItem());
            detail.setDescription(detailRequest.getDescription());
            detail.setAmount(detailRequest.getAmount());
            details.add(detail);
        }
            

            invoiceService.updateInvoice(updatedInvoice);
            return ResponseEntity.ok("Factura actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar factura: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        try {
            invoiceService.deleteInvoice(id);
            return ResponseEntity.ok("Factura borrada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al borrar factura: " + e.getMessage());
        }
    }

    @GetMapping 
    public ResponseEntity<List<InvoiceDto>> listInvoices() {
        try {
            List<InvoiceDto> invoices = invoiceService.getAllInvoices();
            if (invoices.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(invoices);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
  
         
    


