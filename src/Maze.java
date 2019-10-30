import java.util.*;

public class Maze {

	private Box[][] maze;

	private int[] posibleY = { 1, -1, 0, 0, -1, -1, 1, 1 };

	private int[] posibleX = { 0, 0, -1, 1, -1, 1, -1, 1 };

	private Queue<Box[]> queue = new LinkedList<Box[]>();

	private Box[] sol;

	public Maze(Box[][] maze) {
		this.maze = maze;
	}

	public int getLength() {
		return this.maze.length;
	}

	public Box[] getSol() {
		return this.sol;
	}

	public Box getBoxAt(int i, int j) {
		if (isInBounds(i, j))
			return this.maze[i][j];
		return null;

	}

	public Box getBoxAt(Box box) {
		if (isInBounds(box.getI(), box.getJ()))
			return this.maze[box.getI()][box.getJ()];
		return null;
	}

	public boolean isInBounds(int i, int j) {
		return (i >= 0 && i < this.maze.length && j >= 0 && j < this.maze.length);
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
		Box[] path = { startBox };
		ArrayList<Box> newPath = new ArrayList<>();
		queue.add(path);
		while (!queue.isEmpty() && !exit) {
			path = queue.remove();
			node = path[path.length - 1];
			visited[node.getI()][node.getJ()] = true;
			for (int i = 0; i < path.length; i++) {
				newPath.add(path[i]);
			}
			for (int i = 0; i < posibleX.length; i++) {
				if (isInBounds(node.getI() + posibleY[i], node.getJ() + posibleX[i])) {
					Box neighbour = getBoxAt(node.getI() + posibleY[i], node.getJ() + posibleX[i]);
					if (neighbour.getValue() != 1 && !(visited[neighbour.getI()][neighbour.getJ()])) {
						if (neighbour.equals(endBox)) {
							newPath.add(neighbour);
							sol = newPath.toArray(new Box[newPath.size()]);
							exit = true;
							hasSolution = true;
							break;
						} else {
							newPath.add(neighbour);
							queue.add(newPath.toArray(new Box[newPath.size()]));
							newPath.remove(newPath.size() - 1);
						}
					}
				}
			}
			newPath.clear();
		}
		return hasSolution;
	}

}
