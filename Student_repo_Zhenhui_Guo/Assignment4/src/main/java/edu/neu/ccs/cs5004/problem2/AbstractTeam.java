package edu.neu.ccs.cs5004.problem2;

/**
 * Represents detailed information of a team. including name, league, games played and remaining,
 * points and last game played.
 */
public abstract class AbstractTeam {
  private String name;
  private AbstractLeague abstractLeague;
  private int gamePlayed;
  private int gameRemaining;
  private int points;
  private Game lastGame;
  private Record record;
  private boolean onSeason;

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
  public AbstractTeam(String name, AbstractLeague abstractLeague, int gamePlayed, int gameRemaining,
      int points, Game lastGame, Record record) {
    this.name = name;
    this.abstractLeague = abstractLeague;
    this.gamePlayed = gamePlayed;
    this.gameRemaining = gameRemaining;
    this.points = points;
    this.lastGame = lastGame;
    this.record = record;
    this.onSeason = abstractLeague.isOnSeason();
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets game played.
   *
   * @return the game played
   */
  public int getGamePlayed() {
    return gamePlayed;
  }

  /**
   * Gets game remaining.
   *
   * @return the game remaining
   */
  public int getGameRemaining() {
    return gameRemaining;
  }

  /**
   * Gets points.
   *
   * @return the points
   */
  public int getPoints() {
    return points;
  }

  /**
   * Gets last game.
   *
   * @return the last game
   * @throws InvalidGameException the invalid game exception
   */
  public Game getLastGame() throws InvalidGameException {
    if (lastGame == null) {
      throw new InvalidGameException();
    } else {
      return lastGame;
    }
  }

  /**
   * Gets abstract league.
   *
   * @return the abstract league
   */
  public AbstractLeague getAbstractLeague() {
    return abstractLeague;
  }

  /**
   * Gets record.
   *
   * @return the record
   */
  public Record getRecord() {
    return record;
  }


  /**
   * Is on season boolean.
   *
   * @return the boolean
   */
  public boolean isOnSeason() {
    return onSeason;
  }

}
