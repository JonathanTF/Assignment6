package assignment6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import assignment6.TheaterControl.Seat;

public class TicketServer {
	static int PORT = 2222;

	// EE422C: no matter how many concurrent requests you get, // do not have
	// more than three servers running concurrently
	final static int MAXPARALLELTHREADS = 3;
	public static void start(int portNumber) throws IOException {
		PORT = portNumber;
		Runnable serverThread = new ThreadedTicketServer();
		Thread t = new Thread(serverThread);
		t.start();
	}
}

class ThreadedTicketServer implements Runnable {
	String hostname = "127.0.0.1";
	String threadname = "X";
	String testcase;
	TicketClient sc;
	Seat seat = null;
	int CustNum = 0;
	boolean full = false;

	public void run() {
		// TODO 422C
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(TicketServer.PORT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		full = false;
		while (!full) {
			try {

				Socket clientSocket = serverSocket.accept();
	
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(clientSocket.getInputStream()));
				seat = TestTicketOffice.theater.getASeat();
				if (seat != null) {
			
					out.write("Row: " + seat.row + " Num: " + seat.chair + "\n");
					out.flush();
				} else {
					full = true;
					System.out.println("Sorry, we are full");
					System.exit(0);
				}

			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}
}