
package app.service.Interface;

import app.Dto.UserDto;

public interface LoginServiceInterface {
	public void login(UserDto userDto) throws Exception;
	public void logout();
}
