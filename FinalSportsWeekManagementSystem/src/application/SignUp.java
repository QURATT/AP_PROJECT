package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUp {
	public String userName;
	public String password;
	public String email;
	public String name;
	public TextField userName1;
	public TextField password1;
	public TextField email1;
	public TextField name1;
	public Text text;
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	
	Stage stage;
	public void sceneCreation()
	{
		try 
		{	
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene = new Scene(root,1100,700);
			stage = new Stage();
			stage.setScene(scene);
			stage.show();
			//this.primaryStage.show();
			
		
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void getName(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		name1.setText(value);
		setName(value);
	}
	public void getUserName(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		userName1.setText(value);
		setUserName(value);
	}
	public void getPassword(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		password1.setText(value);
		setPassword(value);
		if((this.email != null) && (this.name != null) && (this.password != null) && (this.userName != null) )
		{
			setCredentials();
		}
	}
	public void getEmail(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		email1.setText(value);
		setEmail(value);
		
	}
	public void setCredentials()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = DriverManager.getConnection(myUrl, "root", "");
	        String name = this.name;
			String query = "INSERT INTO accounts (name,email,user_password,user_name) VALUES ('"+this.name+"','"+this.email+"', '"+this.password+"','"+this.userName+"')";
			PreparedStatement statement = conn.prepareStatement(query);
		
		    statement.executeUpdate(query);

			text = new Text();
			text.setText("Account successfully created!");
			
			Login newLogin = new Login();
			Stage primaryStage = new Stage();
			newLogin.loginInput(primaryStage);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
	}
	 
	
	
}
