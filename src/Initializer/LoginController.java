package Initializer;
import javax.swing.*;

import Model.FoodonWheels;

public class LoginController {
	
	void initLogin(JTextField userID,JPasswordField password){
		FoodonWheels FDW=new FoodonWheels();
		int ID = Integer.parseInt(userID.getText());
		String Cpassword = String.valueOf(password.getPassword());

		for(int i=0;i<FDW.getUsers().size();i++) {
			if(FDW.getUsers().get(i).getId()==ID) {
				if(FDW.getUsers().get(i).getPass().equals(Cpassword)) {
					FDW.getUsers().get(i).menu(FDW);
				}
			}
		}


		for (int i : FDW.getRestaurants().keySet()) {
			if (ID == FDW.getRestaurants().get(i).getId()) {
				if (Cpassword.equals(FDW.getRestaurants().get(i).getPass())) {
					FDW.getRestaurants().get(i).menu(FDW);
				}
			}
		}
		FoodonWheels.main(null);
	}
	
}
