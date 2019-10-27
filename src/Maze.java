import java.util.*;

public class Maze {
	
	private int length;
	
	private Box[][] maze;
	
	private int[] posibleY = {1, -1, 0, 0, -1, -1, 1, 1};
	
	private int[] posibleX = {0, 0, -1, 1, -1, 1, -1, 1};
	
	private Queue<Box[]> queue = new LinkedList<Box[]>();
	
	private Box[] sol;
	
	public Maze(Box[][] maze) {
		this.maze = maze;
		this.length = this.maze.length;
	}
	
	public int getLength() {
		return this.length;
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
		return sol;
	}


	public boolean resolveMaze(Box startBox, Box endBox) {
		
		sol = null;
		
		queue.clear();
		
		boolean exit = false;
		boolean hasSolution = false;
		boolean[][] visited = new boolean[maze.length][maze.length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				visited[i][j] = false;
			}
		}
		
		Box node;
		Box[] path= {startBox};	
		ArrayList<Box> newPath = new ArrayList<>();
		queue.add(path);
		
		while(!queue.isEmpty() && !exit) {
			//System.out.println("En la cola hay " +queue.size()+ " elementos");
			
			path = queue.remove();
			
			//System.out.println("El path tiene " +path.length+ " elementos.");
			node = path[path.length-1];
			visited[node.getI()][node.getJ()] = true;
			
			for (int i = 0; i < path.length; i++) {
				newPath.add(path[i]);
			}
			
			//System.out.println("Checkeo el [" +node.getI()+ "][" +node.getJ()+ "]");
			
			for (int i = 0; i < posibleX.length; i++) {
				
				if(isInBounds(node.getI() + posibleY[i], node.getJ() + posibleX[i])) { //Compruebo que ese vecino existe
					Box neighbour = getBoxAt(node.getI() + posibleY[i], node.getJ() + posibleX[i]);
					System.out.println("Comprobando el [" +neighbour.getI()+ "][" +neighbour.getJ()+ "]");
					if(neighbour.getValue() != 1 && !(visited[neighbour.getI()][neighbour.getJ()]) ) { //Compruebo que ese vecino vale 0 y que no esta visitado
						System.out.println("Es valido.");
						if(neighbour.equals(endBox)) {
							System.out.println("Es el final.");
							System.out.println("Lo ultimo que se mete al path es [" +neighbour.getI()+ "][" +neighbour.getJ()+ "]");
							newPath.add(neighbour);
							sol = newPath.toArray(new Box[newPath.size()]);
							for (int j = 0; j < sol.length; j++) {
								System.out.println("El putisimo valor es [" +sol[j].getI()+ "][" +sol[j].getJ()+ "]");
							}
							exit = true;
							hasSolution = true;
							break;
						} else {
							System.out.println("No es el final.");
							newPath.add(neighbour);
							queue.add(newPath.toArray(new Box[newPath.size()]));
							System.out.println("Ya esta en la queue, asi que saco del new path el [" +(newPath.get(newPath.size()-1).getI())+ "][" +(newPath.get(newPath.size()-1).getJ())+ "]");
							newPath.remove(newPath.size()-1);
						}
					}
				}
			}
			newPath.clear();
		}
		return hasSolution;
	}
	
	public void printSol() {
		
	}

	public Box getBoxAt(Box box) {
		if(isInBounds(box.getI(), box.getJ())) return this.maze[box.getI()][box.getJ()];
		return null;
	}

}
