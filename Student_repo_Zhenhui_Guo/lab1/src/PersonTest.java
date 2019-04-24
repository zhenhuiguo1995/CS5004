import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private String firstName;
    private String lastName;
    private Person person;

    @Before
    public void setUp() throws Exception {
        this.firstName = "Tommen";
        this.lastName = "Lannister";
        this.person = new Person(firstName, lastName);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(this.firstName, this.person.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals(this.lastName, this.person.getLastName());
    }

    @Test
    public void setFirstName() throws Exception {
        String firstName = "Cersi";
        this.person.setFirstName(firstName);
        assertEquals(firstName, this.person.getFirstName());
    }

    @Test
    public void setLastName() throws Exception {
        String lastName = "Tyrell";
        this.person.setLastName(lastName);
        assertEquals(lastName, this.person.getLastName());
    }

}