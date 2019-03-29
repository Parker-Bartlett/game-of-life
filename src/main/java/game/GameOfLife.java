package game;

public class GameOfLife {

	public static void main(String[] args) {
		Board board = new Board(8, 6);
		board.generateNewBoard();
		board.drawBoard();
		
		for(int i = 0; i < 100; i++) {			
			board.generateNextGenerationBoard();
			board.drawBoard();
		}
		

	}

}
