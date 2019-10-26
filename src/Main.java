import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Rehacer entrada para que añada las posibles soluciones, readEntry y
		// setMovements y fillBoard puede ser una buena opcion
		// Controlar como hacer dos busquedas si tiene premio
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		int pI = 0, pJ = 0;
		boolean isTherePrize = false;
		Box[][] board = new Box[tam][tam];
		char[][] entryM = new char[tam][tam];
		String entry;
		for (int i = 0; i < entryM.length; i++) {
			entry = sc.nextLine();
			for (int j = 0; j < entryM.length; j++) {
				entryM[i][j] = entry.charAt(j);
				if (entryM[i][j] == '*') {
					isTherePrize = true;
					pI = i;
					pJ = j;
					board[i][j] = new Box(i, j, 0, true);
				}
				else {
					board[i][j] = new Box(i, j, Integer.parseInt(Character.toString(entryM[i][j])), false);
				}
			}
		}
		
		if(!(board[0][0].getValue() == 1 || board[board.length-1][board.length-1].getValue() == 1)) {
			Maze maze = new Maze(board);
			
			if (isTherePrize) {
				searchWithPrize(maze,board,pI,pJ);
				
			} else {
				searchWithoutPrize(maze);
			}
		} else {
			System.out.println("NO.");
		}
		
		sc.close();
	}

	private static void searchWithPrize(Maze maze, Box[][] board, int pI, int pJ) {
		
	}

	private static void searchWithoutPrize(Maze maze) {
		if(maze.resolveMaze(maze.getBoxAt(0, 0), maze.getBoxAt(maze.length-1, maze.length-1))) {
			System.out.println("Tiene solucion, a ver como la imprimo xd");
		}
		else {
			System.out.println("NO.");
		}
	}

}
