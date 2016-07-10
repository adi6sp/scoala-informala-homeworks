package db.homework;

public interface OrderDao {

	void getOrderById(int orderId);
	void getAllOrders();
	void deleteOrder(int orderId);
	void createOrder();
}
