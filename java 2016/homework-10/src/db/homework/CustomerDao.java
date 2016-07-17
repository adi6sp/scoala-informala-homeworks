package db.homework;

public interface CustomerDao {
	String getCustomerById(int customerId);
	int getAllCustomers();
	void deleteCustomer(int customerId);
	void createCustomer(int id, String name, String email);
}

