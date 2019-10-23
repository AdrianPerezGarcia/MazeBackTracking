import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Rehacer entrada para que añada las posibles soluciones, readEntry y setMovements y fillBoard puede ser una buena opcion
		//Controlar como hacer dos busquedas si tiene premio
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		Box[][] board= new Box[tam][tam];
		char[][] m = new char[tam][tam];
		Box[] solution = new Box[tam];
		boolean premio = false;
		int solutioning = 0;
		String entry;
		for (int i = 0; i < m.length; i++) {
			entry = sc.nextLine();
			for (int j = 0; j < m.length; j++) {
				m[i][j] = entry.charAt(j);
				if(m[i][j] == '*') premio = true;
			}
		}
		Maze maze = new Maze(board);
		ArrayList<Box> roads = new ArrayList<>();
		roads.add(board[0][0]);
		
		fillRoads(maze, board[0][0], board[board.length-1][board.length-1], roads);
		if(roads.size() == 0) {
			System.out.println("NO");
		}
		else {
			Box[] sol = optimusSol(roads);
		}
		sc.close();
	}

	private static Box[] optimusSol(ArrayList<Box> road) {
		return null;
	}

	private static void fillRoads(Maze maze, Box actualBox, Box finalBox, ArrayList<Box>road) {
		if(actualBox.equals(finalBox)) {
			maze.addRoad((ArrayList<Box>)road.clone());
		}else {
			int[][] movements = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
			int newJ, newI;
			Box auxBox;
			
			for (int i = 0; i < movements.length; i++) {
				newJ = actualBox.getJ() + movements[i][0];
				newI = actualBox.getI() + movements[i][1];
				auxBox = maze.getBoxAt(newJ, newI);
				
				switch(i) {
				case 0:
					if(maze.canGoUp(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 1:
					if(maze.canGoDown(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 2:
					if(maze.canGoLeft(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 3:
					if(maze.canGoRight(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 4:
					if(maze.canGoUpLeft(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 5:
					if(maze.canGoUpRight(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 6:
					if(maze.canGoDownLeft(actualBox,auxBox)) {
						road.add(auxBox);
						actualBox.setVisited(true);
						fillRoads(maze, auxBox, finalBox, road);
						actualBox.setVisited(false);
						road.remove(auxBox);
					}
					break;
				case 7:
					if(maze.canGoDownRight(actualBox,auxBox)) {
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
