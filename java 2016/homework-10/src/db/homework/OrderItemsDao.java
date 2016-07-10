package db.homework;

public interface OrderItemsDao {

	void getOrderItemById(int orderItemId);
	void getAllOrderItems();
	void deleteOrderItem(int orderItemId);
	void createOrderItem();
}
