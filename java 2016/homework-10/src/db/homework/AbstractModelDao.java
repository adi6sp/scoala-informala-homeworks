package db.homework;

import java.sql.Connection;

public abstract class AbstractModelDao {

	protected Connection getDbConnection(){
		return ConnectionManager.getConnection("postgresql", "localhost", 5432, "eshop", "postgres", "253566");
	}
}
