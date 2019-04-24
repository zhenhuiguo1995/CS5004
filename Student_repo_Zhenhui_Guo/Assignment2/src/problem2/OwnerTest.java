package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OwnerTest {
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private Owner owner;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Donald";
    this.lastName = "Stanley";
    this.address = "376 Brooklyn St.";
    this.email = "donald.standley@morgan.com";
    this.owner = new Owner(firstName, lastName, address, email);
  }

  @Test
  public void getFirstName() throws Exception {
    assertEquals(this.firstName, this.owner.getFirstName());
  }

  @Test
  public void getLastName() throws Exception {
    assertEquals(this.lastName, this.owner.getLastName());
  }

  @Test
  public void getAddress() throws Exception {
    assertEquals(this.address, this.owner.getAddress());
  }

  @Test
  public void getEmail() throws Exception {
    assertEquals(this.email, this.owner.getEmail());
  }


}