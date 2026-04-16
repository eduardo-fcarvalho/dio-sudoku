package application;

import java.util.Scanner;

public class Program {

	void main() {
		 Scanner scanner = new Scanner(System.in);

	        IO.println("Bem vindo ao jogo do Sudoku!");

	        SudokuBoard board = new SudokuBoard();
	        Sudoku game = new Sudoku(board);

	        IO.println();
	        IO.println("Para fazer uma jogada, entre a linha (1-9), coluna (1-9), e o número (1-9) separados por um espaços.");
	        IO.println("Digite 'linha coluna 0' para limpar aquele espaço.");
	        IO.println("Digite 'limpar' para limpar todo o board.");
	        IO.println("Digite 'checar' para checar se o board é válido.");
	        IO.println("Digite 'sair' para parar de jogar.");
	        IO.println();

	        while (!game.isSolved()) {
	            board.printBoard();
	            IO.print("Digite movimento (linha coluna número): ");

	            String input = scanner.nextLine().trim();
	            if (input.equalsIgnoreCase("sair")) {
	                IO.println("Obrigado por jogar!");
	                break;
	            }
	            if (input.equalsIgnoreCase("limpar")) {
	                game.clearBoard();
	                IO.println("Board limpo.\n");
	                continue;
	            }
	            if (input.equalsIgnoreCase("checar")) {
	                game.checkBoard();
	                IO.println();
	                continue;
	            }

	            String[] parts = input.split("\\s+");
	            if (parts.length != 3) {
	                IO.println("Formato incorreto de entrada. Por favor digite: linha coluna número");
	                continue;
	            }

	            try {
	                int row = Integer.parseInt(parts[0]) - 1;
	                int col = Integer.parseInt(parts[1]) - 1;
	                int num = Integer.parseInt(parts[2]);

	                game.makeMove(row, col, num);
	            } catch (NumberFormatException e) {
	                IO.println("Números inválidos. Por favor utilize dígitos.");
	            }
	            IO.println();
	        }

	        if (game.isSolved()) {
	            board.printBoard();
	            IO.println("Parabéns! Você resolveu o Sudoku!");
	        }

	        scanner.close();
	}

}
