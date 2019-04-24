package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * A movie class.
 */
public class Movie extends AbstractMedia {

  public Movie(String alias, String title, int year, List<Name> directors,
      List<Name> actors) {
    super(alias, title, year, directors, actors);
  }
}
