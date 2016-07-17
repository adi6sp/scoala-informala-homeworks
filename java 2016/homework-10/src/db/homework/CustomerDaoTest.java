package db.homework;

import static org.junit.Assert.*;

import org.junit.Test;
public class CustomerDaoTest {

	@Test
	public void getCustomerByIdIsValid(){
		CustomerDao customer = new CustomerDaoImpl();
		//customer.createCustomer(4, "bos", "bos@yahoo.com");
		//customer.deleteCustomer(4);
		String name = customer.getCustomerById(3);
		//customer.getAllCustomers();
		assertEquals("mumu", name);
	}

	@Test
	public void ifNumberOfRowsAreCorectForGetAllCustomer(){
		CustomerDao customer = new CustomerDaoImpl();
		int nrOfRows = customer.getAllCustomers();
		assertEquals(4, nrOfRows);
	}
	
}

