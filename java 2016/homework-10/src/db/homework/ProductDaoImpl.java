package db.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDaoImpl extends AbstractModelDao implements ProductDao {

	Connection conn = getDbConnection();
	Statement st = null;
	PreparedStatement stmt = null;
	ResultSet rs;
	
	@Override
	public String getProductById(int productId) {
		String name = null;  
		try {
			   String sql = "SELECT * FROM products WHERE id = ?";
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, productId);
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
	public int getAllProducts() {
		int nrOfRows = 0; 
		try { 
				String sql = "SELECT * FROM products";
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);

		      while(rs.next()){
		         nrOfRows +=1;
		         int id  = rs.getInt("id");
		         String name = rs.getString("name");
		         String description = rs.getString("description");

		         System.out.print("ID: " + id);
		         System.out.print(", Name: " + name);
		         System.out.println(", Description: " + description);
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
	public void deleteProduct(int productId) {
		 
	      try {
	
	    	  String sql = "DELETE FROM products " +
	                   "WHERE id = ?";
	    	  stmt = conn.prepareStatement(sql);
	    	  stmt.setInt(1, productId);
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
	public void createProduct(int id, String name, String description) {
		try {
			stmt = conn.prepareStatement("INSERT INTO products " + "VALUES (?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, description);
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
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
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
