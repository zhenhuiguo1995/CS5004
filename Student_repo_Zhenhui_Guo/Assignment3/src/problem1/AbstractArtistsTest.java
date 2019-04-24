package problem1;

import static org.junit.Assert.*;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.ArrayList;

public class AbstractArtistsTest {
  private String firstName;
  private String lastName;
  private Name name;
  private int age;
  private String startYear;
  private String endYear;
  private String activeYears;
  private ArrayList<Genre> genres;
  private ArrayList<String> awards;
  private AbstractArtists artist;

  @org.junit.Before
  public void setUp() throws Exception {
    this.firstName = "Tyrion";
    this.lastName = "Lannister";
    this.name = new Name(this.firstName, this.lastName);
    this.age = 23;
    this.startYear = "1998";
    this.endYear = "current";
    this.activeYears = new ActiveYears(this.startYear, this.endYear).getString();
    this.genres = new ArrayList<>();
    this.genres.add(Genre.POPULAR_CULTURE);
    this.awards = new ArrayList<>();
    this.awards.add("First class honor");
    this.artist = new Musician(this.name, this.age, this.activeYears, this.genres, this.awards);
  }

  @org.junit.Test
  public void getName() throws Exception {
    assertEquals(this.name, this.artist.getName());
  }

  @org.junit.Test
  public void getAge() throws Exception {
    assertEquals(this.age, this.artist.getAge());
  }

  @org.junit.Test
  public void getActiveYears() throws Exception {
    assertEquals(this.activeYears, this.artist.getActiveYears());
  }

  @org.junit.Test
  public void getGenre() throws Exception {
    assertEquals(this.genres, this.artist.getGenre());
  }

  @org.junit.Test
  public void getAwards() throws Exception {
    assertEquals(this.awards, this.artist.getAwards());
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void ageNegative() throws Exception {
    this.age = -1;
    this.artist = new Musician(this.name, this.age, this.activeYears, this.genres, this.awards);
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void ageOverflow() throws Exception {
    this.age = 129;
    this.artist = new Musician(this.name, this.age, this.activeYears, this.genres, this.awards);
  }

}