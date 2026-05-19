package minesweeper;

public class Board {

private Cell [][] grid;
private int size;
private int numMines;

public Cell getCell(int row, int col) {
    return grid[row][col];
}

public int getSize() {
    return size;
}

public int getNumMines() {
    return numMines;
}

private static final int[] dx= {
		-1,-1,-1,
		0,0,
		1,1,1
};
private static final int[] dy= {
		-1,0,1,
		-1,0,
		-1,0,1
};

private boolean isInBounds(int row, int col) {

    return row >= 0 &&
           row < size &&
           col >= 0 &&
           col < size;
}

private void placeMines() {
	int placed=0;
	while(placed<numMines) {
		int row=(int)(Math.random()* size);
		int col=(int)(Math.random()* size);
		
		if(!grid[row][col].isMine()) {
			grid[row][col].setMine(true);
			placed++;
		}
		
		
	}
}

private void calculateAdjacentMines() {

    for (int row = 0; row < size; row++) {

        for (int col = 0; col < size; col++) {

            if (grid[row][col].isMine()) {
                continue;
            }

            int count = 0;

            for (int i = 0; i < 8; i++) {

                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (isInBounds(newRow, newCol) &&
                    grid[newRow][newCol].isMine()) {

                    count++;
                }
            }

            grid[row][col].setAdjacentMines(count);
        }
    }
}

public Board(int size, int numMines) {
	if(size <= 0) {
		throw new IllegalArgumentException("Board size must me positive");
	}
	
	if(numMines<=0 || numMines>=size*size) {
		throw new IllegalArgumentException("Number of mines is too large or less than 0");
	}
	
	this.size=size;
	this.numMines=numMines;
	
	
	grid=new Cell[size][size];
	
	for(int row=0;row<size;row++) {
		for(int col=0;col<size;col++){
			grid[row][col]=new Cell(false,CellState.HIDDEN,0);
			
		}
		
	}
	
	placeMines();
	
	calculateAdjacentMines();
	///////////////////////////////////
	/////////////////////////
	
	
	}

public void revealCell(int row, int col) {

    if (!isInBounds(row, col)) {
        return;
    }

    Cell startCell = grid[row][col];

    // Ignore revealed or flagged cells
    if (startCell.getState() != CellState.HIDDEN) {
        return;
    }

    // Reveal first cell
    startCell.setState(CellState.REVEALED);

    // If mine -> game over
    if (startCell.isMine()) {
        return;
    }

    // BFS queue
    CoordinateQueue queue = new CoordinateQueue();

    // Cascade only for zero cells
    if (startCell.getAdjacentMines() == 0) {

        queue.enqueue(row, col);

        while (!queue.isEmpty()) {

            CoordinateQueue.Coordinate current =
                queue.dequeue();

            int currentRow = current.getRow();
            int currentCol = current.getCol();

            for (int i = 0; i < 8; i++) {

                int newRow = currentRow + dx[i];
                int newCol = currentCol + dy[i];

                if (!isInBounds(newRow, newCol)) {
                    continue;
                }

                Cell neighbor = grid[newRow][newCol];

                if (neighbor.getState() == CellState.HIDDEN &&
                    !neighbor.isMine()) {

                    neighbor.setState(CellState.REVEALED);

                    if (neighbor.getAdjacentMines() == 0) {
                        queue.enqueue(newRow, newCol);
                    }
                }
            }
        }
    }
}

public GameOutcome getGameState() {

    boolean allSafeRevealed = true;

    for (int row = 0; row < size; row++) {

        for (int col = 0; col < size; col++) {

            Cell cell = grid[row][col];

            // Defeat condition
            if (cell.isMine() &&
                cell.getState() == CellState.REVEALED) {

                return GameOutcome.DEFEAT;
            }

            // Victory check
            if (!cell.isMine() &&
                cell.getState() != CellState.REVEALED) {

                allSafeRevealed = false;
            }
        }
    }

    if (allSafeRevealed) {
        return GameOutcome.VICTORY;
    }

    return GameOutcome.IN_PROGRESS;
}



}






    

	    
	    
	    
	
	
	
	
	
	
	
	
	

