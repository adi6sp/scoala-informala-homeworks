package db.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItemDaoImpl extends AbstractModelDao implements OrderItemsDao {

	Connection conn = getDbConnection();
	Statement st = null;
	PreparedStatement stmt = null;
	ResultSet rs;
	
	@Override
	public int getOrderItemById(int orderItemId) {
		int quantity = 0; 
		try {
			   String sql = "SELECT * FROM orderitems WHERE id = ?";
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, orderItemId);
			   rs = stmt.executeQuery();
         while ( rs.next() ) {
             quantity = rs.getInt("quantity");
         }
			rs.close();
		   } catch (SQLException e) {
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
		return quantity;
	}

	@Override
	public int getAllOrderItems() {
		 int nrOfRows = 0; 
		 try { 
				String sql = "SELECT * FROM orderitems";
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);

		      while(rs.next()){
		         nrOfRows +=1;
		    	 int id  = rs.getInt("id");
		         int idOrder  = rs.getInt("id_order");
		         int quantity  = rs.getInt("quantity");
		         int idProduct  = rs.getInt("id_product");

		         System.out.print("ID: " + id);
		         System.out.print(", Id order: " + idOrder);
		         System.out.print(", Quantity: " + quantity);
		         System.out.println(", Id product: " + idProduct);
		      }
		     
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			      //finally block used to close resources
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
		return nrOfRows;
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		 
	      try {
	
	    	  String sql = "DELETE FROM orderitems " +
	                   "WHERE id = ?";
	    	  stmt = conn.prepareStatement(sql);
	    	  stmt.setInt(1, orderItemId);
	    	  stmt.executeUpdate();
	    	  System.out.println("Element deleted");
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	      	if(st!=null)
				try {
					conn.close();
				} catch (SQLException e) {
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

	@Override
	public void createOrderItem(int id, int idOrder, int quantity, int idProduct) {
		try {
			stmt = conn.prepareStatement("INSERT INTO orderitems " + "VALUES (?, ?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setInt(2, idOrder);
			stmt.setInt(3, quantity);
			stmt.setInt(4, idProduct);
			stmt.executeUpdate();
			System.out.println("Element added");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
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
