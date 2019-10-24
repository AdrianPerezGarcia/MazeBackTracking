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
		int pI, pJ;
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
				}
			}
		}

		boolean[] movements = { false, false, false, false, false, false, false, false };
		int checkI, checkJ;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				int[][] posibleMovements = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
						{ 1, 1 } };
				for (int k = 0; k < movements.length; k++) {
					checkJ = j + posibleMovements[k][0];
					checkI = i + posibleMovements[k][1];
					if (isInBounds(checkI, checkJ, board)
							&& (entryM[checkI][checkJ] == '0' || entryM[checkI][checkJ] == '*')) {
						movements[k] = true;
					}
				}
				if (entryM[i][j] == '*') {
					board[i][j] = new Box(i, j, true, movements);
					// System.out.println("Se crea la box [" + i + "][" + j + "]");
				} else {
					board[i][j] = new Box(i, j, false, movements);
					// System.out.println("Se crea la box [" + i + "][" + j + "]");
				}
			}
		}
		
		Maze maze = new Maze(board);
		ArrayList<Box> road = new ArrayList<>();
		road.add(board[0][0]);
		if (isTherePrize) {
			System.out.println("Hay premio");
		} else {
			fillRoads(maze, board[0][0], board[board.length - 1][board.length - 1], road);
			if (road.size() == 0) {
				System.out.println("NO");
			} else {
				System.out.println("Longitud del array de arrays: " +maze.getRoads().size());
				printResult(maze.getShortestRoad());
			}
		}
		sc.close();
	}

	private static boolean isInBounds(int checkI, int checkJ, Box[][] board) {
		return (checkI >= 0 && checkI < board.length && checkJ >= 0 && checkJ < board.length);
	}

	private static void fillRoads(Maze maze, Box actualBox, Box finalBox, ArrayList<Box> road) {

		if (actualBox.equals(finalBox)) {
			maze.addRoad(road);
			road.clear();
			road.add(maze.getBoxAt(0, 0));
		} else {
			int[][] movements = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
					{ 1, 1 } };
			int newJ, newI;
			Box auxBox;

			for (int i = 0; i < movements.length; i++) {
				newI = actualBox.getI() + movements[i][0];
				newJ = actualBox.getJ() + movements[i][1];
				// System.out.println(newI+","+newJ);
				auxBox = maze.getBoxAt(newI, newJ);

				switch (i) {
				case 0:
					if (maze.canGoUp(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 1:
					if (maze.canGoDown(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 2:
					if (maze.canGoLeft(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 3:
					if (maze.canGoRight(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 4:
					if (maze.canGoUpLeft(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 5:
					if (maze.canGoUpRight(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 6:
					if (maze.canGoDownLeft(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 7:
					if (maze.canGoDownRight(actualBox, auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				}
			}

		}
	}

	private static void printResult(Box[] solution) {
		for (int i = 0; i < solution.length; i++) {
			System.out.print(solution.toString());
			System.out.println(" ");
		}
		System.out.print("\n");
	}

}
