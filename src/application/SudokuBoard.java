package application;

public class SudokuBoard {
	private int[][] board;
	private boolean[][] fixed;

	public SudokuBoard() {
		board = new int[9][9];
		fixed = new boolean[9][9];

		int[][] initialBoard = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = initialBoard[i][j];
				if (board[i][j] != 0) {
					fixed[i][j] = true;
				}
			}
		}
	}

	public int getCell(int row, int col) {
		return board[row][col];
	}

	public void setCell(int row, int col, int num) {
		board[row][col] = num;
	}

	public boolean isFixed(int row, int col) {
		return fixed[row][col];
	}

	public void printBoard() {
		IO.println("  1 2 3   4 5 6   7 8 9");
		IO.println("-------------------------");
		for (int i = 0; i < 9; i++) {
			IO.print((i + 1) + "|");
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					IO.print(". ");
				} else {
					IO.print(board[i][j] + " ");
				}
				if ((j + 1) % 3 == 0) {
					IO.print("| ");
				}
			}
			IO.println();
			if ((i + 1) % 3 == 0) {
				IO.println("-------------------------");
			}
		}
	}
}
