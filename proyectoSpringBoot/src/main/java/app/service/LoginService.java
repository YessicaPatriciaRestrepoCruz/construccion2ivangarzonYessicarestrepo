
package app.service;

import app.Dto.UserDto;
import app.service.Interface.LoginServiceInterface;
import appp.Dao.UserDaoImplementation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service

public class LoginService implements LoginServiceInterface{
    UserDaoImplementation userDao = new UserDaoImplementation();
    @Autowired 

    public UserDto user;
    @Override
	public void login(UserDto userDto) throws Exception {
		 long id = userDto.getId(); // Obténer el ID del userDto
        
        UserDto validateDto = this.userDao.findUserByUserName(userDto);
                
		if (validateDto == null) {
			throw new Exception("no existe usuario registrado");
		}
		if (!userDto.getPassword().equals(validateDto.getPassword())) {
			throw new Exception("usuario o contraseña incorrecto");
		}
		userDto.setRole(validateDto.getRole());
		user = validateDto;
	}
        
        @Override
	public void logout() {
		user = null;
		System.out.println("se ha cerrado sesion");
	}
    
}
