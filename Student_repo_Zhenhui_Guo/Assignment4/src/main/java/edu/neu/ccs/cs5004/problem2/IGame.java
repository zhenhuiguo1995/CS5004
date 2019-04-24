package edu.neu.ccs.cs5004.problem2;

/**
 * The game interface.
 */
public interface IGame {

  /**
   * Gets the outcome of a game, Tie game or not a TIE game.
   *
   * @return the outcome
   * @throws FutureGameException the future game exception
   */
  Result getOutcome() throws FutureGameException;

  /**
   * Gets the winning team of a game.
   *
   * @return the winning team
   * @throws TiedGameException the tied game exception
   * @throws FutureGameException the future game exception
   */
  AbstractTeam getWinningTeam() throws TiedGameException, FutureGameException;


}
