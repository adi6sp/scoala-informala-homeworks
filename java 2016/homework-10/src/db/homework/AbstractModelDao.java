package db.homework;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractModelDao {

	protected Connection getDbConnection(){
		Connection connect = ConnectionManager.getConnection("postgresql", "localhost", 5432, "eshop", "postgres", "253566");
		if(connect != null)
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return connect;
	}
}
