package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * A TV series class.
 */
public class TvSeries extends AbstractMedia {

  public TvSeries(String alias, String title, int year, List<Name> directors,
      List<Name> actors) {
    super(alias, title, year, directors, actors);
  }
}
