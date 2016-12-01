package database;

import java.util.*;


import model.FreeTime;
import model.User;
import service.ReadWriteMap;

public class DataBase {
	
	private static Map<String, User> userMap = new HashMap<>();
	private static Map<String, FreeTime> freeTimeMap = new HashMap<>();
	
	private static ReadWriteMap<String, User> rwUserLocker = new ReadWriteMap<String, User>(userMap);
	private static ReadWriteMap<String, FreeTime> rwFreeTimeLocker = new ReadWriteMap<String, FreeTime>(freeTimeMap);
	
	
	private DataBase() {
		//userMap.put("1", new User("Usuario", "Prueba"));
		
		freeTimeMap.put(Data.ID_HORA1, new FreeTime(Data.HORA1, 0));
		freeTimeMap.put(Data.ID_HORA2, new FreeTime(Data.HORA2, 0));
		freeTimeMap.put(Data.ID_HORA3, new FreeTime(Data.HORA3, 0));
	}

	public void clearAll() {
		freeTimeMap.clear();
		userMap.clear();
	}

	private static class SingletonHolder {
		private static final DataBase INSTANCE = new DataBase();
	}

	public static DataBase getInstance() {
		return SingletonHolder.INSTANCE;
	}

	// User methods

	public User addUser(User user) {
		final String id = user.getId() == null ? UUID.randomUUID().toString() : user.getId();
		user.setId(id);
		rwUserLocker.put(id, user);
		return user;
	}

	/*
	 * getUser method used for testing in DataBaseTest
	 */

	public User getUser(String id) {
		return rwUserLocker.get(id);
	}

	/*
	 * getUser needs synchronization
	 */
	public List<User> getUsers() {
		return new ArrayList<User>(rwUserLocker.getAll());
	}

	/*
	 * FreeTime methods
	 */

	/*
	 * sumVote needs synchronization
	 */

	public boolean sumVote(String time) {
		// Variable para controlar si el voto se ha sumado o no
		boolean voteSuccess = false;
		for (FreeTime f : freeTimeMap.values()) {
			if (f.getTimeOptions().equals(time)) {
				f.setTimeVotes(f.getTimeVotes()+1);
				rwFreeTimeLocker.put(time, f);
				voteSuccess = true;
			}
		}
		return voteSuccess;
	}

	/*
	 * getVote method used for testing in DataBaseTest
	 */
	public FreeTime getVote(String id) {
		return rwFreeTimeLocker.get(id);
	}

	/*
	 * getVotes needs synchronization
	 */
	public List<FreeTime> getVotes() {
		return new ArrayList<FreeTime>(rwFreeTimeLocker.getAll());
	}

}
