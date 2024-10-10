package app.Dao.Interfaces;
import app.Dto.InvoiceDto;

public interface InvoiceDao {
    
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
    public InvoiceDto findInvoiceById( InvoiceDto invoiceDto) throws Exception;
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception;
   public  void deleteInvoice(InvoiceDto invoiceDto) throws Exception;
    
}
