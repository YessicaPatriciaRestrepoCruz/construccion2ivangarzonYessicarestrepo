package app.service.Interface;

import app.Dto.UserDto;


public interface UserServiceInterface {
   
    public void createUser(UserDto userDto) throws Exception;
    public UserDto getUserById(long id) throws Exception;
    public void updateUser(UserDto userDto) throws Exception;
    public void deleteUser(long id) throws Exception;
}
