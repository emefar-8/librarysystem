package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;


public class MainController {
	
@FXML
private Label lblStatus;

@FXML
private TextField txtUsername;

@FXML
private TextField txtPassword;

@FXML
private ComboBox<String> comboItem;

@FXML
private ComboBox<String> comboType;

@FXML
private ListView<String> listview;

ObservableList<String> list = FXCollections.observableArrayList("Artikel","Bok","film","Tidsskrift");
ObservableList<String> list2 = FXCollections.observableArrayList("Titel","Forfattare","ISBN","Nyckelord");

public void BackToUniversalSearch (ActionEvent event) throws Exception{
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage primaryStage= new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("UniversalSearch.fxml"));
	Scene scene = new Scene(root,300,300);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
}

public void LogInfromUniversalSearch (ActionEvent event) throws Exception{
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage primaryStage= new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	Scene scene = new Scene(root,300,300);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
}

public void Login(ActionEvent event) throws Exception {
	if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")){
		lblStatus.setText("Login Successful!");	
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("LoggedInUser.fxml"));
		Scene scene = new Scene(root,600,300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	} else {
		lblStatus.setText("Login Failed!");	}
}

public void Logout(ActionEvent event) throws Exception {
	System.exit(0);
	
}

public void ShowMyLoans(ActionEvent event) throws Exception{
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage primaryStage= new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("MyLoans.fxml"));
	Scene scene = new Scene(root,600,300);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
}

public void GoBackToProfile (ActionEvent event) throws Exception{
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage primaryStage= new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("LoggedInUser.fxml"));
	Scene scene = new Scene(root,600,300);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
}

public void ShowSearchResults(ActionEvent event) throws Exception{
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage primaryStage= new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("SearchResult.fxml"));
	Scene scene = new Scene(root,600,300);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
}

public void TransferItems(ActionEvent event) throws Exception{
	ObservableList <String> items;
	items = listview.getSelectionModel().getSelectedItems();
	for (String item : items) {
		System.out.println("item");
	}
}
/*
@Override
public void initialize(URL location, ResourceBundle resources) {
	comboItem.setItems(list);
	comboType.setItems(list2);
	listview.setItems(list); // insert fetched data from database (try)
	listview.getSelectionMode().setSelectionMode(SelectionMode.MULTIPLE); //Allows you to pick several rows
	listview.getItems().addAll(.....);// insert fetched data from database (try)
}
*/

}

