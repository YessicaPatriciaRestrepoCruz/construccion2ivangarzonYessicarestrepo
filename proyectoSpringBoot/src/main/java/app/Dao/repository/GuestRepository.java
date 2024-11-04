package app.Dao.repository;

import app.Model.Guest;
import app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GuestRepository extends JpaRepository <Guest,Long>{
         
    
            public Guest findGuestById(long id);
            public Guest findByUserId(User user);  
            public Guest findById( long id );
            

}
