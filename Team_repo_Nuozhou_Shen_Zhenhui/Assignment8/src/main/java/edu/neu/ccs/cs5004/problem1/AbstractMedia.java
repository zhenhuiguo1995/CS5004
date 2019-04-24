package edu.neu.ccs.cs5004.problem1;

import java.util.List;
import java.util.Objects;

/**
 * The general media class.
 */
public abstract class AbstractMedia {

  private String alias;
  private String title;
  private int year;
  private List<Name> directors;
  private List<Name> actors;

  /**
   * Create the a general media.
   *
   * @param alias the alias of the media
   * @param title the title of the media
   * @param year the release year of the media
   * @param directors the directors of the media
   * @param actors the actors of the media
   */
  public AbstractMedia(String alias, String title, int year, List<Name> directors,
      List<Name> actors) {
    this.alias = alias;
    this.title = title;
    this.year = year;
    this.directors = directors;
    this.actors = actors;
  }

  /**
   * Get the alias of the media.
   *
   * @return the alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Get the release year of the media.
   *
   * @return the release year
   */
  public int getYear() {
    return year;
  }

  /**
   * Get the title of the media.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Get the directors of the media.
   *
   * @return the directors
   */
  public List<Name> getDirectors() {
    return directors;
  }

  /**
   * Get the actors of the media.
   *
   * @return the actor
   */
  public List<Name> getActors() {
    return actors;
  }

  /**
   * Set a new alias to the movie.
   *
   * @param newAlias the new alias
   */
  public void setAlias(String newAlias) {
    this.alias = newAlias;
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param obj the object to be compared
   * @return true if the two objects are the same, vice versa
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    AbstractMedia that = (AbstractMedia) obj;
    return this.getActors().equals(that.getActors())
        && this.getDirectors().equals(that.getDirectors())
        && this.getAlias().equals(that.getAlias())
        && this.getTitle().equals(that.getTitle())
        && this.getYear() == that.getYear();
  }

  /**
   * Return the hash code of this object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(alias, title, year, directors, actors);
  }

  /**
   * Return a string representation of this media.
   *
   * @return a string representation
   */
  @Override
  public String toString() {
    String str = "Alias-" + this.alias + "\n";
    str += "Title-" + this.title + "\n";
    str += "Year-" + this.year + "\n";
    str += "Directors-" + this.directors.toString() + "\n";
    str += "Actors-" + this.actors.toString() + "\n";
    return str;
  }
}
