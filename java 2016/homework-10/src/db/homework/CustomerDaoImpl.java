package db.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDaoImpl extends AbstractModelDao implements CustomerDao {

	private Connection conn = getDbConnection();
	private PreparedStatement stmt = null;
	private ResultSet rs;
	private Statement st = null;

	@Override
	public void deleteCustomer(int customerId) {
		 
	      try {
	
	    	  String sql = "DELETE FROM customer " +
	                   "WHERE id = ?";
	    	  stmt = conn.prepareStatement(sql);
	    	  stmt.setInt(1, customerId);
	    	  stmt.executeUpdate();
	    	  System.out.println("Element deleted");
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	}

	@Override
	public String getCustomerById(int customerId) {
		String name = null;  
		try {
			   String sql = "SELECT * FROM customer WHERE id = ?";
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, customerId);
			   rs = stmt.executeQuery();
           while ( rs.next() ) {
                name = rs.getString("name");
           }
			rs.close();
		   } catch (SQLException e) {
			e.printStackTrace();
		   }
		return name;
	}

	@Override
	public int getAllCustomers() {
		int numberOfRows = 0;
		try { 
			String sql = "SELECT * FROM customer";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
	      while(rs.next()){
	    	  numberOfRows +=1;
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
		}
			return numberOfRows;
	}


	@Override
	public void createCustomer(int id, String name, String email) {
		try {
			stmt = conn.prepareStatement("INSERT INTO customer(id,name,email) " + "VALUES (?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.executeUpdate();
			System.out.println("Element added");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		}
	}

}
