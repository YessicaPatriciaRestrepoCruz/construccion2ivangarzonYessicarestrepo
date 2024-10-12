
package app.service;

import app.Controller.Validator.InvoiceDetailValidator;
import app.Dao.Interfaces.InvoiceDetailDao;
import app.Dto.InvoiceDetailDto;
import app.service.Interface.InvoiceDetailServiceInterface;
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

/**
 *
 * @author Yessica
 */
public class InvoiceDetailService implements InvoiceDetailServiceInterface {
    
    @Autowired
    private InvoiceDetailDao invoiceDetailDao;
    
    @Autowired
    private InvoiceDetailValidator invoiceDetailValidator;

    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        
        invoiceDetailValidator.validate(invoiceDetailDto); 
        invoiceDetailDao.createInvoiceDetail(invoiceDetailDto);
    }

    @Override
    public void updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        invoiceDetailValidator.validate(invoiceDetailDto);
        invoiceDetailDao.updateInvoiceDetail(invoiceDetailDto);
    }

    @Override
    public void deleteInvoiceDetail(long id) throws Exception {
        invoiceDetailDao.deleteInvoiceDetail(id);
    }

     public List<InvoiceDetailDto> getDetailsByInvoiceId(long invoiceId) throws Exception {
        return invoiceDetailDao.getDetailsByInvoiceId(invoiceId);
    }
    

    @Override
    public InvoiceDetailDto getInvoiceDetailById(long id) throws Exception {
        
        return invoiceDetailDao.getInvoiceDetailById(id);
    }
    
}
