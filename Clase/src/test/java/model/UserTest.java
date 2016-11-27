package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User user;
    String nullString = null;
	
	@Before
	public void setUp() {
	    user = new User ("Thomas", "Brown");
	}
	
	@Test
	public void should_create_user_object(){
		assertEquals(user.getFirstName(),"Thomas");
	}
	
	@Test
	public void testTrue() {
		assertEquals(true, true);
	}
	
	

}
