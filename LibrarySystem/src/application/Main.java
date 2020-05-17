package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import javafx.fxml.Initializable;
import java.sql.*;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("UniversalSearch.fxml"));
			Scene scene = new Scene(root,600,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
	String username="root";
	String password="mypassword";
	
	try {
		// 1. Get a connection to database
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=Asia/Bangkok", username, password);

		// 2. Create a statement
				Statement myStmt = myConn.createStatement();
		// 3. Execute SQL query
				ResultSet myRs = myStmt.executeQuery("select * from actor");
		// 4. Process the result set
				while (myRs.next()) {
					System.out.println(myRs.getString("first_name")+ "," + myRs.getString("last_name"));
				}
				System.out.println("Connected!");
				return myConn;
		}
		catch (Exception exc) {
		exc.printStackTrace();
		}
	return null;
	}
	
	public static void main(String[] args) throws Exception {
		getConnection();
		launch(args);
		
	}
	
}	

