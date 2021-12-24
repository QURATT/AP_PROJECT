package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Spectstors {
	public String name;
	public String email;
	public String phone_number;
	public String address;
	public String seat_no;
	
	
	//UI variables...
	public TextField full_name;
	public TextField email_id;
	public TextField phoneNumber;
	public TextField addresss;
	public Button submit;
	public Label warning;
	
	//Getters Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public void screen()
	{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Spectators.fxml"));
			Scene scene = new Scene(root,1100,700);
			Stage stage = new Stage();
			stage.setScene(scene);
			
			stage.show();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	//UI Handlers
	public void nameHandler(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		full_name.setText(value);
		setName(value);
	}
	public void emailHandler(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		email_id.setText(value);
		setEmail(value);
	}
	public void phoneNumberHandler(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		phoneNumber.setText(value);
		setPhone_number(value);
	}
	public void addressHandler(ActionEvent event) {
		String value = ((TextField)event.getSource()).getText();
		addresss.setText(value);
		setAddress(value);
	}
	public void submitHandler(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		submit.setText(value);
		warning.setText("Reservation Completed!");
		try {
			makeSpectator();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//File Handling
	public void makeSpectator() throws IOException{
		try 
		{
			boolean flag = false;
	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = DriverManager.getConnection(myUrl, "root", ""); 
	    	String query = "INSERT INTO spectator (name, email, phone_no, address, seat_no,Game_name, Visiting_Date, Price, row_no) VALUES ('"+this.name+"','"+this.email+"', '"+this.phone_number+"','"+this.address+"', '"+reserveSeat.getSeat()+"','"+reserveSeat.getGame()+"','"+reserveSeat.getDate()+"', '"+reserveSeat.getPrice()+"' , '"+reserveSeat.getRow()+"')";
			PreparedStatement statement = conn.prepareStatement(query);
		
		    statement.executeUpdate(query);

		    conn.close();
            
       
            //Normal functioning...
			removeFromAvailable();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void removeFromAvailable() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", ""); 
    	String query = "delete from available_seats where Seat_No = '"+reserveSeat.getSeat()+"' AND Game_name = '"+reserveSeat.getGame()+"' AND Date = '"+reserveSeat.getDate()+"' ";
		PreparedStatement statement = conn.prepareStatement(query);
	
	    statement.executeUpdate(query);

	    conn.close();
	}
}