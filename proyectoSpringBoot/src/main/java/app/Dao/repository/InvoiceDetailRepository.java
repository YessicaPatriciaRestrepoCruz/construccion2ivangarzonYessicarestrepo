
package app.Dao.repository;

import app.Model.Invoice;
import app.Model.InvoiceDetail;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface InvoiceDetailRepository extends JpaRepository < InvoiceDetail ,Long > {

 @Transactional
    public void deleteInvoiceDetailByInvoiceId( Invoice invoice );
    public List<InvoiceDetail> findByInvoiceId( Invoice invoice );
    public InvoiceDetail findInvoiceDetailById (Long id);
    
   
}
