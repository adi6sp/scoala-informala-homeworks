package exceptions.homework;

public class Ticket {

	private String category;
	private int price;
	public Ticket(String category, int price) {
		super();
		this.category = category;
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}
	
}
