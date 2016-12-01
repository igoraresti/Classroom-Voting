package database;

import static org.junit.Assert.*;


import java.util.List;


import org.junit.Test;

import model.User;

public class DataBaseTest {
	
	
	@Test
    public void should_be_able_to_get_single_user(){
    	DataBase database = DataBase.getInstance();
    	User user = new User();
    	database.addUser(user);
    	assertEquals(user, database.getUser(user.getId()));
    }

    @Test
    public void should_be_able_to_get_users_list() {
    	DataBase database = DataBase.getInstance();
    	List<User> usersList = database.getUsers();
    	User newUser = new User("Foo", "Bar");
    	usersList.add(newUser);
    	database.addUser(newUser);
        assertEquals(usersList, database.getUsers());
    }
    
    @Test
    public void should_be_able_to_add_user(){
    	DataBase database = DataBase.getInstance();
    	User newUser = new User("Foo", "Bar");
    	assertEquals(database.addUser(newUser), newUser);
    }
    
    @Test
    public void should_be_able_to_get_single_vote(){
    	DataBase database = DataBase.getInstance();
    	assertEquals(0,database.getVote(Data.ID_HORA1).getTimeVotes());
    }
    
    @Test
    public void should_be_able_to_sum_user_vote(){
    	DataBase database = DataBase.getInstance();
    	int numberVotes = database.getVote(Data.ID_HORA1).getTimeVotes();
    	numberVotes++;
    	database.getVote(Data.ID_HORA1).setTimeVotes(database.getVote(Data.ID_HORA1).getTimeVotes()+1);
    	assertEquals(numberVotes,database.getVote(Data.ID_HORA1).getTimeVotes());
    }


}
