import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Owner owner;

    @Before
    public void setUp() throws Exception {
        this.firstName = "Alice";
        this.lastName = "Francis";
        this.phoneNumber = "2062263212";
        this.owner = new Owner(firstName, lastName, phoneNumber);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(this.firstName, owner.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        String anotherFirstName = "Alexa";
        owner.setFirstName(anotherFirstName);
        assertEquals(anotherFirstName, owner.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        String antherLastName = "Stark";
        owner.setLastName(antherLastName);
        assertEquals(antherLastName, owner.getLastName());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals(this.phoneNumber, owner.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        String anotherPhoneNumber = "2063904145";
        owner.setPhoneNumber(anotherPhoneNumber);
        assertEquals(anotherPhoneNumber, owner.getPhoneNumber());
    }

}