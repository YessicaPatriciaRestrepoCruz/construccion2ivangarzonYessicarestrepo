package app.service;

 
import app.Controller.Validator.UserValidator;
import app.Dao.Interfaces.UserDao;
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
    private UserDao userDao;
       
       @Autowired
    private UserValidator userValidator;
    
     @Autowired
    private final PersonService personService = new PersonService();
     
    @Autowired
    private final PersonDaoImplementation personDao = new PersonDaoImplementation();
    @Autowired
  
    
    private final MemberDaoImplementation memberDao = new MemberDaoImplementation();

    @Override
    public void createUser(UserDto userDto) throws Exception {
        
        userValidator.validateUserName(userDto.getUserName());
        userValidator.validatePassword(userDto.getPassword());
        userValidator.validateRole(userDto.getRole());
        userDao.createUser(userDto);
    }

    @Override
    public void updateUser(UserDto userDto) throws Exception {
        
        userValidator.validateUserName(userDto.getUserName());
        userValidator.validatePassword(userDto.getPassword());
        userValidator.validateRole(userDto.getRole());
        userDao.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
         userDao.deleteUser(id);
    }

    @Override
    public UserDto getUserById(Long id) throws Exception {
        return userDao.findUserById(id);

    }
    
    

   
    
}