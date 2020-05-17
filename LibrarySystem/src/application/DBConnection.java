package application;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception{
		String username="root";
		String password="mypassword";
		String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=Asia/Bangkok"; // where our database is located
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected!");
		return conn;
		} catch (Exception e) {System.out.println(e);}
		
	return null;
	}
	
	
}
