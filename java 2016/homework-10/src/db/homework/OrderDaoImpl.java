package db.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDaoImpl extends AbstractModelDao implements OrderDao {

	Connection conn = getDbConnection();
	Statement st = null;
	ResultSet rs;
	
	@Override
	public void getOrderById(int orderId) {
		
	}

	@Override
	public void getAllOrders() {
		
	}

	@Override
	public void deleteOrder(int orderId) {
		
	}

	@Override
	public void createOrder() {
		
	}

	public void createColummOrder(){
		System.out.println("Creating columm in given table..."); 
		try {
			st = conn.createStatement();
			String sql = "ALTER TABLE orders ADD  COLUMN id_customer INTEGER";
			st.execute(sql);
			System.out.println("Created columm in given table...");
		}catch (SQLException e) {
			e.printStackTrace();
	  }finally{
	      try{
	         if(st!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	  }	
	}
}
