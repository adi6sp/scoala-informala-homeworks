package db.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDaoImpl extends AbstractModelDao implements CustomerDao {

	private Connection conn = getDbConnection();
	private Statement st = null;
	private ResultSet rs;

	@Override
	public void deleteCustomer(int customerId) {
		  System.out.println("Creating statement...");
	      try {
	    	  st = conn.createStatement();
	    	  String sql = "DELETE FROM Customers " +
	                   "WHERE id = customerId";
	    	  st.executeUpdate(sql);
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	      	if(st!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public void getCustomerById(int customerId) {
		   try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT name FROM customer WHERE id = customerId");
           while ( rs.next() ) {
               String name = rs.getString("name");
               System.out.println(name);
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
	}

	@Override
	public void getAllCustomers() {
		 try { 
			String sql = "SELECT id, first, last, age FROM Registration";
			ResultSet rs = st.executeQuery(sql);

	      while(rs.next()){
	         int id  = rs.getInt("id");
	         String name = rs.getString("name");
	         String email = rs.getString("email");

	         System.out.print("ID: " + id);
	         System.out.print(", Name: " + name);
	         System.out.println(", Email: " + email);
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
	}


	@Override
	public void createCustomer(int id, String name, String email) {
		try {
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO customer(id,name,email) " + "VALUES (?, ?, ?)");
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
	}

}
