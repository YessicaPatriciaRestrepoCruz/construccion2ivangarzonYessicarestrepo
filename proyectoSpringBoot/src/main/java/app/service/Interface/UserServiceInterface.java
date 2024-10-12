package app.service.Interface;

import app.Dto.UserDto;


public interface UserServiceInterface {
   
    public void createUser(UserDto userDto) throws Exception;
    public void updateUser(UserDto userDto) throws Exception;
    public void deleteUser(Long id) throws Exception;
    public UserDto getUserById(Long id) throws Exception;
}
