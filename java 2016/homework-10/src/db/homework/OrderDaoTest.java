package db.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderDaoTest {

	@Test
	public void ifGetOrderNameByIdIsCorect() {
		OrderDao order = new OrderDaoImpl();
		String name = order.getOrderById(2);
		assertEquals("boc", name);
	}

	@Test
	public void test() {
		OrderDao order = new OrderDaoImpl();
		int nrOfRows = order.getAllOrders();
		assertEquals(2, nrOfRows);
	}
}
