import java.util.ArrayList;

public class Maze {
	
	private Box[][] maze;
	
	private ArrayList<ArrayList<Box>> roads;
	
	public Maze(Box[][] maze) {
		this.maze = maze;
		this.roads = new ArrayList<>();
	}

	public Box getBoxAt(int x, int y) {
		return maze[x][y];
	}

	public void addRoad(ArrayList<Box> road) {
		roads.add(road);
	}
	
	public boolean isInBounds(int i, int j) {
		return(i >= 0 && i < this.maze.length && j >= 0 && j < this.maze.length);
	}

	public boolean canGoUp(Box actualBox, Box auxBox) {
		return actualBox.upAvaliable();
	}

	public boolean canGoDown(Box actualBox, Box auxBox) {
		return actualBox.downAvaliable();
	}

	public boolean canGoLeft(Box actualBox, Box auxBox) {
		return actualBox.leftAvaliable();
	}

	public boolean canGoRight(Box actualBox, Box auxBox) {
		return actualBox.rightAvaliable();
	}

	public boolean canGoUpLeft(Box actualBox, Box auxBox) {
		return actualBox.upLeftAvaliable();
	}

	public boolean canGoUpRight(Box actualBox, Box auxBox) {
		return actualBox.upRightAvaliable();
	}

	public boolean canGoDownLeft(Box actualBox, Box auxBox) {
		return actualBox.downLeftAvaliable();
	}

	public boolean canGoDownRight(Box actualBox, Box auxBox) {
		return actualBox.downRightAvaliable();
	}
}
