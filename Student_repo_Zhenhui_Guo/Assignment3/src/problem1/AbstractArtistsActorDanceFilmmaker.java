package problem1;

import java.util.ArrayList;

public abstract class AbstractArtistsActorDanceFilmmaker extends AbstractArtists {
  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;

  /**
   * Creates an artists given name, age, active years, genre and awards.
   *
   * @param name the name of the artist.
   * @param age the age of the artist.
   * @param activeYears the active years of the artist.
   * @param genre the genre of the artist.
   * @param awards the awards that the artist has received.
   */
  public AbstractArtistsActorDanceFilmmaker(Name name, int age, String activeYears,
      ArrayList<Genre> genre, ArrayList<String> awards, ArrayList<String> movies,
      ArrayList<String> series, ArrayList<String> otherMultimedia) throws Exception {
    super(name, age, activeYears, genre, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  /**
   * @return the movies which the artist worked on.
   */
  public ArrayList<String> getMovies() {
    return movies;
  }

  /**
   * @return the series which the artist worked on.
   */
  public ArrayList<String> getSeries() {
    return series;
  }

  /**
   * @return the other multimedia which the artist worked on.
   */
  public ArrayList<String> getOtherMultimedia() {
    return otherMultimedia;
  }

  /**
   * @param movie the movie to be added.
   * @return the movie list which the artist worked on.
   */
  public ArrayList<String> addMovie(String movie) {
    this.movies.add(movie);
    return new ArrayList<>(this.movies);
  }

  /**
   * @param series the series to be added.
   * @return the series list which the artist worked on.
   */
  public ArrayList<String> addSeries(String series) {
    this.series.add(series);
    return new ArrayList<>(this.series);
  }

  /**
   * @param otherMultimedia other multimedia to add.
   * @return the other multimedia list which the artist worked on.
   */
  public ArrayList<String> addOtherMultimedia(String otherMultimedia) {
    this.otherMultimedia.add(otherMultimedia);
    return new ArrayList<>(this.otherMultimedia);
  }
}
