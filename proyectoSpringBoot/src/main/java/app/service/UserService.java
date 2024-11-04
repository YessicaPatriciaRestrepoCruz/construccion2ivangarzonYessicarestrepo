package app.service;

 
import app.Controller.Validator.UserValidator;
import app.Dao.Interfaces.UserDao;
import app.Dto.UserDto;

import app.service.Interface.UserServiceInterface;
import app.Dao.MemberDaoImplementation;
import app.Dao.PersonDaoImplementation;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    private PersonService personService;;
     
    @Autowired
    private PersonDaoImplementation personDao;
    @Autowired
     private MemberDaoImplementation memberDao;

    @Override
    public void createUser(UserDto userDto) throws Exception {
        
         if (userDto == null) {
            throw new IllegalArgumentException("UserDto no puede ser nulo");
        }
        
        userValidator.validateUserName(userDto.getUserName());
        userValidator.validatePassword(userDto.getPassword());
        userValidator.validateRole(userDto.getRole());
        userDao.createUser(userDto);
    }

    @Override
    public void updateUser(UserDto userDto) throws Exception {
        
        if (userDto == null) {
            throw new IllegalArgumentException("UserDto no puede ser nulo");
        }
        
        userValidator.validateUserName(userDto.getUserName());
        userValidator.validatePassword(userDto.getPassword());
        userValidator.validateRole(userDto.getRole());
        userDao.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        
        if (id == null) {
            throw new IllegalArgumentException("ID no puede ser nulo");
        }
         userDao.deleteUser(id);
    }

    @Override
    public UserDto getUserById(Long id) throws Exception {
        return userDao.findUserById(id);

    }

    @Override
    public List<UserDto> getAllUsers() {
        
        try {
        return userDao.findAllUsers(); 
    } catch (DataAccessException e) {
        throw new RuntimeException("Error al obtener la lista de usuarios: " + e.getMessage(), e);
    } catch (Exception e) {
        throw new RuntimeException("Error inesperado: " + e.getMessage(), e);
    }
        
       
    }
    
    

   
    
}