package minesweeper;

public class Test {
	  public static void printBoard(Board board, boolean revealAll) {

	        for (int row = 0; row < board.getSize(); row++) {

	            for (int col = 0; col < board.getSize(); col++) {

	                Cell cell = board.getCell(row, col);

	                // Debug mode -> reveal everything
	                if (revealAll) {

	                    if (cell.isMine()) {
	                        System.out.print("* ");
	                    } else {
	                        System.out.print(
	                            cell.getAdjacentMines() + " "
	                        );
	                    }

	                    continue;
	                }

	                // Normal gameplay printing
	                if (cell.getState() == CellState.HIDDEN) {

	                    System.out.print("# ");

	                } else if (cell.isMine()) {

	                    System.out.print("* ");

	                } else {

	                    System.out.print(
	                        cell.getAdjacentMines() + " "
	                    );
	                }
	            }

	            System.out.println();
	        }
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board b= new Board(5,5);
		
		System.out.println("First board");
		printBoard(b, false);
		
		  System.out.println("\nRevealing cell (0,0)...");
	        b.revealCell(0, 0);
	        

	        System.out.println("\n=== BOARD AFTER REVEAL ===");
	        printBoard(b, false);
	        
	        System.out.println("Game state" + b.getGameState());
	        
	        
	        System.out.println("\n=== FULL BOARD (DEBUG) ===");
	        printBoard(b, true);
	}

}
