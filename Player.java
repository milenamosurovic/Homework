package minesweeper;

import java.util.Random;

public class Player {

	MyLinkedList myLinkedList;
	Board board;
	
	public Player(Board board) {
		super();
		this.board = board;
		this.myLinkedList= new MyLinkedList();
	}

	GameOutcome PlayTurn() {
		Random rnd = new Random();
		
		int row;
		int column;
		
		do {
			row = rnd.nextInt(board.getSize());
			column = rnd.nextInt(board.getSize());
		} while(board.getCell(row, column).getState() != CellState.HIDDEN);
		
		board.revealCell(row, column);
		boolean wasSafe = !board.getCell(row, column).isMine();
		Move move = new Move(row, column, wasSafe);
		myLinkedList.insert(move);
		return board.getGameState();
	}
	
	MyLinkedList getMoveHistory(){
		
		return myLinkedList;
	}
	
}
