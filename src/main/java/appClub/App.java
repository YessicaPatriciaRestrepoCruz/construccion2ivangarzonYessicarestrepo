
package appClub;

import app.Controller.ControllerInterface;
import app.Controller.LoginController;

public class App {
    
    	public static void main(String[] args) throws Exception {
		ControllerInterface controller = new LoginController();
		try {
			controller.session();
			//MYSQLConnection.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        }
}