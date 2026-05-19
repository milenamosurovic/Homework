package types;

import java.util.List;

public class MatchDataSheet {
	
	private List<Match> matches;
	
	public MatchDataSheet(List<Match> matches) {
		this.matches = matches;
	}
	
	public Double calculateWinRate() {
		if(matches.isEmpty() || matches == null) return 0.0;
		Integer w = Math.toIntExact(matches.stream()
					.filter(m -> m.getResul().equals(Result.VICTORY))
					.count());
		return (double) (w/matches.size())*100;
	}
	
	public Double averageClicksOnVictory() {
		return matches.stream()
					.filter(m -> m.getResul().equals(Result.VICTORY))
					.mapToInt(Match::getTotalClicks)
					.average()
					.orElse(0.0);
	}
	
	public Match findFastestVictory() {
		return matches.stream()
				.filter(r -> r.getResul().equals(Result.VICTORY))
				.min((m1, m2) -> Integer.compare(m1.getTimeMs(), m2.getTimeMs()))
				.orElse(null);
	}
	
	
	

}
