package db.homework;

public interface CustomerDao {
	void getCustomerById(int customerId);
	void getAllCustomers();
	void deleteCustomer(int customerId);
	void createCustomer(int id, String name, String email);
}

