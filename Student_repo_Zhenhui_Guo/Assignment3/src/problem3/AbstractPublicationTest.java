package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractPublicationTest {
  private String title;
  private Integer year;
  private String firstName;
  private String lastName;
  private Author author;
  private AbstractPublication publication;
  private String conferenceName;
  private MONTH month;
  private String city;
  private String country;
  private Location location;

  @Before
  public void setUp() throws Exception {
    this.title = "A chronicle of wars following King Robert's death";
    this.year = 2017;
    this.firstName = "George";
    this.lastName = "Martin";
    this.author = new Author(this.firstName, this.lastName);
    this.conferenceName = "Annual Meeting of the old Town";
    this.month = MONTH.Dec;
    this.city = "The old Town";
    this.country = "The Seven Kingdoms";
    this.location = new Location(this.city, this.country);
    this.publication = new Conference(this.title, this.author, this.year,
        this.conferenceName, this.month, this.location);
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearTooSmall() throws Exception {
    this.year = 123;
    this.publication = new Conference(this.title, this.author, this.year,
        this.conferenceName, this.month, this.location);
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearTooLarge() throws Exception {
    this.year = 12345;
    this.publication = new Conference(this.title, this.author, this.year,
        this.conferenceName, this.month, this.location);
  }

  @Test
  public void getTitle() throws Exception {
    assertEquals(this.title, this.publication.getTitle());
  }

  @Test
  public void getAuthor() throws Exception {
    assertEquals(this.author, this.publication.getAuthor());
  }

  @Test
  public void getYear() throws Exception {
    assertEquals(this.year, this.publication.getYear());
  }

}