package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {
  private String city;
  private String country;
  private Location location;

  @Before
  public void setUp() throws Exception {
    this.city = "Los Angelos";
    this.country = "US";
    this.location = new Location(this.city, this.country);
  }

  @Test
  public void getCity() throws Exception {
    assertEquals(this.city, this.location.getCity());
  }

  @Test
  public void getCountry() throws Exception {
    assertEquals(this.country, this.location.getCountry());
  }

}