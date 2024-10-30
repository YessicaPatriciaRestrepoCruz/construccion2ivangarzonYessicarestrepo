package app;


import app.Controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.controller;

@SpringBootApplication
public class AppApplication  {
    

	public static void main(String[] args) throws Exception {
		
                SpringApplication.run(AppApplication.class,args);
        }

}
