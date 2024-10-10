package app.service.Interface;

import app.Dto.UserDto;


public interface UserServiceInterface {
   
    public void createUser() throws Exception;
    public UserDto getUserById(long id) throws Exception;
    public void updateUser(UserDto userDto) throws Exception;
    public void deleteUser() throws Exception;
    public UserDto createUserGuest( ) throws Exception;
}
