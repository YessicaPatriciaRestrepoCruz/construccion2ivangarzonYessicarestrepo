package app.Dao;


import app.Dao.Interfaces.UserDao;
import app.Dao.repository.UserRepository;
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.Model.Person;

import app.helpers.Helper;
import app.Model.User;
import java.sql.SQLException;
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

public class UserDaoImplementation implements UserDao {
    @Autowired
    UserRepository userRepository;

	@Override
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        userRepository.save(user);
    }
    @Override
    public UserDto findUserByUserName(UserDto userDto) throws Exception {
        
       User user  = userRepository.findUserByUsername(userDto.getUserName());
       return Helper.parse(user);
    }
    
    @Override
    public void updateUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto) ;//verificar helper
        userRepository.save(user);
    }

    @Override
    public void deleteUser( Long id) throws Exception {
        
        userRepository.deleteById(id);
        
    }

   @Override
public UserDto findUserById(long id) throws Exception {

    User user = userRepository.findUserById(id);
    return Helper.parse(user);
    
}
 
    @Override
    public UserDto findByPersonId( PersonDto personDto ) throws Exception {
        Person person = Helper.parse( personDto );
        User user = this.userRepository.findByPersonId( person );
        return Helper.parse( user );

    }

    public boolean existsByUserName(UserDto userDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UserDto findByUserName(UserDto userDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll(); // Usa el método findAll del repositorio
    return users.stream()
                 .map(Helper::parse)
                 .toList();
}
   

  

    
}





