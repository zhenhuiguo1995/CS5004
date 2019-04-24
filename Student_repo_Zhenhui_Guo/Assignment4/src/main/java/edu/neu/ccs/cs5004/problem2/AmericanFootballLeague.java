package edu.neu.ccs.cs5004.problem2;

/**
 * Represents detailed information about an American football league.
 */
public class AmericanFootballLeague extends AbstractLeague{
  private static final int ONE = 1;
  private static final int AMERICAN_FOOTBALL_WIN_SCORE = 1;
  private static final int AMERICAN_FOOTBALL_LOSE_DRAW_SCORE = 0;


  /**
   * Instantiates a new American football league.
   *
   * @param leagueName the league name
   * @param startMonths the start months
   * @param endMonths the end months
   * @param numberOfGames the number of games
   * @param nextGame the next game
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AmericanFootballLeague(String leagueName, int startMonths, int endMonths,
      int numberOfGames, Game nextGame) throws IllegalArgumentException {
    super(leagueName, startMonths, endMonths, numberOfGames, nextGame);
  }


  @Override
  public AbstractLeague createGameForLeague(String leagueName, int startMonths, int endMonths,
      int numberOfGames, Game game) {
    return new AmericanFootballLeague(leagueName, startMonths, endMonths, numberOfGames, game);
  }



  @Override
  public Game playGame(Game game, int homeTeamScore, int awayTeamScore)
      throws IllegalArgumentException {
    AmericanFootballTeam homeTeam;
    AmericanFootballTeam awayTeam;
    if (homeTeamScore > awayTeamScore) {
      homeTeam = updateTeam(game, (AmericanFootballTeam) game.getHomeTeam(), Result.WIN);
      awayTeam = updateTeam(game, (AmericanFootballTeam) game.getAwayTeam(), Result.LOSE);
    } else if (homeTeamScore < awayTeamScore) {
      homeTeam = updateTeam(game, (AmericanFootballTeam) game.getHomeTeam(), Result.LOSE);
      awayTeam = updateTeam(game, (AmericanFootballTeam) game.getAwayTeam(), Result.WIN);
    } else {
      homeTeam = updateTeam(game, (AmericanFootballTeam) game.getHomeTeam(), Result.TIE);
      awayTeam = updateTeam(game, (AmericanFootballTeam) game.getAwayTeam(), Result.TIE);
    }
    return new Game(homeTeam, awayTeam, game.getDate(), homeTeamScore, awayTeamScore);
  }


  /**
   * Update an American football team based on the results of the game.
   *
   * @param game the game
   * @param baseballTeam the baseball team
   * @param result the result
   * @return the american football team
   */
  public AmericanFootballTeam updateTeam(Game game, AmericanFootballTeam baseballTeam,
      Result result) {
    int gamePlayed = baseballTeam.getGamePlayed() + ONE;
    int gameRemaining = baseballTeam.getGameRemaining() - ONE;
    int points;
    Record oldRecord = baseballTeam.getRecord();
    Record newRecord;
    if (result == Result.WIN) {
      points = baseballTeam.getPoints() + AMERICAN_FOOTBALL_WIN_SCORE;
      newRecord = new Record(oldRecord.getWins() + ONE, oldRecord.getLosses(),
          oldRecord.getDraws());
    } else if (result == Result.LOSE) {
      points = baseballTeam.getPoints() + AMERICAN_FOOTBALL_LOSE_DRAW_SCORE;
      newRecord = new Record(oldRecord.getWins(), oldRecord.getLosses() + ONE,
          oldRecord.getDraws());
    } else {
      points = baseballTeam.getPoints() + AMERICAN_FOOTBALL_LOSE_DRAW_SCORE;
      newRecord = new Record(oldRecord.getWins(), oldRecord.getLosses(),
          oldRecord.getDraws() + ONE);
    }
    return new AmericanFootballTeam(baseballTeam.getName(), baseballTeam.getAbstractLeague(),
        gamePlayed, gameRemaining, points, game, newRecord);
  }



}
