package model;

public class FreeTime {
	
	private String timeOption;
	private int timeVotes;
	
	public FreeTime(String timeOption, int timeVotes){
		this.timeOption = timeOption;
		this.timeVotes = timeVotes;
	}
	
	public String getTimeOptions() {
		return timeOption;
	}
	public void setTimeOptions(String timeOption) {
		this.timeOption = timeOption;
	}
	public int getTimeVotes() {
		return timeVotes;
	}
	public void setTimeVotes(int timeVotes) {
		this.timeVotes = timeVotes;
	}
	
	
	

}
