package types;

public class Match {
	
	private Integer matchId;
	private String botType;
	private Result result;
	private Integer timeMs;
	private Integer totalClicks;
	
	public Match(Integer matchId, String botType, Result result, Integer timeMs, Integer totalClicks) {
		this.matchId = matchId;
		this.botType = botType;
		this.result = result;
		this.timeMs = timeMs;
		this.totalClicks = totalClicks;
	}
	
	public Integer getMatchId() {return matchId;}
	public String getBotType() {return botType;}
	public Result getResul() {return result;}
	public Integer getTimeMs() {return timeMs;}
	public Integer getTotalClicks() {return totalClicks;}
	
	@Override
	public String toString() {
		return "MatchId #" + matchId + " [" + result + "] " + "Clicks=" + totalClicks + " Time=" + timeMs + "ms";
	}
	
}
