package edu.neu.ccs.cs5004.problem2;


/**
 * Represents detailed information of a baseball team record, including number of wins and losses.
 */
public class Record {
  private int wins;
  private int losses;
  private int draws;
  private static final int INITIAL_SCORE = 0;

  /**
   * Creates a default record for any game.
   */
  public Record() {
    this.wins = INITIAL_SCORE;
    this.losses = INITIAL_SCORE;
    this.draws = INITIAL_SCORE;
  }


  /**
   * Instantiates a new Record for any game.
   *
   * @param wins the wins
   * @param losses the losses
   * @param draws the draws
   */
  public Record(int wins, int losses, int draws) {
    this.wins = wins;
    this.losses = losses;
    this.draws = draws;
  }

  /**
   * Gets the number of wins.
   *
   * @return the wins
   */
  public int getWins() {
    return wins;
  }

  /**
   * Gets the number of  losses.
   *
   * @return the losses
   */
  public int getLosses() {
    return losses;
  }

  /**
   * Gets the number of  draws.
   *
   * @return the draws
   */
  public int getDraws() {
    return draws;
  }
}
