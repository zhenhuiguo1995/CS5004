package edu.neu.ccs.cs5004.problem2;

import java.util.Calendar;

/**
 * Represents details of a game, including the date, home team score and away team score as well as
 * the home team and away team.
 */
public class Game implements IGame {
  private AbstractTeam homeTeam;
  private AbstractTeam awayTeam;
  private Calendar date;
  private int homeTeamScore;
  private int awayTeamScore;
  private static final int ZERO = 0;


  /**
   * Instantiates a new Game of any type.
   *
   * @param homeTeam the home team
   * @param awayTeam the away team
   * @param date the date
   * @param homeTeamScore the home team score
   * @param awayTeamScore the away team score
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Game(AbstractTeam homeTeam, AbstractTeam awayTeam,
      Calendar date, int homeTeamScore, int awayTeamScore) throws IllegalArgumentException {
    if (homeTeam.getClass().equals(awayTeam.getClass())) {
      if (homeTeam instanceof BaseballTeam) {
        if (homeTeamScore == awayTeamScore && homeTeamScore != ZERO) {
          throw new IllegalArgumentException();
        }
      }
      this.homeTeam = homeTeam;
      this.awayTeam = awayTeam;
      this.date = date;
      this.homeTeamScore = homeTeamScore;
      this.awayTeamScore = awayTeamScore;
    } else {
      throw new IllegalArgumentException();
    }

  }


  /**
   * Gets the date.
   *
   * @return the date
   */
  public Calendar getDate() {
    return date;
  }

  /**
   * Gets home team score.
   *
   * @return the home team score
   */
  public int getHomeTeamScore() {
    return homeTeamScore;
  }

  /**
   * Gets away team score.
   *
   * @return the away team score
   */
  public int getAwayTeamScore() {
    return awayTeamScore;
  }

  /**
   * Gets home team.
   *
   * @return the home team
   */
  public AbstractTeam getHomeTeam() {
    return homeTeam;
  }

  /**
   * Gets away team.
   *
   * @return the away team
   */
  public AbstractTeam getAwayTeam() {
    return awayTeam;
  }

  @Override
  public Result getOutcome() throws FutureGameException {
    if (!homeTeam.isOnSeason()
        || this.homeTeam instanceof BaseballTeam && this.homeTeamScore == this.awayTeamScore) {
      throw new FutureGameException();
    } else {
      if (this.homeTeamScore == this.awayTeamScore) {
        return Result.TIE;
      } else {
        return Result.NOT_A_TIE;
      }
    }
  }

  @Override
  public AbstractTeam getWinningTeam() throws TiedGameException, FutureGameException {
    if (getOutcome() == Result.TIE) {
      throw new TiedGameException();
    } else {
      return homeTeamScore > awayTeamScore ? homeTeam : awayTeam;
    }
  }

}
