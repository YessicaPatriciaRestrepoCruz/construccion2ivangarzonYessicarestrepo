package app.Controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@Setter
@Getter
@NoArgsConstructor

@RestController
@RequestMapping("/api/admin")
public class AdminController implements ControllerInterface {
    
     @Autowired
    private PersonController personController;
    
    @Autowired
    private UserController userController;
    
    @Autowired
    private MemberController memberController;
    
    @Autowired
    private GuestController guestController;
    
    @Autowired
    private GuestController invoiceController;
    
    
   
     @GetMapping("/")
    public String welcome() {
        return "Bienvenido al Sistema de Gestión del Club.";
    }

    @Override
    public void session() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

   


   
    
    
    
    

    
    

    

    
    