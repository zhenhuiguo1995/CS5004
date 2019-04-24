package problem1;

import java.util.ArrayList;

/**
 * Represents information for the artists class.
 */
public abstract class AbstractArtists {
  private Name name;
  private int age;
  private String activeYears;
  private ArrayList<Genre> genre;
  private ArrayList<String> awards;

  /**
   * Creates an artists given name, age, active years, genre and awards.
   *
   * @param name the name of the artist.
   * @param age the age of the artist.
   * @param activeYears the active years of the artist.
   * @param genre the genre of the artist.
   * @param awards the awards that the artist has received.
   */
  public AbstractArtists(Name name, int age, String activeYears, ArrayList<Genre> genre,
      ArrayList<String> awards) throws Exception {
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("The age of an artist must be within 0~128");
    } else {
    this.name = name;
    this.age = age;
    this.activeYears = activeYears;
    this.genre = genre;
    this.awards = awards;
    }
  }

  /**
   * @return the name of the artist.
   */
  public Name getName() {
    return name;
  }

  /**
   * @return the age of the artist.
   */
  public int getAge() {
    return age;
  }

  /**
   * @return the active years of the artist.
   */
  public String getActiveYears() {
    return activeYears;
  }

  /**
   * @return the genre of the artist.
   */
  public ArrayList<Genre> getGenre() {
    return genre;
  }

  /**
   * @return the awards of the artist.
   */
  public ArrayList<String> getAwards() {
    return awards;
  }
}
