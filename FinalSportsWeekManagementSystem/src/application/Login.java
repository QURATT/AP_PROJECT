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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login 
{
	private String user_name;
	private String password;
	public TextField userName;
	public TextField passwords;
	public Label result;
	public Stage primaryStage;
	
	public Stage getPrimaryStage()
	{
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void loginInput(Stage stage)
	{
		setPrimaryStage(stage);
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root,1100,700);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	@FXML
	public void getSignUp(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();
		System.out.println(value);
		if(value.equals("Sign-up"))
		{
			SignUp scene = new SignUp();
			scene.sceneCreation();
		}
	}
	public void getText(ActionEvent event)
	{
		String value = ((TextField)event.getSource()).getText();
		userName.setText(value);
		setUser_name(value);  
		
	}
	public void inputPassword(ActionEvent event) throws ReflectiveOperationException
	{
		String value = ((TextField)event.getSource()).getText();
		passwords.setText(value);
		setPassword(value); 
		if(this.user_name != null && this.password != null)
		{
			loginAuthorization();
		}
	}
	public void loginAuthorization() throws ReflectiveOperationException
	{
		
		String file_input;
		try 
		{
			boolean ad = false;
			boolean flag = false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "SELECT user_name, user_password  FROM accounts";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
               String u_name = rs.getString("user_name");
               String u_pass = rs.getString("user_password");
           		if((this.user_name.toLowerCase()).equals(u_name.toLowerCase()))
           		{
           			if((this.password.toLowerCase()).equals(u_pass.toLowerCase()))
           			{
           				flag = true;
           				result.setText("Authenticated!");
           			}
   						   
   					   
           		}
            }
		
   			 if(flag == false)
   			{
   				query = "SELECT user_name, user_password  FROM administrator";
   	            st = conn.createStatement();

   	            rs = st.executeQuery(query);
   	            while (rs.next())
   	            {
   	               String u_name = rs.getString("user_name");
   	               String u_pass = rs.getString("user_password");
   	           		if((this.user_name.toLowerCase()).equals(u_name.toLowerCase()))
   	           		{
   	           			if((this.password.toLowerCase()).equals(u_pass.toLowerCase()))
   	           			{
   	           				ad = true;
   	           				flag = true;
   	           				result.setText("Authenticated as Administrator!");
   	           			}
   	           		}
   	            }
   			}
   	         if(flag == false)
    		{				
   				result.setText("Incorrect username or password");
   			}
   			else
   			{
   				MainScreen screen1 = new MainScreen();
   				screen1.screen(ad);
   			}
   			
            
            conn.close();

		
			//Addesd to remove 
			MainScreen screen1 = new MainScreen();
				screen1.screen(ad);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

