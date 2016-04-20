package assignment6;

import java.util.EmptyStackException;
import java.util.Stack;

public class TheaterControl {
	public class Seat {
		String row;
		Integer chair;

		Seat(String s, Integer i) {
			row = s;
			chair = i;

		}
	}

	Stack<Seat> Theater = new Stack();

	TheaterControl() {
		// fill the stack, least to most desirable
		// refunds not part of assignment, do not re-push seats after
		// initialization
		// Character[] row =
		// {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String[] row = { "AA", "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I",
				"H", "G", "F", "E", "D", "C", "B", "A" };
		// Integer[] worstMidOrder =
		// {121,108,120,109,119,110,118,111,117,112,116,113,115,114};
		// Integer[] worstLeftOrder ={128,127,126,125,124,123,122};
		// Integer[] worstRightOrder = {101,102,103,104,105,106,107};
		Integer[] worstSeatOrder = { 101, 128, 102, 127, 103, 126, 104, 125, 105, 124, 106, 123, 107, 122, 108, 121,
				109, 120, 110, 119, 111, 118, 112, 117, 113, 116, 114, 115 };
		Integer[] worstBackSeat = { 101, 128, 102, 127, 103, 126, 104, 125, 105, 124, 106, 123, 107, 122 };
		Integer[] worstAAseat = { 101, 128, 102, 127, 103, 104, 116, 117, 118 };
		// fill the stack in worst -> best order
		// AA seats at top
		// special z and y
		int rowI = 0; // z
		int size = worstAAseat.length;
		for (int k = 0; k < size; k++) {
			Theater.push(new Seat(row[rowI], worstAAseat[k]));
		}

		rowI = 1; // z
		size = worstBackSeat.length;
		for (int k = 0; k < size; k++) {
			Theater.push(new Seat(row[rowI], worstBackSeat[k]));
		}
		rowI = 2;// y
		for (int k = 0; k < size; k++) {
			Theater.push(new Seat(row[rowI], worstBackSeat[k]));
		}
		rowI = 3;// x
		size = worstSeatOrder.length; // normal seats
		int numRows = row.length;
		for (; rowI < numRows; rowI++) {
			for (int k = 0; k < size; k++) {
				Theater.push(new Seat(row[rowI], worstSeatOrder[k]));
			}
		}
		//System.out.println(Theater);

	}
	public Seat getASeat(){
		try{
		Seat seat = Theater.pop();
		return seat;
		}catch(EmptyStackException e){
			return null;
		}

	}
}
