package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
		
	User target;
	
	@Before
	public void setup(){
		this.target = new User();
		target.setFirstName("Igor");
	}
	
	@Test
	public void sayTrue() {
		assertEquals(true, true);
	}
	
	@Test
    public void testSetFirstName() {
        assertEquals(target.getFirstName(), "Igor");
    }


}
