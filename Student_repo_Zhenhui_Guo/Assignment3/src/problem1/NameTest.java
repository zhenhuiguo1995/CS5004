package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private String firstName;
  private String lastName;
  private Name name;

  @Before
  public void setUp() {
    this.firstName = "Alice";
    this.lastName = "Goodman";
    this.name = new Name(this.firstName, this.lastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(this.firstName, name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(this.lastName, name.getLastName());
  }

}