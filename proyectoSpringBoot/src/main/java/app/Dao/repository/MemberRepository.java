
package app.Dao.repository;

import app.Model.Member;
import app.Model.Person;
import app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository < Member,Long > {
    
       // public Member existsByDocument(long id);
        public Member findPersonByUserId(User userid); 
        public Member findById(long id);
    
}
