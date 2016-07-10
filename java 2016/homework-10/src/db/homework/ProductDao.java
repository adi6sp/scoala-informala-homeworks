package db.homework;

public interface ProductDao {

	void getProductById(int productId);
	void getAllProducts();
	void deleteProduct(int productId);
	void createProduct();
}
