package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AbstractArtistsActorDanceFilmmakerTest {
  private String firstName;
  private String lastName;
  private Name name;
  private int age;
  private String startYear;
  private String endYear;
  private String activeYears;
  private ArrayList<Genre> genres;
  private ArrayList<String> awards;
  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;
  private AbstractArtistsActorDanceFilmmaker artist;


  @Before
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
    this.movies = new ArrayList<>();
    this.series = new ArrayList<>();
    this.otherMultimedia = new ArrayList<>();
    this.artist = new Actor(this.name, this.age, this.activeYears,
        this.genres, this.awards, this.movies, this.series, this.otherMultimedia);
  }

  @Test
  public void getMovies() throws Exception {
    assertEquals(this.movies, this.artist.getMovies());
  }

  @Test
  public void getSeries() throws Exception {
    assertEquals(this.series, this.artist.getSeries());
  }

  @Test
  public void getOtherMultimedia() throws Exception {
    assertEquals(this.otherMultimedia, this.artist.getOtherMultimedia());
  }

  @Test
  public void addMovie() throws Exception {
    String movie = "Spiderman";
    this.artist.addMovie(movie);
    assertEquals(this.movies, this.artist.getMovies());
  }

  @Test
  public void addSeries() throws Exception {
    String series = "Game of Thrones";
    this.series.add(series);
    assertEquals(this.series, this.artist.getSeries());
  }

  @Test
  public void addOtherMultimedia() throws Exception {
    String otherMultimedia = "Behaviour arts";
    this.otherMultimedia.add(otherMultimedia);
    assertEquals(this.otherMultimedia, this.artist.getOtherMultimedia());
  }

}