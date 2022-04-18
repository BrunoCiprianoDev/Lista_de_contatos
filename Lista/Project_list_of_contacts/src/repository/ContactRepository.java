package repository;

import connection.ConnectionFactory;
import entities.Contact;
import entities.Key;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContactRepository {
	public static void save(Key key, Contact contact) {
		 String sql = "INSERT INTO contact (name, phone) VALUES ('"+contact.getName()+"', '"+contact.getPhone()+"')";
		 Connection connection = ConnectionFactory.connection(key);
		 try {
			 Statement statement = connection.createStatement();
			 statement.executeLargeUpdate(sql);
			 ConnectionFactory.closeConnection(connection, statement);
		 }catch(SQLException e) {
			 JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!","Erro ao salvar dados!", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		 }
	}	 
	public static List<Contact> getAllContacts(Key key){
		String sql = "SELECT id, name, phone FROM contact";
		Connection connection = ConnectionFactory.connection(key);
		List<Contact> listOfContacts = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				listOfContacts.add(new Contact(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phone")));
			}
			ConnectionFactory.closeConnection(connection);
			return listOfContacts;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!","Erro ao carregar dados!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}	
	public static void update(Key key, int id, Contact contact) {
		String sql1 = "UPDATE contact SET name = '"+contact.getName()+"' WHERE id = '"+id+"'";	
		String sql2 = "UPDATE contact SET phone = '"+contact.getPhone()+"' WHERE id = '"+id+"'";
		Connection connection = ConnectionFactory.connection(key);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			ConnectionFactory.closeConnection(connection);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!","Erro ao atualizar dados!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}	
	public static void delete(Key key, int id) {
		String sql = "DELETE FROM contact WHERE id='"+id+"'";
		Connection connection = ConnectionFactory.connection(key);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			ConnectionFactory.closeConnection(connection);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Falha na conexão com banco de dados!","Erro ao deletar dados!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}		
}
