package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Account;
import beans.Customer;

public class AccountModel {
	private Connection connection;

	public AccountModel() {
		super();
		this.connection = this.getConn("customer_management");
	}
	
	public Connection getConn(String name){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+name,"root",null);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int create(Account account) {
		String sql = "INSERT INTO account VALUES (NULL,?,?,?,?)";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, account.getName());
			statement.setString(2, account.getUsername());
			statement.setString(3, account.getPassword());
			statement.setInt(4, account.getLevel());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public Account get(String username,String password) {
		String sql = "SELECT * FROM account WHERE username=? AND password=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				Account account = new Account(rs.getInt("id"),rs.getString("name"),rs.getString("username"),rs.getString("password"), rs.getInt("level"));
				return account;
			}else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
