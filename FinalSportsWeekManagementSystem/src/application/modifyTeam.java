package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class modifyTeam extends Thread{
	public Players player = new Players();
	public TextField name1;
	public TextField address1;
	public TextField email1;
	public TextField team_id1;
	public MenuItem game1;
	public void screen(String function)
	{
		if(function.equals("add"))
		{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AddPlayer.fxml"));
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
		else
		{
			try 
			{
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("RemovePlayer.fxml"));
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
	}
	public void addPlayer(ActionEvent event)
	{
		String name = name1.getText();
		String email = email1.getText();
		String address = address1.getText();
		String game = game1.getText();	
		
		int team_id = Integer.parseInt(team_id1.getText());
		try {
			int player_id = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = DriverManager.getConnection(myUrl, "root", "");
			//MAX_PLAYER_ID
	        String query = "SELECT player_id FROM Player WHERE player_id=(SELECT max(player_id) FROM Player);";
	        Statement st = conn.createStatement();
	       
	        ResultSet rs = st.executeQuery(query);	
	        while(rs.next())
	        {
	        	player_id =  rs.getInt("player_id"); 
	        	player_id +=1;
	        }
		
		
			//MAX_PLAYER_ID
	        query ="INSERT into player VALUES('"+name+"' , '"+player_id+"' , '"+email+"' , '"+address+"', '"+team_id+"', '"+game+"')";
	        st = conn.createStatement();
	        st.executeUpdate(query);
	        conn.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	public void removePlayer()
	{
		String name = name1.getText();
		String game = game1.getText();	
		int team_id = Integer.parseInt(team_id1.getText());
		int player_id1 = Integer.parseInt(email1.getText());
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        	Connection conn = DriverManager.getConnection(myUrl, "root", "");
	        	String query = "Delete FROM `player` WHERE Upper(player_name) = Upper('"+name+"') AND player_id ='"+player_id1+"';";
	        	  
	  	        Statement st = conn.createStatement();
	  	       
	  	        st.executeUpdate(query);
	  	      
			
	        	conn.close();
	     	}
	     	catch (Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	}
	
}


