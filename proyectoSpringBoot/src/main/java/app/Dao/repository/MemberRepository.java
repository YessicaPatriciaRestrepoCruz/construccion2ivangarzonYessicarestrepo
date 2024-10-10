
package app.Dao.repository;

import app.Model.Member;
import app.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository < Member,Long > {
    
        public Member existsByDocuemnt(long id);
        public Member findPersonByUserId(long userid);// verificar funcion 
        public Member findMemberById(Long id);
        public Member deleteMember(Long id);
    
}
