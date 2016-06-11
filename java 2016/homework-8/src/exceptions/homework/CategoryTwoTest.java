package exceptions.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTwoTest {

	@Test

		public void ifTheValueIsCorect() throws CategoryTicketsSoldoutException {
			CategoryTwo category = new CategoryTwo(17);
			category.calculateTiket();
			assertEquals(1360, category.calculateValue(),0);
		
	}

}
