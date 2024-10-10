package appp.Dao;

import app.Dao.Interfaces.InvoiceDao;
import app.Dao.repository.InvoiceRepository;
import app.Model.Invoice;
import app.helpers.Helper;
import app.Dto.InvoiceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
    
public class InvoiceDaoImplementation implements InvoiceDao {
    @Autowired
        InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        
         Invoice invoice = Helper.parse(invoiceDto);
       invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceDto findInvoiceById(InvoiceDto invoiceDto) throws Exception {
        
        Invoice invoice = invoiceRepository.findInvoiceById(invoiceDto.getId());
        return Helper.parse(invoice);
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception {
        
        Invoice invoice = Helper.parse(invoiceDto);//verificar helper
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(InvoiceDto invoiceDto) throws Exception {
        
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.delete(invoice);
    }
}
