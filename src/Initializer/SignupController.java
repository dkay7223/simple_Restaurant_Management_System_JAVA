package Initializer;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Model.Customer;
import Model.FoodonWheels;
import Model.Restaurant;
import Model.Rider;
import Model.User;

public class SignupController {

	protected void init_Restaurents(JTextField name, JTextField address, JTextField phone, JTextField email,
			JPasswordField password) {
		FoodonWheels FDW = new FoodonWheels();
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());
		Restaurant res = new Restaurant(Cname, Caddress, Cphone, Cemail);
		res.setPass(Cpassword);
		res.profile();
		FDW.getRestaurants().put(res.getId(), res);
	}

	protected void init_Customers(JTextField name, JTextField address, JTextField phone, JTextField email,
			JPasswordField password) {
		FoodonWheels FDW = new FoodonWheels();
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());

		User customer = new Customer(Cname, Caddress, Cphone, Cemail);
		customer.setPass(Cpassword);
		customer.profile();
		FDW.getUsers().add(customer);
		FDW.getCustomers().put(customer.getId(), customer);
	}

	protected void init_Riders(JTextField name, JTextField address, JTextField phone, JTextField email, JPasswordField password) {
		FoodonWheels FDW = new FoodonWheels();
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());

		User rider = new Rider(Cname, Caddress, Cphone, Cemail);
		rider.setPass(Cpassword);
		rider.profile();
		FDW.getUsers().add(rider);
		FDW.getRiders().put(rider.getId(), rider);
	}

}
