package app.service;


import app.Controller.Validator.GuestValidator;
import app.Dto.GuestDto;
import app.service.Interface.GuestServiceInterface;
import appp.Dao.GuestDaoImplementation;
import appp.Dao.InvoiceDaoImplementation;
import appp.Dao.MemberDaoImplementation;
import appp.Dao.PersonDaoImplementation;
import appp.Dao.UserDaoImplementation;
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
    private final UserDaoImplementation userDao = new UserDaoImplementation();
    
     @Autowired
    private final InvoiceDaoImplementation invoiceDao = new InvoiceDaoImplementation();
     
    @Autowired
    private final PersonDaoImplementation personDao = new PersonDaoImplementation();
    
    @Autowired
    private final GuestDaoImplementation guestDao = new GuestDaoImplementation();
    
    @Autowired
    private final UserService userService = new UserService();
    
     @Autowired
    private GuestValidator guestValidator;
    
    @Autowired
    private final MemberDaoImplementation memberDao = new MemberDaoImplementation();
    
    
       
         @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        
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
        guestValidator.validateUser(guestDto.getUserId());
        guestValidator.validateMember(guestDto.getMemberId());
        guestValidator.validateStatus(guestDto.getStatus());
        guestDao.updateGuest(guestDto);
    }
   

    @Override
    public GuestDto getGuestById(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GuestDto> getAllGuests() throws Exception {
          return guestDao.getAllGuest();
    }

   
    
    
    
}
