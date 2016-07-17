package db.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderItemDaoImplTest {

	@Test
	public void ifQuantitySelectedByIdIsCorect() {
		OrderItemsDao orderItem = new OrderItemDaoImpl();
		int quantity = orderItem.getOrderItemById(2);
		assertEquals(4, quantity);
	}

	@Test
	public void ifNumberOfRowsForAllOrdersItemsAreCorect(){
		OrderItemsDao orderItem = new OrderItemDaoImpl();
		int nrOfRows = orderItem.getAllOrderItems();
		assertEquals(2, nrOfRows);
	}
}
