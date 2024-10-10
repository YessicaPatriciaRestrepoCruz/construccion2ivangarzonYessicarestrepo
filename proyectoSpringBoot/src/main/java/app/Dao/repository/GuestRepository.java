package app.Dao.repository;

import app.Model.Guest;
import app.Model.Member;
import app.Model.Person;
import app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GuestRepository extends JpaRepository <Guest,Long>{
         
    
            public Guest findGuestById(long id);
            public Guest findByUserId(User user); //verificar sisi es necesario 
            public Guest findById( long id );
           
            // realizar existByUserId(User user)
            // se debe realizar para todos los metodos? o solo para claves primarias?
            


}
