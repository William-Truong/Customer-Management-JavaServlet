package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;

public class CustomerModel {

	private Connection connection;
	
	public CustomerModel() {
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
	
	public List<Customer> all(){
		String sql = "SELECT * FROM customer";
		try {
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			List<Customer> customers = new ArrayList<Customer>();
			while(rs.next()) {
				customers.add(new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getDate("created_date"),rs.getDate("updated_date")));
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Customer get(int id) {
		String sql = "SELECT * FROM customer WHERE id=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			Customer customer = null;
			if(rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getDate("created_date"), rs.getDate("updated_date"));
				return customer;
			}else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int create(Customer customer) {
		String sql = "INSERT INTO customer VALUES (NULL,?,?,?,NULL)";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setDate(3, customer.getCreated_date());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int edit(Customer customer) {
		String sql = "UPDATE customer SET name=?,email=?,updated_date=? WHERE id=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setDate(3, customer.getUpdated_date());
			statement.setInt(4, customer.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM customer WHERE id=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<Customer> find(String name){
		String sql = "SELECT * FROM customer WHERE name LIKE N'%"+name+"%'";
		try {
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			List<Customer> customers = new ArrayList<Customer>();
			while(rs.next()) {
				customers.add(new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getDate("created_date"),rs.getDate("updated_date")));
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}


