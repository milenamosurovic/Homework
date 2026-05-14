package minesweeper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GamesSimulator {

	
	static Player createBot(Board board) {
		
		//Player p1 = new Player(board);
		return new Player(board);
	}
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 8;
		int numMines = 6;
		//Board board = new Board(size, numMines);
		
		String csvFile = "SimulatorResults.csv";
		try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))){
			writer.println("MatchId, BotType, Result, TimeMs, TotalClicks");
		
		for(int i = 1; i <= 1000; i++) {
			
			
//			if (i%50==15) {
//				System.out.println("I work for: " + i);
//			}
			
			Board board = new Board(size, numMines);
			
			Player p1 = createBot(board);
			GameOutcome results;
			long start = System.currentTimeMillis();
			results = p1.PlayTurn();
			
			while(results == GameOutcome.IN_PROGRESS) {
				results = p1.PlayTurn();
				
			}
			
			long finish = System.currentTimeMillis();		
			long timeMs = finish - start;
			
			MyLinkedList linkedList = p1.getMoveHistory();
			int totalClicks = 0;
			
			NodeMove p = linkedList.head;
			
			while(p != null) {
				totalClicks++;
				p = p.next;				
			}
			
			writer.println(i + ", " + "? " + ", " + results + ", " + timeMs + ", " + totalClicks);
			
		}
		}
		catch(IOException e) {
			System.out.println("Error writting CSV file: " + e.getMessage());
		}
		
	}
	
	

}
