package minesweeper;

public class Move {

	int row;
	int column;
	boolean wasSafe;
	
	public Move(int row, int column, boolean wasSafe) {
		super();
		this.row = row;
		this.column = column;
		this.wasSafe = wasSafe;
	}
	
}
