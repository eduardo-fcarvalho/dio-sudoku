package application;

public class Sudoku {
	private SudokuBoard board;

	public Sudoku(SudokuBoard board) {
        this.board = board;
    }

	private boolean isValidPlacement(int row, int col, int num) {
		if (num < 1 || num > 9)
			return false;

		for (int i = 0; i < 9; i++) {
			if (board.getCell(row, i) == num)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board.getCell(i, col) == num)
				return false;
		}

		int boxRow = row - row % 3;
		int boxCol = col - col % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board.getCell(boxRow + i, boxCol + j) == num)
					return false;
			}
		}

		return true;
	}

	public boolean makeMove(int row, int col, int num) {
		if (row < 0 || row >= 9 || col < 0 || col >= 9) {
			IO.println("Coordenadas inválidas. Deve ser 1-9.");
			return false;
		}
		if (board.isFixed(row, col)) {
			IO.println("Não se pode trocar um número fixo.");
			return false;
		}

		board.setCell(row, col, num);
		return true;
	}

	public void clearBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!board.isFixed(i, j)) {
					board.setCell(i, j, 0);
				}
			}
		}
	}

	public boolean checkBoard() {
		boolean valid = true;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				int num = board.getCell(row, col);
				if (num != 0) {
					board.setCell(row, col, 0);
					if (!isValidPlacement(row, col, num)) {
						IO.println(
								"Erro na linha " + (row + 1) + ", coluna " + (col + 1) + ": " + num + " viola as regras.");
						valid = false;
					}
					board.setCell(row, col, num);
				}
			}
		}
		if (valid) {
			IO.println("O board é válido. Sem erros encontrados.");
		} else {
			IO.println("O board contém erros.");
		}
		return valid;
	}

	public boolean isSolved() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.getCell(i, j) == 0)
					return false;
			}
		}
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				int num = board.getCell(row, col);
				board.setCell(row, col, 0);
				if (!isValidPlacement(row, col, num)) {
					board.setCell(row, col, num);
					return false;
				}
				board.setCell(row, col, num);
			}
		}
		return true;
	}
}
