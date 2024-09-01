package app.service.Interface;
import app.Dto.InvoiceDto;
import java.util.List;

public interface InvoiceServiceInterface {
    
   public void createInvoice(InvoiceDto invoiceDto) throws Exception;
   public InvoiceDto getInvoiceById(long id) throws Exception;
   public List<InvoiceDto> getAllInvoices() throws Exception;
   public void updateInvoice(InvoiceDto invoiceDto) throws Exception;
   public void deleteInvoice(long id) throws Exception;
    
}
