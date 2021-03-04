package movieTheater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TheaterHost {

	// Create global constants for Rows and Columns
	public static final int MAX_ROWS = 10;
	public static final int MAX_COLS = 20;

	// Main method
	public static void main(String[] args) {

		// NOTE: Assume a buffer of 3 seats and/or one row

		String line = null;
		String[] lineSplit = new String[2];
		int numSeatsNeeded = 0;

		// Current row and column
		int[] row = { 1 };
		int[] col = { 1 };

		try {
			// Create a BufferedReader and BufferedWriter
			BufferedReader br = new BufferedReader(new FileReader("Reservations.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("AssignedSeating.txt"));

			while ((line = br.readLine()) != null) {

				lineSplit = line.split(" ");
				numSeatsNeeded = Integer.parseInt(lineSplit[1]);

				// Find seats
				findSeats(row, col, numSeatsNeeded, lineSplit);

				System.out.println(String.join(" ", lineSplit));
				bw.write(String.join(" ", lineSplit).concat("\n"));
			}

			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void findSeats(int[] row, int[] col, int numSeatsNeeded, String[] lineSplit) {
		ArrayList<String> seatList = new ArrayList<>();

		if (numSeatsNeeded > (MAX_COLS - col[0] + 1)) {
			row[0] += 2;
			col[0] = 1;
		}

		if ((numSeatsNeeded <= (MAX_COLS - col[0] + 1)) && (col[0] <= MAX_COLS)) {
			int seatsReserved = 0;
			String rowLetter = null;

			switch (row[0]) {
			case 1:
				rowLetter = "A";
				break;
			case 3:
				rowLetter = "C";
				break;
			case 5:
				rowLetter = "E";
				break;
			case 7:
				rowLetter = "G";
				break;
			case 9:
				rowLetter = "I";
			}
			
			while (seatsReserved < numSeatsNeeded) {
				seatList.add(rowLetter + col[0]);
				col[0]++;
				seatsReserved++;
			}
			
			// Social Distance by 3 seats
			col[0] += 3;
			
			lineSplit[1] = String.join(",", seatList);
		}
		return;
	}
}
