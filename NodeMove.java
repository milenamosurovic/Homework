package minesweeper;

public class NodeMove {

	Move move;
	NodeMove next;
	public NodeMove(Move move, NodeMove next) {
		super();
		this.move = move;
		this.next = next;
	}
	public NodeMove(Move move) {
		super();
		this.move = move;
		this.next = null;
	}

	
}
