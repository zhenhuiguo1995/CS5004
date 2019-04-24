import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AuthorTest {
    private Person person;
    private Email email;
    private Address address;
    private Author author;

    @Before
    public void setUp() throws Exception {
        person = new Person("Renly", "Baratheon");
        email = new Email("njugzh", "gmail.com");
        address = new Address(535, "Pontius Ave.",
                "Seattle", "WA", 98109, "US");
        author = new Author(person, email, address);
    }

    @Test
    public void getPerson() throws Exception {
        assertEquals(person, author.getPerson());
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals(email, author.getEmail());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals(address, author.getAddress());
    }

    @Test
    public void setPerson() throws Exception {
        Person person = new Person("Jane", "Love");
        author.setPerson(person);
        assertEquals(person, author.getPerson());
    }

    @Test
    public void setEmail() throws Exception {
        Email email = new Email("guo.zhenhui", "husky.neu.edu");
        author.setEmail(email);
        assertEquals(email, author.getEmail());
    }

    @Test
    public void setAddress() throws Exception {
        Address address = new Address(1260, "Republican Street",
                "Seattle", "WA", 98179, "UK");
        author.setAddress(address);
        assertEquals(address, author.getAddress());
    }

}