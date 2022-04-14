package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import connection.Key;

public class LoginRepository {
	public static boolean testConnection(Key key) {
		Connection connection = ConnectionFactory.connection(key);
		try{
			Statement statement = connection.createStatement();
			ConnectionFactory.closeConnection(connection, statement);
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Usuario ou senha invalidos!","Erro de autenticação!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

}
