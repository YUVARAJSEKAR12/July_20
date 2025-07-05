package com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBExe {
	public static void main(String[] args) {
		dbConnection();
	}

	public static void dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "Saikalai@123");
			System.out.println("connected");
			Statement statement = conn.createStatement();
		//	String query = "Select * from world.city;";
			String query="Select min(percentage) from world.countrylanguage;";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("min(percentage)"));
				//System.out.println(rs.getString("CountryCode"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection dbConnection_one() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "Saikalai@123");
			System.out.println("connected");
			}
			
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	// read
	public static ResultSet read_db(String query) {
		ResultSet rs = null;
		try {
			Connection conn = dbConnection_one();
			Statement statement = conn.createStatement();
			 rs = statement.executeQuery(query);
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	
	
	
	
	
	
	

}
