package edu.neu.ccs.cs5004.problem2;

/**
 * Represents details of a soccer league.
 */
public class SoccerLeague extends AbstractLeague{
  private static final int ONE = 1;
  private static final int SOCCER_WIN_SCORE = 3;
  private static final int SOCCER_DRAW_SCORE = 1;
  private static final int SOCCER_LOSE_SCORE = 0;


  /**
   * Instantiates a new soccer league.
   *
   * @param leagueName the league name
   * @param startMonths the start months
   * @param endMonths the end months
   * @param numberOfGames the number of games
   * @param nextGame the next game
   * @throws IllegalArgumentException the illegal argument exception
   */
  public SoccerLeague(String leagueName, int startMonths, int endMonths, int numberOfGames,
      Game nextGame) throws IllegalArgumentException {
    super(leagueName, startMonths, endMonths, numberOfGames, nextGame);
  }


  @Override
  public AbstractLeague createGameForLeague(String leagueName, int startMonths, int endMonths,
      int numberOfGames, Game game) {
    return new SoccerLeague(leagueName, startMonths, endMonths, numberOfGames, game);
  }

  @Override
  public Game playGame(Game game, int homeTeamScore, int awayTeamScore)
      throws IllegalArgumentException {
    SoccerTeam homeTeam;
    SoccerTeam awayTeam;
    if (homeTeamScore > awayTeamScore) {
      homeTeam = updateTeam(game, (SoccerTeam) game.getHomeTeam(), Result.WIN);
      awayTeam = updateTeam(game, (SoccerTeam) game.getAwayTeam(), Result.LOSE);
    } else if (homeTeamScore < awayTeamScore) {
      homeTeam = updateTeam(game, (SoccerTeam) game.getHomeTeam(), Result.LOSE);
      awayTeam = updateTeam(game, (SoccerTeam) game.getAwayTeam(), Result.WIN);
    } else {
      homeTeam = updateTeam(game, (SoccerTeam) game.getHomeTeam(), Result.TIE);
      awayTeam = updateTeam(game, (SoccerTeam) game.getAwayTeam(), Result.TIE);
    }
    return new Game(homeTeam, awayTeam, game.getDate(), homeTeamScore, awayTeamScore);
  }

  /**
   * Update a soccer team based on the result.
   *
   * @param game the game
   * @param soccerTeam the soccer team
   * @param result the result
   * @return the soccer team
   */
  public SoccerTeam updateTeam(Game game, SoccerTeam soccerTeam,
      Result result) {
    int gamePlayed = soccerTeam.getGamePlayed() + ONE;
    int gameRemaining = soccerTeam.getGameRemaining() - ONE;
    int points;
    Record oldRecord = soccerTeam.getRecord();
    Record newRecord;
    if (result == Result.WIN) {
      points = soccerTeam.getPoints() + SOCCER_WIN_SCORE;
      newRecord = new Record(oldRecord.getWins() + ONE, oldRecord.getLosses(),
          oldRecord.getDraws());
    } else if (result == Result.LOSE) {
      points = soccerTeam.getPoints() + SOCCER_LOSE_SCORE;
      newRecord = new Record(oldRecord.getWins(), oldRecord.getLosses() + ONE,
          oldRecord.getDraws());
    } else {
      points = soccerTeam.getPoints() + SOCCER_DRAW_SCORE;
      newRecord = new Record(oldRecord.getWins(), oldRecord.getLosses(),
          oldRecord.getDraws() + ONE);
    }
    return new SoccerTeam(soccerTeam.getName(), soccerTeam.getAbstractLeague(),
        gamePlayed, gameRemaining, points, game, newRecord);
  }

}
