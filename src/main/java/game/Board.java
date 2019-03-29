package game;
public class Board {
	
	private int columns;
	private int rows;
	private int[][] board;
	private int[][] nextGenerationBoard;
	
	public Board(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		board = new int[columns][rows];
		nextGenerationBoard = new int[columns][rows];
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public void setBoard(int[][] newBoard) {
		board = newBoard;
	}
	
	public void generateNewBoard() {
		for(int column = 0; column < columns; column++) {
			for(int row = 0; row < rows; row++) {
				board[column][row] = (int) (Math.random() * 2);
			}
		}
	}
	
	public void generateNextGenerationBoard() {
		for(int column = 0; column < columns; column++) {
			for(int row = 0; row < rows; row++) {
				//figure out how many neighbors the active board place has
				int neighborCount = 0;
				for(int i = -1; i < 2; i++) {
					for(int x = -1; x < 2; x++) {
						//figure out how to not act if the neighbor is off the board 
						//If neighbor is off the board wrap around to the next location
						//If the neighbor contains 1 add to neighborCount
						neighborCount = checkNeighbors(column, row, neighborCount, i, x);
						}
					}
				//figure out state of active board place
				checkNextGenState(column, row, neighborCount);
			}
		}
		board = nextGenerationBoard;
	}

	private void checkNextGenState(int column, int row, int neighborCount) {
		if (board[column][row] == 0 && neighborCount == 3) {
			nextGenerationBoard[column][row] = 1;
		} else if (board[column][row] == 1 && (neighborCount > 3 || neighborCount < 2)) {
			nextGenerationBoard[column][row] = 0;
		} else {
			nextGenerationBoard[column][row] = board[column][row];
		}
	}

	private int checkNeighbors(int column, int row, int neighborCount, int i, int x) {
		int boardWrappedColumn = (column + i + columns) % columns;
		int boardWrappedRow = (row + x + rows) % rows;
		neighborCount += board[boardWrappedColumn][boardWrappedRow];
		return neighborCount;
	}
	
	public void drawBoard() {
		for(int column = 0; column < columns; column++) {
			for(int row = 0; row < rows; row++) {
				if(board[column][row] == 0) {
					System.out.print(".");
				} else {
					System.out.print("O");
				}
			}
			System.out.println("\n");
		}
	}
}
