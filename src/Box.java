public class Box {
	
	private int value;
	
	private boolean visited;
	
	boolean prize;
	
	public Box(int value, boolean prize) {
		this.value = value;
		this.prize = prize;
		visited= false;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isPrize() {
		return prize;
	}

	public void setPrize(boolean prize) {
		this.prize = prize;
	}
	
	
}
