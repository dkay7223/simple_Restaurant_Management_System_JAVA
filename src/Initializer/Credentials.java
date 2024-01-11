package Initializer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.FoodonWheels;
import Model.Restaurant;

public class Credentials extends SignupGUI implements ActionListener {

	JFrame signupframe;

	private JButton signup;
	private JButton goback;

	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	private JPasswordField password;

	// static String Cname,Caddress,Cphone,Cemail,Cpassword;

	void showCredentialsform() {

		signupframe = new JFrame();
		signupframe.setLayout(null);
		signupframe.setSize(640, 720);
		signupframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel(
				"If you are registering as a restaurent, Enter the Restaurent name in Username field! ");
		label.setBounds(40, 20, 600, 34);
		signupframe.add(label);

		label = new JLabel("Username:");
		label.setBounds(180, 80, 220, 34);
		signupframe.add(label);

		name = new JTextField();
		name.setBounds(260, 80, 220, 34);
		signupframe.add(name);

		label = new JLabel("Password:");
		label.setBounds(180, 140, 220, 34);
		signupframe.add(label);

		password = new JPasswordField();
		password.setBounds(260, 140, 220, 34);
		signupframe.add(password);

		label = new JLabel("Address:");
		label.setBounds(180, 200, 220, 34);
		signupframe.add(label);

		address = new JTextField();
		address.setBounds(260, 200, 220, 34);
		signupframe.add(address);

		label = new JLabel("Email:");
		label.setBounds(180, 260, 220, 34);
		signupframe.add(label);

		email = new JTextField();
		email.setBounds(260, 260, 220, 34);
		signupframe.add(email);

		label = new JLabel("Phone No / Active Telephone :");
		label.setBounds(90, 320, 220, 34);
		signupframe.add(label);

		phone = new JTextField();
		phone.setBounds(260, 320, 220, 34);
		signupframe.add(phone);

		signup = new JButton("Sign up");
		signup.setBounds(260, 400, 120, 34);
		signupframe.add(signup);
		signup.addActionListener(this);

		goback = new JButton("Go Back");
		goback.setBounds(390, 400, 120, 34);
		signupframe.add(goback);
		goback.addActionListener(this);

		signupframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signup) {
			if (SignupGUI.choice.equals("Customer")) {
				SignupController b = new SignupController();
				b.init_Customers(name, address, phone, email, password);
			} else if (SignupGUI.choice.equals("Rider")) {
				SignupController b = new SignupController();
				b.init_Riders(name, address, phone, email, password);
			} else if (SignupGUI.choice.equals("Restaurent")) {
				SignupController b = new SignupController();
				b.init_Restaurents(name, address, phone, email, password);
			}
		} else if (e.getSource() == goback) {
			SignupGUI s = new SignupGUI();
			signupframe.dispose();
			s.showchoiceframe();
		}

	}
}
