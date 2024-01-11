package Initializer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignupGUI implements ActionListener  {
	JFrame choiceframe;

	private JButton customer;
	private JButton restaurent;
	private JButton rider;
	private JButton goback;
	static String choice;
	
	void showchoiceframe() {
		choiceframe = new JFrame("SignUp");
		choiceframe.setSize(720, 640);
		choiceframe.setLayout(null);
		choiceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		customer = new JButton("As a Customer");
		customer.setBounds(220, 80, 220, 40);
		customer.addActionListener(this);
		
		restaurent = new JButton("As a restuarent");
		restaurent.setBounds(220, 130, 220, 40);
		restaurent.addActionListener(this);
		
		rider = new JButton("As a Rider");
		rider.setBounds(220, 180, 220, 40);
		rider.addActionListener(this);
		
		goback = new JButton("Go back");
		goback.setBounds(220, 230, 220, 40);
		goback.addActionListener(this);
		
		choiceframe.add(customer);
		choiceframe.add(restaurent);
		choiceframe.add(rider);
		choiceframe.add(goback);
		
		choiceframe.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==customer) {
			SignupGUI.choice="Customer";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==restaurent) {
			SignupGUI.choice="Restaurent";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==rider) {
			SignupGUI.choice="Rider";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==goback) {
			FDWGUI d = new FDWGUI();
			choiceframe.dispose();
			d.showbasic();
		}
	}
	
	
	
	
	
}
