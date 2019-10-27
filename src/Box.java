public class Box {
	
	private int i;
	
	private int j;
	
	private int value;
	
	private boolean visited;
	
	private boolean prize;
	
	public Box(int i, int j, int value, boolean prize) {
		this.value = value;
		this.i = i;
		this.j = j;
		this.prize = prize;
		visited= false;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
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
	
	@Override
	public String toString() {
		return("(" +(this.i+1)+ "," +(this.j+1)+ ")");
	}
	
}
