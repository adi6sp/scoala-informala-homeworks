package db.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDaoImpl extends AbstractModelDao implements ProductDao {

	Connection conn = getDbConnection();
	Statement st = null;
	ResultSet rs;
	
	@Override
	public void getProductById(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllProducts() {
		
	}

	@Override
	public void deleteProduct(int productId) {
		
	}

	@Override
	public void createProduct() {
		
	}
	
	public void createTableProduct(){
		 System.out.println("Creating table in given database..."); 
		 try {
			st = conn.createStatement();
	      String sql = "CREATE TABLE products " + "(id INTEGER not NULL, " + "name varchar(256), " + "description varchar(1024), " +
	    		  " PRIMARY KEY ( id ))"; 
	      st.executeUpdate(sql);
	      System.out.println("Created table in given database...");
	      }catch (SQLException e) {
				e.printStackTrace();
		  }finally{
		      //finally block used to close resources
		      try{
		         if(st!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		  }
	}

}
