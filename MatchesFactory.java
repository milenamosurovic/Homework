package types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MatchesFactory {
	
	public static Match parseMatch(String lines) {
		
		String[] info = lines.split(",");
		
		Integer matchId = Integer.valueOf(info[0].trim());
		String botType = info[1].trim();
		Result result = Result.valueOf(info[2].trim().toUpperCase());
		Integer timeMs = Integer.valueOf(info[3].trim());
		Integer totalClicks = Integer.valueOf(info[4].trim());
		
		return new Match(matchId, botType, result, timeMs, totalClicks);
	}
	
	public static MatchDataSheet createDateSheet(String matchesFile) {
		
		List<Match> matches = new ArrayList<>();
		
		try {
			matches = Files.lines(Paths.get(matchesFile))
								.skip(1)
								.map(MatchesFactory::parseMatch)
								.toList();
		} catch(IOException e) { e.printStackTrace();}
		
		return new MatchDataSheet(matches);
	}

}
