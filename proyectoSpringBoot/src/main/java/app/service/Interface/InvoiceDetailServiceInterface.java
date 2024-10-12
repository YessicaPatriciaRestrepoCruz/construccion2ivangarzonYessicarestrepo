
package app.service.Interface;

import app.Dto.InvoiceDetailDto;
import java.util.List;

/**
 *
 * @author Yessica
 */
public interface InvoiceDetailServiceInterface {
    
    
    void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    void updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    void deleteInvoiceDetail(long id) throws Exception;
    
    InvoiceDetailDto getInvoiceDetailById(long id) throws Exception;
}
