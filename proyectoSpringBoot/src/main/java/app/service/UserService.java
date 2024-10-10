package app.service;

 
import app.Dto.MemberDto;
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.helpers.Helper;
import app.service.Interface.UserServiceInterface;
import appp.Dao.MemberDaoImplementation;
import appp.Dao.PersonDaoImplementation;
import appp.Dao.UserDaoImplementation;

import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Getter
@Setter
@NoArgsConstructor
@Service

public class UserService implements UserServiceInterface {
    
     @Autowired
    private final PersonService personService = new PersonService();
     
    @Autowired
    private final PersonDaoImplementation personDao = new PersonDaoImplementation();
    @Autowired
    private final UserDaoImplementation userDao = new UserDaoImplementation();
    
    @Autowired
    private final MemberDaoImplementation memberDao = new MemberDaoImplementation();
    
    

   
    

     @Override
    public void createUser() throws Exception {
        
        UserDto userDto;
        PersonDto personDto = this.personService.createPerson( );
        
        userDto = this.userDao.findByPersonId( personDto ) ;
        
        if ( userDto != null ){
            throw new Exception("El usuario para: " + personDto.getName() + " es: " + userDto.getUserName() );
        }
        
        userDto = new UserDto();
        userDto.setPersonnId( Helper.parse( personDto ) );
        
        userDto.getUserNameDto();
        userDto.getUserTypeDto();
        userDto.getUserPasswordDto();
                
        if ( this.userDao.existsByUserName( userDto ) ) {
            throw new Exception("Ya existe un usuario con ese user name");
        }
        
        try {
            this.userDao.createUser( userDto );
        } catch (SQLException e) {
            throw new Exception( e.getMessage() );
        }
        
    }

    @Override
    public UserDto getUserById(long id) throws Exception {
        
         return null;
        
    }

    @Override
    public void updateUser(UserDto userDto) throws Exception {
        
        
    }

    @Override
    public void deleteUser() throws Exception {
        
        UserDto userDto;
        PersonDto personDto = new PersonDto();
        personDto.getPersonDocumentDto();
        
        personDto = this.personDao.findByDocument( personDto );
        if ( personDto == null ){
            throw new Exception("La persona no existe" );
        }

        userDto = this.userDao.findByPersonId( personDto ) ;        
        if ( userDto == null ){
            throw new Exception("La persona no tiene usuario" );
        }
        
        MemberDto partnerDto = this.memberDao.findByUserId( userDto );
        
        if ( partnerDto != null ){
            throw new Exception("El usuario es socio" );            
        }
        
        System.out.println("Borrar usuario: " + userDto.getUserName() );
        
        this.userDao.deleteUser( userDto );        
    }
        
    

    @Override
    public UserDto createUserGuest() throws Exception {
        
        UserDto userDto;
        PersonDto personDto = this.personService.createPerson( );
        
        userDto = this.userDao.findByPersonId( personDto ) ;
        
        if ( userDto != null ){
            if ( userDto.getRole().equals( "INVITADO" ) ){
                return userDto;
            }
            else{
                return null;
            }
        }
        
        userDto = new UserDto();
        userDto.setPersonnId( Helper.parse( personDto ) );
        
        userDto.getUserNameDto();
        userDto.setRole( "INVITADO" );
        userDto.getUserPasswordDto();
                
        if ( this.userDao.existsByUserName( userDto ) ) {
            throw new Exception("Ya existe un usuario con ese user name");
        }
        
        try {
            this.userDao.createUser( userDto );
        } catch (SQLException e) {
            throw new Exception( e.getMessage() );
        }
        
        userDto = this.userDao.findByUserName( userDto ) ;
        return userDto;
    }
   
    
}