package db.homework;

public interface ProductDao {

	String getProductById(int productId);
	int getAllProducts();
	void deleteProduct(int productId);
	void createProduct(int id, String name, String description);
}
