package db.homework;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductDaoTest {

	@Test
	public void ifGetProductByIdIsCorect() {
		ProductDao product = new ProductDaoImpl();
		String name = product.getProductById(2);
		assertEquals("vw", name);
	}

	public void ifNumberOfRowsAreCorectForAllProducts(){
		ProductDao product = new ProductDaoImpl();
		int nrOfRows = product.getAllProducts();
		assertEquals(3, nrOfRows);
	}
}
