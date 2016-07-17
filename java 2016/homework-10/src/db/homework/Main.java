package db.homework;

public class Main {

	public static void main(String[] args) {

		loadDriver();
		OrderItemDaoImpl orderItem = new OrderItemDaoImpl();
		orderItem.createTableOrderItem();
		orderItem.createOrderItem(2, 3, 4, 2);
		orderItem.getAllOrderItems();
		System.out.println("The quantity selected is "+orderItem.getOrderItemById(2));
		orderItem.deleteOrderItem(2);
		
		OrderDaoImpl order = new OrderDaoImpl();
		order.createColummOrder();
		//order.createOrder("bos","01/07/198", 2, 2);
		System.out.println("The name selected is: "+order.getOrderById(2));
		order.getAllOrders();
		order.deleteOrder(2);
		
		ProductDaoImpl product = new ProductDaoImpl();
		product.createTableProduct();
		product.createProduct(3, "dacia", "the simplest car");
		System.out.println("The name selected is: "+product.getProductById(2));
		product.getAllProducts();
		product.deleteProduct(3);
		
		CustomerDao customer = new CustomerDaoImpl();
		customer.createCustomer(4, "bos", "bos@yahoo.com");
		System.out.println("The name selected is "+customer.getCustomerById(3));
		customer.getAllCustomers();
		customer.deleteCustomer(4);
	}

	private static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
