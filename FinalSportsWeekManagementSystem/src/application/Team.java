package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; 

public class Team extends Thread
{
	public static String team_id;
	public static String game;

	//UI
	public Label game_name;
	@FXML
	public TextField name;
	@FXML 
	public TextField email;
	@FXML 
	public TextField address;
	
	
	public static String getGame() 
	{
		return game;
	}
	public static void setGame(String game) 
	{
		Team.game = game;
	}
	public void registerTeam(String game)
	{
		try 
		{
			setGame(game);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("RegisterTeam.fxml"));
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
	
	public static String email1, email2, email3, email4, email5, email6, email7, email8, email9, email10, email11;
	public static String name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11;
	public static String address1, address2, address3, address4, address5, address6, address7, address8, address9, address10, address11;
	@FXML 
	public void buttonHandler(ActionEvent event)
	{
		try {
			Team.getPlayers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public static void getPlayers() throws ClassNotFoundException
	{
		int player_id = 0;
		try {
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
    	query = "SELECT team_id FROM team WHERE team_id = (SELECT max(team_id) FROM team);";
       st = conn.createStatement();
       int team_id = 0 ;
        rs = st.executeQuery(query);	
        while(rs.next())
        {
        	 team_id =  rs.getInt("team_id"); 
        	 team_id +=1;
        }
        System.out.print(false);
        query ="INSERT into player VALUES('"+name1+"' , '"+player_id+"' , '"+email1+"' , '"+address1+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name2+"' , '"+player_id+"' , '"+email2+"' , '"+address2+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name3+"' , '"+player_id+"' , '"+email3+"' , '"+address3+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name4+"' , '"+player_id+"' , '"+email4+"' , '"+address4+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name5+"' , '"+player_id+"' , '"+email5+"' , '"+address5+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name6+"' , '"+player_id+"' , '"+email6+"' , '"+address6+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name7+"' , '"+player_id+"' , '"+email7+"' , '"+address7+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name8+"' , '"+player_id+"' , '"+email8+"' , '"+address8+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name9+"' , '"+player_id+"' , '"+email9+"' , '"+address9+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name10+"' , '"+player_id+"' , '"+email10+"' , '"+address10+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into player VALUES('"+name11+"' , '"+player_id+"' , '"+email11+"' , '"+address11+"', '"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        query ="INSERT into team VALUES('"+team_id+"', '"+game+"')";
    	st = conn.createStatement();
        st.executeUpdate(query);
        player_id+=1;
        System.out.print(true);
        conn.close();
        }
		 catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	public void handleName(ActionEvent event)
	{
		name1 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail(ActionEvent event)
	{
		email1 = new String(((TextField)event.getSource()).getText());
		
	}
	public void getAddress(ActionEvent event)
	{
		String address1 = ((TextField)event.getSource()).getText();	
		
		
	}
	public void getName2(ActionEvent event)
	{
		name2 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail2(ActionEvent event)
	{
		email2 = ((TextField)event.getSource()).getText();
		
	}
	public void getAddress2(ActionEvent event)
	{
		String address2 = ((TextField)event.getSource()).getText();	
		
	
	}
	public void getName3(ActionEvent event)
	{
		name3 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail3(ActionEvent event)
	{
		 email3 = ((TextField)event.getSource()).getText();
	
	}
	public void getAddress3(ActionEvent event)
	{
		String address3 = ((TextField)event.getSource()).getText();	
		
	}
	public void getName4(ActionEvent event)
	{
		name4 = ((TextField)event.getSource()).getText();		
	}
	public void getEmail4(ActionEvent event)
	{
		email4 = ((TextField)event.getSource()).getText();
	}
	public void getAddress4(ActionEvent event)
	{
		String address4 = ((TextField)event.getSource()).getText();	
	}
	public void getName5(ActionEvent event)
	{
		name5 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail5(ActionEvent event)
	{
		email5 = ((TextField)event.getSource()).getText();
	
	}
	public void getAddress5(ActionEvent event)
	{
		String address5 = ((TextField)event.getSource()).getText();	
		
	}
	public void getName6(ActionEvent event)
	{
		name6 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail6(ActionEvent event)
	{
		 email6 = ((TextField)event.getSource()).getText();
	}
	public void getAddress6(ActionEvent event)
	{
		String address6 = ((TextField)event.getSource()).getText();	
	
	}
	public void getName7(ActionEvent event)
	{
		name7 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail7(ActionEvent event)
	{
		 email7 = ((TextField)event.getSource()).getText();
	}
	public void getAddress7(ActionEvent event)
	{
		String address7 = ((TextField)event.getSource()).getText();	
	}
	public void getName8(ActionEvent event)
	{
		name8 = ((TextField)event.getSource()).getText();
	}
	public void getEmail8(ActionEvent event)
	{
		 email8 = ((TextField)event.getSource()).getText();
	}
	public void getAddress8(ActionEvent event)
	{
		String address8 = ((TextField)event.getSource()).getText();	
	}
	public void getName9(ActionEvent event)
	{
		name9 = ((TextField)event.getSource()).getText();	
	}
	public void getEmail9(ActionEvent event)
	{
		 email9  = ((TextField)event.getSource()).getText();
	}
	public void getAddress9(ActionEvent event)
	{
		String address9 = ((TextField)event.getSource()).getText();	
	}
	public void getName10(ActionEvent event)
	{
		name1 = ((TextField)event.getSource()).getText();	
			
	}
	public void getEmail10(ActionEvent event)
	{
		 email10 = ((TextField)event.getSource()).getText();
	}
	public void getAddress10(ActionEvent event)
	{
		String address10 = ((TextField)event.getSource()).getText();	
		
	}
	public void getName11(ActionEvent event)
	{
		String name11 = ((TextField)event.getSource()).getText();	
		
	}
	public void getEmail11(ActionEvent event)
	{
		 email11 = ((TextField)event.getSource()).getText();
	
	}
	public void getAddress11(ActionEvent event)
	{
		String address11 = ((TextField)event.getSource()).getText();	
			
	}
	//
	public void registerForSix(String game)
	{
		try 
		{
			setGame(game);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("RegisterForGame.fxml"));
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

