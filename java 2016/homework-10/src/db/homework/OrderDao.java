package db.homework;

import java.sql.Date;

public interface OrderDao {

	String getOrderById(int orderId);
	int getAllOrders();
	void deleteOrder(int orderId);
	void createOrder(String name, Date date, int id_customer, int id);
	
}
