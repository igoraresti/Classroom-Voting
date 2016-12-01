package model;

public class FreeTime {
	
	private String timeOption;
	private int timeVotes;
	private String id;
	
	public FreeTime(String timeOption, int timeVotes){
		this.timeOption = timeOption;
		this.timeVotes = timeVotes;
		this.id = timeOption;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
