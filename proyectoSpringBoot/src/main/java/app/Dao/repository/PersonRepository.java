
package app.Dao.repository;

import app.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository< Person,Long>{

    public boolean existsByDocuemnt(long document);

    public Person findByDocument(long document);

    public Person findPersonById(long id);
    
}
