package edu.neu.ccs.cs5004.problem2;

/**
 * Represents detailed information about a baseball league.
 */
public class BaseballLeague extends AbstractLeague{
  private static final int ONE = 1;
  private static final int BASEBALL_WIN_SCORE = 1;
  private static final int BASEBALL_LOSE_SCORE = 0;

  /**
   * Instantiates a new baseball league.
   *
   * @param leagueName the league name
   * @param startMonths the start months
   * @param endMonths the end months
   * @param numberOfGames the number of games
   * @param nextGame the next game
   * @throws IllegalArgumentException the illegal argument exception
   */
  public BaseballLeague(String leagueName, int startMonths, int endMonths, int numberOfGames,
      Game nextGame) throws IllegalArgumentException {
    super(leagueName, startMonths, endMonths, numberOfGames, nextGame);
  }


  @Override
  public AbstractLeague createGameForLeague(String leagueName, int startMonths, int endMonths,
      int numberOfGames, Game game) {
    return new BaseballLeague(leagueName, startMonths, endMonths, numberOfGames, game);
  }

  @Override
  public Game playGame(Game game, int homeTeamScore, int awayTeamScore) {
    BaseballTeam homeTeam;
    BaseballTeam awayTeam;
    if (homeTeamScore > awayTeamScore) {
      homeTeam = updateTeam(game, (BaseballTeam) game.getHomeTeam(), Result.WIN);
      awayTeam = updateTeam(game, (BaseballTeam) game.getAwayTeam(), Result.LOSE);
    } else {
      homeTeam = updateTeam(game, (BaseballTeam) game.getHomeTeam(), Result.LOSE);
      awayTeam = updateTeam(game, (BaseballTeam) game.getAwayTeam(), Result.WIN);
    }
    return new Game(homeTeam, awayTeam, game.getDate(), homeTeamScore, awayTeamScore);
  }

  /**
   * Update a baseball team based on the result of a game.
   *
   * @param game the game
   * @param baseballTeam the baseball team
   * @param result the result
   * @return the baseball team
   */
  public BaseballTeam updateTeam(Game game, BaseballTeam baseballTeam, Result result) {
    int gamePlayed = baseballTeam.getGamePlayed() + ONE;
    int gameRemaining = baseballTeam.getGameRemaining() - ONE;
    int points;
    Record oldRecord = baseballTeam.getRecord();
    Record newRecord;
    if (result == Result.WIN) {
      points = baseballTeam.getPoints() + BASEBALL_WIN_SCORE;
      newRecord = new Record(oldRecord.getWins() + ONE, oldRecord.getLosses(),
          oldRecord.getDraws());
    } else {
      points = baseballTeam.getPoints() + BASEBALL_LOSE_SCORE;
      newRecord = new Record(oldRecord.getWins(), oldRecord.getLosses() + ONE,
          oldRecord.getDraws());
    }
    return new BaseballTeam(baseballTeam.getName(), baseballTeam.getAbstractLeague(), gamePlayed,
        gameRemaining, points, game, newRecord);
  }


}
