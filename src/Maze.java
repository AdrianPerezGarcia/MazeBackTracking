import java.util.ArrayList;

public class Maze {
	
	private Box[][] maze;
	
	private ArrayList<ArrayList<Box>> roads;
	
	public Maze(Box[][] maze) {
		this.maze = maze;
		this.roads = new ArrayList<>();
	}

	public Box getBoxAt(int x, int y) {
		if(isInBounds(x,y)) return maze[x][y];
		else return null;
		
	}

	public void addRoad(ArrayList<Box> road) {
		roads.add(road);
	}
	
	public boolean isInBounds(int i, int j) {
		return(i >= 0 && i < this.maze.length && j >= 0 && j < this.maze.length);
	}

	public boolean canGoUp(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.upAvaliable();
		
		return false;
	}

	public boolean canGoDown(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.downAvaliable();
		
		return false;
	}

	public boolean canGoLeft(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.leftAvaliable();
		
		return false;
	}

	public boolean canGoRight(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.rightAvaliable();
		
		return false;
	}

	public boolean canGoUpLeft(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.upLeftAvaliable();
		
		return false;
	}

	public boolean canGoUpRight(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.upRightAvaliable();
		
		return false;
	}

	public boolean canGoDownLeft(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.downLeftAvaliable();
		
		return false;
	}

	public boolean canGoDownRight(Box actualBox, Box destinyBox) {
		if(destinyBox != null && !destinyBox.isVisited())
			return actualBox.downRightAvaliable();
		
		return false;
	}
	
	public Box[][] getMaze() {
		return maze;
	}

	public void setMaze(Box[][] maze) {
		this.maze = maze;
	}

	public ArrayList<ArrayList<Box>> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<ArrayList<Box>> roads) {
		this.roads = roads;
	}

	public Box[] getShortestRoad() {
		int min = Integer.MAX_VALUE;
		Box[] result = null;
		for (int i = 0; i < roads.size(); i++) {
			if(min > roads.get(i).size()) {
				min = roads.get(i).size();
				result = roads.get(i).toArray(new Box[roads.get(i).size()]);
				System.out.println("Nuevo resultado optimo (" +min+ ") en " +i);
			}
		}
		return result;
	}

}
