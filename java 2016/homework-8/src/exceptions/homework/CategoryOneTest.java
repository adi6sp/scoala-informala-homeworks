package exceptions.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryOneTest {

	@Test
	public void ifTheValueIsCorect() throws CategoryTicketsSoldoutException {
		CategoryOne category = new CategoryOne(7);
		category.calculateTiket();
		assertEquals(840, category.calculateValue(),0);
	}
}
