package application;

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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScheduleHandler extends Thread {
	public TextField team1;
	public TextField team2;
	public MenuItem date;
	public MenuItem game;
	public MenuItem game1;
	public Label texts;
	public  void screen()
	{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MakeSchedule.fxml"));
			Scene scene = new Scene(root,1200,700);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public  void makeSchedule()
	{
		String team_one = team1.getText();
		String team_two = team2.getText();
		String value = date.getText();	
		String value1 = game.getText();	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "INSERT INTO schedule VALUES ('"+team_one+"','"+team_two+"', '"+value+"','"+value1+"')";
			PreparedStatement statement = conn.prepareStatement(query);
		
		    statement.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
	}
	public  void screenDisplay()
	{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("DisplaySchedule.fxml"));
			Scene scene = new Scene(root,1200,700);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void operations(ActionEvent event) throws Exception
	{
		String game2 =  ((MenuItem)event.getSource()).getText();
		System.out.println(game2);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
		String query = "Select team1, team2, date, game from schedule where game = '"+game2+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        int i = 1;
        String text="";
        while (rs.next())
        {
        	 String team1 = rs.getString("team1");
        	 String team2 = rs.getString("team2");
        	 String game_name = rs.getString("game");
             String game_date = rs.getString("date");
           	text = text+" "+team1+"\t\t\t\t"+team2+"\t\t\t  "+ game_date+"\t\t\t"+ game_name+"\n";
             
        	i++;
				   
        }
		texts.setText(text);
		conn.close();
		
		}



}
