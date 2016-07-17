package db.homework;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDaoImpl extends AbstractModelDao implements OrderDao {

	Connection conn = getDbConnection();
	Statement st = null;
	PreparedStatement stmt = null;
	ResultSet rs;
	
	@Override
	public String getOrderById(int orderId) {
		String name = null;
		try {
			   String sql = "SELECT * FROM orders WHERE id = ?";
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, orderId);
			   rs = stmt.executeQuery();
        while ( rs.next() ) {
            name = rs.getString("name");
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
		return name;
		
	}

	@Override
	public int getAllOrders() {
		int nrOfRows = 0; 
		try { 
				String sql = "SELECT * FROM orders";
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);

		      while(rs.next()){
		         nrOfRows +=1;
		    	 String name  = rs.getString("name");
		         Date date = rs.getDate("date");
		         int id_customer = rs.getInt("id_customer");
		         int id  = rs.getInt("id");

		         System.out.print("Name: " + name);
		         System.out.print(", Date: " + date);
		         System.out.print(", Id customer: " + id_customer);
		         System.out.println(", Id: " + id);
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
		return nrOfRows;
	}

	@Override
	public void deleteOrder(int orderId) {
		  try {
				
	    	  String sql = "DELETE FROM orders " +
	                   "WHERE id = ?";
	    	  stmt = conn.prepareStatement(sql);
	    	  stmt.setInt(1, orderId);
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
	public void createOrder(String name,Date date,int id_customer,int id) {
		try {
			stmt = conn.prepareStatement("INSERT INTO orders " + "VALUES (?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setDate(2, date);
			stmt.setInt(3, id_customer);
			stmt.setInt(4, id);			
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
