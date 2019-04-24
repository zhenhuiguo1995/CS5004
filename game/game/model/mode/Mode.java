package edu.neu.ccs.cs5004.game.model.mode;

/**
 * Represents a mode.
 */
public interface Mode {
  /**
   * Set up player's ships.
   */
  void setUpPlayerShips();

  /**
   * Set up computer's ships.
   */
  void setUpComputerShips();

  /**
   * Start the game.
   */
  void startBattle();

  /**
   * Creates new game mode.
   *
   * @return new game mode
   */
  static Mode createGameMode() {
    return new GameMode();
  }

  /**
   * Creates a new debug mode.
   *
   * @return a new debug mode
   */
  static Mode createDebugMode() {
    return new DebugMode();
  }
}
