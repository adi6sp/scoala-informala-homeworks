package exceptions.homework;

public class CategoryTicketsSoldoutException extends Exception {
	public String message;

	public CategoryTicketsSoldoutException(String message) {
		super();
		this.message = message;
	}
	
}
