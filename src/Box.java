public class Box {

	private int i;

	private int j;

	private int value;

	private boolean prize;

	public Box(int i, int j, int value, boolean prize) {
		this.value = value;
		this.i = i;
		this.j = j;
		this.prize = prize;
	}

	public int getI() {
		return this.i;
	}

	public int getJ() {
		return this.j;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isPrize() {
		return this.prize;
	}

	@Override
	public String toString() {
		return ("(" + (this.i + 1) + "," + (this.j + 1) + ")");
	}

}
