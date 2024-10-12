
package app.Dao.Interfaces;

import app.Dto.PersonDto;
import app.Dto.UserDto;

public interface UserDao {
    
   public void createUser(UserDto userDto) throws Exception;
   public void updateUser(UserDto userDto) throws Exception;
 
   public UserDto findUserByUserName(UserDto useDto) throws Exception;
   public UserDto findUserById ( long id)throws Exception;
 public void deleteUser(Long id) throws Exception;
   public UserDto findByPersonId( PersonDto personDto ) throws Exception;
   
}
