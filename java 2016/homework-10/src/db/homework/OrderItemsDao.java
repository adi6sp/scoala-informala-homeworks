package db.homework;

public interface OrderItemsDao {

	int getOrderItemById(int orderItemId);
	int getAllOrderItems();
	void deleteOrderItem(int orderItemId);
	void createOrderItem(int id, int idOrder, int quantity, int idProduct);
}
