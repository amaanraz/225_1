package fifteenpuzzle;

import java.io.*;
import java.util.*;


public class FifteenPuzzle {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;


	// Board in form of 2d array
	private int[][] board;

	
	/**
	 * @param fileName Name of file
	 * @throws FileNotFoundException if file not found
	 * @throws BadBoardException if the board is incorrectly formatted
	 * Reads a board from file and creates the board
	 */
	public FifteenPuzzle(String fileName) throws IOException, BadBoardException {
		//initialize variables
		board = new int[4][4];
		// read file to board variable
		try {
			Scanner scanner = new Scanner(new File(fileName));
			for (int i = 0; i < 4; i++) {
				// Get line by line
				String line = scanner.nextLine();
				for (int j = 0; j < 4; j++) {
					// Separate characters of from line "AA" "BB" ....
					String number = line.substring(3*j, 3*j+2);
					// Check for empty space
					if (number.equals("  ")) {
						board[i][j] = 0;
					} else {
						// Trim whitespace and extract int from string
						board[i][j] = Integer.parseInt(number.trim());
					}
				}
			}
			scanner.close();
			// check bad board
			badBoard(board);

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	
	/**
	 * Get the number of the tile, and moves it to the specified direction
	 * 
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(int tile, int direction) throws IllegalMoveException {


		// Find indexes of tile
		int column = 0;
		int row = 0;

		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] == tile){
					row = i;
					column = j;
				}
			}
		}

		// Check if direction of tile is empty and move it
		// Up = 0 Down = 1 Left = 2 Right = 3
		int movingRow = row;
		int movingCol = column;

		if(direction == 0) movingRow--;
		if(direction == 1) movingRow++;
		if(direction == 2) movingCol--;
		if(direction == 3) movingCol++;

		// If direction takes off board
		if(movingRow < 0 || movingRow > 3 || movingCol < 0 || movingCol > 3){
			throw new IllegalMoveException("Move is not contained within the board\n");
		}
		// Check if empty
		if(board[movingRow][movingCol] == 0) {
			// switch places
			board[movingRow][movingCol] = tile;
			board[row][column] = 0;
		} else {
			throw new IllegalMoveException("Direction of movement is not empty\n");
		}

	}

	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the board has all tiles in their correct positions
	 */
	public boolean isSolved() {
		int counter = 1;
		// run loop and check if in order from 1 to 15
		for (int[] row : board) {
			for (int element : row) {
				if(element == counter){
					counter++;
				} else {
					if(element != 0){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		// convert 2d array to exact format of txt file

		// single digit contain space in front then digit followed by space
		// double-digit numbers have 1 space
		// 0 counts as 2 white spaces
		String strBoard = "";

		for (int[] row : board) {
			for (int element : row) {
				// single digit elements
				if (element <= 9 && element > 0){
					if(element == row[3]){ // last element does not contain space
						strBoard = strBoard.concat(" " + element);
					} else {
						strBoard = strBoard.concat(" " + element + " ");
					}
				} else if(element == 0){
					if(element == row[3]){
						strBoard = strBoard.concat("  ");
					} else {
						strBoard = strBoard.concat("   ");
					}
				} else {
					// double digit
					if(element == row[3]){
						strBoard = strBoard.concat(element + "");
					} else {
						strBoard = strBoard.concat(element + " ");
					}
				}
			}
			// add newline character
			strBoard = strBoard.concat("\n");
		}
		return strBoard;
	}

	// check bad board -> everything from 1 to 15 appears once and 1 0 is present
	private void badBoard(int[][] board) throws BadBoardException{
		// Use set to verify if board is unique (Standard procedure to check uniqueness)
		Set<Integer> set = new HashSet<Integer>();
		for (int[] row : board) {
			for (int element : row) {
				// element already exists in set -> duplicate element
				if(!set.add(element)){
					throw new BadBoardException("Board does not have unique elements\n");

				}
				// element not from 1 to 15
				if(element > 15 || element < 0){
					throw new BadBoardException("Board has element(s) greater than 15 or less than 0\n");
				}
			}
		}
	}

}
