package Initializer;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.FoodonWheels;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*Made By
 * Muhammad Usman 20i-2602
 * Daniyal Khan 20i-1847
 * Will submitting the full GUI before Saturday Inshallah*/
@SuppressWarnings("serial")
public class LoginGUI extends JFrame implements ActionListener {

	JFrame Loginframe;
	private JTextField username;
	private JPasswordField password;
	private JButton loginbutton;
	private JButton goback;

	public LoginGUI() {

	}

	void showlogingui() {
		Loginframe = new JFrame("FoodOnWheels");
		Loginframe.setSize(720, 640);
		Loginframe.setLayout(null);
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("User ID:");
		label.setBounds(180, 80, 220, 34);
		Loginframe.add(label);

		username = new JTextField();
		username.setBounds(260, 80, 220, 34);
		Loginframe.add(username);

		label = new JLabel("Password:");
		label.setBounds(180, 140, 220, 34);
		Loginframe.add(label);

		password = new JPasswordField();
		password.setBounds(260, 140, 220, 34);
		Loginframe.add(password);

		loginbutton = new JButton("Login");
		loginbutton.setBounds(300, 200, 120, 34);
		Loginframe.add(loginbutton);
		loginbutton.addActionListener(this);

		goback = new JButton("Go back");
		goback.setBounds(300, 250, 120, 34);
		Loginframe.add(goback);
		goback.addActionListener(this);

		Loginframe.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginbutton) {
			LoginController l=new LoginController();
				l.initLogin(username, password);
				Loginframe.dispose();
				FoodonWheels.main(null);
		} 
		else if (e.getSource() == goback) {
			FDWGUI d = new FDWGUI();
			d.showbasic();
			Loginframe.dispose();
		}
	}

}
