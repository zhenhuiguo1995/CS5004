package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.ActiveYears;

public class AuthorTest {
  private String firstName;
  private String lastName;
  private Author author;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Jamie";
    this.lastName = "Stanley";
    this.author = new Author(this.firstName, this.lastName);
  }

  @Test
  public void getFirstName() throws Exception {
    assertEquals(this.firstName, this.author.getFirstName());
  }

  @Test
  public void getLastName() throws Exception {
    assertEquals(this.lastName, this.author.getLastName());
  }

}