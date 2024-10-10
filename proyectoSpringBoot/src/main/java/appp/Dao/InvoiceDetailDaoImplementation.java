
package appp.Dao;

import app.Dao.Interfaces.InvoiceDetailDao;
import app.Dao.repository.InvoiceDetailRepository;
import app.Dto.InvoiceDetailDto;
import app.Model.InvoiceDetail;
import app.helpers.Helper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao  {
    @Autowired
            InvoiceDetailRepository invoiceDetailRepository;


    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public InvoiceDetailDto findInvoiceDetailById(InvoiceDetailDto invoiceDetailDto) throws Exception {
        
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findInvoiceDetailById(invoiceDetailDto.getId());
        return Helper.parse(invoiceDetail);
    }

    @Override
    public void updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
      
        
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void deleteInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
         
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.delete(invoiceDetail);
    }

   
    
    
    
}
