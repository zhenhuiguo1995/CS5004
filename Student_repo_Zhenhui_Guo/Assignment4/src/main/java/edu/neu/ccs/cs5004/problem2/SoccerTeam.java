package edu.neu.ccs.cs5004.problem2;

/**
 * Represents details of a soccer team.
 */
public class SoccerTeam extends AbstractTeam{

  /**
   * Instantiates a new Abstract team.
   *
   * @param name the name
   * @param abstractLeague the abstract league
   * @param gamePlayed the game played
   * @param gameRemaining the game remaining
   * @param points the points
   * @param lastGame the last game
   * @param record the record
   */
  public SoccerTeam(String name, AbstractLeague abstractLeague, int gamePlayed, int gameRemaining,
      int points, Game lastGame, Record record) {
    super(name, abstractLeague, gamePlayed, gameRemaining, points, lastGame, record);
  }
}
