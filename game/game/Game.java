package edu.neu.ccs.cs5004.game;

/**
 * Represents the battleship game.
 */
public interface Game {
  /**
   * Create a new battleship game.
   *
   * @return a battleship game.
   */
  static Game createNewGame() {
    return new ActualGame();
  }
}
