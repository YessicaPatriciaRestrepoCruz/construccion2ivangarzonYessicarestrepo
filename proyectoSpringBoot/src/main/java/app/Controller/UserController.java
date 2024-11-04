package app.Controller;

import app.Controller.Request.CreateUserRequest;
import app.Dto.UserDto;
import app.service.Interface.UserServiceInterface;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@Setter
@Getter
@NoArgsConstructor


public class UserController {    

 @Autowired
    private UserServiceInterface userService;
 
 @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        UserDto userDto = new UserDto();
        try {
            userDto.setId(request.getId());
            userDto.setUserName(request.getUsername());
            userDto.setPassword(request.getPassword());
            userDto.setRole(request.getRole());

            userService.createUser(userDto);
            return new ResponseEntity<>("Usuario creado exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody CreateUserRequest request) {
        UserDto userDto = new UserDto();
        try {
            userDto.setId(id); 
            userDto.setUserName(request.getUsername());
            userDto.setPassword(request.getPassword());
            userDto.setRole(request.getRole());

            userService.updateUser(userDto);
            return new ResponseEntity<>("Usuario actualizado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Usuario borrado exitosamente.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listUsers() {
         try {
        List<UserDto> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(users, HttpStatus.OK); 
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
  
   
}