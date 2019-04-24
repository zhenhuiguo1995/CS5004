package assignment0;

import static org.junit.Assert.*;

import assignment0.Author;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  private String name;
  private String email;
  private String address;
  private Author author;

  @Before
  public void setUp() throws Exception {
    this.name = "Renly Baretheon";
    this.email = "renly@gamesofthrones.edu";
    this.address = "535 Pontius Ave";
    this.author = new Author(name, email, address);
  }

  @Test
  public void getName() throws Exception {
    assertEquals(this.name, this.author.getName());
  }

  @Test
  public void getEmail() throws Exception {
    assertEquals(this.email, this.author.getEmail());
  }

  @Test
  public void getAddress() throws Exception {
    assertEquals(this.address, this.author.getAddress());
  }

}