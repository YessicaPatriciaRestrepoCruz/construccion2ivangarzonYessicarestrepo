package appp.Dao;

import app.Dao.Interfaces.GuestDao;
import app.Dao.repository.GuestRepository;
import app.Dto.GuestDto;
import app.Dto.UserDto;
import app.Model.Guest;
import app.helpers.Helper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class GuestDaoImplementation implements GuestDao {
    
    @Autowired 
    
        GuestRepository guestRepository;
        
          @Override
        public void createGuest(GuestDto guestDto) throws Exception {
        Guest guest = Helper.parse(guestDto);
        guestRepository.save(guest);
    }//revisar

    @Override
    public GuestDto findGuestById(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GuestDto findByUserId(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
       
    } 



    

