package db.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItemDaoImpl extends AbstractModelDao implements OrderItemsDao {

	Connection conn = getDbConnection();
	Statement st = null;
	ResultSet rs;
	
	@Override
	public void getOrderItemById(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllOrderItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrderItem() {
		// TODO Auto-generated method stub
		
	}
	
	public void createTableOrderItem(){
		 System.out.println("Creating table in given database..."); 
		 try {
			st = conn.createStatement();
	      String sql = "CREATE TABLE orderitems " + "(id INTEGER not NULL, " + "id_order INTEGER, " + "quantity INTEGER, " + "id_product INTEGER, " +
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
