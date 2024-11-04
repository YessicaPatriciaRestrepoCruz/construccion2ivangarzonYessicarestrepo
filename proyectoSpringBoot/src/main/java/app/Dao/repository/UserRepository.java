
package app.Dao.repository;

import app.Model.Person;
import app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    public User findUserByUsername(String userName);

    public User findUserById(long id);

    public User findByPersonId(Person person);
    
    boolean existsByUsername(String username);
    
}
