package game;

import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello, how many columns would you like your board to have?");
		int columns = input.nextInt();
		System.out.println("Okay, how many rows?");
		int rows = input.nextInt();
		System.out.println("Great! How many generations would you like to see?");
		int generations = input.nextInt();

		
		Board board = new Board(columns, rows);
		board.generateNewBoard();
		board.drawBoard();
		
		for(int i = 0; i < generations; i++) {			
			board.generateNextGenerationBoard();
			board.drawBoard();
		}
		

	}

}
