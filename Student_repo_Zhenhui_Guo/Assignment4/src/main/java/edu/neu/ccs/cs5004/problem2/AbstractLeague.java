package edu.neu.ccs.cs5004.problem2;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Represents details of a league, including league name, season start month and end month, number
 * of games in the league and next game to be played.
 */
public abstract class AbstractLeague implements ILeague {
  private static final int INITIAL_SCORE = 0;
  private static final int MIN_VALUE = 1;
  private static final int MIN_MONTHS = 0;
  private static final int MAX_MONTHS = 11;
  private String leagueName;
  private int startMonths;
  private int endMonths;
  private int numberOfGames;
  private Game nextGame;
  private boolean onSeason;

  /**
   * Instantiates a new League.
   *
   * @param leagueName the league name
   * @param startMonths the start months
   * @param endMonths the end months
   * @param numberOfGames the number of games
   * @param nextGame the next game
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractLeague(String leagueName, int startMonths, int endMonths, int numberOfGames,
      Game nextGame) throws IllegalArgumentException {
    if (startMonths < MIN_MONTHS || startMonths > MAX_MONTHS
        || endMonths < MIN_MONTHS || endMonths > MAX_MONTHS) {
      throw new IllegalArgumentException();
    } else {
      this.leagueName = leagueName;
      this.startMonths = startMonths;
      this.endMonths = endMonths;
      this.numberOfGames = numberOfGames;
      this.nextGame = nextGame;
      this.onSeason = this.isOnSeason();
    }
  }

  @Override
  public AbstractTeam compareTeam(AbstractTeam firstTeam, AbstractTeam secondTeam)
      throws TiedTeamException, IllegalArgumentException {
    if (!firstTeam.getAbstractLeague().getLeagueName()
        .equals(secondTeam.getAbstractLeague().getLeagueName())) {
      throw new IllegalArgumentException("Two teams must be in the same league");
    } else {
      if (firstTeam.getPoints() > secondTeam.getPoints()) {
        return firstTeam;
      } else if (firstTeam.getPoints() < secondTeam.getPoints()) {
        return secondTeam;
      } else {
        if (firstTeam.getRecord().getWins() > secondTeam.getRecord().getWins()) {
          return firstTeam;
        } else if (firstTeam.getRecord().getWins() < secondTeam.getRecord().getWins()) {
          return secondTeam;
        } else {
          throw new TiedTeamException();
        }
      }
    }
  }

  @Override
  public AbstractLeague scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Calendar date)
      throws IllegalArgumentException {
    if (homeTeam.getGameRemaining() < MIN_VALUE || awayTeam.getGameRemaining() < MIN_VALUE) {
      throw new IllegalArgumentException();
    }
    Game game = new Game(homeTeam, awayTeam, date, INITIAL_SCORE, INITIAL_SCORE);
    return createGameForLeague(this.getLeagueName(), this.getStartMonths(), this.getEndMonths(),
        this.getNumberOfGames(), game);
  }

  /**
   * Schedule game for league abstract league.
   *
   * @param leagueName the league name
   * @param startMonths the start months
   * @param endMonths the end months
   * @param numberOfGames the number of games
   * @param game the game
   * @return the abstract league
   */
  public abstract AbstractLeague createGameForLeague(String leagueName, int startMonths,
      int endMonths, int numberOfGames, Game game);


  /**
   * Gets league name.
   *
   * @return the league name
   */
  public String getLeagueName() {
    return leagueName;
  }

  /**
   * Gets start months.
   *
   * @return the start months
   */
  public int getStartMonths() {
    return startMonths;
  }

  /**
   * Gets end months.
   *
   * @return the end months
   */
  public int getEndMonths() {
    return endMonths;
  }

  /**
   * Gets number of games.
   *
   * @return the number of games
   */
  public int getNumberOfGames() {
    return numberOfGames;
  }

  /**
   * Gets next game.
   *
   * @return the next game
   */
  public Game getNextGame() {
    return nextGame;
  }


  /**
   * Is on season boolean.
   *
   * @return the boolean
   */
  public boolean isOnSeason() {
    if (this.getStartMonths() <= LocalDateTime.now().getMonthValue()
        && LocalDateTime.now().getMonthValue() <= this.getEndMonths()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Gets on season.
   *
   * @return the on season
   */
  public boolean getOnSeason() {
    return this.onSeason;
  }

}
