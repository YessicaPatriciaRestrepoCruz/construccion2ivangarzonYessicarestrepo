package app.service;


import app.Dto.GuestDto;
import app.Dto.MemberDto;
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.helpers.Helper;
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
    private final MemberDaoImplementation memberDao = new MemberDaoImplementation();
    
    @Override
    public void addGuest() throws Exception {
       
        UserDto userDtoLocate = this.userService.createUserGuest();

        if ( userDtoLocate == null ) {
            throw new Exception("No se encontró ningún usuario");            
        }

        PersonDto personDto = new PersonDto();
        personDto.getPersonDocumentDto( "Ingrese el documento del socio que invita" );
        personDto = this.personDao.findByDocument(personDto);
        if ( personDto == null ) {
            throw new Exception("No se encontró ningúna persona con el numero de identificación");            
        }
        
        UserDto userDtoInvite = this.userDao.findByPersonId( personDto );
        MemberDto partnerDto = this.memberDao.findByUserId( userDtoInvite );
        if ( partnerDto == null ) {
            throw new Exception( personDto.getName() + " no es socio del club");            
        }
                
        GuestDto guestDto = new GuestDto();
        guestDto.setUserId( Helper.parse( userDtoLocate ) );
        guestDto.setMemberId(Helper.parse(partnerDto));
        guestDto.setStatus("ACTIVO" );
        
        this.guestDao.createGuest( guestDto );
    }   
    
    @Override
    public void deleteGuest() throws Exception {
        
        
        PersonDto personDtoLocale = new PersonDto();
        personDtoLocale.getDocument();
        personDtoLocale = this.personDao.findByDocument( personDtoLocale );
        
        if ( personDtoLocale == null ){
            throw new Exception("No existe la persona");
        }
        
        
        UserDto userDtoLocate = this.userDao.findByPersonId( personDtoLocale );
        if ( userDtoLocate == null ) {
            throw new Exception("No se encontró ningún usuario con el número de identificación ");            
        }

        GuestDto guestDto = this.guestDao.findByUserId( userDtoLocate );
        
        if ( guestDto == null ){
            throw new Exception("No existe el invitado");                            
        }
        
        this.guestDao.deleteGuest( guestDto );
    }    
    

    
    
    
    
    
    
    

    @Override
    public void updateGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GuestDto getGuestById(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GuestDto> getAllGuests() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
    
}
