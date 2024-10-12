package app.Dao.Interfaces;
import app.Dto.InvoiceDto;
import java.util.List;

public interface InvoiceDao {
    
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
    public InvoiceDto findInvoiceById( Long id) throws Exception;
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception;
   public  void deleteInvoice(Long id) throws Exception;

    public List<InvoiceDto> findAllInvoices();
    
}
