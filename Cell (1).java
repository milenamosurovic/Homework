package minesweeper;

public class Cell {

	private boolean mine;
	private CellState state;
	private int adjacentMines;
	public Cell(boolean mine, CellState state, int adjacentMines) {
		
		this.mine = mine;
		this.state = state;
		this.adjacentMines = adjacentMines;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public CellState getState() {
		return state;
	}
	public void setState(CellState state) {
		this.state = state;
	}
	public int getAdjacentMines() {
		return adjacentMines;
	}
	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}
	
	
	
}
