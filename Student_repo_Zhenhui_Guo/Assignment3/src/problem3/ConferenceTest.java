package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConferenceTest {
  private String title;
  private Integer year;
  private String firstName;
  private String lastName;
  private Author author;
  private Conference conference;
  private String conferenceName;
  private MONTH month;
  private String city;
  private String country;
  private Location location;

  @Before
  public void setUp() throws Exception {
    this.title = "Contract between the first Man and the White Walkers: a Glimpse";
    this.year = 2018;
    this.firstName = "Samwell";
    this.lastName = "Tarly";
    this.author = new Author(this.firstName, this.lastName);
    this.conferenceName = "Monthly Conference of the Night's Watch";
    this.month = MONTH.Apr;
    this.city = "BlackCastle";
    this.country = "The Seven Kingdoms";
    this.location = new Location(this.city, this.country);
    this.conference = new Conference(this.title, this.author, this.year,
        this.conferenceName, this.month, this.location);
  }

  @Test
  public void getConferenceName() throws Exception {
    assertEquals(this.conferenceName, this.conference.getConferenceName());
  }

  @Test
  public void getMonth() throws Exception {
    assertEquals(this.month, this.conference.getMonth());
  }

  @Test
  public void getLocation() throws Exception {
    assertEquals(this.location, this.conference.getLocation());
  }

}