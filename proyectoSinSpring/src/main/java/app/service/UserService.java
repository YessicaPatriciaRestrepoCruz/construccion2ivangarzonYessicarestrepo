package app.service;

import app.Dao.Interfaces.UserDao;
import app.Dao.Interfaces.PersonDao;  
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.service.Interface.UserServiceInterface;

import java.sql.SQLException;

public class UserService implements UserServiceInterface {

    private UserDao userDao;
    private PersonDao personDao; 

  
    public UserService() {
        this.userDao = userDao;
        this.personDao = personDao;
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
        
        PersonDto personDto = personDao.findPersonById(userDto.getPerson().getId());
        if (personDto == null) {
            throw new Exception("Persona no encontrada.");
        }

        try {
            
            userDao.createUser(userDto);
        } catch (SQLException e) {
            
            throw new Exception("Error al crear el usuario.", e);
        }
    }

    @Override
    public UserDto getUserById(long id) throws Exception {
        UserDto user = userDao.findUserById(id);
        if (user == null) {
            throw new Exception("Usuario no encontrado.");
        }
        return user;
    }

    @Override
    public void updateUser(UserDto userDto) throws Exception {
        
        UserDto existingUser = userDao.findUserById(userDto.getId());
        if (existingUser == null) {
            throw new Exception("Usuario no encontrado.");
        }

        try {
            
            userDao.updateUser(userDto);
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el usuario.", e);
        }
    }

    @Override
    public void deleteUser(long id) throws Exception {
        
        UserDto user = userDao.findUserById(id);
        if (user == null) {
            throw new Exception("Usuario no encontrado.");
        }

        try {
           
            userDao.deleteUser(id);
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el usuario.", e);
        }
    }
    
}