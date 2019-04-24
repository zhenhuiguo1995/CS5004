package edu.neu.ccs.cs5004.problem2;

import java.util.Calendar;

/**
 * The interface League.
 */
public interface ILeague {

  /**
   * Compare the points or records of two teams.
   *
   * @param firstTeam the first team
   * @param secondTeam the second team
   * @return the abstract team
   * @throws TiedTeamException the tied team exception
   * @throws IllegalArgumentException the illegal argument exception
   */
  AbstractTeam compareTeam(AbstractTeam firstTeam, AbstractTeam secondTeam)
      throws TiedTeamException, IllegalArgumentException;


  /**
   * Schedule game for any type of league.
   *
   * @param homeTeam the home team
   * @param awayTeam the away team
   * @param date the date
   * @return the abstract league
   * @throws IllegalArgumentException the illegal argument exception
   */
  AbstractLeague scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Calendar date)
      throws IllegalArgumentException;


  /**
   * Play any game in a league.
   *
   * @param game the game
   * @param homeTeamScore the home team score
   * @param awayTeamScore the away team score
   * @return the game
   * @throws IllegalArgumentException the illegal argument exception
   */
  Game playGame(Game game, int homeTeamScore, int awayTeamScore)
      throws IllegalArgumentException;
}
