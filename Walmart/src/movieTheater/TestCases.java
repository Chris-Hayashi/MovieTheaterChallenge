package movieTheater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void oneReservation() {
		String[] lineSplit = {"R001", "5"};
		int[] row = { 1 };
		int[] col = { 1 };
		int numSeatsNeeded = 5;
		TheaterHost host = new TheaterHost();
		host.findSeats(row, col, numSeatsNeeded, lineSplit);
		assertEquals("A1,A2,A3,A4,A5", lineSplit[1]);
	}
	
//	@Test
//	void twoReservations() {
//		String[] lineSplit1 =  {"R001", "3"};
//		String[] lineSplit2 = {"R002", "4"};
//		int[] row = { 1 };
//		int[] col = { 1 };
//		int numSeatsNeeded =
//	}

}
