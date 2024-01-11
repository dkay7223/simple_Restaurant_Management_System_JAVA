package Model;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Orders {

	private ArrayList<CartItems> cartitem;
	private Order_Status status;
	private int order_id;
	private int restaurant_id;
	private Invoice bill;
	private int cutomerid;
	private ZonedDateTime date = ZonedDateTime.now();
	
	
	Random rand = new Random();

	
	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public Orders.Order_Status isStatus() {
		return status;
	}

	public void setStatus(Orders.Order_Status status) {
		this.status = status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public ArrayList<CartItems> getCartitem() {
		return cartitem;
	}

	public void setCartitem(ArrayList<CartItems> cartitem) {
		this.cartitem = cartitem;
	}
	public Invoice getBill() {
		return bill;
	}

	public void setBill(Invoice bill) {
		this.bill = bill;
	}
	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	enum Order_Status {
		CANCELED, REALIZED, DRAFT, DISPATCHED, DELIVERED,
	}

	// ********************************
	Orders(int custid,int restaurantId,ArrayList<CartItems> cartitem,Invoice bill) {
		this.cutomerid=custid;
		this.bill=bill;
		this.restaurant_id=restaurantId;
		this.setCartitem(cartitem);
		this.setStatus(Order_Status.DRAFT);
		this.order_id = rand.nextInt(1000);
		this.setDate(date);
		
	}

	public int getCutomerid() {
		return cutomerid;
	}

	public void setCutomerid(int cutomerid) {
		this.cutomerid = cutomerid;
	}

	




}
