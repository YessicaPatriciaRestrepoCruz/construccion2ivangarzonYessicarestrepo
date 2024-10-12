package app;


import app.Controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.controller;

@SpringBootApplication
public class AppApplication implements CommandLineRunner  {
    
    @Autowired
    LoginController controller;

	public static void main(String[] args) throws Exception {
		/*ControllerInterface controller = new LoginController();
		try {
			controller.session();
		MYSQLConnection.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
                SpringApplication.run(AppApplication.class,args);
        }

    @Override
    public  void run(String... args) throws Exception {
        try {
            controller.session();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }

}
