package app;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner  {

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
        System.out.println("vive");    }

}
