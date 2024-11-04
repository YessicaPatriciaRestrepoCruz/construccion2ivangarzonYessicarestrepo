package app.Dao;

import app.Dao.Interfaces.InvoiceDao;
import app.Dao.repository.InvoiceRepository;
import app.Model.Invoice;
import app.helpers.Helper;
import app.Dto.InvoiceDto;
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
    
public class InvoiceDaoImplementation implements InvoiceDao {
    @Autowired
        InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        
         Invoice invoice = Helper.parse(invoiceDto);
       invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceDto findInvoiceById(Long id) throws Exception {
        
       Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new Exception("Factura no encontrada."));

        return Helper.parse(invoice);
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception {
        
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(Long id) throws Exception {
        
        if (!invoiceRepository.existsById(id)) {
            throw new Exception("Factura no encontrada.");
        }
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDto> findAllInvoices() {
      
        List<Invoice> invoices = invoiceRepository.findAll();
        return Helper.parseInvoices(invoices); 
    }
}
