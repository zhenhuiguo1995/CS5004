package assignment1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private Author author;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Arya";
    this.lastName = "Stark";
    this.email = "arya.stark@got.com";
    this.address = "Winterfell, North";
    this.author = new Author(firstName, lastName, email, address);
  }

  @Test
  public void getEmail() throws Exception {
    assertEquals(this.email, author.getEmail());
  }

  @Test
  public void getAddress() throws Exception {
    assertEquals(this.address, author.getAddress());
  }

}