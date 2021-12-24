package testcases;

import application.SignUp;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class signupTest {
	
	private static final String notnull = null;
	SignUp s= new SignUp();

	@Test
	public void testingCorrectCredentials() {
		 s.setName("Uswa Nasir");
		 s.setEmail("i190534@nu.edu.pk");
		 s.setUserName("uswa");
		 s.setPassword("1212");
		 Assert.assertEquals("Uswa Nasir", s.getName());
		 Assert.assertEquals("i190534@nu.edu.pk", s.getEmail());
		 Assert.assertEquals("uswa", s.getUserName());
		 Assert.assertEquals("1212", s.getPassword());
	}
	
	@Test
	public void testingEmptyCredentials() {
		 s.setName("");
		 s.setEmail("");
		 s.setUserName("");
		 s.setPassword("");
		 Assert.assertEquals("Uswa Nasir", s.getName());
		 Assert.assertEquals("i190534@nu.edu.pk", s.getEmail());
		 Assert.assertEquals("uswa", s.getUserName());
		 Assert.assertEquals("1212", s.getPassword());
	}

	@Test
	public void testingfalseCredentials() {
		 s.setName("QuratT");
		 s.setEmail("i190685@nu.edu.pk");
		 s.setUserName("qurat");
		 s.setPassword("12");
		 Assert.assertNotEquals("Uswa Nasir", s.getName());
		 Assert.assertNotEquals("i190534@nu.edu.pk", s.getEmail());
		 Assert.assertNotEquals("uswa", s.getUserName());
		 Assert.assertNotEquals("1212", s.getPassword());
	}
	
	@Test
	public void testingDatabaseCredentials() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String myUrl = "jdbc:mysql://localhost:3306/sports_week";
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        String name = s.name;
        String query = "INSERT INTO accounts (name,email,user_password,user_name) VALUES ('"+s.name+"','"+s.email+"', '"+s.password+"','"+s.userName+"')";
		PreparedStatement statement = conn.prepareStatement(query);
        Assert.assertNotNull(statement);
	}

}
