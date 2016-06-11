package exceptions.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryThreeTest {

	@Test
	public void ifTheValueIsCorect() throws CategoryTicketsSoldoutException {
		CategoryThree category = new CategoryThree(25);
		category.calculateTiket();
		assertEquals(1250, category.calculateValue(),0);
	}

}
