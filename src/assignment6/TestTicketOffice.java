package assignment6;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestTicketOffice {

	public static int score = 0;
	public static TheaterControl theater;
	 @Test
	public void basicServerTest() {
		theater = new TheaterControl();
		System.out.println(theater.toString());
		try {
			TicketServer.start(2222);
			System.out.println("5");
		} catch (Exception e) {
			System.out.println("6");
			fail();
		}
		System.out.println("7");
		TicketClient client = new TicketClient();
		System.out.println("8");
		client.requestTicket();
		System.out.println("9");
	}

//	//@Test
//	public void testServerCachedHardInstance() {
//		try {
//			TicketServer.start(16790);
//		} catch (Exception e) {
//			fail();
//		}
//		TicketClient client1 = new TicketClient("localhost", "c1",16790);
//		TicketClient client2 = new TicketClient("localhost", "c2",16790);
//		client1.requestTicket();
//		client2.requestTicket();
//		
//	}
//
//	//@Test
//	public void twoNonConcurrentServerTest() {
//		try {
//			TicketServer.start(16791);
//		} catch (Exception e) {
//			fail();
//		}
//		TicketClient c1 = new TicketClient("nonconc1",16791);
//		TicketClient c2 = new TicketClient("nonconc2",16791);
//		TicketClient c3 = new TicketClient("nonconc3",16791);
//		c1.requestTicket();
//		c2.requestTicket();
//		c3.requestTicket();
//	}
//
//	//@Test
//	public void twoConcurrentServerTest() {
//		try {
//			TicketServer.start(16792);
//		} catch (Exception e) {
//			fail();
//		}
//		final TicketClient c1 = new TicketClient("conc1",16792);
//		final TicketClient c2 = new TicketClient("conc2",16792);
//		final TicketClient c3 = new TicketClient("conc3",16792);
//		Thread t1 = new Thread() {
//			public void run() {
//				c1.requestTicket();
//			}
//		};
//		Thread t2 = new Thread() {
//			public void run() {
//				c2.requestTicket();
//			}
//		};
//		Thread t3 = new Thread() {
//			public void run() {
//				c3.requestTicket();
//			}
//		};
//		t1.start();
//		t2.start();
//		t3.start();
//		try {
//			t1.join();
//			t2.join();
//			t3.join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
}
