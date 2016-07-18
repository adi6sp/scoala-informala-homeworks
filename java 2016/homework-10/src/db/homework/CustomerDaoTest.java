package db.homework;

import static org.junit.Assert.*;

import org.junit.Test;
public class CustomerDaoTest {

	@Test
	public void getCustomerByIdIsValid(){
		CustomerDao customer = new CustomerDaoImpl();
		String name = customer.getCustomerById(3);
		assertEquals("mumu", name);
	}

	@Test
	public void ifNumberOfRowsAreCorectForGetAllCustomer(){
		CustomerDao customer = new CustomerDaoImpl();
		int nrOfRows = customer.getAllCustomers();
		assertEquals(4, nrOfRows);
	}
	
}

