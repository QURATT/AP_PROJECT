package testcases;

import application.reserveSeat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class reserveSeatTest {
	
	reserveSeat r= new reserveSeat();
	
	@Before
    public void before() throws Exception {
        r.operations();
    }

	@Test
	public void NotreserveTest() {
		r.setSeat("7");
		assertEquals("7", reserveSeat.getSeat());
		r.setGame("Cricket");
		assertEquals("Cricket", reserveSeat.getGame());
		r.setDate("22-02-2022");
		assertEquals("22-02-2022", reserveSeat.getDate());
	}

	
	@Test
	public void ReserveTest() throws Exception {
		r.operations();
		r.setSeat("7");
		assertEquals("7", reserveSeat.getSeat());
		r.setGame("Cricket");
		assertEquals("Cricket", reserveSeat.getGame());
		r.setDate("22-02-2022");
		assertEquals("22-02-2022", reserveSeat.getDate());
	}
	
	
	@Test
	public void TicketPrice() throws Exception {
		 
		reserveSeat.setPrice(800);
		assertEquals(800, reserveSeat.getPrice());
		 
	}
}
