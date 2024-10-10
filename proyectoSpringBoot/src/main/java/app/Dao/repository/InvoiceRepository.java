
package app.Dao.repository;

import app.Model.Invoice;
import app.Model.Member;
import app.Model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository < Invoice,Long > {
    
    public List<Invoice> findByPersonId(Person person);
    public List<Invoice> findByPartnerId(Member member);
    public Invoice findInvoiceById(Long id);
    
}
