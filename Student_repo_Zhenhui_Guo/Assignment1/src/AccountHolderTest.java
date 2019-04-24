import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountHolderTest {
    private String firstName;
    private String lastName;
    private AccountHolder accountHolder;

    @Before
    public void setUp() throws Exception {
        this.firstName = "Samwell";
        this.lastName = "Tarlly";
        this.accountHolder = new AccountHolder(firstName, lastName);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(this.firstName, accountHolder.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        String anotherFirstName = "John";
        this.accountHolder.setFirstName(anotherFirstName);
        assertEquals(anotherFirstName, this.accountHolder.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals(this.lastName, accountHolder.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        String anotherLastName = "Snow";
        this.accountHolder.setLastName(anotherLastName);
        assertEquals(anotherLastName, this.accountHolder.getLastName());
    }

}