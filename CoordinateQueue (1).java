package minesweeper;

public class CoordinateQueue {
	  private static class CoordinateNode {
	        int row;
	        int col;
	        CoordinateNode next;

	        CoordinateNode(int row, int col) {
	            this.row = row;
	            this.col = col;
	            this.next = null;
	        }
	    }

	  public static class Coordinate {
	        private int row;
	        private int col;

	        public Coordinate(int row, int col) {
	            this.row = row;
	            this.col = col;
	        }

	        public int getRow() {
	            return row;
	        }

	        public int getCol() {
	            return col;
	        }
	    }
	  
	   private CoordinateNode front;
	    private CoordinateNode rear;
	    private int size;

	    public CoordinateQueue() {
	        front = null;
	        rear = null;
	        size = 0;
	    }

	    // Add coordinate to queue
	    public void enqueue(int row, int col) {
	        CoordinateNode newNode = new CoordinateNode(row, col);

	        if (rear == null) {
	            front = newNode;
	            rear = newNode;
	        } else {
	            rear.next = newNode;
	            rear = newNode;
	        }

	        size++;
	    }

	    // Remove and return front coordinate
	    public Coordinate dequeue() {
	        if (isEmpty()) {
	            return null;
	        }

	        Coordinate result = new Coordinate(front.row, front.col);

	        front = front.next;

	        if (front == null) {
	            rear = null;
	        }

	        size--;

	        return result;
	    }

	    // View front coordinate without removing it
	    public Coordinate peek() {
	        if (isEmpty()) {
	            return null;
	        }

	        return new Coordinate(front.row, front.col);
	    }

	    // Check whether queue is empty
	    public boolean isEmpty() {
	        return front == null;
	    }

	    // Current number of elements
	    public int size() {
	        return size;
	    }
	
	}
	

