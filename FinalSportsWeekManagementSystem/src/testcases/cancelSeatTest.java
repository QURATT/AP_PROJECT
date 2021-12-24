package testcases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CancellationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import application.CancelReservation;
import application.reserveSeat;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class cancelSeatTest {
	
	CancelReservation c= new CancelReservation();
	
	  @Before
	    public void before() throws SQLException, ClassNotFoundException {
	        c.startCancellation();
	    }
	  
	  @Test
		public void NotcancelTest() {
			CancelReservation.setSeat("7");
			assertEquals("7", reserveSeat.getSeat());
			//CancelReservation.setName("Cricket");
			assertEquals("Cricket", reserveSeat.getGame());
		}

	/*@Test
	public void testScreen() {
		 
			try {
				assertDisplays("Cancellation.fxml", (AnchorPane)FXMLLoader.load(getClass().getResource("Cancellation.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void assertDisplays(String string, AnchorPane load) {
		// TODO Auto-generated method stub
		
	}*/
	  @SuppressWarnings("null")
	@Test
	  public void CancelSeat() throws ClassNotFoundException, SQLException
	  {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/sports_week";
	        Connection conn = null;
			try {
				conn = DriverManager.getConnection(myUrl, "root", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	String query = "Select * FROM spectator where name = Uswa AND seat_no = 2 AND Visiting_date= 25-01-2022 AND Game_name = Football";
	    	Statement st = null;
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        ResultSet rs = st.executeQuery(query);
	        String to_delete = "";
	        try {
				c.startCancellation();
			} catch (CancellationException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        assertnotEquals(null);
	  }

	private void assertnotEquals(Object object) {
		// TODO Auto-generated method stub
		
	}

}
