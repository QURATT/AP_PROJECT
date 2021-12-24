package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CancellationException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CancelReservation {

	public static String name;
	public static String seat;
	public static String date1;
	public static String game;
	public static String row;
	public static String price;
	public static String getRow() {
		return row;
	}
	public static void setRow(String row) {
		CancelReservation.row = row;
	}
	public static String getPrice() {
		return price;
	}
	public static void setPrice(String price) {
		CancelReservation.price = price;
	}
	//UI varibales
	public TextField name1;
	public TextField seat1;
	public MenuItem date;
	public MenuItem game1;
	
	//Getters Setters
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		CancelReservation.name = name;
	}
	public static String getSeat() {
		return seat;
	}
	public static void setSeat(String seat) {
		CancelReservation.seat = seat;
	}
	public void nameTextFieldHandler(ActionEvent event)
	{
		String value = ((TextField)event.getSource()).getText();
		this.name = value;
		name1.setText(value);
	}
	public void seatTextFieldHandler(ActionEvent event)
	{
		String value = ((TextField)event.getSource()).getText();
		this.seat = value;
		seat1.setText(value);
	}
	public void dateButtonHandle(ActionEvent event)
	{
		String value = ((MenuItem)event.getSource()).getText();
		this.date1 = value;
	}
	public void gameButtonHandle(ActionEvent event)
	{
		String value = ((MenuItem)event.getSource()).getText();
		this.game = value;
	}
	public void ButtonHandle(ActionEvent event) throws IOException
	{
		String value = ((Button)event.getSource()).getText();
		try {
			startCancellation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void startCancellation()  throws CancellationException, ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", ""); 
    	String query = "Select * FROM spectator where name = '"+this.name+"' AND seat_no = '"+this.seat+"' AND Visiting_date= '"+this.date1+"' AND Game_name = '"+this.game+"'";
    	Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        String to_delete = "";
        while(rs.next())
        {
        	this.price = rs.getString("price"); 
        	this.row = rs.getString("row_no"); 
        }
    	
    	query = "DELETE FROM spectator where name = '"+this.name+"' AND seat_no = '"+this.seat+"' AND Visiting_date= '"+this.date1+"' AND Game_name = '"+this.game+"'";
    	st = conn.createStatement();
        int x = st.executeUpdate(query);
       
        query ="INSERT into available_seats VALUES('"+this.seat+"' , '"+this.row+"' , '"+this.price+"' , '"+this.game+"', '"+this.date1+"')";
    	st = conn.createStatement();
        x = st.executeUpdate(query);
        //Add to available, delete from spectators

        conn.close();	
	}
	public void screen() {
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Cancellation.fxml"));
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
	
}
