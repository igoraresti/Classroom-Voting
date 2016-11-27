package database;

import static org.junit.Assert.*;


import java.util.List;


import org.junit.Test;

import model.User;

public class DataBaseTest {
	
	
	@Test
    public void should_be_able_to_get_single_user(){
    	DataBase database = DataBase.getInstance();
    	assertEquals("Usuario", database.getUser(0).getFirstName());
    	assertEquals("Prueba", database.getUser(0).getLastName());
    }

    @Test
    public void should_be_able_to_get_users_list() {
    	DataBase database = DataBase.getInstance();
    	List<User> usersList = database.getUsers();
    	User newUser = new User("Foo", "Bar");
    	usersList.add(newUser);
        assertEquals(usersList, database.getUsers());
    }
    
    @Test
    public void should_be_able_to_add_user(){
    	DataBase database = DataBase.getInstance();
    	User newUser = new User("Foo", "Bar");
    	database.addUser(newUser);
    	assertEquals(newUser.getFirstName(), database.getUser(1).getFirstName());
    }
    
    @Test
    public void should_be_able_to_get_single_vote(){
    	DataBase database = DataBase.getInstance();
    	assertEquals(0,database.getVote(0).getTimeVotes());
    }
    
    @Test
    public void should_be_able_to_sum_user_vote(){
    	DataBase database = DataBase.getInstance();
    	int numberVotes = database.getVote(0).getTimeVotes();
    	numberVotes++;
    	database.getVote(0).setTimeVotes(database.getVote(0).getTimeVotes()+1);
    	assertEquals(numberVotes,database.getVote(0).getTimeVotes());
    }


}
