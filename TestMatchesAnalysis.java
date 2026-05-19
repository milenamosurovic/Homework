package tests;

import types.Match;
import types.MatchDataSheet;
import types.MatchesFactory;

public class TestMatchesAnalysis {

	public static void main(String[] args) {
		
		String matchesFile = "C:\\Users\\chris\\Desktop\\000 Projects\\000 Soft. Eng\\1st year\\FP-Java\\eclipse workspace\\Minesweeper_Data_Analysis\\data\\SimulatorResults.csv";
		
		MatchDataSheet data = MatchesFactory.createDateSheet(matchesFile);
		
		Double winRate = data.calculateWinRate();
		Double aveClicksOnVictory = data.averageClicksOnVictory();
		Match fastestVictory = data.findFastestVictory();
		
		

		System.out.println("The win rate is of " + winRate + "%");
		System.out.println("The average clicks on a Victory is " + aveClicksOnVictory);
		System.out.println("The fastest victory is: " + fastestVictory);
	
	}

}
