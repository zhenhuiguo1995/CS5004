package problem1;

import java.util.ArrayList;

/**
 * Represents details of a dancer, including name, age, active years, genre, awards,
 * movies, series and other multimedia.
 */
public class Dancer extends AbstractArtistsActorDanceFilmmaker {

  /**
   * Creates an artists given name, age, active years, genre and awards.
   *
   * @param name the name of the artist.
   * @param age the age of the artist.
   * @param activeYears the active years of the artist.
   * @param genre the genre of the artist.
   * @param awards the awards that the artist has received.
   */
  public Dancer(Name name, int age, String activeYears,
      ArrayList<Genre> genre, ArrayList<String> awards, ArrayList<String> movies,
      ArrayList<String> series, ArrayList<String> otherMultimedia) throws Exception {
    super(name, age, activeYears, genre, awards, movies, series, otherMultimedia);
  }
}
