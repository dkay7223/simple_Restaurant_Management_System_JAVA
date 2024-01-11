package Model;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {

	private String Name;
	private String Address;
	private String phone;
	private String email;
	private int id;
	private String pass;
	private HashMap<Integer, Orders> order;
	private HashMap<Integer, FoodItems> menue;
	private HashMap<Integer, Invoice> payments;

	Random rand = new Random();

	public HashMap<Integer, FoodItems> getMenue() {
		return menue;
	}

	public void setMenue(HashMap<Integer, FoodItems> menue) {
		this.menue = menue;
	}

	public HashMap<Integer, Orders> getOrder() {
		return order;
	}

	public void setOrder(HashMap<Integer, Orders> order) {
		this.order = order;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public HashMap<Integer, Invoice> getPayments() {
		return payments;
	}

	public void setPayments(HashMap<Integer, Invoice> payments) {
		this.payments = payments;
	}

	public Restaurant(String Name, String Address, String phone, String email) {
		this.Name = Name;
		this.Address = Address;
		this.phone = phone;
		this.email = email;
		this.id = rand.nextInt(1000);
		setMenue(new HashMap<Integer, FoodItems>());
		setOrder(new HashMap<Integer, Orders>());
		setPayments(new HashMap<Integer, Invoice>());

	}

	public void profile() {
		System.out.println("\n**********RESTAURANT PROFILE***********");
		System.out.println("Name : " + this.getName());
		System.out.println("Email : " + this.getEmail());
		System.out.println("ID : " + this.getId());
		System.out.println("Address : " + this.getAddress());
		System.out.println("Phone : " + this.getPhone());
		System.out.println("***************************************");

	}

	public void menu(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Our Menu\n" + "2. Add Food details\n" + "3. Update Food details\n" + "4. Delete Food\n"
				+ "5. Check food order\n" + "6. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {
		case 1: {
			menue();
			menu(FDW);
			break;
		}

		case 2: {
			addFood();
			menu(FDW);
			break;
		}
		case 3: {
			updateFood();
			menu(FDW);
			break;
		}
		case 4: {
			deleteFood();
			menu(FDW);
			break;
		}
		case 5: {
			checkOrder(FDW);
			menu(FDW);
			break;
		}

		case 6: {
			break;
		}
		}
	}

	public void menue() {
		if (this.menue.size() > 0) {
			System.out.println("\n\n*************MENU**************");
			int k = 1;
			for (int i : this.getMenue().keySet()) {
				System.out.println(k + ".   Food ID : " + this.getMenue().get(i).getFoodid() + "    Food Item : "
						+ this.getMenue().get(i).getName() + "      Description : "
						+ this.getMenue().get(i).getDescription() + "        Price : "
						+ this.getMenue().get(i).getPrice());
				k++;
			}
			System.out.println("\n\n");
		} else {
			System.out.println("\nNo Menu Available.\n");
		}
	}

	void addFood() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("\n\nEnter Food Name ");
			String food = input.next();
			input.nextLine();
			System.out.println("Enter the Description of Food");
			String description = input.nextLine();
			System.out.println("Enter the Price ");
			double price = input.nextDouble();
			FoodItems F = new FoodItems(food, description, price);
			F.setRes_id(this.getId());
			this.getMenue().put(F.getFoodid(), F);
			System.out.println("\nPress 1 to enter more food items\nPress 2 to Stop Entering Food Items");
			int choice = input.nextInt();
			if (choice == 1) {
				addFood();
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void updateFood() {

		menue();
		try {
			System.out.println("***********************************");
			Scanner input = new Scanner(System.in);
			System.out.println("\nEnter Food ID you want to Update : ");
			int id = input.nextInt();

			for (int i : this.getMenue().keySet()) {
				if (id == this.getMenue().get(i).getFoodid()) {

					System.out.println(
							"Which Field Do you want to Update ?\n1. Name\n2. Description\n3. Price\n  Enter your choice : ");
					int choice = input.nextInt();
					switch (choice) {
					case 1: {
						System.out.println("Enter Food Name ");
						String food = input.next();

						this.getMenue().get(i).setName(food);

						break;
					}
					case 2: {
						input.nextLine();
						System.out.println("Enter the Description of Food");
						String description = input.nextLine();

						this.getMenue().get(i).setDescription(description);

						break;
					}
					case 3: {
						System.out.println("Enter the Price ");
						double price = input.nextDouble();

						this.getMenue().get(i).setPrice(price);
						break;
					}
					}

				}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void deleteFood() throws InputMismatchException {
		Scanner input = new Scanner(System.in);

		menue();
		try {
			System.out.println("Enter Food ID you want to Delete : ");
			int id = input.nextInt();
			for (int i : this.getMenue().keySet()) {
				if (id == this.getMenue().get(i).getFoodid()) {
					System.out.println("Are you Sure you want to delete this food item ?\n1. Yes\n2. No");
					int choice = input.nextInt();
					if (choice == 1) {
						this.getMenue().remove(i);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void checkOrder(FoodonWheels FDW) {

		if (this.getOrder().size() > 0) {
			Scanner input = new Scanner(System.in);
			System.out.println("----------------------YOUR ORDERS---------------------------");
			for (int i : this.getOrder().keySet()) {
				if (this.getOrder().get(i).isStatus().equals(Orders.Order_Status.DRAFT))
					System.out.println("--------------ORDER ID : " + i + " -------------------");
				for (int j = 0; j < this.getOrder().get(i).getCartitem().size(); j++) {
					System.out.println((j + 1) + ".   " + "Food Name : "
							+ this.getOrder().get(i).getCartitem().get(j).getFood_item().getName()
							+ "       Quantity : " + this.getOrder().get(i).getCartitem().get(j).getQuantity());
				}
			}
			try {
				System.out.println("Select Order to Prepare ");
				int choice = input.nextInt();
				this.getOrder().get(choice).setStatus(Orders.Order_Status.REALIZED);

				for (int i : FDW.getCustomers().keySet()) {
					if (FDW.getCustomers().get(i).getId() == this.getOrder().get(choice).getCutomerid()) {

						for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
							if (FDW.getCustomers().get(i).getOrder().get(j).equals(this.getOrder().get(choice))) {
								FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.REALIZED);
							}
						}

					}
				}
				this.getPayments().put(this.getOrder().get(choice).getBill().getInvoice_id(),
						this.getOrder().get(choice).getBill());
				calculateBill(this.getOrder().get(choice));
				System.out.println("Your Order Has been Prepared. A Rider will soon Deliver it.\n\n");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("\nNo Orders Available.\n");
		}
	}

	void calculateBill(Orders order) {
		order.getBill().genInvoice();
	}

}
