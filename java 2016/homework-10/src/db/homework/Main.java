package db.homework;

public class Main {

	public static void main(String[] args) {

		loadDriver();
		OrderItemDaoImpl orderItem = new OrderItemDaoImpl();
		orderItem.createTableOrderItem();
		OrderDaoImpl order = new OrderDaoImpl();
		order.createColummOrder();
		ProductDaoImpl product = new ProductDaoImpl();
		product.createTableProduct();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		//customer.createCustomer(4, "bos", "bos@gmail");
	}

	private static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
