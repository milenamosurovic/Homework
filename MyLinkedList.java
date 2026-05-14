package minesweeper;

public class MyLinkedList {

	
	NodeMove head;
	
	public MyLinkedList() {
		super();
		this.head = null;
	}
	public NodeMove getHead() {
		return this.head;
	}
	//public void setHead(NodeMove head) {
	//	this.head = head;
	//}
	
	void insert(Move move) {
		NodeMove newNode = new NodeMove(move, this.head);
		this.head = newNode;
	}
	
	
}
