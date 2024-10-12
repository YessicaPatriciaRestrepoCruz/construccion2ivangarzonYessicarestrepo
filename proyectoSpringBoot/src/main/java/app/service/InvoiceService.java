
package app.service;


import app.Controller.Validator.InvoiceValidator;
import app.Dao.Interfaces.InvoiceDao;
import app.Dto.InvoiceDto;
import app.service.Interface.InvoiceServiceInterface;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceService implements InvoiceServiceInterface {
    
    
    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired 
    private InvoiceDao invoiceDao;

    
    public InvoiceDto getInvoiceById(long id) throws Exception {
       
         return invoiceDao.findInvoiceById(id);
    }

    public List<InvoiceDto> getAllInvoices() throws Exception {
        
        return invoiceDao.findAllInvoices();
    }

    public void updateInvoice(InvoiceDto invoiceDto) throws Exception {
        
        invoiceValidator.validateAmount(invoiceDto.getAmount());
        invoiceValidator.validateStatus(invoiceDto.getStatus());
        invoiceDao.updateInvoice(invoiceDto);
    }

    public void deleteInvoice(long id) throws Exception {
        invoiceDao.deleteInvoice(id);
    }

    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        
        invoiceValidator.validateAmount(invoiceDto.getAmount());
        invoiceValidator.validateStatus(invoiceDto.getStatus());
        invoiceDao.createInvoice(invoiceDto);
    }
}// Guardar la factura en el sistema