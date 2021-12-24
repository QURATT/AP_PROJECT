package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainScreen {
	
	public void screen(boolean administrator)
	{
		if(administrator == false)
		{
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("OutputScreen.fxml"));
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
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ADscreen.fxml"));
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
	public void getReservation(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();
		if(value.equals("Reserve a seat"))
		{
			reserveSeat newResv = new reserveSeat();
			newResv.startReservation();
			try {
				newResv.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void cancelReservation(ActionEvent event)
	{
		
		String value = ((Button)event.getSource()).getText();
		if(value.equals("Cancel Reservation"))
		{
			CancelReservation cancel = new CancelReservation();
			cancel.screen();
		}
		
	}
	public void registerTeam(ActionEvent event)
	{
		String value = ((MenuItem)event.getSource()).getText();	
		
		Team team = new Team();
		if(value.equals("Cricket") ||value.equals("Football")|| value.equals("Hockey"))
		{
		team.registerTeam(value);
		}
		else
		{
			team.registerForSix(value);
			
		}
		try {
			team.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyTeam(ActionEvent event)
	{
		String value = ((MenuItem)event.getSource()).getText();	
		Team team = new Team();
		if(value.equals("Add a Player"))
		{
			modifyTeam add = new modifyTeam();
			add.screen("add");
			try {
				add.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(value.equals("Remove a Player"))
		{
			modifyTeam remove = new modifyTeam();
			remove.screen("remove");
			try {
				remove.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	public void makeSchedule(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();

		System.out.println(value);
		if(value.equals(value))
		{
			ScheduleHandler schedule = new ScheduleHandler();
			schedule.screen();
			try {
				schedule.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	public void displaySchedule(ActionEvent event)
	{
		String value = ((Button)event.getSource()).getText();

		System.out.println(value);
		if(value.equals(value))
		{
			ScheduleHandler schedule = new ScheduleHandler();
			schedule.screenDisplay();
			try {
				schedule.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
