package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class reserveSeat extends Thread{
	
	public MenuItem game1;
	public MenuItem date1;
	public static String game;
	public static String date;
	public static int game_price;
	public static int game_row;
	public Label texts;
	public Label warning;
	public TextField choice;
	public String choice1;
	public int count = 0;
	public String numbers;
	public static String seat;
	public static String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}


	public Stage stage = new Stage();

	public static String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public static String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public Stage getStage() {
		return this.stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
		
	}
	
	public void gameButtonHandler(ActionEvent event)
	{
		String value = ((MenuItem)event.getSource()).getText();
		setGame(value);
	}
	public void dateButtonHandler(ActionEvent event) throws Exception
	{
		String value = ((MenuItem)event.getSource()).getText();
		setDate(value);
		try 
		{
			operations();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void startReservation()
	{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("reservation.fxml"));
			Scene scene = new Scene(root,1100,700);
	
			stage.setScene(scene);
		
		//	stage.setFullScreen(true);///////////////////////////////////////////////////////////////////////////////////
			stage.show();
			setStage(stage);
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void operations() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
		String query = "SELECT Seat_No, Row_No, Price, Game_name, Date FROM available_seats";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        String text = "";
        while (rs.next())
        {
        	 int game_seat = rs.getInt("Seat_No");
             this.game_row = rs.getInt("Row_No");
             this.game_price= rs.getInt("Price");
        	 String game_name = rs.getString("Game_name");
             String game_date = rs.getString("Date");
             
				   if((this.game.toLowerCase()).equals(game_name.toLowerCase()))
				   {
					   if((this.date.toLowerCase()).equals(game_date))
					   {
						   	text = text+game_seat +"\t\t\t\t"+this.game_row+"\t\t\t\t"+ this.game_price+"\n";
						   	this.numbers = this.numbers + "," + game_seat;
						   	this.count++;
					   }
				   }
				   
        }
		texts.setText(text);
		conn.close();
		
		}


	
	
	public void gameTextFieldHandler(ActionEvent event) throws IOException
	{
		String value = ((TextField)event.getSource()).getText();
		this.choice1 = value;
		int i = 1;
		boolean flag = false;
		String []  parsed = numbers.split(",");
		warning.setText("");
		while(i <= this.count)
		{
			if(this.choice1.equals(parsed[i]))
			{
				flag  = true;
			}
		i++;
		}
		if(flag == false)
		{
			warning.setText("Seat not availabe!");
			choice.setText("");
		}
		else
		{
			this.stage.close();
			setSeat(value);
			Spectstors newSpec = new Spectstors();
			newSpec.setSeat_no(value);
			newSpec.screen();
		}
	}
	public static int getPrice() {
		return game_price;
	}
	public static void setPrice(int price) {
		reserveSeat.game_price = price;
	}
	public static int getRow() {
		return game_row;
	}
	public static void setRow(int row) {
		reserveSeat.game_row = row;
	}
}
