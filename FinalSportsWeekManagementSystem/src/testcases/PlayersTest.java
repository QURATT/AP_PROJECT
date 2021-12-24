package testcases;
import application.Players;
import junit.framework.Assert;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayersTest {
	
	Players p= new Players();
	
	@BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}

    @Test
	public void checkingPlayers() {
		assertNotNull(p);
	}
	 
	@SuppressWarnings("static-access")
	@Test
	public void PlayersInfo() {
		p.setPlayer_id("19i-0685");
		assertEquals("19i-0685", Players.getPlayer_id());
		p.setPlayer_name("QURAT");
		assertEquals("QURAT", Players.getPlayer_name());
		p.setGame("Cricket");
		assertEquals("Cricket", p.getGame());
		p.setEmail("i190685@nu.edu.pk");
		assertEquals("i190685@nu.edu.pk", p.getEmail());
		p.setAddress("Khawaja Corp, Rawalpindi");
		assertEquals("Khawaja Corp, Rawalpindi", p.getAddress());
	}
	
	@Test
	public void SetPlayers() {
		Players p1= new Players("Uswa", "19i-0534", "Football", "i190534@nu.edu.pk", "G-10/2, Islamabad");
		Players p2= new Players("Meshal", "19i-1977", "Football", "i191977@nu.edu.pk", "PWD, Rawalpindi");
		assertNotSame(p2, p1);
	}

}
