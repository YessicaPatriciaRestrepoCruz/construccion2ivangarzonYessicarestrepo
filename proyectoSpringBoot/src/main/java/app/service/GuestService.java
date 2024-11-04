package app.service;


import app.Controller.Validator.GuestValidator;
import app.Dto.GuestDto;
import app.service.Interface.GuestServiceInterface;
import app.Dao.GuestDaoImplementation;
import app.Dao.InvoiceDaoImplementation;
import app.Dao.MemberDaoImplementation;
import app.Dao.PersonDaoImplementation;
import app.Dao.UserDaoImplementation;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Getter
@Setter
@NoArgsConstructor
@Service

public class GuestService implements GuestServiceInterface {

    @Autowired
     private UserDaoImplementation userDao;
    
     @Autowired
     private InvoiceDaoImplementation invoiceDao;
     
    @Autowired
     private PersonDaoImplementation personDao;
    
    @Autowired
    private GuestDaoImplementation guestDao;
    
    @Autowired
    private UserService userService;
    
     @Autowired
    private GuestValidator guestValidator;
    
    @Autowired
     private MemberDaoImplementation memberDao;
    
    
       
         @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        
        if (guestDto == null) {
            throw new IllegalArgumentException("GuestDto no puede ser nulo");
        }
        
        guestValidator.validateUser(guestDto.getUserId());
        guestValidator.validateMember(guestDto.getMemberId());
        guestValidator.validateStatus(guestDto.getStatus());
        guestDao.createGuest(guestDto);
    }
       
    
    @Override
    public void deleteGuest(long id) throws Exception {
        
      guestDao.deleteGuest(id);
    }    
    
    @Override
    public void updateGuest(GuestDto guestDto) throws Exception {
        
        if (guestDto == null) {
            throw new IllegalArgumentException("GuestDto no puede ser nulo");
        }
        guestValidator.validateUser(guestDto.getUserId());
        guestValidator.validateMember(guestDto.getMemberId());
        guestValidator.validateStatus(guestDto.getStatus());
        guestDao.updateGuest(guestDto);
    }
   

    @Override
    public GuestDto getGuestById(long id) throws Exception {
        
        GuestDto guest = guestDao.getGuestById(id);
    if (guest == null) {
        throw new Exception("Invitado no encontrado con ID: " + id);
    }
    return guest;
    }

    @Override
    public List<GuestDto> getAllGuests() throws Exception {
          return guestDao.getAllGuest();
    }

   
    
    
    
}
