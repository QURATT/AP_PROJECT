package testcases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import application.Spectstors;
import application.reserveSeat;

public class SpectatorsTest {

	
	Spectstors s= new Spectstors();
	
	@Test
	public void setSpectator() {
		 s.setName("Anonymous");
		 s.setEmail("anonymoushere@gmail.com");
		 s.setAddress("Anonymous Address");
		 s.setPhone_number("4567");
		 s.setSeat_no("hidden");
		 assertEquals("Anonymous", s.getName());
		 assertEquals("anonymoushere@gmail.com", s.getEmail());
		 assertEquals("Anonymous Address", s.getAddress());
		 assertEquals("4567", s.getPhone_number());
		 assertEquals("hidden", s.getSeat_no());
	}
	
	@Test
	public void makingSpectator() throws IOException, ClassNotFoundException, SQLException {
		s.makeSpectator();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", ""); 
    	String query = "INSERT INTO spectator (name, email, phone_no, address, seat_no,Game_name, Visiting_Date, Price, row_no) VALUES ('Qurat "+"', qhere@hotmail.com'"+"', '-56'"+"', Rawalpindi'"+"', '"+reserveSeat.getSeat()+"','"+reserveSeat.getGame()+"','"+reserveSeat.getDate()+"', '"+reserveSeat.getPrice()+"' , '"+reserveSeat.getRow()+"')";
		PreparedStatement statement = conn.prepareStatement(query);
	
	    statement.executeUpdate(query);

	    conn.close();
	}

}
