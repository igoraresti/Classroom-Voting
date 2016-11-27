package database;

import java.util.ArrayList;
import java.util.List;

import model.FreeTime;
import model.User;


public class DataBase {

	private static final String hora1 = "12:30";
	private static final String hora2 = "12:45";
	private static final String hora3 = "13:00";
	
	private static List<User> usersList = new ArrayList<User>();;
	private static List<FreeTime> votesList = new ArrayList<FreeTime>();
	

	private DataBase() {
		usersList.add(new User("Usuario", "Prueba"));
		
		votesList.add(new FreeTime(hora1, 0));
		votesList.add(new FreeTime(hora2,0));
		votesList.add(new FreeTime(hora3,0));
	}
	
	public void clearAll() {
		usersList.clear();
		votesList.clear();
	}
	
	private static class SingletonHolder {
			private static final DataBase INSTANCE = new DataBase();
    }

    public static DataBase getInstance() {
        return SingletonHolder.INSTANCE;
    }

	public void addUser(User user){
		if(usersList.indexOf(user)==-1)
			usersList.add(user);
	}
	
	public User getUser(int index){
		return usersList.get(index);
	}

	public List<User> getUsers() {
		return usersList;
	}

	public void sumVote(String time) {
		for(FreeTime f: votesList){
			if(f.getTimeOptions().equals(time)){
				f.setTimeVotes(f.getTimeVotes()+1);
			}
		}
	}
	
	public void addNewOption(FreeTime newOption){
		votesList.add(newOption);
	}

	public FreeTime getVote(int index){
		return votesList.get(index);
	}
	public List<FreeTime> getVotes(){
		return votesList;
	}

}
