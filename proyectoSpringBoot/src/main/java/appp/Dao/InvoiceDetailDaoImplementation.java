
package appp.Dao;

import app.Dao.Interfaces.InvoiceDetailDao;
import app.Dao.repository.InvoiceDetailRepository;
import app.Dto.InvoiceDetailDto;
import app.Model.InvoiceDetail;
import app.helpers.Helper;
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
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao  {
    @Autowired
            InvoiceDetailRepository invoiceDetailRepository;


    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

   

    @Override
    public void updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
      
        
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void deleteInvoiceDetail(long id) throws Exception {
        invoiceDetailRepository.deleteById(id);
    }

    @Override
    public InvoiceDetailDto getInvoiceDetailById(long id) throws Exception {
       InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow(() -> new Exception("Detalle de factura no encontrado"));
        return Helper.parse(invoiceDetail);
    }

    @Override
    public List<InvoiceDetailDto> getDetailsByInvoiceId(long invoiceId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
    
    
    
}
