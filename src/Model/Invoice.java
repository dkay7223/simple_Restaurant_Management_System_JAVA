package Model;
import java.util.ArrayList;
import java.util.Random;

public class Invoice {

	
	private int Invoice_id;
	private boolean invoice_status;
	private ArrayList<CartItems> order;
	private double totalprice;
	

	public int getInvoice_id() {
		return Invoice_id;
	}




	public void setInvoice_id(int invoice_id) {
		Invoice_id = invoice_id;
	}




	public boolean isInvoice_status() {
		return invoice_status;
	}




	public void setInvoice_status(boolean invoice_status) {
		this.invoice_status = invoice_status;
	}




	public ArrayList<CartItems> getOrder() {
		return order;
	}




	public void setOrder(ArrayList<CartItems> order) {
		this.order = order;
	}




	public double getTotalprice() {
		return totalprice;
	}




	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}




	public Random getRand() {
		return rand;
	}




	public void setRand(Random rand) {
		this.rand = rand;
	}




	Random rand = new Random();

	
	Invoice(ArrayList<CartItems> order){
		this.setOrder(order);
		this.setInvoice_id(rand.nextInt(1000));
		this.setInvoice_status(false);
		
	}
	
	
	void genInvoice() {
		this.totalprice=0;
		System.out.println("\n\n------------------INVOICE-----------------");
		for(int i=0;i<getOrder().size();i++) {
			totalprice=totalprice+getOrder().get(i).getQuantity()*getOrder().get(i).getFood_item().getPrice();	
		}
		System.out.println("*******************************************");
		System.out.println("Your Total Payable Bill is : " +this.getTotalprice());		
		System.out.println("*******************************************\n");
		if (!this.isInvoice_status()) {
			System.out.println("You Have Not Yet Payed For Your Order\n");
		} else {
			System.out.println("You Have Payed For Your Order\n");
		}
		
	}



}
