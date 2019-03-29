package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	
	Board testBoard = new Board(6, 4);
	@Before
	public void setUp() {
		int[][] boardState = {
				{0,1,0,0},
				{1,1,0,0},
				{1,1,0,1},
				{0,0,0,0},
				{0,1,0,0},
				{0,0,0,0}
		};
		testBoard.setBoard(boardState);
	}
	
	@Test
	public void shouldFillBoardWithOesAndZeros() {
		testBoard.generateNewBoard();
		int[][] board = testBoard.getBoard();

		for (int column = 0; column < 4; column++) {
			for (int row = 0; row < 4; row++) {
				assertTrue(board[column][row] <= 1);
			}
		}
	}
	
	@Test
	public void shouldTurnDeadCellToLivingCellWhenThereAreThreeNeighbors() {
		testBoard.generateNextGenerationBoard();
		int[][] nextGen = testBoard.getBoard();
		assertEquals(nextGen[0][0], 1);
	}
	
	@Test
	public void shouldKillLivingCellWhenGreaterThanThreeNeighbors() {
		testBoard.generateNextGenerationBoard();
		int[][] nextGen = testBoard.getBoard();
		assertEquals(nextGen[1][1], 0);
	}
	
	@Test
	public void shouldKillLivingCellWhenLessThanTwoNeighbors() {
		testBoard.generateNextGenerationBoard();
		int[][] nextGen = testBoard.getBoard();
		assertEquals(nextGen[4][1], 0);
	}
	

}








