import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Maze {
	
	private Box[][] maze;
	
	int[] posibleY = {1, -1, 0, 0, -1, -1, 1, 1};
	
	int[] posibleX = {0, 0, -1, 1, -1, 1, -1, 1};
	
	int size;
		
	public Queue<Box> path = new LinkedList<Box>();
	public Queue<Box> queue = new LinkedList<Box>();
	
	private ArrayList<Box> sol;
	
	public int length;
	
	public Maze(Box[][] maze) {
		this.maze = maze;
		this.sol = new ArrayList<>();
		this.length = maze.length;
	}

	public Box getBoxAt(int i, int j) {
		if(isInBounds(i,j)) return maze[i][j];
		else return null;
		
	}
	
	public boolean isInBounds(int i, int j) {
		return(i >= 0 && i < this.maze.length && j >= 0 && j < this.maze.length);
	}
	
	public boolean isInBounds(Box box) {
		return(box.getI() >= 0 && box.getI() < this.maze.length && box.getJ() >= 0 && box.getJ() < this.maze.length);
	}

	public Box[] getSol() {
		if(sol.isEmpty()) {
			return null;
		}
		else {
			return null;
		}
	}


	public boolean resolveMaze(Box startBox, Box endBox) {
		queue.clear();
		path.clear();
		boolean exit = false;
		boolean hasSolution = false;
		Box actualBox;
		System.out.println("A resolver desde [" +startBox.getI()+ "][" +startBox.getJ()+ "] hasta [" +endBox.getI()+ "][" +endBox.getJ()+ "]");
		queue.add(startBox);
		while(!queue.isEmpty() && !exit) {
			actualBox = queue.remove();
			System.out.println("Checkeo el [" +actualBox.getI()+ "][" +actualBox.getJ()+ "]");
			if(actualBox.equals(endBox)) {
				exit = true;
				hasSolution = true;
				System.out.println("Is the end");
			}
			System.out.println("No es el final");
			actualBox.setVisited(true);
			for (int i = 0; i < posibleX.length; i++) {
				if(isInBounds(actualBox.getI() + posibleY[i], actualBox.getJ() + posibleX[i])) {
					if(getBoxAt(actualBox.getI() + posibleY[i], actualBox.getJ() + posibleX[i]).getValue() != 1 && !(getBoxAt(actualBox.getI() + posibleY[i], actualBox.getJ() + posibleX[i]).isVisited())) {
					queue.add(getBoxAt(actualBox.getI() + posibleY[i], actualBox.getJ() + posibleX[i]));
					System.out.println("Añado el [" + (actualBox.getI() + posibleY[i]) + "][" + (actualBox.getJ() + posibleX[i]) + "]");
					}
				}
			}
			System.out.println("Visitado el [" +actualBox.getI()+ "][" +actualBox.getJ()+ "]");
			
		}
		return hasSolution;
	}

}
