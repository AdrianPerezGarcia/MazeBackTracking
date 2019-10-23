public class Box {
	
	private int value;
	
	private int i;
	
	private int j;
	
	private boolean visited;
	
	boolean prize;
	
	private boolean[] movementsAllowed;
	
	public Box(int value, int i, int j, boolean prize, boolean[] movementsAllowed) {
		this.value = value;
		this.i = i;
		this.j = j;
		this.prize = prize;
		this.movementsAllowed = movementsAllowed;
		visited= false;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	public boolean upAvaliable() {
		return movementsAllowed[0];
	}
	
	public boolean downAvaliable() {
		return movementsAllowed[1];
	}
	
	public boolean leftAvaliable() {
		return movementsAllowed[2];
	}
	
	public boolean rightAvaliable() {
		return movementsAllowed[3];
	}
	
	public boolean upLeftAvaliable() {
		return movementsAllowed[4];
	}
	
	public boolean upRightAvaliable() {
		return movementsAllowed[5];
	}
	
	public boolean downLeftAvaliable() {
		return movementsAllowed[6];
	}
	
	public boolean downRightAvaliable() {
		return movementsAllowed[7];
	}
	
	public boolean equals(Box box2) {
		return (this.i == box2.getI() && this.j == box2.getJ());
		
	}

	@Override
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append("(").append(i).append(",").append(j).append(")");
		if(prize) result.append("*");
		return result.toString();
	}
}
