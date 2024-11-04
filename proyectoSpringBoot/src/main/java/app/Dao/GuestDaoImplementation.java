package app.Dao;

import app.Dao.Interfaces.GuestDao;
import app.Dao.repository.GuestRepository;
import app.Dto.GuestDto;
import app.Dto.UserDto;
import app.Model.Guest;
import app.helpers.Helper;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
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
    public GuestDto findGuestById(Long id) throws Exception {
       return guestRepository.findById(id)
                .map(Helper::parse)
                .orElseThrow(() -> new Exception("Invitado no encontrado con ID: " + id));
    }

    @Override
    public void updateGuest(GuestDto guestDto) throws Exception {
        Guest guest = Helper.parse(guestDto);
        guestRepository.save(guest);
    }

    @Override
    public void deleteGuest( long id) throws Exception {// se cambio GuestDto guesDto
         guestRepository.deleteById(id); 
    }

    @Override
    public GuestDto findByUserId(UserDto userDto) throws Exception {
        
        Guest guest = guestRepository.findByUserId(Helper.parse(userDto));
    if (guest == null) {
        throw new Exception("Invitado no encontrado para el usuario con ID: " + userDto.getId());
    }
    return Helper.parse(guest);
    }

    
    @Override
    public List<GuestDto> getAllGuest() {
        
        List<Guest> guests = guestRepository.findAll();
        return Helper.parseGuests(guests); 
        
    }
    
    @Override
    public GuestDto getGuestById(long id) throws Exception {
         return findGuestById(id);  
    }
        
       
    } 



    

