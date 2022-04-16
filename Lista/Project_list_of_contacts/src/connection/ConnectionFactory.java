package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	public static Connection connection() {
		String url = "jdbc:mysql://localhost:3306/list_of_contacts";
		String user = "root";
		String password = "@Rafael2006#";
		try{
			return DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection connection, Statement statement) {
		closeConnection(connection);
		try {
			if(statement != null) {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
		closeConnection(connection, statement);
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
