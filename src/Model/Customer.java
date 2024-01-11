package Model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
//***********child class of user*********
public class Customer extends User {

	
	//***********array list to store current order*********
	ArrayList<CartItems> placeorder = new ArrayList<CartItems>();

	//**********constructor*******************************
	public Customer(String Name, String Address, String phone, String email) {
		super(Name, Address, phone, email);
		setCart(new HashMap<Integer, CartItems>());
		setOrder(new HashMap<Integer, Orders>());
		super.setType(Usertype.CUSTOMER);

	}

	//******************overriding abstract method of menu********
	public void menu (FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1. View Food details\n" + " 2. place order\n" + " 3. Cancel Order\n" + " 4. Update Cart\n"
				+ " 5. Check Food delivery status\n" + " 6. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {

		case 1: {
			viewFood(FDW);
			menu(FDW);
			break;
		}
		case 2: {
			placeOrder(FDW);
			menu(FDW);
			break;
		}
		case 3: {
			cancelOrder(FDW);
			menu(FDW);
			break;
		}
		case 4: {
			updateCart();
			menu(FDW);
			break;
		}

		case 5: {
			viewOrders();
			menu(FDW);
			break;
		}
		case 6: {
			break;
		}
		}
	}
	
	
	

	//  view cart
	void viewCart() {
		System.out.println("\n-------------------------Your Cart---------------------");
		int k = 1;
		for (int i : this.getCart().keySet()) {
			System.out.println(k + " ID : " + this.getCart().get(i).getCartItem_id() + "     Food Item : "
					+ this.getCart().get(i).getFood_item().getName() + "  Price : "
					+ this.getCart().get(i).getFood_item().getPrice());
			k++;
		}
	}

	
	
	// view orders
	void viewOrders() {
		System.out.println("\n\n**********************Your Orders*******************");
		int k = 1;
		for (int i : this.getOrder().keySet()) {
			System.out.println("*************ORDER ID " + i + " ***************");
			for (int j = 0; j < this.getOrder().get(i).getCartitem().size(); j++) {
				System.out.println("Order ID : " + k + ". Food Item : "
						+ this.getOrder().get(i).getCartitem().get(j).getFood_item().getName() + "  Price : "
						+ this.getOrder().get(i).getCartitem().get(j).getFood_item().getPrice() + "    Status : "
						+ this.getOrder().get(i).isStatus());
				k++;
			}
		}
	}
	
	
	
	
	//view food details
	void viewFood(FoodonWheels FDW) {
		int k = 1;
		for (int i : FDW.getRestaurants().keySet()) {
			System.out.println(k + ". " + FDW.getRestaurants().get(i).getName() + "       Restaurant ID : "
					+ FDW.getRestaurants().get(i).getId());
			k++;
		}
		try {
			System.out.println("\nChoose Restaurant by Entering ID : ");
			Scanner input = new Scanner(System.in);
			int id = input.nextInt();
			FDW.getRestaurants().get(id).menue();
			System.out.println("Select Food Item by Menu ID to Add to Cart : ");
			int menu_id = input.nextInt();
			FDW.getRestaurants().get(id).getMenue().get(menu_id);
			System.out.println("Enter the Quantity of Item");
			int quantity = input.nextInt();
			CartItems CI = new CartItems(FDW.getRestaurants().get(id).getId(), this.getName(), this.getId(),
					this.getAddress(), quantity, FDW.getRestaurants().get(id).getMenue().get(menu_id));
			this.getCart().put(CI.getCartItem_id(), CI);
			System.out.println("\nAdd more Items to Cart : \n1. Yes\n2. No");
			id = input.nextInt();
			if (id == 1) {
				viewFood(FDW);
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	
	
	
	// place order
	void placeOrder(FoodonWheels FDW) {
		viewCart();
		try {
			System.out.println("Choose Food Item by Entering ID : ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			this.placeorder.add(this.getCart().get(choice));
			System.out.println("\nAdd more Food Items to Your Order\n1. Yes\n2. No");
			int l = input.nextInt();

			while (l == 1) {
				System.out.println("Choose Food Item by Entering ID : ");
				int prev_res = choice;
				choice = input.nextInt();
				if (this.getCart().get(choice).getRestaurantId() != prev_res) {
					System.out.println("\nCOMPLETE YOUR CURRENT ORDER FROM THE SAME RESTAURANT.\n");
					choice = prev_res;
				} else {
					this.placeorder.add(this.getCart().get(choice));
				}
				System.out.println("\nAdd more Food Items to Your Order\n1. Yes\n2. No");
				l = input.nextInt();
			}

			System.out.println("\n**********************CheckOut********************");
			for (int i = 0; i < this.placeorder.size(); i++) {
				System.out.println("----------------------------------------------");
				System.out.println("Name : " + this.placeorder.get(i).getFood_item().getName());
				System.out.println("Description : " + this.placeorder.get(i).getFood_item().getDescription());
				System.out.println("Qunatity : " + this.placeorder.get(i).getQuantity());
				System.out.println("Price per Item: " + this.placeorder.get(i).getFood_item().getPrice());
				System.out.println("---------------------------------------------------\n");
			}

			System.out.println(
					"\nSelect Your Payment Method\n1. Cash On Deliery\n2. Online Payment\n Enter your Choice ");
			int choice_1 = input.nextInt();
			switch (choice_1) {
			case 1: {

				Invoice bill = new Invoice(this.placeorder);
				bill.genInvoice();
				Orders O = new Orders(this.getId(), this.getCart().get(choice).getRestaurantId(), this.placeorder,
						bill);
				this.getOrder().put(O.getOrder_id(), O);
				for (int j : FDW.getRestaurants().keySet()) {
					for (int k : FDW.getRestaurants().get(j).getMenue().keySet()) {
						if (FDW.getRestaurants().get(j).getMenue().get(k)
								.equals(this.getCart().get(choice).getFood_item())) {
							FDW.getRestaurants().get(j).getOrder().put(O.getOrder_id(), O);
						}
					}
				}

				this.getCart().remove(choice);
				System.out.println("\nYour Order has Been Placed\nPay for your Order once you recieve your Order\n\n");
				break;
			}
			case 2: {
				System.out.println("\nCONGRATULATIONS YOUR PAYMENT HAS BEEN SUCCESSFUL\n");
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
		placeorder = new ArrayList<CartItems>();
	}

	
	
	
	// update cart
	void updateCart() {
		viewCart();
		try {
			System.out.println("\n1.Remove Item from Cart\n2.Change Qunatity\n");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the ID of the item you want to Remove : ");
				choice = input.nextInt();
				this.getCart().remove(choice);
				System.out.println("\nItem Removed Successfully.");
				break;
			}
			case 2: {
				System.out.println("Enter the ID of the item you want to Change Quantity of : ");
				choice = input.nextInt();
				System.out.println(
						"Enter the new Quantity of " + this.getCart().get(choice).getFood_item().getName() + " : ");
				int quantity = input.nextInt();
				this.getCart().get(choice).setQuantity(quantity);
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	
	//  cancel order
	void cancelOrder(FoodonWheels FDW) {
		viewOrders();
		try {
			System.out.println("\nEnter the ID of the Order you want to Cancel : ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			if (this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.DRAFT)
					|| this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.REALIZED)
					|| this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.CANCELED)) {
				FDW.getRestaurants().get(this.getOrder().get(choice).getRestaurant_id()).getOrder().get(choice)
						.setStatus(Orders.Order_Status.CANCELED);
				this.getOrder().remove(choice);
				System.out.println("Your Order has been Cancelled Successfully.");
				System.out.println("\n\n");
			}

			else {
				System.out.println("Sorry You Cannot Cancel Your Order Now, It has Already been Dispatched.");
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

}
